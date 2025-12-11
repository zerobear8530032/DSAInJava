//3531. Count Covered Buildings
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].
//
//A building is covered if there is at least one building in all four directions: left, right, above, and below.
//
//Return the number of covered buildings.
//
//
//
//Example 1:
//
//
//
//Input: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
//
//Output: 1
//
//Explanation:
//
//Only building [2,2] is covered as it has at least one building:
//above ([1,2])
//below ([3,2])
//left ([2,1])
//right ([2,3])
//Thus, the count of covered buildings is 1.
//Example 2:
//
//
//
//Input: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
//
//Output: 0
//
//Explanation:
//
//No building has at least one building in all four directions.
//Example 3:
//
//
//
//Input: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
//
//Output: 1
//
//Explanation:
//
//Only building [3,3] is covered as it has at least one building:
//above ([1,3])
//below ([5,3])
//left ([3,2])
//right ([3,5])
//Thus, the count of covered buildings is 1.
//
//
//Constraints:
//
//2 <= n <= 105
//1 <= buildings.length <= 105
//buildings[i] = [x, y]
//1 <= x, y <= n
//All coordinates of buildings are unique.
package Arrays;

import java.util.HashMap;

public class CountCoveredBuildings_3531 {
//    approch :
//    we can create 2 hashmap where one map have rows have max , min col position with corresponding rows
//    and one map with cols having corresponding min , max value of rows in that column
//    then we can check the current row , col is between the building row , col wise
//    in O(1) time hence we can check it and sum up the answer
//    time complexity : O(n)
//    space complexity : O(n*2)
    public static int countCoveredBuildings(int n, int[][] buildings) {
        HashMap<Integer,int []> rowMap= new HashMap<>();
        HashMap<Integer,int []> colMap= new HashMap<>();
        for(int [] point:buildings){
            int row= point[0];
            int col= point[1];
            if(rowMap.containsKey(row)){
                int [] cols= rowMap.get(row);
                cols[0]= Math.min(col,cols[0]);
                cols[1]= Math.max(col,cols[1]);
            }else{
                int [] cols= {col,col};
                rowMap.put(row,cols);
            }
            if(colMap.containsKey(col)){
                int [] rows= colMap.get(col);
                rows[0]= Math.min(row,rows[0]);
                rows[1]= Math.max(row,rows[1]);
            }else{
                int [] rows= {row,row};
                colMap.put(col,rows);
            }
        }
        int res=0;
        for(int [] point : buildings){
            int row = point[0];
            int col = point[1];
//             important row have corresponding cols , colmap have corresponding rows range
            int [] cols = rowMap.get(row);
            int [] rows = colMap.get(col);
            if(rows[0]<row && row <rows[1]  &&  cols[0]<col && col<cols[1] ){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] buildings1= {{1,2},{2,2},{3,2},{2,1},{2,3}};
        int n1=3;
        int output1= 1;

        //Example 2:

        int [][] buildings2= {{1,1},{1,2},{2,1},{2,2}};
        int n2=3;
        int output2= 0;

        //Example 3:

        int  n3 = 5;
        int [][]buildings3 = {{1,3},{3,2},{3,3},{3,5},{5,3}};
        int output3=  1;



    }
}
