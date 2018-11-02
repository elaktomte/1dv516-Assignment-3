import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUndirectedGraph implements A3Graph {
	int totalVertices;
	Node[] vertices;
	List<List<Integer>> connectedList = new ArrayList<List<Integer>>();


	public MyUndirectedGraph (int vertices) {
		this.totalVertices = vertices;
		this.vertices = new Node[vertices];
	}

	@Override
	public void addVertex(int vertex) {
		Node newNode = new Node(vertex, totalVertices);
		vertices[vertex] = newNode;

	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		vertices[sourceVertex].addEdge(targetVertex);
		vertices[targetVertex].addEdge(sourceVertex);
	}

	@Override
	public boolean isConnected() {
		boolean Answer = false;
		this.connectedList= connectedComponents();
		if (connectedList.get(0).size() == totalVertices) {
			Answer = true;
		}
		return Answer;
	}

	@Override
	public boolean isAcyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		int indexer = 0;
		List<List<Integer>>	connectedList = new ArrayList<List<Integer>>();
		List<Integer> innerList = new ArrayList<Integer>();
		
		connectedList.add(innerList);
		innerList.add(vertices[0].vertexID);
		innerList.addAll(vertices[0].edges);
		for (int i = 1; i < vertices.length; i++) {
			Node currentNode = vertices[i];
			System.out.println("Current Node is: "+currentNode.vertexID + " and the edges are: "+currentNode.edges.toString());
			if(currentNode.edges.size() != 0 ) {
				for(int j = 0; j < currentNode.edges.size(); ++j) {
					if(innerList.contains(currentNode.edges.get(j))) {
						if(!innerList.contains(currentNode.vertexID)) {
							innerList.add(currentNode.vertexID);
						}
					} else if (currentNode.edges.size() != 0 && !innerList.contains(currentNode.vertexID)){
						boolean linked = false;
						for (int k = 0; k < currentNode.edges.size(); k++) {
							if (innerList.contains(currentNode.edges.get(k)) && linked == false) {
								innerList.add(currentNode.vertexID);
								linked = true;
							}

						}
						if (linked == false) {
							System.out.println("AIDS");
							List<Integer> newList = new ArrayList<Integer>();
							newList.add(currentNode.vertexID);
							connectedList.add(newList);
							innerList = connectedList.get(connectedList.size()-1);
						}
					}
				}
			}else {
				System.out.println("current Node is: " +currentNode.vertexID);
				List<Integer> newList = new ArrayList<Integer>();
				connectedList.add(newList);
				innerList = connectedList.get(connectedList.size()-1);
				innerList.add(currentNode.vertexID);
			}

		}
		return connectedList;
	}

	@Override
	public boolean hasEulerPath() {
		// TODO Auto-generated method stub
		return A3Graph.super.hasEulerPath();
	}

	@Override
	public List<Integer> eulerPath() {
		// TODO Auto-generated method stub
		return A3Graph.super.eulerPath();
	}

	class Node {
		public int vertexID;
		List<Integer> edges = new ArrayList<Integer>();
		int currentI = 0;

		public Node(int v, int maxEdges) {
			this.vertexID = v;
		}
		public void addEdge(int target) {
			boolean answer = false;
			if (edges.contains(target)) {
				answer = true;
			}
			if (answer == false) {
				edges.add(target);
			}
		}

	}  


}



