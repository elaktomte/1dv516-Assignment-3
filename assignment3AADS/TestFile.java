import java.util.ArrayList;
import java.util.List;
public class TestFile {

	public static void main(String[] args) {

		MyUndirectedGraph graph = new MyUndirectedGraph(5);
		for(int i = 0; i < 5; i++) {
			graph.addVertex(i);
		}
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		
		
		graph.isConnected();
		for (int i = 0; i < graph.connectedList.size(); i++) {
			System.out.println(graph.connectedList.get(i).toString());
		}
		System.out.println(graph.isAcyclic());
		System.out.println(graph.hasEulerPath());
		
		System.out.println(graph.eulerPath().toString());

		
		
	}

}
