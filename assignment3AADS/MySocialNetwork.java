import java.util.List;
import java.util.*;

public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {

    public MySocialNetwork(int vertices) {
		super(vertices);
		// TODO Auto-generated constructor stub
	}

    /*
     * public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance). 
     * 
     * It returns the number of people that are at distance 
     * "distance" of the person given by "vertexIndex". For instance, for distance=2, it returns the number of people who are friends of my
     *  friends (but who are not directly my friends or myself). In the graph in the next figure, numberOfPeopleAtFriendshipDistance(5, 2)
     *   will return 4 (there are 4 vertices at distance 2 of vertex 5: <10,11,14,3>)
     */
    
	@Override
    public int numberOfPeopleAtFriendshipDistance(int vertexIndex, int distance) {
	// TODO Auto-generated method stub
	return 0;
    }

	/*
	 * public int furthestDistanceInFriendshipRelationships(int vertexIndex). 
	 * Given a person in "vertexIndex", it returns the
	 *  distance to furthest person in the graph from vertexIndex (this is, returns the highest value of the shortest paths between
	 *   "vertexIndex" and the rest of nodes). In the graph in the next figure, furthestDistanceInFriendshipRelationships(5) will
	 *    return 3 (node 13 is at distance 3 of node 5, and there is not any other node more distant than node 13)
	 */
    @Override
    public int furthestDistanceInFriendshipRelationships(int vertexIndex) {
	// TODO Auto-generated method stub
	return 0;
    }

    /*
	* public List<Integer> possibleFriends(int vertexIndex). 
	* Given a person in "vertexIndex", it returns the list vertices that are
	* at distance 2 of "vertexIndex" (this is, they are friends of friends), where each of these vertices shares at least three common friends with "vertexIndex". In 
	* the graph in the next figure possibleFriends(5) are <3,10>. Vertex 3 shares 4>3 friends with vertex 5 (1,2,4, and 6); while vertex 10 shares exactly 3 friends 
	* with vertex 5 (7,8,9). Note that also vertices 14 and 11 are at distance 2 of vertex 5, but they share only one friend with node 5, therefore they are 
	* not considered possible friends. 
	*
	*
     */
    
    @Override
    public List<Integer> possibleFriends(int vertexIndex) {
	// TODO Auto-generated method stub
	return null;
    }

}
class Tree {
	int leaves;
	TreeNode root;
	LinkedList[] NodesByLevel = new LinkedList[leaves];
	
	public Tree (int leaves) {
		this.leaves = leaves;
	}
	
	public void setRoot (int Value) {
		this.root = new TreeNode(0, Value);
	}
}
class TreeNode {
	int depth;
	int value;
	boolean AlreadyAdded = false;
	ArrayList children = new ArrayList();
	
	public TreeNode(int depth, int value) {
		this.depth = depth;
		this.value = value;
	}
	public void setChildren (ArrayList children) {
		this.children = children;
	}
	public void addChild(int value) {
		children.add(new TreeNode(this.depth+1, value));
	}
}
