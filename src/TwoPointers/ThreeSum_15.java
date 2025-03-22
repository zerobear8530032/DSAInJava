package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class ThreeSum_15 {
	    
//	brute force approch :
//	here we take every single pair by nested loop
//	and sort the triplet and add it to the hashset to remove duplicates
//	and last give answer as a list
//	time complexity: O(n*n*(n log n +n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBruteForce(int[] nums) {
	        HashSet<List<Integer>> triplets = new HashSet();
	        for(int i =0;i<nums.length;i++){
	            for(int j =i+1;j<nums.length;j++){
	                for(int k =j+1;k<nums.length;k++){
	                    int sum = nums[i]+nums[j]+nums[k];
	                    if(sum==0){
	                        List <Integer> temp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
	                        Collections.sort(temp);
	                        triplets.add(temp);
	                    }
	                }
	            }
	        }
	        List<List<Integer>> ans = new ArrayList<List<Integer>>(triplets);
	        return ans;
	    }
	
//	Better approch :
//	HERE THE  WE CAN OPTIMIZE IT IF THE INITAL ARRAY IS SORTED WE CAN SET 2 POINTER TO 2 INDEX AND REST OF THE
//	LAST NUMBER CAN BE GET AS TARGET-NUMS[X1]+NUMS[X2]= NUMS[X3]
//	WE CAN SEARCH FOR THAT NUMS[X3} USING BINARY SEARCH 
//	time complexity: O(n log n)+O(n*n* log n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBetter(int[] nums) {
		HashSet<List<Integer>> triplets = new HashSet();
		Arrays.sort(nums);
		for(int i =0;i<nums.length;i++){
			for(int j =i+1;j<nums.length;j++){
				int target= 0-(nums[i]+nums[j]);
				int k=search(nums, j+1, nums.length-1, target);
				if(k!=-1) {
					List<Integer> temp = new ArrayList(Arrays.asList(nums[i],nums[j],nums[k]));
					triplets.add(temp);
				}
			}
		}
		List<List<Integer>> ans = new ArrayList(triplets);
		return ans;
	}
	
//	Best approch :
//	we can sort the array and then apply a 2 pointer technique to search the target instead of binary search
//	time complexity: O(n log n)+O(n*n*n) 
//	space complexity: space n*3; 
	public static List<List<Integer>> threeSumBest(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		int n = nums.length;
		int i =0;
		while(i<n-2) {// initial 2 sum
			int k = n-1;
			int j = i+1;
			while(j<k) {
				int sum = nums[i]+nums[j]+nums[k];// sum
				if(sum==0) {// add the triplets
					List<Integer> t= new ArrayList<Integer>(Arrays.asList(nums[i],nums[j],nums[k]));
					ans.add(t);
					int currj= nums[j];
					while(j+1<n && currj==nums[j]) {// once we used the triplets we can skip all duplicates at index j
						j++;
					}
					int currk= nums[k];
					while(k-1>=0 && currk==nums[k]) {// once we used the triplets we can skip all duplicates at index k
						k--;
					}
				}else if(sum<0) {// if we need bigger sum  we increase j 
					j++;
				}else {
					k--;// if we need smaller sum we can decrease k
				}
			}
			int curri=nums[i];
			while(i<n && nums[i]==curri ) {// here we skip all duplicate i because we  have already used it above
				i++;
			}
		}
		
		return ans;
	}
	public static int search(int [] nums, int start ,int end, int target) {
		while(start<=end) {
			int mid = start+(end-start)/2;
			if(target<nums[mid]) {
				end=mid-1;
			}else if (target>nums[mid]){
				start=mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static boolean check(List<List<Integer>> ans, List<List<Integer>> output) {
		if(output.size()!=ans.size()) {
			return false;
		}
		for(int i =0;i<ans.size();i++) {
			if(output.get(i).size()!= ans.get(i).size()) {
				return false;
			}
			Collections.sort(ans.get(i));
			Collections.sort(output.get(i));
			for(int j=0;j<output.get(i).size();j++) {
				if(ans.get(i).get(j)!= output.get(i).get(j)) {
					return false;
				}
			}
		}
		return true;
	}

	 
	
	
	public static void main(String[] args) {
		
		int []nums1 = {-1,0,1,2,-1,-4};
		List<List<Integer>> output1 = new ArrayList<>(Arrays.asList(Arrays.asList(-1, -1, 2),Arrays.asList(-1, 0, 1)));
		int []nums2 = {0,1,1};
		List<List<Integer>> output2 = new ArrayList<>();
		
System.out.println("Brute Force Approch ");
		
		
		List<List<Integer>> ans1 = threeSumBruteForce(nums1);
		List<List<Integer>> ans2 = threeSumBruteForce(nums2);
	
		
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		
		System.out.println("Optimize Approch :");
		
		ans1 = threeSumBetter(nums1);
		ans2 = threeSumBetter(nums2);
		
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		System.out.println("Best Approch :");
		
		ans1 = threeSumBest(nums1);
		ans2 = threeSumBest(nums2);
		
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		
		
	}

}
