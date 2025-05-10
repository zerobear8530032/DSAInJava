//2918. Minimum Equal Sum of Two Arrays After Replacing Zeros
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given two arrays nums1 and nums2 consisting of positive integers.
//
//You have to replace all the 0's in both arrays with strictly positive integers such that the sum of elements of both arrays becomes equal.
//
//Return the minimum equal sum you can obtain, or -1 if it is impossible.
//
//Example 1:
//
//Input: nums1 = [3,2,0,1,0], nums2 = [6,5,0]
//Output: 12
//Explanation: We can replace 0's in the following way:
//- Replace the two 0's in nums1 with the values 2 and 4. The resulting array is nums1 = [3,2,2,1,4].
//- Replace the 0 in nums2 with the value 1. The resulting array is nums2 = [6,5,1].
//Both arrays have an equal sum of 12. It can be shown that it is the minimum sum we can obtain.
//Example 2:
//
//Input: nums1 = [2,0,2,0], nums2 = [1,4]
//Output: -1
//Explanation: It is impossible to make the sum of both arrays equal.
// 
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 105
//0 <= nums1[i], nums2[i] <= 106

package Greedy;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros_2918 {
//	approch : greedy
//	find both array sum of elements and count of zeroes 
//	now check which array have largest sum when we add frequency of zeroes and element sum
//	because we want equal sum so its better to add larger element in smaller array 
//	so we check which array have largest sum + zeros
//	let say its array 1  then we apply function to array 2(because we will increase sum of arary 2 to make it equal)
//	now check how much difference is btw both the array 
//	total sum+zeroes of arr1 - sum of element of arr2 
//	we will get the remaining numbers we need to add in array 2 
//	now here we will check weather the array 2 have zeroes which can accept greater values
//	like if zero count is ==0 return -1 because then we cant increase value
//	other wise we will  divide remaining value by zero count if the division result in lesser then 0 value means 
//	we cannot increase value bbecause we are allowed to only increase positive integer not decimals
//	if the division results in positive integer greater then 0 then we will return total sum + zero count of array 1
//	because its possible to increment the element to make it sum equal	
// if the array 2 is greater we will apply same on array 1 
//	time complexity :O(n+m)
//	space complexity :O(1)
	    public static long minSum(int[] nums1, int[] nums2) {
	        long sumn1=0;
	        long sumn2=0;
	        long zeron1=0;
	        long zeron2=0;
//	        find sum of array 1 & zero count
	        for(int x:nums1){
	            if(x==0){
	                zeron1++;
	            }
	            sumn1+=x;
	        }
//	        find sum of array 2 & zero count
	        for(int x:nums2){
	            if(x==0){
	                zeron2++;
	            }
	            sumn2+=x;
	        }
// check which array hold greater sum including zeroes 
	        if((sumn1+zeron1) < (sumn2+zeron2)){
//	     if array 2 is greater we apply function on array 1
//	        	find remaining
	            long remaining = (sumn2+zeron2)-sumn1;
	            if(zeron1==0) return -1;// if zeroes are not present we canot increase it total sum
	            long avgzeroval= remaining/zeron1;// find how much value each zero can have
	            if(avgzeroval==0){// if avg is 0 thatmeans its not a integer we need only integers so we return 0
	                return -1;
	            }else{
	                return sumn2+zeron2;// other wise we can return sum2 total sum
	            }
	        }else if((sumn1+zeron1) > (sumn2+zeron2)){
//	        	if array 1 is greater 
//	        	find remaining
	            long remaining = (sumn1+zeron1)-sumn2;
//	            return -1 if zero count is 0
	            if(zeron2==0) return -1;
//	            find avg value each zero could have
	            long avgzeroval= remaining/zeron2;
	            if(avgzeroval==0){// if its decimal return -1
	                return -1;
	            }else{
//	            	other wise array 1 sum+zerocount
	                return sumn1+zeron1;
	            }
	        }else {
//	        	this is where sum +zero ins array 1 & array 2 are equal we can return any sym
	            return sumn1+zeron1;
	        }
	    }
	
	public static void main(String[] args) {
		
		//Example 1:

		int []nums11 = {3,2,0,1,0}, nums12 = {6,5,0};
		int output1=12;

		//Example 2:

		int []nums21 = {2,0,2,0}, nums22 = {1,4};
		int output2=-1;
				
		//Example 3:
		
		int []nums31 = {0,16,28,12,10,15,25,24,6,0,0}, nums32 = {20,15,19,5,6,29,25,8,12};
		int output3=139;

		
		long ans1=minSum(nums11,nums12);
		long ans2=minSum(nums21,nums22);
		long ans3=minSum(nums31,nums32);
		
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
