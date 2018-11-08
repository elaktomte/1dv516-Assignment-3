import java.util.List;

public class Haustestfil {
	public static void main(String[] args){
		MyDirectedGraph md = new MyDirectedGraph(5);
		
		for(int i = 0; i < 5; ++i){
			md.addVertex(i);
		}
		md.addEdge(0, 2);
		md.addEdge(2, 1);
		md.addEdge(1, 0);
		md.addEdge(0, 3);
	
		
		
		List<List<Integer>> myList = md.connectedComponents();
		System.out.println(myList);
		System.out.println(md.isAcyclic());
		System.out.println(md.isConnected());
		
		
		
	}
	
	

}
