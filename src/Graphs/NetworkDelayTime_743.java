//Network Delay Time
//Medium
//Topics
//Company Tags
//Hints
//You are given a network of n directed nodes, labeled from 1 to n. You are also given times, a list of directed edges where times[i] = (ui, vi, ti).
//
//ui is the source node (an integer from 1 to n)
//vi is the target node (an integer from 1 to n)
//ti is the time it takes for a signal to travel from the source to the target node (an integer greater than or equal to 0).
//You are also given an integer k, representing the node that we will send a signal from.
//
//Return the minimum time it takes for all of the n nodes to receive the signal. If it is impossible for all the nodes to receive the signal, return -1 instead.
//
//Example 1:
//
//
//
//Input: times = [[1,2,1],[2,3,1],[1,4,4],[3,4,1]], n = 4, k = 1
//
//Output: 3
//Example 2:
//
//Input: times = [[1,2,1],[2,3,1]], n = 3, k = 2
//
//Output: -1
//Constraints:
//
//1 <= k <= n <= 100
//1 <= times.length <= 1000
package Graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class NetworkDelayTime_743 {
    public static int networkDelayTime(int[][] times, int n, int k) {
        int [] nodes= new int [n+1];
        Arrays.fill(nodes,Integer.MAX_VALUE);
        nodes[0]=0;
        nodes[k]=0;
        HashMap<Integer,List<List<Integer>>> graph = new HashMap<>();
        for(int i =1;i<=n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int []time:times){
            graph.get(time[0]).add(Arrays.asList(time[1],time[2]));
        }

        PriorityQueue<int []> queue = new PriorityQueue<>((i1,i2)->i1[1]-i2[1]);
        queue.add(new int []{k,0});
        while(!queue.isEmpty()){
            int [] e= queue.poll();
            int node = e[0];
            int time = e[1];
            for(List<Integer> neighbour:graph.get(node)){
                // System.out.println(node+" "+neighbour);
                if(time<nodes[node]){

                    continue;
                }
                int newTime = time + neighbour.get(1);
                if(newTime<nodes[neighbour.get(0)]){
                    nodes[neighbour.get(0)]=newTime;
                    queue.add(new int []{neighbour.get(0),newTime});
                }
            }

        }
        // System.out.println(Arrays.toString(nodes));
        int max =Integer.MIN_VALUE;
        for(int x:nodes){
            max=Math.max(x,max);
        }
        return max==Integer.MAX_VALUE ? -1 :max;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] times1 = {{1,2,1},{2,3,1},{1,4,4},{3,4,1}};
        int n1 = 4, k1 = 1;
        int output1 =3;
        //Example 2:

        int [][] times2 = {{1,2,1},{2,3,1}};
        int n2 = 3, k2 = 2;
        int output2 =-1;

        int ans1= networkDelayTime(times1,n1,k1);
        int ans2= networkDelayTime(times2,n2,k2);

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

    }
}
