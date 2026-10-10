//Longest Turbulent Subarray
//Medium
//Topics
//Company Tags
//You are given an integer array arr, return the length of a maximum size turbulent subarray of arr.
//
//A subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.
//
//More formally, a subarray [arr[i], arr[i + 1], ..., arr[j]] of arr is said to be turbulent if and only if:
//
//For i <= k < j:
//
//arr[k] > arr[k + 1] when k is odd, and
//arr[k] < arr[k + 1] when k is even.
//Or, for i <= k < j:
//
//arr[k] > arr[k + 1] when k is even, and
//arr[k] < arr[k + 1] when k is odd.
//Example 1:
//
//Input: arr = [2,4,3,2,2,5,1,4]
//
//Output: 4
//Explanation: The longest turbulent subarray is [2,5,1,4].
//
//Example 2:
//
//Input: arr = [1,1,2]
//
//Output: 2
//Constraints:
//
//1 <= arr.length <= 40,000
//0 <= arr[i] <= 1,000,000,000
package Greedy;

class LongestTurbulentSubarray_978 {
//    approch :
//    we can maintin 2 different count one checks from increas -> decrease -> increase
//    other decrease -> increase -> decrease
//    if any sequence break we just reset it
//    and in the end check which have higher val
//    time complexity : O(n)
//    space complexity : O(1)
    public static int maxTurbulenceSize(int[] nums) {
        boolean needBigger1 = true;
        boolean needBigger2 = false;
        int res1 = 1;
        int curr1 = 1;
        int res2 = 1;
        int curr2 = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (needBigger1 && nums[i] < nums[i + 1]) {
                curr1++;
                needBigger1 = false;
            } else if (!needBigger1 && nums[i] > nums[i + 1]) {
                curr1++;
                needBigger1 =true;
            } else {
                needBigger1 = true;
                curr1 = 1;
                if (needBigger1 && nums[i] < nums[i + 1]) {
                    curr1++;
                    needBigger1 = false;
                } else if (!needBigger1 && nums[i] > nums[i + 1]) {
                    curr1++;
                    needBigger1 =true;
                }
            }
            res1 = Math.max(curr1, res1);
            if (needBigger2 && nums[i] < nums[i + 1]) {
                curr2++;
                needBigger2 = false;
            } else if (!needBigger2 && nums[i] > nums[i + 1]) {
                curr2++;
                needBigger2 = true;
            } else {
                needBigger2 =false;
                curr2 = 1;
                if (needBigger2 && nums[i] < nums[i + 1]) {
                    curr2++;
                    needBigger2 = false;
                } else if (!needBigger2 && nums[i] > nums[i + 1]) {
                    curr2++;
                    needBigger2 = true;
                }
            }
            res2 = Math.max(curr2, res2);
        }
        return Math.max(res1, res2);
    }

    public static void main(String[] args) {

//        Example 1
        int [] nums1= {2,4,3,2,2,5,1,4};
        int output1= 4;

//        Example 2
        int [] nums2= {1,1,2};
        int output2= 2;

//        Example 3
        int [] nums3= {9,4,2,10,7,8,8,1,9};
        int output3= 5;

        int ans1=maxTurbulenceSize(nums1);
        int ans2=maxTurbulenceSize(nums2);
        int ans3=maxTurbulenceSize(nums3);
        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}