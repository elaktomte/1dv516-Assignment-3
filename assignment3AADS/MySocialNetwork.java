import java.util.List;


import java.util.*;

public class MySocialNetwork extends MyUndirectedGraph implements A3SocialNetwork {

	public MySocialNetwork(int vertices) {
		super(vertices);
		// TODO Auto-generated constructor stub
	}

	//FIXME RÄtta till DFS sökandet så att den inte går haywire, utan faktiskt sparar depthen ordentligt.
	
	
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
		Integer[] Levels = new Integer[totalVertices];
		boolean[] visited = new boolean[totalVertices];
		Levels = DepthDFS(vertexIndex, Levels, 0, visited);	
		int people = 0;
		for (int i = 0; i < Levels.length; i++) {
			if (Levels[i] == distance) {
				people++;
			}
		}

		return people;

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
		Integer[] Levels = new Integer[totalVertices];
		boolean[] visited = new boolean[totalVertices];
		Levels = DepthDFS(vertexIndex, Levels, 0, visited);	
		int distance = 0;
		for (int i = 0; i < Levels.length; i++) {
			System.out.println("["+i+"] : " +Levels[i]);
			if (Levels[i] > distance) {
				distance = Levels[i];
			}
		}
		

		return distance;
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

	public Integer[] DepthDFS(int current, Integer[] levels, int depth, boolean[] visited) {
		visited[current] = true;
		if (levels[current] != null) {
			if (levels[current] < depth) {
				levels[current] = depth;
			}
		}
		else {
			levels[current] = depth;
		}
		for (int i = 0; i < CycleList[current].size(); i++) {
			if(!visited[CycleList[current].get(i)])
				levels = DepthDFS(CycleList[current].get(i), levels, depth+1, visited);
		}

		return levels;
	}

}
