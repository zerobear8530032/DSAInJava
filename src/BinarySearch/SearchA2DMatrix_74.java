//74. Search a 2D Matrix
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an m x n integer matrix matrix with the following two properties:
//
//Each row is sorted in non-decreasing order.
//The first integer of each row is greater than the last integer of the previous row.
//Given an integer target, return true if target is in matrix or false otherwise.
//
//You must write a solution in O(log(m * n)) time complexity.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//Output: false
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= m, n <= 100
//-104 <= matrix[i][j], target <= 104
package BinarySearch;

public class SearchA2DMatrix_74 {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int rs=0;
        int re= matrix.length-1;
        while(rs<=re){
            int rmid = rs+(re-rs)/2;
            int [] row = matrix[rmid];
            int start= row[0];
            int end= row[row.length-1];
            if(start<=target && end>=target){
                return binarySearch(row,target);
            }else if(start<target){
                rs=rmid+1;
            }else{
                re=rmid-1;
            }
        }
        return false;
    }

    public static boolean binarySearch(int [] arr,int target){
        int s=0;
        int e= arr.length-1;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(arr[mid]<target){
                s=mid+1;
            }else if(arr[mid]>target){
                e=mid-1;
            }else{
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        //Example 1:

        int [][] matrix1 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target1 = 3;
        boolean output1= true;

        //Example 2:


        int [][] matrix2 = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target2 = 13;
        boolean output2= false;

        boolean ans1= searchMatrix(matrix1,target1);
        boolean ans2= searchMatrix(matrix2,target2);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }






    }
}
