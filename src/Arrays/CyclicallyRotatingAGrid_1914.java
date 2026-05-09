//1914. Cyclically Rotating a Grid
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an m x n integer matrix grid​​​, where m and n are both even integers, and an integer k.
//
//The matrix is composed of several layers, which is shown in the below image, where each color is its own layer:
//
//
//
//A cyclic rotation of the matrix is done by cyclically rotating each layer in the matrix. To cyclically rotate a layer once, each element in the layer will take the place of the adjacent element in the counter-clockwise direction. An example rotation is shown below:
//
//
//Return the matrix after applying k cyclic rotations to it.
//
//
//
//Example 1:
//
//
//Input: grid = [[40,10],[30,20]], k = 1
//Output: [[10,20],[40,30]]
//Explanation: The figures above represent the grid at every state.
//Example 2:
//
//
//Input: grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], k = 2
//Output: [[3,4,8,12],[2,11,10,16],[1,7,6,15],[5,9,13,14]]
//Explanation: The figures above represent the grid at every state.
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//2 <= m, n <= 50
//Both m and n are even integers.
//1 <= grid[i][j] <= 5000
//1 <= k <= 109
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicallyRotatingAGrid_1914 {
    public  static int[][] rotateGrid(int[][] grid, int k) {
        int [][] res= new int [grid.length][grid[0].length];
        int up=0;
        int down=grid.length-1;
        int left=0;
        int right=grid[0].length-1;
        int size = grid.length*grid[0].length;
        while(size>0){
            List<Integer> borders=getBouders(grid,up,down,left,right);
            size-=borders.size();
            rotate(borders,k%borders.size());
            setBouders(res,up,down,left,right,borders);
            up++;
            down--;
            left++;
            right--;
        }
        return res;
    }

    public static void rotate(List<Integer> list, int k){
        // System.out.println("Original list");
        // System.out.println(list);
        // System.out.println("Reverse whole list");
        reverse(list,0,list.size()-1);
        // System.out.println(list);
        // System.out.println("Reverse first half ");
        reverse(list,0,k-1);
        // System.out.println(list);
        // System.out.println("Reverse second half ");
        reverse(list,k,list.size()-1);
        // System.out.println(list);
    }

    public static void reverse(List<Integer> list, int s, int e){
        while(s<=e){
            int temp = list.get(s);
            list.set(s,list.get(e));
            list.set(e,temp);
            s++;
            e--;
        }
    }
    public static String printGrid(int [][] grid){
        StringBuilder str= new StringBuilder('[');
        for(int [] row:grid){
            str.append(Arrays.toString(row)).append(',');
        }
        str.setCharAt(str.length()-1,']');
        return str.toString();
    }

    public  static  boolean check(int [][] ans, int  [][] output){
        if(ans==null && output!=null ||output==null && ans!=null||ans.length!=output.length ){
            return  false;
        }
        for(int i =0;i< ans.length;i++){
            if(!Arrays.equals(ans[i],output[i])){
                return false;
            }
        }


        return true;
    }


    public static List<Integer> getBouders(int [][] grid, int up, int down , int left, int right){
        List<Integer> res= new ArrayList<>();
        for(int i=up;i<down;i++){
            res.add(grid[i][left]);
        }
        for(int i=left;i<right;i++){
            res.add(grid[down][i]);
        }
        for(int i=down;i>up;i--){
            res.add(grid[i][right]);
        }
        for(int i=right;i>left;i--){
            res.add(grid[up][i]);
        }
        return res;
    }
    public static void setBouders(int [][] grid,int up,int down , int left,int right, List<Integer> values){
        int idx=0;
        for(int i=up;i<down;i++){
            grid[i][left]=values.get(idx++);
        }
        for(int i=left;i<right;i++){
            grid[down][i]=values.get(idx++);
        }
        for(int i=down;i>up;i--){
            grid[i][right]=values.get(idx++);
        }
        for(int i=right;i>left;i--){
            grid[up][i]=values.get(idx++);
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int [][] grid1 = {{40,10},{30,20}};
        int k1 = 1;
        int [][] output1 = {{10,20},{40,30}};

        //Example 2:

        int [][] grid2 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int k2 = 2;
        int [][] output2 = {{3,4,8,12},{2,11,10,16},{1,7,6,15},{5,9,13,14}};

        int [][] ans1 =  rotateGrid(grid1,k1);
        int [][] ans2 =  rotateGrid(grid2,k2);

        if(check(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ printGrid(output1));
            System.out.println("Your Output : "+ printGrid(ans1));
        }
        if(check(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ printGrid(output2));
            System.out.println("Your Output : "+ printGrid(ans2));
        }

    }
}
