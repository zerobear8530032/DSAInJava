//Largest Rectangle In Histogram
//You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
//
//Return the area of the largest rectangle that can be formed among the bars.
//
//Note: This chart is known as a histogram.
//
//Example 1:
//
//Input: heights = [7,1,7,2,2,4]
//
//Output: 8
//Example 2:
//
//Input: heights = [1,3,7]
//
//Output: 7
//Constraints:
//
//1 <= heights.length <= 1000.
//0 <= heights[i] <= 1000
package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram_NEETCODE {
//  approch :
//     we can only expland a recatngle to left or right if the leftside have more or equal height so we can use
//    a single loop to iterate and check left side and rightside how much to expand
//    time complexity : O(n*n)
//    space complexity : O(1)

    public static int largestRectangleAreaBruteForce(int[] heights) {
        int maxArea= 0;

        for(int i =0;i<heights.length;i++){
            int leftSide=i;
            while(leftSide>=0 && heights[leftSide]>=heights[i]){
                leftSide--;
            }
            int rightSide=i;
            while(rightSide<heights.length && heights[rightSide]>=heights[i]){
                rightSide++;
            }
            int height= heights[i];
            int area= (rightSide-leftSide-1)*height;
            maxArea= Math.max(maxArea,area);
        }
        return maxArea;
    }

//  approch :
// with above observation we can say we will skip all element which are greater then current
//    to left and right so we just have to find the smaller element to left and right index
//    and just use above formula
//    important note we will use 0 if the index is out of bound because of brute force approch
//    we can see the left side need to be reduce by 1
//    time complexity : O(n)
//    space complexity : O(n)

    public static int largestRectangleAreaBetter(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int [] NSL = new int [heights.length];// nearest greater element to LEFT
        int [] NSR = new int [heights.length];// nearest greater element to RIGHT
        int n = heights.length;
        for (int i =0;i<n;i++){
            if(stk.isEmpty()){
                NSL[i]=-1;
            }else{
                while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    NSL[i]=-1;
                }else{
                    NSL[i]=stk.peek();
                }
            }
                stk.push(i);
        }

        stk.clear();
        for (int i =n-1;i>=0;i--){
            if(stk.isEmpty()){
                NSR[i]=heights.length;
            }else{
                while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                    stk.pop();
                }
                if(stk.isEmpty()){
                    NSR[i]=heights.length;
                }else{
                    NSR[i]=stk.peek();
                }
            }
                stk.push(i);
        }
        int maxArea=0;
        for(int i =0;i<n;i++){
            int area= heights[i]*(NSR[i]-NSL[i]-1);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }


    public static void main(String[] args) {
        //Example 1:

        int [] heights1 = {7,1,7,2,2,4};
        int output1= 8;

        //Example 2:

        int [] heights2 = {1,3,7};
        int output2= 7;

        int ans1 = largestRectangleAreaBruteForce(heights1);
        int ans2 = largestRectangleAreaBruteForce(heights2);

        System.out.println("Brute Force Approch :");
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

        ans1 = largestRectangleAreaBetter(heights1);
        ans2 = largestRectangleAreaBetter(heights2);

        System.out.println("Better  Approch :");
        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
    }
}
