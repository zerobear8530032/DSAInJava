//Graph Valid Tree
//Solved
//Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to check whether these edges make up a valid tree.
//
//Example 1:
//
//Input:
//n = 5
//edges = [[0, 1], [0, 2], [0, 3], [1, 4]]
//
//Output:
//true
//Example 2:
//
//Input:
//n = 5
//edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]
//
//Output:
//false
//Note:
//
//You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
//Constraints:
//
//1 <= n <= 100
//0 <= edges.length <= n * (n - 1) / 2
package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphValidTree_NEETCODE {
//    approch :
//    the tree is a graph which is having no cycle
//    and all nodes are connected
//    so we can use a cycle detection while keeping the track
//    of total visted nodes are == n
//    if any of above condition does not met return false
//    time complexity : O(E+V)
//    space complexity : O(E+V)
    public  static boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map= new HashMap();
        for(int i =0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int [] edge:edges){
            int parent = edge[0];
            int child = edge[1];
            map.get(parent).add(child);
            map.get(child).add(parent);
        }
        HashSet<Integer> path = new HashSet();

        if(cycleExists(0,-1,map,path)){
            return false;
        }
        return path.size()==n;
    }
    public static boolean cycleExists(int node,int parent,HashMap<Integer,List<Integer>> map, HashSet<Integer> path){
        if(path.contains(node)){
            return true;
        }
        if(!map.containsKey(node)){
            return false;
        }
        path.add(node);
        for(int child:map.get(node)){
            if(child==parent){continue;}
            boolean cycle=cycleExists(child,node,map,path);
            if(cycle){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1= 5;
        int [][] edges1={{0,1},{0,2},{0,3},{1,4}};
        boolean output1= true;

        //Example 2:

        int n2= 5;
        int [][] edges2={{0,1},{1,2},{2,3},{1,3},{1,4}};
        boolean output2= false;

        //Example 3:

        int n3= 4;
        int [][] edges3={{0,1},{2,3}};
        boolean output3= false;

        boolean ans1 = validTree(n1,edges1);
        boolean ans2 = validTree(n2,edges2);
        boolean ans3 = validTree(n3,edges3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+(output3));
            System.out.println("Your Answer :"+ (ans3));
        }






    }
}
