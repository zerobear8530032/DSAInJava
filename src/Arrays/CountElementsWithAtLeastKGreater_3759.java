//3759. Count Elements With at Least K Greater Values
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n and an integer k.
//
//An element in nums is said to be qualified if there exist at least k elements in the array that are strictly greater than it.
//
//Return an integer denoting the total number of qualified elements in nums.
//
//
//
//Example 1:
//
//Input: nums = [3,1,2], k = 1
//
//Output: 2
//
//Explanation:
//
//The elements 1 and 2 each have at least k = 1 element greater than themselves.
//​​​​​​​No element is greater than 3. Therefore, the answer is 2.
//
//Example 2:
//
//Input: nums = [5,5,5], k = 2
//
//Output: 0
//
//Explanation:
//
//Since all elements are equal to 5, no element is greater than the other. Therefore, the answer is 0.
//
//
//
//Constraints:
//
//1 <= n == nums.length <= 105
//1 <= nums[i] <= 109
//0 <= k < n
package Arrays;

import java.util.Arrays;

public class CountElementsWithAtLeastKGreater_3759 {
//  if i sort the arrya i can
//    say from current index+1 till end are all elements are greater
//    but there are duplicates so i can use a binary search to find next greater number index
//    and just skip all the elements which are duplicates
//    time complexity : O(N log n)
//    space complexity : O(1)

    public static int countElements(int[] nums, int k) {
        if(k==0){
            return nums.length;
        }
        Arrays.sort(nums);
        int n = nums.length;
        int res=0;
        int i=0;
        while(i<nums.length){
            int idx=binarySearch(nums,i,nums.length-1,nums[i]);
            // System.out.println(i+ "  "+idx);
            if(idx!=-1 && n-idx>=k){
                res+= idx-i;
            }
            i=idx;
            if(idx==-1){
                break;
            }
        }
        return res;
    }

    public static int binarySearch(int []nums, int s, int e, int target){
        int res=-1;
        while(s<=e){
            int mid= s+(e-s)/2;
            if(nums[mid]<=target){
                s=mid+1;
            }else{
                res=mid;
                e=mid-1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {3,1,2};
        int k1 = 1;
        int output1= 2;

        //Example 2:

        int [] nums2 = {5,5,5};
        int k2 = 2;
        int output2= 0;

        int ans1 = countElements(nums1,k1);
        int ans2 = countElements(nums2,k2);

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



    }
}
