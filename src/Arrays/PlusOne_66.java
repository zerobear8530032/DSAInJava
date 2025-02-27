//66. Plus One
//Solved
//Easy
//Topics
//Companies
//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//
//Increment the large integer by one and return the resulting array of digits.
//
// 
//
//Example 1:
//
//Input: digits = [1,2,3]
//Output: [1,2,4]
//Explanation: The array represents the integer 123.
//Incrementing by one gives 123 + 1 = 124.
//Thus, the result should be [1,2,4].
//Example 2:
//
//Input: digits = [4,3,2,1]
//Output: [4,3,2,2]
//Explanation: The array represents the integer 4321.
//Incrementing by one gives 4321 + 1 = 4322.
//Thus, the result should be [4,3,2,2].
//Example 3:
//
//Input: digits = [9]
//Output: [1,0]
//Explanation: The array represents the integer 9.
//Incrementing by one gives 9 + 1 = 10.
//Thus, the result should be [1,0].
// 
//
//Constraints:
//
//1 <= digits.length <= 100
//0 <= digits[i] <= 9
//digits does not contain any leading 0's.

package Arrays;

import java.util.Arrays;

class PlusOne_66 {

//	approch :
//	calculate the  sum
//	k=1
//	nums[i]+1
//	then ans[i]=sum%10// this will add the unit digit of sum
//	then calculatecarry = sum/10 // this will give 10 th place of sum
//	now add carry to k k=k+carry
//	repeat above until we have iterate entire array at last once loop is done if the carry is not0 means the last number is greater then array so increase sze of array and put last 
//	digit at starting of array and rest as previous array 
//	Time complexity :O(n)
//	Space complexity :O(1)
	
    public static int[] plusOne(int[] nums) {
        int k=1;// add 1
        int carry=0;// carry
        int [] ans = new int[nums.length];//ans array 
        for(int i=nums.length-1;i>=0;i--){// sum of 1
            int sum = nums[i]+k;// cal sum
            ans[i]= sum%10;// unit place of sum
           carry = sum/10;// update carry 
            k=carry;// update k 
        }
        if(carry!=0){// if carry is not 0 means the number size is greater
            int [] finalans = new int [nums.length+1];
            for(int i =ans.length-1;i>=0;i--){// copy the arry to new array 
                finalans[i+1]= ans[i];
            }
            finalans[0]=carry;// put the carry 
            return finalans;// new array output
        }

        return ans;// old array output
    }
    
    
    public static boolean check(int [] arr1, int [] arr2) {
		if(arr1.length!=arr2.length) {
			return false;
		}
		for(int i =0;i<arr1.length;i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		
		return true;
	}

    
    public static void main(String[] args) {

//    	Example 1:

    	int [] digits1 = {1,2,3};
    	int [] output1= {1,2,4};
    	
//    	Example 2:

    	int []digits2 = {4,3,2,1};
    	int [] output2= {4,3,2,2};

//    	Example 3:

        int []digits3 = {9};
        int [] output3 ={1,0};
        
        
        int[] ans1=plusOne(digits1);
        int[] ans2=plusOne(digits2);
        int[] ans3=plusOne(digits3);
        
        
        if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}

    	 
	}
    
    
}