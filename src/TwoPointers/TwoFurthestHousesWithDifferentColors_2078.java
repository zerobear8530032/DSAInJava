//2078. Two Furthest Houses With Different Colors
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//There are n houses evenly lined up on the street, and each house is beautifully painted. You are given a 0-indexed integer array colors of length n, where colors[i] represents the color of the ith house.
//
//Return the maximum distance between two houses with different colors.
//
//The distance between the ith and jth houses is abs(i - j), where abs(x) is the absolute value of x.
//
//
//
//Example 1:
//
//
//Input: colors = [1,1,1,6,1,1,1]
//Output: 3
//Explanation: In the above image, color 1 is blue, and color 6 is red.
//The furthest two houses with different colors are house 0 and house 3.
//House 0 has color 1, and house 3 has color 6. The distance between them is abs(0 - 3) = 3.
//Note that houses 3 and 6 can also produce the optimal answer.
//Example 2:
//
//
//Input: colors = [1,8,3,8,3]
//Output: 4
//Explanation: In the above image, color 1 is blue, color 8 is yellow, and color 3 is green.
//The furthest two houses with different colors are house 0 and house 4.
//House 0 has color 1, and house 4 has color 3. The distance between them is abs(0 - 4) = 4.
//Example 3:
//
//Input: colors = [0,1]
//Output: 1
//Explanation: The furthest two houses with different colors are house 0 and house 1.
//House 0 has color 0, and house 1 has color 1. The distance between them is abs(0 - 1) = 1.
//
//
//Constraints:
//
//n == colors.length
//2 <= n <= 100
//0 <= colors[i] <= 100
//Test data are generated such that at least two houses have different colors.
package TwoPointers;

public class TwoFurthestHousesWithDifferentColors_2078 {
//     approch : we know the max distance can only be 0 to n-1
//    now if both 0 to n-1 is different we have our answer
//    so we can increse left pointer if nums[n-1] is equl to nums[left] to find possible output
//    if non is present will will get to the right pointer
//    same we does in opposit direction
//    time complexity : O(n)
//    space complexity : O(1)
    public static int maxDistance(int[] colors) {
        int r=colors.length-1;
        while(colors[r]==colors[0]){
            r--;
        }
        int l=0;
        while(colors[l]==colors[colors.length-1]){
            l++;
        }
        return Math.max(colors.length-l-1,r);
    }
    public static void main(String[] args) {

        //Example 1:

        int [] colors1 = {1,1,1,6,1,1,1};
        int output1=3;

        //Example 2:

        int [] colors2 = {1,8,3,8,3};
        int output2= 4;

        //Example 3:

        int [] colors3 = {0,1};
        int output3=1;

        int ans1= maxDistance(colors1);
        int ans2= maxDistance(colors2);
        int ans3= maxDistance(colors3);


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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
