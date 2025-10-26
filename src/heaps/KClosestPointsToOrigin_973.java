//973. K Closest Points to Origin
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).
//
//The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).
//
//You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
//
//
//
//Example 1:
//
//
//Input: points = [[1,3],[-2,2]], k = 1
//Output: [[-2,2]]
//Explanation:
//The distance between (1, 3) and the origin is sqrt(10).
//The distance between (-2, 2) and the origin is sqrt(8).
//Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
//We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
//Example 2:
//
//Input: points = [[3,3],[5,-1],[-2,4]], k = 2
//Output: [[3,3],[-2,4]]
//Explanation: The answer [[-2,4],[3,3]] would also be accepted.
//
//
//Constraints:
//
//1 <= k <= points.length <= 104
//-104 <= xi, yi <= 104
package heaps;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {
        static class Entry implements  Comparable<Entry>{
            int x;
            int y;
            double originDistance;

            public Entry(int x, int y, double originDistance) {
                this.x = x;
                this.y=y;
                this.originDistance=originDistance;
            }

            @Override
            public int compareTo(Entry o) {
                return Double.compare(this.originDistance, o.originDistance);
            }


            public String toString(){
                return "[ X : "+x+", Y : "+y+" originDistance "+originDistance+"]";
            }

        }
        public static int[][] kClosest(int[][] points, int k) {
            int []origin = {0,0};

            PriorityQueue <Entry>  queue= new PriorityQueue<>();

            for(int []y:points){
                double dist=getDistance(origin[0],y[1] ,y[0],origin[1] );
                queue.add(new Entry(y[0],y[1],dist));
            }

            int [][] res= new int [k][];
            for(int i =0;i<k;i++){
                Entry e= queue.remove();
                res[i]=  new int []{e.x,e.y};
            }
            return res;
        }

        public static double getDistance(double x1, double x2, double y1, double y2){
            double a= Math.pow(x2-x1,2);
            double b= Math.pow(y2-y1,2);
            return Math.sqrt(a+b);
        }


        public static String printMatrix(int [][] arr){
            StringBuilder res= new StringBuilder("[");
            for(int [] row:arr){
                res.append(Arrays.toString(row)).append(",");
            }
            res.setCharAt(res.length()-1,']');
            return res.toString();
        }


    public static boolean check(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) return false;

        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        for (int[] row : m1) {
            set1.add(Arrays.toString(row));
        }
        for (int[] row : m2) {
            set2.add(Arrays.toString(row));
        }

        return set1.equals(set2);
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] points1 = {{1,3},{-2,2}};
        int k1 = 1;
        int [][]output1=  {{-2,2}};

        //Example 2:

        int [][] points2 = {{3,3},{5,-1},{-2,4}};
        int k2 = 2;
        int [][]output2=  {{3,3},{-2,4}};

        int [][] ans1= kClosest(points1,k1);
        int [][] ans2= kClosest(points2,k2);

        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ printMatrix(output1));
            System.out.println("Your Answer :"+ printMatrix(ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ printMatrix(output2));
            System.out.println("Your Answer :"+ printMatrix(ans2));
        }


    }
}
