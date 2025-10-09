//Hamiltonian Cycle
//Last Updated : 25 May, 2025
//Hamiltonian Cycle or Circuit in a graph G is a cycle that visits every vertex of G exactly once and returns to the starting vertex.
//
//If a graph contains a Hamiltonian cycle, it is called Hamiltonian graph otherwise it is non-Hamiltonian.
//Finding a Hamiltonian Cycle in a graph is a well-known NP-complete problem, which means that there's no known efficient algorithm to solve it for all types of graphs. However, it can be solved for small or specific types of graphs.
//The Hamiltonian Cycle problem has practical applications in various fields, such as logistics, network design, and computer science.
//What is Hamiltonian Path?
//Hamiltonian Path in a graph G is a path that visits every vertex of G exactly once and it doesn't have to return to the starting vertex. It's an open path.
//
//Similar to the Hamiltonian Cycle problem, finding a Hamiltonian Path in a general graph is also NP-complete and can be challenging. However, it is often a more easier problem than finding a Hamiltonian Cycle.
//Hamiltonian Paths have applications in various fields, such as finding optimal routes in transportation networks, circuit design, and graph theory research.
//Problem Statement
//Given an undirected graph, the task is to determine whether the graph contains a Hamiltonian cycle or not. If it contains, then print the path, else print "Solution does not exist".
//
//Examples:
//
//Input: graph[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 1], [0, 1, 0, 0, 1], [1, 1, 0, 0, 1], [0, 1, 1, 1, 0]]
//
//
//Input graph[][]
//Output: 0 1 2 4 3 0
//
//Input: graph[][] = [[0, 1, 0, 1, 0], [1, 0, 1, 1, 1], [0, 1, 0, 0, 1], [1, 1, 0, 0, 0], [0, 1, 1, 0, 0]]
//
//one_img_2
//Input graph[][]
//
//Output: Solution Does Not Exists

package Graphs;

import java.util.ArrayList;
import java.util.List;

public class HamiltonianCycle_GFG {
//	approch : 
//	This solution uses backtracking to explore all possible paths starting from node 0, marking nodes as visited to avoid revisiting. When a path includes all nodes and ends at the starting node, a Hamiltonian cycle is found. The function uses a visited array for state tracking and backtracks if a dead end is reached. If no such cycle exists, it reports that no valid path is found
//	time complexity :O(n!) 
//	space complexity :O(n) 
	public static List<Integer> detectHamiltonianCycle(int [][] graph ){
		List<Integer> res= new ArrayList<Integer>();
		List<Integer> finalres=  new ArrayList();
		boolean [] visitedArr= new  boolean[graph.length];
		helper(graph,0,0,res,finalres,visitedArr);
		return finalres;
		
	}
	public static boolean helper(int [][] graph, int curnode, int nodecount, List<Integer> res, List<Integer> finalres, boolean [] visitedArr){
		if(nodecount!=0 && curnode==0) {
			if(nodecount==graph.length) {
				res.add(0);
				finalres.addAll(res);
				return true;
			}	
		}
		if(visitedArr[curnode]) {
			return false;
		}
		
		if(nodecount>graph.length) {
			return false;
		}
		for(int i =0;i<graph[curnode].length;i++) {
			if(graph[curnode][i]==0) {
				continue;
			}
//			remove connection to current node of the next node :
			int prev =graph[i][curnode];
			visitedArr[curnode]=true;
			res.add(curnode);
			if(helper(graph,i,nodecount+1,res,finalres,visitedArr)) {
				return true;
			}else {
//			back tracking 
			res.remove(res.size()-1);
			visitedArr[curnode]=false;
			}
				
			
		}
		
		
		
		return false;
	}
	public static void main(String[] args) {
		int [][] graphs1=  {
				{0, 1, 0, 1, 0}, 
				{1, 0, 1, 1, 1},
				{0, 1, 0, 0, 1},
				{1, 1, 0, 0, 1}, 
				{0, 1, 1, 1, 0}
							};
//		output path exists 
		int [][] graphs2=  {
				{0, 1, 0, 1, 0}, 
				{1, 0, 1, 1, 1}, 
				{0, 1, 0, 0, 1}, 
				{1, 1, 0, 0, 0}, 
				{0, 1, 1, 0, 0}
				};
//		output path does not exists  
		
		List<Integer> output1= detectHamiltonianCycle(graphs1);
		List<Integer> output2= detectHamiltonianCycle(graphs2);
		
		if(output1.size()==0) {
			System.out.println("No Valid Path Found");
		}else {
			System.out.println(output1);			
		}
		if(output2.size()==0) {
			System.out.println("No Valid Path Found");
		}else {
			System.out.println(output1);
		}

	}
}
