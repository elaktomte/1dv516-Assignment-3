import java.util.ArrayList;
import java.util.List;
public class TestFile {

	public static void main(String[] args) {
		//firstTest();
		secondTest();
		
		
	}
	public static void firstTest() {
		MyUndirectedGraph graph = new MyUndirectedGraph(5);
		
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
	public static void secondTest() {
		MySocialNetwork network = new MySocialNetwork(15);
		network.addEdge(4, 0 );
		network.addEdge(4, 1);
		network.addEdge(4, 3);
		network.addEdge(4, 5);
		network.addEdge(4, 6);
		network.addEdge(4, 7);
		network.addEdge(4, 8);
		network.addEdge(4, 11);
		network.addEdge(4, 14);
		network.addEdge(9, 8);
		network.addEdge(9, 7);
		network.addEdge(9, 6);
		network.addEdge(10, 6);
		network.addEdge(0, 3);
		network.addEdge(0, 2);
		network.addEdge(13, 5);
		network.addEdge(5, 2);
		network.addEdge(12, 2);
		network.addEdge(0, 1);
		network.addEdge(1, 2);
		network.addEdge(1, 3);
		network.addEdge(2, 3);
		
		System.out.println(network.numberOfPeopleAtFriendshipDistance(4, 2));
		System.out.println(network.furthestDistanceInFriendshipRelationships(12));
		System.out.println(network.possibleFriends(4).toString());
		
	}

}
