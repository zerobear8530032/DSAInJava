//85. Maximal Rectangle
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
//
// 
//
//Example 1:
//
//
//Input: matrix = [['1','0','1','0','0'],['1','0','1','1','1'],['1','1','1','1','1'],['1','0','0','1','0']]
//Output: 6
//Explanation: The maximal rectangle is shown in the above picture.
//Example 2:
//
//Input: matrix = [['0']]
//Output: 0
//Example 3:
//
//Input: matrix = [['1']]
//Output: 1
// 
//
//Constraints:
//
//rows == matrix.length
//cols == matrix[i].length
//1 <= row, cols <= 200
//matrix[i][j] is '0' or '1'.

package Stacks;

import java.util.Stack;

public class MaxAreaRectangleInBinaryMatrix {
//    approch : we can apply maximum area of historgram logic here
//    where we try to  make rows similr to historgrams each time and apply the approch
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static int maximalRectangle(char[][] matrix) {
        int [] currrow = new int [matrix[0].length];// first row
        for(int i =0;i<matrix[0].length;i++){
            currrow[i]= matrix[0][i]-'0';
        }
        // lets copy each any eevery row :
        int maxArea= MAH(currrow);
        for(int row=1;row<matrix.length;row++){
            for(int col=0;col<matrix[row].length;col++){
                if(matrix[row][col]=='0'){
                    currrow[col]= 0;
                }else{
                    currrow[col]+=(matrix[row][col]-'0');
                }
            }
            maxArea= Math.max(maxArea,MAH(currrow));
        }
        return maxArea;
    }
    public static int MAH(int [] nums){
        Stack<Integer> stk = new Stack();
        int [] NSL = new int [nums.length];
        int [] NSR = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            if(stk.isEmpty()){
                NSL[i]=-1;
            }else{
                while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    NSL[i]=-1;
                }else{
                    NSL[i]= stk.peek();
                }
            }
            stk.push(i);
        }

        stk.clear();

        for(int i=nums.length-1;i>=0;i--){
            if(stk.isEmpty()){
                NSR[i]=nums.length;
            }else{
                while(!stk.isEmpty() && nums[stk.peek()]>=nums[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    NSR[i]=nums.length;
                }else{
                    NSR[i]= stk.peek();
                }
            }
            stk.push(i);
        }
        int maxArea=0;
        for(int i =0;i<nums.length;i++){
            int area=  (NSR[i]-NSL[i]-1)*nums[i];
            maxArea= Math.max(maxArea,area);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        //Example 1:

        char [][] matrix1 = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        int output1= 6;
     
        //Example 2:
     
        char [][] matrix2 = {{'0'}};
        int output2=0;
        
        //Example 3:

        char [][] matrix3 = {{'1'}};
        int output3=1;

        int ans1 = maximalRectangle(matrix1);
        int ans2 = maximalRectangle(matrix2);
        int ans3 = maximalRectangle(matrix3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ output1);
            System.out.println("Your Output : "+ ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed ");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Excepted Output : "+ output3);
            System.out.println("Your Output : "+ ans3);
        }


    }
}
