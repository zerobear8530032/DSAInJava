//1584. Min Cost to Connect All Points
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
//
//The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
//
//Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
//
//
//
//Example 1:
//
//
//Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
//Output: 20
//Explanation:
//
//We can connect the points as shown above to get the minimum cost of 20.
//Notice that there is a unique path between every pair of points.
//Example 2:
//
//Input: points = [[3,12],[-2,5],[-4,1]]
//Output: 18
//
//
//Constraints:
//
//1 <= points.length <= 1000
//-106 <= xi, yi <= 106
//All pairs (xi, yi) are distinct.
package Graphs;

import java.util.*;

public class MinCostToConnectAllPoints_1584 {

//    Approch : we cna use prims algo to find minimum spanning tree of all graoh
//    which was created where each node connected to every other node
//    time complexity : O(E*V + N log N)
//    space complexity : O(E*V + N )
    public static int minCostConnectPoints(int[][] points) {
        HashMap<Integer,List<Integer>> graph = new HashMap<>();
        PriorityQueue<int []> queue = new PriorityQueue<>((i1,i2)->i1[1]-i2[1]);
        for(int i =0;i<points.length;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i =0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                graph.get(i).add(j);
                graph.get(j).add(i);
            }
        }
        int res=0;
        boolean [] visited= new boolean[points.length];
        queue.add(new int []{0,0});
        while(!queue.isEmpty()){
            int [] entry = queue.poll();
            int p = entry[0];
            int weight = entry[1];
            if(visited[p]){
                continue;
            }
            visited[p]=true;
            res+=weight;
            for(int n : graph.get(p)){
                if(visited[n]){
                    continue;
                }
                queue.add(new int []{n,getCost(points[n],points[p])});
            }
        }
        return res;
    }

    public static int getCost(int [] p1 , int [] p2){
        return Math.abs(p1[0]-p2[0])+ Math.abs(p1[1]-p2[1]);
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] points1 = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        int output1= 20;

        //Example 2:

        int [][] points2 = {{3,12},{-2,5},{-4,1}};
        int output2= 18;

        int ans1= minCostConnectPoints(points1);
        int ans2= minCostConnectPoints(points2);

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
