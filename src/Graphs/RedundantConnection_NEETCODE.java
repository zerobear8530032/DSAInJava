//Redundant Connection
//Medium
//Topics
//Company Tags
//Hints
//You are given a connected undirected graph with n nodes labeled from 1 to n. Initially, it contained no cycles and consisted of n-1 edges.
//
//We have now added one additional edge to the graph. The edge has two different vertices chosen from 1 to n, and was not an edge that previously existed in the graph.
//
//The graph is represented as an array edges of length n where edges[i] = [ai, bi] represents an edge between nodes ai and bi in the graph.
//
//Return an edge that can be removed so that the graph is still a connected non-cyclical graph. If there are multiple answers, return the edge that appears last in the input edges.
//
//
//Example 1:
//
//
//
//Input: edges = [[1,2],[1,3],[3,4],[2,4]]
//
//Output: [2,4]
//
//Example 2:
//
//
//
//Input: edges = [[1,2],[1,3],[1,4],[3,4],[4,5]]
//
//Output: [3,4]
//
//Constraints:
//
//n == edges.length
//3 <= n <= 1000
//1 <= edges[i][0] < edges[i][1] <= edges.length
//There are no repeated edges and no self-loops in the input.
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RedundantConnection_NEETCODE {
        public static int[] findRedundantConnection(int[][] edges) {
            DSU dsu = new DSU(1001);
            List<int []> res = new ArrayList<>();
            for(int [] edge : edges){
                if(!dsu.union(edge[0],edge[1])){
                    return edge;
                }
            }
            return null;
        }



    static class DSU{
        int components=0;
        int [] parent;
        int [] rank;
        public DSU(int size){
            parent = new int [size];
            rank = new int [size];
            for(int i=0;i<size;i++){
                parent[i]=i;
            }
            components=size;
        }

        public int find(int x){
            if(x!= parent[x]){
                parent[x]= find(parent[x]);
            }
            return parent[x];
        }

        public boolean union(int x , int y){
            int parentX=find(x);
            int parentY=find(y);
            if(parentX == parentY){
                return false;
            }
            if(rank[parentX]<rank[parentY]){
                parent[parentX]=parentY;
            }else if(rank[parentX]>rank[parentY]){
                parent[parentY]=parentX;
            }else{
                parent[parentY]=parentX;
                rank[parentX]++;
            }
            components--;
            return true;
        }

    }

    public static void main(String[] args) {
        //Example 1:

        int [][] edges1 = {{1,2},{1,3},{3,4},{2,4}};
        int [] output1= {2,4};
        //Example 2:

        int [][] edges2 = {{1,2},{1,3},{1,4},{3,4},{4,5}};
        int [] output2= {3,4};

        int [] ans1= findRedundantConnection(edges1);
        int [] ans2= findRedundantConnection(edges2);
        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+Arrays.toString(output1));
            System.out.println("Your Answer :"+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+Arrays.toString(output2));
            System.out.println("Your Answer :"+ Arrays.toString(ans2));
        }
    }
}
