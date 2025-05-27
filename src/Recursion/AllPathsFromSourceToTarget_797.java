//797. All Paths From Source to Target
//Medium
//Topics
//premium lock icon
//Companies
//Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.
//
//The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
//
// 
//
//Example 1:
//
//
//Input: graph = [[1,2],[3],[3],[]]
//Output: [[0,1,3],[0,2,3]]
//Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
//Example 2:
//
//
//Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
//Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
// 
//
//Constraints:
//
//n == graph.length
//2 <= n <= 15
//0 <= graph[i][j] < n
//graph[i][j] != i (i.e., there will be no self-loops).
//All the elements of graph[i] are unique.
//The input graph is guaranteed to be a DAG.

package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllPathsFromSourceToTarget_797 {
	
//	approch :
//	simple recursion and backtracking
//	start from node 0 and try to visit each node form there and add the next node in curr list
//	once visited backtrack
//	base condition when current node is == graph .length -1
//	add the created path in th eresult are repeat for each node
//	time complexity : O(N*K): N number of nodes , k number of paths from each node 
//	space complexity : O(N*K)
	public  static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		 List<List<Integer>> res= new ArrayList();
		 List<Integer> curr= new ArrayList();
		 curr.add(0);
		 helper(graph,res,curr, 0 );
		 return res;
	  }
	 
	 

	public static void helper(int [][] graph,List<List<Integer>> res, List<Integer> curr, int node) {
		if(node==graph.length-1) {
			res.add(new ArrayList(curr));
			return ;
		}
		for(int i =0;i<graph[node].length;i++) {
			int nextnode= graph[node][i];
			curr.add(nextnode);
			helper(graph,res,curr,nextnode);
			curr.removeLast();
		}
	}



	public static void main(String[] args) {
		//Example 1:

		int [][] graph1 = {{1,2},{3},{3},{}};
		List<List<Integer>> output1= new ArrayList(
				Arrays.asList(
					Arrays.asList(0,1,3),
					Arrays.asList(0,2,3)
				));

		//Example 2:

		int [][] graph2 = {{4,3,1},{3,2,4},{3},{4},{}};
		List<List<Integer>> output2= new ArrayList(
				Arrays.asList(
						Arrays.asList(0,4),
						Arrays.asList(0,3,4),
						Arrays.asList(0,1,3,4),
						Arrays.asList(0,1,2,3,4),
						Arrays.asList(0,1,4)
						));
		
		
		
		List<List<Integer>> ans1= allPathsSourceTarget(graph1);
		List<List<Integer>> ans2= allPathsSourceTarget(graph2);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		

		

	}

}
