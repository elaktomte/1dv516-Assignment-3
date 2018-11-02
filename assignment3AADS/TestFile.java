import java.util.ArrayList;
import java.util.List;
public class TestFile {

	public static void main(String[] args) {

		MyUndirectedGraph graph = new MyUndirectedGraph(7);
		for(int i = 0; i < 7; i++) {
			graph.addVertex(i);
		}
		
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(0, 3);
		graph.addEdge(4, 5);
		graph.addEdge(6, 1);
		
		
		System.out.println(graph.vertices[1].edges.toString());
		
		System.out.println(graph.isConnected());
		System.out.println(graph.connectedList.size());
		for (int i = 0; i < graph.connectedList.size(); i++) {
			System.out.println(graph.connectedList.get(i).toString());
		}
		System.out.println(graph.vertices[1].edges.toString());
		
		
		/*
		 * [ 1, 2,3,4,5]
		 * [6]
		 * [7,8]
		 * 
		 * 
		 * 
		 * 
		 * 
		 */
		
		
	}

}
