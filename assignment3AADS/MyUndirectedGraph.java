import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class MyUndirectedGraph implements A3Graph {
	int totalVertices;
	Node[] vertices;
	List<List<Integer>> connectedList = new ArrayList<List<Integer>>();
	LinkedList<Integer> [] CycleList;

	public MyUndirectedGraph (int vertices) {
		this.totalVertices = vertices;
		this.vertices = new Node[vertices];
		CycleList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			CycleList[i] = new LinkedList();
		}
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
		CycleList[sourceVertex].addFirst(targetVertex);
		CycleList[targetVertex].addFirst(sourceVertex);
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

	/*
	 * (non-Javadoc)
	 * @see A3Graph#isAcyclic()
	 * 
	 * 
	 */

	@Override
	public boolean isAcyclic() {
		boolean answer = false;
		boolean[] visitedNodes = new boolean[totalVertices];



		for (int i = 0; i < totalVertices; i++) {
			if (visitedNodes[i] == false) {
				if(traverse(i, -1 ,visitedNodes)) {
					answer = true;
				}
			}

		}


		return answer;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
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
					if (innerList.contains(currentNode.vertexID)) {
						if (!innerList.contains(currentNode.edges.get(j))) {
							innerList.add(currentNode.edges.get(j));
						}
					}
					else if (!innerList.contains(currentNode.vertexID) && innerList.contains(currentNode.edges.get(j))) {
						innerList.add(currentNode.vertexID);
					}
					else if (!innerList.contains(currentNode.vertexID) && !innerList.contains(currentNode.edges.get(j))) {
						int indexer = connectedList.size();
						boolean isAlreadyAdded = false;
						for (int k = 0; k < indexer; k++) {
							if (connectedList.get(k).contains(currentNode.vertexID)) {
								isAlreadyAdded = true;
								break;
							}
						}
						if (isAlreadyAdded == false) {
							List<Integer> newList = new ArrayList<Integer>();
							newList.add(currentNode.vertexID);
							newList.addAll(currentNode.edges);
							connectedList.add(newList);
						}
						isAlreadyAdded = false;
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
		boolean answer = false;
		if (isConnected()) {
			int oddVertices = 0;
			for (int i = 0; i<vertices.length; i++) {
				if (vertices[i].edges.size() %2 == 1) {
					oddVertices++;
				}
			}
			if (oddVertices == 2 || oddVertices == 0) {
				answer = true;
			}
		}
		return answer;
	}

	@Override
	public List<Integer> eulerPath() {
		Node vertice;
		ArrayList path = new ArrayList();
		//first we need to find the first odd vertice in case the odd vertices were 2 (euler path).
		for (int i = 0; i < vertices.length; i++) {
			if (vertices[i].edges.size() %2 ==1 ) {
				vertice = vertices[i];
				break;
			}
		}
		// TODO Auto-generated method stub
		return A3Graph.super.eulerPath();
	}
	
	public void pathTraverse(int current, int previous, boolean[] visited) {
		
	}
	
	public boolean traverse (int current, int previous, boolean[] visited) {
		visited[current] = true;


		for (int i = 0; i < CycleList[current].size(); i++) {
			int vertice = CycleList[current].get(i);
			if (vertice != previous) {
				if (visited[vertice]) {
					return true;
				}
				else {
					if (traverse(vertice, current, visited)) {
						return true;
					}
				}
			}
		}
		return false;

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



