//Number of Connected Components in an Undirected Graph
//Solved
//There is an undirected graph with n nodes. There is also an edges array, where edges[i] = [a, b] means that there is an edge between node a and node b in the graph.
//
//The nodes are numbered from 0 to n - 1.
//
//Return the total number of connected components in that graph.
//
//Example 1:
//
//Input:
//n=3
//edges=[[0,1], [0,2]]
//
//Output:
//1
//Example 2:
//
//Input:
//n=6
//edges=[[0,1], [1,2], [2,3], [4,5]]
//
//Output:
//2
//Constraints:
//
//1 <= n <= 100
//0 <= edges.length <= n * (n - 1) / 2
package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class NumConnectedComponentsInAnUndirectedGraph_NEETCODE {
//    approch : here we can create a adjecency map and
//    go over eevery single node and compute the path if the path already exists
//    in the visited we will not go in that node
//    and skip it
//    time complexity : O(e+V)
//    space complexity : O(e+V)
    public static int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int [] edge:edges){
            // its a undirected graphs so relation need to be 2 sided
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        HashSet<Integer> visited = new HashSet();
        int comp=0;
        for(int node=0;node<n;node++){
            if(!visited.contains(node)){
                dfs(node,-1,map,visited);
                comp++;
            }
        }
        return comp;
    }

    public  static void dfs(int node, int parent , HashMap<Integer,List<Integer>> map, HashSet<Integer> visited){
        visited.add(node);
        for(int neighbours : map.get(node)){
            if(!visited.contains(neighbours)){
                dfs(neighbours,node,map,visited);
            }
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int n1=3;
        int [][] edges1= {{0,1},{0,2}};
        int output1= 1;

        //Example 2:

        int n2=6;
        int [][] edges2= {{0,1},{1,2},{2,3},{4,5}};
        int output2= 2;


    }
}
