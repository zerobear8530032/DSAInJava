//3724. Minimum Operations to Transform Array
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given two integer arrays nums1 of length n and nums2 of length n + 1.
//
//You want to transform nums1 into nums2 using the minimum number of operations.
//
//You may perform the following operations any number of times, each time choosing an index i:
//
//Increase nums1[i] by 1.
//Decrease nums1[i] by 1.
//Append nums1[i] to the end of the array.
//Return the minimum number of operations required to transform nums1 into nums2.
//
//
//
//Example 1:
//
//Input: nums1 = [2,8], nums2 = [1,7,3]
//
//Output: 4
//
//Explanation:
//
//Step	i	Operation	nums1[i]	Updated nums1
//1	0	Append	-	[2, 8, 2]
//2	0	Decrement	Decreases to 1	[1, 8, 2]
//3	1	Decrement	Decreases to 7	[1, 7, 2]
//4	2	Increment	Increases to 3	[1, 7, 3]
//Thus, after 4 operations nums1 is transformed into nums2.
//
//Example 2:
//
//Input: nums1 = [1,3,6], nums2 = [2,4,5,3]
//
//Output: 4
//
//Explanation:
//
//Step	i	Operation	nums1[i]	Updated nums1
//1	1	Append	-	[1, 3, 6, 3]
//2	0	Increment	Increases to 2	[2, 3, 6, 3]
//3	1	Increment	Increases to 4	[2, 4, 6, 3]
//4	2	Decrement	Decreases to 5	[2, 4, 5, 3]
//Thus, after 4 operations nums1 is transformed into nums2.
//
//Example 3:
//
//Input: nums1 = [2], nums2 = [3,4]
//
//Output: 3
//
//Explanation:
//
//Step	i	Operation	nums1[i]	Updated nums1
//1	0	Increment	Increases to 3	[3]
//2	0	Append	-	[3, 3]
//3	1	Increment	Increases to 4	[3, 4]
//Thus, after 3 operations nums1 is transformed into nums2.
//
//
//
//Constraints:
//
//1 <= n == nums1.length <= 105
//nums2.length == n + 1
//1 <= nums1[i], nums2[i] <= 105
package Greedy;

public class MinimumOperationsToTransformArray_3724 {
// approch :
// We can transform nums1[i] → nums2[i] by performing either increments or decrements.
// Each increment/decrement operation costs 1.
// Since nums2 has one extra element, we must also perform an append operation.
// For the last element (nums2[n]), we can generate it in three possible ways:
// 1. Transform some nums1[i] into it (cost = |nums1[i] - last| + 1)
// 2. Transform nums2[i] into it (cost = |nums2[i] - last| + 1)
// 3. If 'last' lies between nums1[i] and nums2[i], we can encounter it naturally
// while changing nums1[i] → nums2[i], so the append cost becomes only 1.
// time complexity : O(n)
// space complexity : O(1)
    public static long minOperations(int[] nums1, int[] nums2) {
        int lastElement = nums2[nums2.length - 1];
        long operations = 0;
        int appendOperation = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            int n2 = nums2[i];
            operations += Math.abs(n2 - n1); // computing n1 to become n2
//            computing n1 to become lastElement
            appendOperation = Math.min(appendOperation, Math.abs(lastElement - n1) + 1);
//            computing n2 to become lastElement
            appendOperation = Math.min(appendOperation, Math.abs(lastElement - n2) + 1);
//            if last element is btw n1 , n2 then we can assume we just make n1 == n2 and append it at that time costing a single operation
            if (n1 <= lastElement && n2 >= lastElement || n2<=lastElement && n1>=lastElement) {
                appendOperation =Math.min(1,appendOperation);
            }
        }
        return operations + appendOperation;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums11 = {2,8}, nums12 = {1,7,3};
        long output1= 4;

        //Example 2:

        int [] nums21 = {1,3,6}, nums22 = {2,4,5,3};
        long output2= 4;

        //Example 3:

        int [] nums31 = {2}, nums32 = {3,4};
        long output3= 3;

        long ans1 = minOperations(nums11,nums12);
        long ans2 = minOperations(nums21,nums22);
        long ans3 = minOperations(nums31,nums32);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
