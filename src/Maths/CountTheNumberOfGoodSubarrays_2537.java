//2537. Count the Number of Good Subarrays
//Medium
//Topics
//Companies
//Hint
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
// 
//
//Example 1:
//
//Input: nums = [1,1,1,1,1], k = 10
//Output: 1
//Explanation: The only good subarray is the array nums itself.
//Example 2:
//
//Input: nums = [3,1,4,3,2,2,4], k = 2
//Output: 4
//Explanation: There are 4 different good subarrays:
//- [3,1,4,3,2,2] that has 2 pairs.
//- [3,1,4,3,2,2,4] that has 3 pairs.
//- [1,4,3,2,2,4] that has 2 pairs.
//- [4,3,2,2,4] that has 2 pairs.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i], k <= 109



package Maths;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
public class CountTheNumberOfGoodSubarrays_2537 {
// brute force approch :
//	find every single sub array and caclualte number of apirs 
//	with the help of hashmap of frequency :
//	formula : nC2 : n!/2!*(n-2)!
//	simplifies : n*(n-1)*(n-2)!/2!*(n-2)! : (n-2)! cancle out
//	final formula : n*(n-1)/2*1 
//	time complexiy: O(n^3)
//	space complexiy: O(n^2)
	public static long countGoodBruteForce(int[] nums, int k) {
		int ans =0;
		for(int i =0;i<nums.length;i++) {
			for(int j =i;j<nums.length;j++) {
				if(isGoodArrayBruteForce(nums,i,j,k)) {
					ans++;
				}
			}
		}
		return ans;
	}

	public static boolean isGoodArrayBruteForce(int[] nums, int s, int e, int k) {
		HashMap<Integer,Integer> map = new HashMap();
		for(int i=s;i<=e;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		int pairs=0;
		for(Map.Entry<Integer, Integer> entry:map.entrySet()) {
			int val=entry.getValue();
			int pair= (val*(val-1))/2;// finding pairs for each frequency
			pairs+=pair;
		}
		
		return pairs>=k;
	}
// Better force approch :
//	the approch is similar to what we were doing before just 
//	one optimization is that we can use a sliding window where 
//	we will include more elements in the subarray if it pairs are less then k
//	and we remove element if it greter or equal to k
//	time complexiy: O(n^2)
//	space complexiy: O(n)
	public static long countGoodBetter(int[] nums, int k) {
		int ans =0;
		int left=0;
		HashMap<Integer,Integer> map= new HashMap();
		for(int right=0;right<nums.length;right++) {
			if(map.containsKey(nums[right])) {
				map.put(nums[right], map.get(nums[right])+1);
			}else {
				map.put(nums[right],1);
			}
			long currentPairs= calculatePairs(map);
			if(currentPairs>=k) {
//				 calculate the rest of the sub array :
				 int restwindow = (nums.length-right);
				ans+=restwindow;
			}
			while(currentPairs>=k && left<=right) {
				if(map.containsKey(nums[left])) {
					map.put(nums[left],map.get(nums[left])-1);
				}
				left++;
				currentPairs=calculatePairs(map);
				if(currentPairs>=k) {
					int restwindow = (nums.length-right);
					 ans+=restwindow;
				}	
			}
		}
		
		
		
		return ans;
	}
	public static long calculatePairs(HashMap<Integer,Integer>map) {
		long pairs=0;
		for(Map.Entry<Integer, Integer> e:map.entrySet()) {
			int val =e.getValue();
			int pair= (val*(val-1))/2;
			pairs+=pair;
		}
		return pairs;
	}
// Best approch :
//	the approch is similar to what we were doing before just 
//	one optimization is that we can use a sliding window where 
//	we will include more elements in the subarray if it pairs are less then k
//	and we remove element if it greter or equal to k
//	time complexiy: O(n^2)
//	space complexiy: O(n)
	public static long countGoodBest(int[] nums, int k) {
	    int ans = 0;
	    int left = 0;
	    long currentPairs = 0;
	    HashMap<Integer, Integer> map = new HashMap<>();

	    for (int right = 0; right < nums.length; right++) {
	        int oldFreq = map.getOrDefault(nums[right], 0);
	        currentPairs += oldFreq;  // f → f+1 adds f pairs
	        map.put(nums[right], oldFreq + 1);

	        while (currentPairs >= k && left <= right) {
	            // Count valid subarrays
	        	// why we take this to clacualte substring
	        	
	            ans += (nums.length - right);

	            // Shrink from left
	            int leftFreq = map.get(nums[left]);
	            currentPairs -= (leftFreq - 1);  // f → f-1 removes (f-1) pairs
	            map.put(nums[left], leftFreq - 1);
	            left++;
	        }
	    }

	    return ans;
	}

	
	

	public static void main(String[] args) {
		
		//Example 1:

		int [] nums1 = {1,1,1,1,1};
		int k1 = 10;
		int output1=1;

		//Example 2:

		int [] nums2 = {3,1,4,3,2,2,4};
		int k2 = 2;
		int output2=4;
		
		//Example 3:
		
		int [] nums3 = {2,3,1,3,2,3,3,3,1,1,3,2,2,2};
		int k3 = 18;
		int output3=9;
		
		System.out.println(countGoodBest(nums2, k2));
	

	}

}
