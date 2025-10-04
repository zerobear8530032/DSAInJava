//240. Search a 2D Matrix II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
//
//Integers in each row are sorted in ascending from left to right.
//Integers in each column are sorted in ascending from top to bottom.
//
//
//Example 1:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
//Output: true
//Example 2:
//
//
//Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
//Output: false
//
//
//Constraints:
//
//m == matrix.length
//n == matrix[i].length
//1 <= n, m <= 300
//-109 <= matrix[i][j] <= 109
//All the integers in each row are sorted in ascending order.
//All the integers in each column are sorted in ascending order.
//-109 <= target <= 109
package BinarySearch;

public class SearchA2DMatrixII_240 {

//    approch : here we can see one thing from  row 0 and last col || last row first col
//    the entire row is sorted in ascending and descending order
//    so we can apply elimination  we can say if  current is greater then target means entire column can be skipped
//    other wise we can skip the row in the end we can reach target
//    or we can get out of bound
//    time complexity : O(m+n)
//    space complexity : O(1)
    public static boolean searchMatrix(int[][] matrix, int target) {
        int r=0;
        int c= matrix[0].length-1;
        while(r<matrix.length && c>=0){
            int curr= matrix[r][c];
            if(curr<target){r++;}
            else if(curr>target){c--;}
            else{return true;}
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] matrix1 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target1 = 5;
        boolean output1= true;

        //Example 2:


        int [][] matrix2 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int target2 = 20;
        boolean output2= false;

        boolean ans1 =  searchMatrix(matrix1,target1);
        boolean ans2 =  searchMatrix(matrix2,target2);
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
