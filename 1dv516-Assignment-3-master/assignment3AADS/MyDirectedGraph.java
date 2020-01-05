import java.util.*;

public class MyDirectedGraph implements A3Graph {
	int totalVertices = 0;
	ArrayList<Node> vertices = new ArrayList<Node>();
	List<List<Integer>> connectedList = new ArrayList<List<Integer>>();
	ArrayList<Node> inverseVertices = new ArrayList<Node>();

	public MyDirectedGraph() {

	}
	public MyDirectedGraph(int vertices) {
		for (int i = 0; i<vertices; i++) {
			addVertex(i);
		}
	}

	@Override
	public void addVertex(int vertex) {
		vertices.add(new Node(vertex));
		inverseVertices.add(new Node(vertex));
		totalVertices++;
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		vertices.get(sourceVertex).edges.add(targetVertex);
		inverseVertices.get(targetVertex).edges.add(sourceVertex);
	}

	@Override
	public boolean isConnected() { //MyDirectedGraph, isConnected() returns true if the graph is strongly connected
		boolean answer = false;
		if (totalVertices <= 0) {
			System.out.println("No vertices in the graph");
		} 
		else if (totalVertices == 1) {
			answer = true;
		}	
		else {
			connectedList = connectedComponents();
			if ( connectedList.get(0).size() == totalVertices) {
				answer = true;
			}
		}
		return answer;
	}

	public boolean connectedDFS(boolean[] visited, Integer target, Integer current, Integer start) {
		boolean answer = false;
		visited[current] = true;
		Node currentNode = vertices.get(current);
		if (current == target) {
			if (invertedConnectedDFS(new boolean[totalVertices], target, start, start))
				return true;
		}
		else {
			for (int i = 0; i < currentNode.edges.size(); i++) {
				if (currentNode.edges.size() == 0){
					return false;
				}
				else {
					Integer currentEdge = currentNode.edges.get(i);
					if (currentNode.edges.contains(target)) {
						answer = invertedConnectedDFS(new boolean[totalVertices], target, start, start);
						break;
					}
					else if (visited[currentEdge] == false) {
						answer = connectedDFS(visited, target, currentEdge,start);
					}
				}
				
			}
		}

		return answer;
	}
	public boolean invertedConnectedDFS(boolean[] visited, Integer target, Integer current, Integer start) {
		boolean answer = false;
		visited[current] = true;
		Node currentNode = inverseVertices.get(current);
		if (current == target) {
			return true;
		} 
		else if (currentNode.edges.size() == 0) {
			return false;
		}
		else {
			for (int i = 0; i < currentNode.edges.size(); i++) {
				Integer currentEdge = currentNode.edges.get(i);
				if (currentNode.edges.contains(target)) {
					//System.out.println("Found it!");
					return true;
				}
				else if (visited[currentEdge] == false) {
					return invertedConnectedDFS(visited, target, currentEdge, start);
				}
			}
		}
		return answer;
	}


	@Override
	public boolean isAcyclic() {		//returns true if the graph is not cyclic
		boolean answer = true;
		if (totalVertices <=1) {
			return true;
		}
		else {
			connectedComponents();
			for (int i = 0; i < connectedList.size(); i++) {
				if (connectedList.get(i).size() > 1) {
					answer = false;
					break;
				}
			}
		}
		return answer;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		connectedList = new ArrayList<List<Integer>>();
		for (int i = 0; i<totalVertices; i++) {
			Node currentNode = vertices.get(i);
			for (int j = 0; j < totalVertices; j++) {
				if (j != i) {
					if (connectedDFS(new boolean[totalVertices], j, i, i)) {
						if (connectedList.size() > 0) {
							for(int k = 0; k < connectedList.size(); k++) {
								if (!connectedList.get(k).contains(i) && connectedList.get(k).contains(j)) {
									connectedList.get(k).add(i);
									break;
								} 
								else if (connectedList.get(k).contains(i) && !connectedList.get(k).contains(j)) {
									connectedList.get(k).add(j);
									break;
								}	
							}
						}
						else {
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(i);
							list.add(j);
							connectedList.add(list);
						}
					}
					else {
						if (connectedList.size() == 0) {
							ArrayList<Integer> list = new ArrayList<Integer>();
							list.add(i);
							connectedList.add(list);
						}
						else {
							boolean contained = false;
							for (int o = 0; o < connectedList.size(); o++) {
								if(connectedList.get(o).contains(i)) {
									contained = true;
									break;
								}
							}
							if (!contained) {
								ArrayList<Integer> list = new ArrayList<Integer>();
								list.add(i);
								connectedList.add(list);
							}
						}
					}
				}
			}
		}
		return connectedList;
	}


	class Node {
		public int vertexID;
		List<Integer> edges = new ArrayList<Integer>();


		public Node(int v) {
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
