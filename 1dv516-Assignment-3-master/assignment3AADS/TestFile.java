import java.util.ArrayList;
import java.util.List;
public class TestFile {

	public static void main(String[] args) {
		//firstTest();
		//secondTest();
		//thirdTest();
		//fourthTest();
		fifthTest();
		//sixthTest();
		//seventhTest();
		//eightTest();
	}
	public static void firstTest() {
		MyUndirectedGraph graph = new MyUndirectedGraph();
	     for(int i=0; i<5; i++) {
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
		
		System.out.println("FIRST TEST STARTING ---------");
		System.out.println(graph.isConnected()+ ", expected True");
		for (int i = 0; i < graph.connectedList.size(); i++) {
			System.out.println(graph.connectedList.get(i).toString());
		}
		System.out.println(graph.isAcyclic()+" , expected True");
		System.out.println(graph.hasEulerPath() +" , expected True");
		
		System.out.println(graph.eulerPath().toString());
		System.out.println("FIRST TEST DONE ---------");
		System.out.println("");

	}
	public static void secondTest() {
		System.out.println("SECOND TEST STARTING ---------");
		MySocialNetwork network = new MySocialNetwork();
	     for(int i=0; i<15; i++) {
	         network.addVertex(i);
	     }
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
		
		System.out.println(network.numberOfPeopleAtFriendshipDistance(4, 2) +" , expected 4");
		System.out.println(network.furthestDistanceInFriendshipRelationships(12) + " , expected 5");
		System.out.println(network.possibleFriends(4).toString() + " , expected [2, 9]");
		System.out.println("SECOND TEST DONE ---------");
		System.out.println("");
		
	}
	public static void thirdTest() {
		System.out.println("THIRD TEST STARTING ---------");
		 MyUndirectedGraph graph = new MyUndirectedGraph();
	     for(int i=0; i<=7; i++) {
	         graph.addVertex(i);
	     }

	     graph.addEdge(1, 4);
	     graph.addEdge(2, 1);
	     graph.addEdge(2, 3);
	     graph.addEdge(1, 3);
	     graph.addEdge(6, 5);
	     graph.addEdge(6, 7);
	     graph.addEdge(3, 5);
	     graph.addEdge(0, 7);
	     
	     System.out.println(graph.connectedComponents());
	     
	     System.out.println(graph.isConnected());
	     System.out.println("THIRD TEST DONE ---------");
	     
	}
	public static void fourthTest() {
		System.out.println("FOURTH TEST STARTING ---------");
		   MyUndirectedGraph graph = new MyUndirectedGraph();
		     for(int i=0; i<=7; i++) {
		         graph.addVertex(i);
		     }

		     graph.addEdge(1, 4);
		     graph.addEdge(2, 1);
		     graph.addEdge(7, 4);
		     graph.addEdge(5, 7);
		     graph.addEdge(4, 3);
		     graph.addEdge(6, 7);

		     System.out.println("Expected True, actual is "+ graph.isAcyclic()); //-> returns False.
		     System.out.println("FOURTH TEST DONE ---------");

		//Anothere example:

		

	}
	public static void fifthTest() {
		System.out.println("FIFTH TEST STARTING ---------");
		MyUndirectedGraph graph = new MyUndirectedGraph();
		for(int i=0; i<=7; i++) {
	        graph.addVertex(i);
	    }

	    graph.addEdge(1, 4);
	    graph.addEdge(2, 1);
	    graph.addEdge(7, 4);
	    graph.addEdge(5, 7);
	    graph.addEdge(4, 3);
	    graph.addEdge(6, 7);
	    //the next one creates a cycle
	    graph.addEdge(3, 6);

	    System.out.println("Expected False, actual is " +graph.isAcyclic());
	   //graph.isAcyclic() -> returns true
	    System.out.println("FIFTH TEST DONE ---------");
	}
	public static void sixthTest() {
		System.out.println("SIXTH TEST STARTING ---------");
		MyDirectedGraph graph = new MyDirectedGraph();
		for(int i=0; i<5; i++) {
	        graph.addVertex(i);
	    }

	    graph.addEdge(0, 2);
	    graph.addEdge(2, 1);
	    graph.addEdge(1, 0);
	    graph.addEdge(0, 3);

	    //System.out.println("Expected False, actual is " +graph.isAcyclic());
	    //System.out.println("Expected False, actual is "+ graph.isConnected());
	    System.out.println(graph.connectedComponents());
	    System.out.println("SIXTH TEST DONE ---------");
	}
	public static void seventhTest() {
		System.out.println("SEVENTH TEST STARTING ---------");
		MyDirectedGraph graph = new MyDirectedGraph();
		graph.addVertex(0);
		//System.out.println(graph.connectedComponents());
		System.out.println(graph.isConnected());
		System.out.println("SEVENTH TEST ENDING ---------");

	}
    public static void eightTest() {
    	System.out.println("EIGHT TEST STARTING ---------");
    	MyDirectedGraph graph = new MyDirectedGraph(8);
    	graph.addEdge(0, 2);
    	graph.addEdge(2, 3);
    	graph.addEdge(3, 1);
    	graph.addEdge(1, 0);
    	graph.addEdge(4, 1);
    	graph.addEdge(3, 7);
    	graph.addEdge(7, 2);
    	graph.addEdge(1, 6);
    	System.out.println("Testing something");
    	System.out.println(graph.inverseVertices.get(3).edges);
    	System.out.println(graph.invertedConnectedDFS(new boolean[8], 2, 0, 0));
    	System.out.println("Done Testing something");
    	System.out.println(graph.connectedComponents());
		System.out.println(graph.isConnected());
		System.out.println(graph.isAcyclic());
    	System.out.println("EIGHT TEST ENDING ---------");
    	
    }
}
