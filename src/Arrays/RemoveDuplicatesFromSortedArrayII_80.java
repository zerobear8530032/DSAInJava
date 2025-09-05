//80. Remove Duplicates from Sorted Array II
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
//
//Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
//
//Return k after placing the final result in the first k slots of nums.
//
//Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
//
//Custom Judge:
//
//The judge will test your solution with the following code:
//
//int[] nums = [...]; // Input array
//int[] expectedNums = [...]; // The expected answer with correct length
//
//int k = removeDuplicates(nums); // Calls your implementation
//
//assert k == expectedNums.length;
//for (int i = 0; i < k; i++) {
//    assert nums[i] == expectedNums[i];
//}
//If all assertions pass, then your solution will be accepted.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,2,2,3]
//Output: 5, nums = [1,1,2,2,3,_]
//Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//
//Input: nums = [0,0,1,1,1,1,2,3,3]
//Output: 7, nums = [0,0,1,1,2,3,3,_,_]
//Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-104 <= nums[i] <= 104
//nums is sorted in non-decreasing order.

package Arrays;

public class RemoveDuplicatesFromSortedArrayII_80 {
    public static int removeDuplicates(int[] nums) {
        int l =0;
        int r=0;
        while(r<nums.length){
            int freq= getFreq(r,nums);
            if(freq<2){
                nums[l]=nums[r];
                l++;
            }else {
                nums[l]=nums[r];
                l++;
                nums[l]=nums[r+1];
                l++;
            }
            r+=freq;
        }
        return l;
    }
    public static int getFreq(int r, int [] nums){
        int count =0;
        int n= nums[r];
        while(r<nums.length && nums[r]==n){
            count++;
            r++;
        }
        return count;
    }

    public static  boolean check(int [] ans, int [] output){
        if(ans.length<output.length){
            return false;
        }
        for(int i=0;i<output.length;i++){
            if(ans[i]!=output[i]){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,1,1,2,2,3};
        int [] output1= {1,1,2,2,3};
        int len1= output1.length;

        //Example 2:

        int [] nums2 = {0,0,1,1,1,1,2,3,3};
        int [] output2= {0,0,1,1,2,3,3};
        int len2= output2.length;

       int ans1= removeDuplicates(nums1);
       int ans2= removeDuplicates(nums2);

        if(ans1== len1 && check(nums1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== len2 && check(nums2,output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
