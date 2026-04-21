//1722. Minimize Hamming Distance After Swap Operations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two integer arrays, source and target, both of length n. You are also given an array allowedSwaps where each allowedSwaps[i] = [ai, bi] indicates that you are allowed to swap the elements at index ai and index bi (0-indexed) of array source. Note that you can swap elements at a specific pair of indices multiple times and in any order.
//
//The Hamming distance of two arrays of the same length, source and target, is the number of positions where the elements are different. Formally, it is the number of indices i for 0 <= i <= n-1 where source[i] != target[i] (0-indexed).
//
//Return the minimum Hamming distance of source and target after performing any amount of swap operations on array source.
//
//
//
//Example 1:
//
//Input: source = [1,2,3,4], target = [2,1,4,5], allowedSwaps = [[0,1],[2,3]]
//Output: 1
//Explanation: source can be transformed the following way:
//- Swap indices 0 and 1: source = [2,1,3,4]
//- Swap indices 2 and 3: source = [2,1,4,3]
//The Hamming distance of source and target is 1 as they differ in 1 position: index 3.
//Example 2:
//
//Input: source = [1,2,3,4], target = [1,3,2,4], allowedSwaps = []
//Output: 2
//Explanation: There are no allowed swaps.
//The Hamming distance of source and target is 2 as they differ in 2 positions: index 1 and index 2.
//Example 3:
//
//Input: source = [5,1,2,4,3], target = [1,5,4,2,3], allowedSwaps = [[0,4],[4,2],[1,3],[1,4]]
//Output: 0
//
//
//Constraints:
//
//n == source.length == target.length
//1 <= n <= 105
//1 <= source[i], target[i] <= 105
//0 <= allowedSwaps.length <= 105
//allowedSwaps[i].length == 2
//0 <= ai, bi <= n - 1
//ai != bi
package Graphs;

import java.util.*;

public class MinimizeHammingDistanceAfterSwapOperations_1722 {
//    approch : create groups of components  from index i to j from allowed swaps
//    then we can always find  way to rearrange those indexes in every way so we can easily find
//    the min distance btw both of the arrays
//    we can use DFS to explore all nodes and visit all paths they lead too
//    and create components which can be used to check hamming distnce
//    time complexity : O(n)
//    space complexity : O(n)
    public static int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            for(int i =0;i<source.length;i++){
                graph.put(i,new ArrayList<>());
            }
            for(int [] nodes:allowedSwaps){
                graph.get(nodes[0]).add(nodes[1]);
                graph.get(nodes[1]).add(nodes[0]);
            }

            // System.out.println(graph);
            HashMap<Integer,List<Integer>> groups= new HashMap();
            HashSet<Integer> visited= new HashSet<>();
            for(int i=0;i<source.length;i++){
                if(visited.contains(i)){continue;}
                DFS(groups,visited,graph,i,i);
            }
            // System.out.println(groups);
            int res=0;
            for(int key:groups.keySet()){
                HashMap<Integer,Integer> freq = new HashMap();
                for(int x:groups.get(key)){
                    freq.put(source[x],freq.getOrDefault(source[x],0)+1);
                }
                for(int x:groups.get(key)){
                    if( freq.containsKey(target[x])){
                        freq.put(target[x],freq.get(target[x])-1);
                        if(freq.get(target[x])==0){
                            freq.remove(target[x]);
                        }
                    }else{
                        res++;
                    }
                }

            }

            return res;
        }


    public static void DFS(HashMap<Integer,List<Integer>> groups,HashSet<Integer> visited, HashMap<Integer,List<Integer>> graph,int node,int startingNode){
        if(visited.contains(node)){return ;}
        else{visited.add(node);}
        if(groups.containsKey(startingNode)){
            groups.get(startingNode).add(node);
        }else{
            groups.put(startingNode,new ArrayList(Arrays.asList(node)));
        }
        if(!graph.containsKey(node)){return;}
        List<Integer> neighbour = graph.get(node);
        for(int ng:neighbour){
            DFS(groups,visited,graph,ng,startingNode);
        }
    }

    public static void main(String[] args) {

        //Example 1:

        int [] source1 = {1,2,3,4}, target1 = {2,1,4,5};
        int [][] allowedSwaps1 = {{0,1},{2,3}};
        int output1= 1;

        //Example 2:

        int [] source2 = {1,2,3,4}, target2 = {1,3,2,4};
        int [][] allowedSwaps2 = {};
        int output2= 2;

        //Example 3:

        int [] source3 = {5,1,2,4,3}, target3 = {1,5,4,2,3};
        int [][] allowedSwaps3 = {{0,4},{4,2},{1,3},{1,4}};
        int output3= 0;

        int ans1 = minimumHammingDistance(source1,target1,allowedSwaps1);
        int ans2 = minimumHammingDistance(source2,target2,allowedSwaps2);
        int ans3 = minimumHammingDistance(source3,target3,allowedSwaps3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }


    }
}
