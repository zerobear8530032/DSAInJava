//Number of Connected Components in an Undirected Graph
//Medium
//Topics
//Company Tags
//Hints
//You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [aᵢ, bᵢ] indicates that there is an edge between aᵢ and bᵢ in the graph.
//
//Return the number of connected components in the graph.
//
//Example 1:
//
//
//
//Input:
//n = 5, edges = [[0,1],[1,2],[3,4]]
//
//Output: 2
//Example 2:
//
//
//
//Input:
//n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
//
//Output: 1
//Constraints:
//
//1 <= n <= 2000
//1 <= edges.length <= 5000
//edges[i].length == 2
//0 <= aᵢ <= bᵢ < n
//aᵢ != bᵢ
//There are no repeated edges.
package Graphs;

public class NumberConnectedComponentsInAnUndirectedGraph_NEETCODE {
         public static int countComponents(int n, int[][] edges) {
            DSU dsu = new DSU(n);
            for(int[] edge:edges){
                dsu.union(edge[0],edge[1]);
            }
            return dsu.components;

        }
     static class DSU {
        int components = 0;
        int[] parent;
        int[] rank;

        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            components = size;
        }

        public int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);
            if (parentX == parentY) {
                return;
            }
            if (rank[parentX] < rank[parentY]) {
                parent[parentX] = parentY;
            } else if (rank[parentX] > rank[parentY]) {
                parent[parentY] = parentX;
            } else {
                parent[parentY] = parentX;
                rank[parentX]++;
            }
            components--;
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int n1 = 5;
        int [][] edges1 = {{0,1},{1,2},{3,4}};
        int output1= 2;

        //Example 2:

        int n2 = 5;
        int [][] edges2 = {{0,1},{1,2},{2,3},{3,4}};
        int output2= 1;


        int ans1= countComponents(n1,edges1);
        int ans2= countComponents(n2,edges2);

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

    }

}
