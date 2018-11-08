import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyDirectedGraph implements A3Graph{
	List<Integer>[] vertices;
	List<List<Integer>> connectedList;
	
	public MyDirectedGraph(int i){
		vertices = new List[i];
	}

	@Override
	public void addVertex(int vertex) {
		vertices[vertex] = new ArrayList<Integer>();
		
	}

	@Override
	public void addEdge(int sourceVertex, int targetVertex) {
		vertices[sourceVertex].add(targetVertex);
		
	}
	
	public void DFS(List<Integer>[] graph, int start, boolean[] visited, List<Integer> newList){
		visited[start] = true;
		for(int i = 0; i < graph[start].size(); ++i){
			if(!visited[graph[start].get(i)]){
				DFS(graph, graph[start].get(i),visited,newList);
			}
		}newList.add(start);
	}

	
	public List<Integer> fillOrder(List<Integer>[] graph, boolean[] visited){
		int size = graph.length;
		
		List<Integer> order = new ArrayList<Integer>();
		
		for(int i = 0; i < size; ++i){
			if(!visited[i]){
				DFS(graph, i, visited, order);
			}
		}
		return order;
	}
	
	public List<Integer>[] getTranspose(List<Integer>[] graph){
		int size = graph.length;
		List<Integer>[] newGraph = new List[size];
		for(int i = 0; i < size; ++i){
			newGraph[i] = new ArrayList<Integer>();
		}
		for(int j = 0; j < size; ++j){
			for(int i = 0; i < graph[j].size(); ++i){
				newGraph[graph[j].get(i)].add(j);
			}
		}
		return newGraph;
	}
	@Override
	public boolean isConnected() {
		return connectedList.size() == 1;
	}

	@Override
	public boolean isAcyclic() {
		for(int i = 0; i < connectedList.size(); ++i){
			if(connectedList.get(i).size() > 2){
				return true;
			}
		}
		return false;
	}

	@Override
	public List<List<Integer>> connectedComponents() {
		int V = vertices.length;
		boolean[] visited = new boolean[V];
		List<Integer> order = fillOrder(vertices, visited);
		
		List<Integer>[] reverseGraph = getTranspose(vertices);
		
		visited = new boolean[V];
		
		Collections.reverse(order);
		
		connectedList = new ArrayList<>();
		
		for(int i = 0; i < order.size(); ++i){
			int v = order.get(i);
			if(!visited[v]){
				List<Integer> newList = new ArrayList<>();
				DFS(reverseGraph, v, visited, newList);
				connectedList.add(newList);
			}
		}
		return connectedList;
		
	}

}
