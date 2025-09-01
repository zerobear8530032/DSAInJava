//48. Rotate Image
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
//
//You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
//
//
//
//Example 1:
//
//
//Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
//Output: [[7,4,1],[8,5,2],[9,6,3]]
//Example 2:
//
//
//Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
//
//
//Constraints:
//
//n == matrix.length == matrix[i].length
//1 <= n <= 20
//-1000 <= matrix[i][j] <= 1000
//
package Arrays;

import java.util.Arrays;

public class RotateImage_48 {
//    approch : here we first get transpose of the matrix
//    then we will just reverse each row and every thing can be done in place to get answer;
    public static void rotate(int[][] matrix) {
        transpose(matrix);
        for(int [] row:matrix){
            reverse(row);
        }
    }

    public static void reverse(int [] arr){
        int s =0;
        int e= arr.length-1;
        while(s<e){
            int temp = arr[s];
            arr[s]=arr[e];
            arr[e]=temp;
            s++;
            e--;
        }
    }
    public static void transpose(int [][] matrix){
        for(int i =0;i<matrix.length;i++){
            for(int j =i;j<matrix.length;j++){
                swap(matrix,i,j,j,i);
            }
        }

    }
    public static void swap(int [][] matrix,int r1,int c1, int r2,int c2){
        int temp = matrix[r1][c1];
        matrix[r1][c1]=matrix[r2][c2];
        matrix[r2][c2]=temp;
    }

    public static boolean check(int [][] ans,int [][]output) {
        if(ans.length!=output.length) {
            return false;
        }
        for(int i=0;i<ans.length;i++) {
            if(ans[i].length!=output[i].length){return false;}
            for(int j=0;j<ans[i].length;j++){
                if(ans[i][j]!=output[i][j]){
                    return false;
                }
            }
        }
        return true;

    }


    public static void main(String[] args) {
        //Example 1:

        int [][] matrix1 = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] output1=  {{7,4,1},{8,5,2},{9,6,3}};

        //Example 2:

        int [][] matrix2 = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        int [][] output2=  {{15,13,2,5},{14,3,4,1},{12,6,8,9},{16,7,10,11}};


        rotate(matrix1);
        rotate(matrix2);

        if(check(matrix1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(matrix1));
        }
        if(check(matrix2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(matrix2));
        }




    }
}
