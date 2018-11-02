import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUndirectedGraph implements A3Graph {
	int totalVertices;
	Node[] vertices;
	ArrayList<List<Integer>> connectedList = new ArrayList<List<Integer>>();
	
	
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
		connectedList.get(0).add(sourceVertex);
		connectedList.get(0).add(targetVertex);
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAcyclic() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		ArrayList<List<Integer>>	connectedList = new ArrayList<List<Integer>>();
		List innerList = connectedList.get(0);
		for (int i = 0; i < vertices.length; i++) {
			Node currentNode = vertices[i];
			if(innerList.size() == 0) {
				innerList.add(currentNode);
				innerList.addAll(currentNode.edges);
			}

			else {
				for (int j = 0; j< currentNode.edges.length; j++) {
					if(currentNode.edges.length == 0) {
						break;
					}
					else {
						if(innerList.contains(currentNode.edges[j])) {

						}
						else if (currentNode.edges[j] == null) {
							break;
						}
						else {
							innerList.add(currentNode.edges[j]);
						}

					}
				}


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
		List<Integer> edges;
		int currentI = 0;

		public Node(int v, int maxEdges) {
			edges = new Integer[maxEdges];
			this.vertexID = v;
		}
		public void addEdge(int target) {
			boolean answer = false;
			for (int i = 0; i < edges.length; i++) {
				if (edges[i] == target) {
					answer = true;
				}
			}
			if (answer == false) {
				edges[currentI++] = target;
			}
		}

	}  


}



