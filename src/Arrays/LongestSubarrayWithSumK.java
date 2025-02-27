//Longest Subarray with Sum K
//Difficulty: MediumAccuracy: 24.64%Submissions: 601K+Points: 4
//Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.
//
//Examples:
//
//Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
//Output: 6
//Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.
//Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
//Output: 5
//Explanation: Only subarray with sum = -5 is [-5, 8, -14, 2, 4] of length 5.
//Input: arr[] = [10, -10, 20, 30], k = 5
//Output: 0
//Explanation: No subarray with sum = 5 is present in arr[].
//Constraints:
//1 ≤ arr.size() ≤ 105
//-104 ≤ arr[i] ≤ 104
//-109 ≤ k ≤ 109


package Arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestSubarrayWithSumK {
	
	
//	brute Force Approch :
//	here we are finding every single sub array and checking its sum equal to K
//	time complexity : O(n^3)
//	time complexity : O(1)
	public static int LongestSubarrayWithSumKBruteForce(int [] arr,long  k) {
		int ans =0;
		for(int i =0;i<arr.length-1;i++) {
			for(int j=i;j<arr.length;j++) {
				int sum =0;
				int len =0;
				for(int s=i;s<=j;s++) {
					sum+=arr[s];
					len++;
				}
				if(sum==k) {
					ans=Math.max(ans, len);							
				}
			}
			
		}
		return ans;
	}
	
//	better Approch :
//	here we are finding every single sub array and checking its sum equal to K while on the go
//	time complexity : O(n^2)
//	time complexity : O(1)
	public static int LongestSubarrayWithSumKBetter(int [] arr,long k) {
		int ans =0;
		for(int i =0;i<arr.length;i++) {
			int sum =0;
			int len =0;
			for(int j=i;j<arr.length;j++) {
				sum+=arr[j];
				if(sum==k) {
					ans=Math.max(ans, j-i+1);
				}
			}
			
		}
		return ans;
	}
//	Best Approch :
//	here we use hashmap which will contain a prefix sum as key and index as its output
//	now we will iterate over the loop and check if current sum ==k then we will
//	update max of maxlen and current index+1
//	other wise we will check rem= currentsum-k 
//	the intution here is if we find that current sum -k means we can 
//	take entire sub array from the remainder  starting till current sum ending 
//	and if we find it we can get the index by look up in the hashmmap with remainnder
//	then we can  find length of current sum using a formula of i-map.get(rem)
//	now we will take max of maxlen and sub array 
//	lastly we will do one last thing we put current prefixsum and index as key,value in the map
//---------------------------------------------   
//	here are some edges cases if we put current prefix sum with its index every time
//	their is a possibility where update the value of lowest index to a greater one which will 
//	make the the answer incorrect we only need lowest index in the map because we need longest sub array
//	so we need to check first that the key already exists in map if not then only put it other wise
//	move on 
	
//---------------------------------------------   
//	time complexity : O(n)
//	time complexity : O(n)
	public static int LongestSubarrayWithSumKBest(int [] arr,Long k) {
		int n=arr.length;
		HashMap <Long,Integer> prefixmap = new HashMap();// this will store prefix map
		int maxlen=0;
		Long sum=0L;
		for(int i =0;i<n;i++) {// iterate
			sum+=arr[i];// current prefix sum
			if(sum==k) {// if the current sum is k means we have the curr longest sub array with sum k
				maxlen=Math.max(maxlen, i+1);
			}
			long rem = sum-k;// here we take the current sum -k  to check that sum-k exists or not
//			cause if it exists that could be our new sub array
			if(prefixmap.containsKey(rem)) {// check rem exists 
//				here we take length of sub array from old sub array till current possible one
				int length = i-prefixmap.get(rem);
				maxlen= Math.max(maxlen, length);// here we get max subarray length
			}
			//  this is a edge case we cannot update the map every time cause it can lead to distrupt ooutput
			if(!prefixmap.containsKey(sum)) {
				
				prefixmap.put(sum, i);	
			}	
		}
		return maxlen;
                    
	}
	public static void printsubarray(int[] arr,int s,int e) {
		for(int i=s;i<=e;i++) {
			System.out.print(arr[i]+"\t");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//Examples:
		//
		int []arr1 = {10, 5, 2, 7, 1, -10};
		long k1 = 15L;
		int  output1=6;
		
		int [] arr2 = {-5, 8, -14, 2, 4, 12};
		long k2 = -5L;
		int output2=5;
		
		int [] arr3= {10,-10,20,30};
		long k3=5;
		int  output3=0;
		
		int [] arr4= {94 ,-33 ,-13 ,40 ,-82 ,94, -33 ,-13, 40 ,-82};
		long  k4=52;
		int  output4=3;

		int  ans1=LongestSubarrayWithSumKBruteForce(arr1,k1);
		int  ans2=LongestSubarrayWithSumKBruteForce(arr2,k2);
		int  ans3=LongestSubarrayWithSumKBruteForce(arr3,k3);
		int  ans4=LongestSubarrayWithSumKBruteForce(arr4,k4);
		
		System.out.println("Brute Force Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Your Output :"+ ans4);
			System.out.println("Actual Output :"+ output4);			
		}
		
		System.out.println("Better Approch :");
		
		ans1=LongestSubarrayWithSumKBetter(arr1,k1);
		ans2=LongestSubarrayWithSumKBetter(arr2,k2);
		ans3=LongestSubarrayWithSumKBetter(arr3,k3);
		ans4=LongestSubarrayWithSumKBetter(arr4,k4);
			
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Your Output :"+ ans4);
			System.out.println("Actual Output :"+ output4);			
		}
		
		System.out.println("Optimize Approch :");
		
		ans1=LongestSubarrayWithSumKBest(arr1,k1);
		ans2=LongestSubarrayWithSumKBest(arr2,k2);
		ans3=LongestSubarrayWithSumKBest(arr3,k3);
		ans4=LongestSubarrayWithSumKBest(arr4,k4);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		if(output4==ans4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Your Output :"+ ans4);
			System.out.println("Actual Output :"+ output4);			
		}
		
	}
}
