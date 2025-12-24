//3074. Apple Redistribution into Boxes
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array apple of size n and an array capacity of size m.
//
//There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
//
//Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
//
//Note that, apples from the same pack can be distributed into different boxes.
//
//
//
//Example 1:
//
//Input: apple = [1,3,2], capacity = [4,3,1,5,2]
//Output: 2
//Explanation: We will use boxes with capacities 4 and 5.
//It is possible to distribute the apples as the total capacity is greater than or equal to the total number of apples.
//Example 2:
//
//Input: apple = [5,5,5], capacity = [2,4,2,7]
//Output: 4
//Explanation: We will need to use all the boxes.
//
//
//Constraints:
//
//1 <= n == apple.length <= 50
//1 <= m == capacity.length <= 50
//1 <= apple[i], capacity[i] <= 50
//The input is generated such that it's possible to redistribute packs of apples into boxes.
package Arrays;

import java.util.Arrays;

public class AppleRedistributionIntoBoxes_3074 {

    public static int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int totalApple =0;
        for(int x:apple){
            totalApple+=x;
        }
        int res=0;
        for(int i=capacity.length-1;i>=0;i--){
            if(totalApple<=0){break;}
            totalApple-=capacity[i];
            res++;
        }
        return res;
    }


    public static void main(String[] args) {
        //Example 1:

        int [] apple1 = {1,3,2}, capacity1 = {4,3,1,5,2};
        int output1= 2;

        //Example 2:

        int [] apple2 = {5,5,5}, capacity2 = {2,4,2,7};
        int output2= 4;

        int ans1= minimumBoxes(apple1,capacity1);
        int ans2= minimumBoxes(apple2,capacity2);

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
