//2570. Merge Two 2D Arrays by Summing Values
//Easy
//Topics
//Companies
//Hint
//You are given two 2D integer arrays nums1 and nums2.
//
//nums1[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
//nums2[i] = [idi, vali] indicate that the number with the id idi has a value equal to vali.
//Each array contains unique ids and is sorted in ascending order by id.
//
//Merge the two arrays into one array that is sorted in ascending order by id, respecting the following conditions:
//
//Only ids that appear in at least one of the two arrays should be included in the resulting array.
//Each id should be included only once and its value should be the sum of the values of this id in the two arrays. If the id does not exist in one of the two arrays, then assume its value in that array to be 0.
//Return the resulting array. The returned array must be sorted in ascending order by id.
//
// 
//
//Example 1:
//
//Input: nums1 = [[1,2],[2,3],[4,5]], nums2 = [[1,4],[3,2],[4,1]]
//Output: [[1,6],[2,3],[3,2],[4,6]]
//Explanation: The resulting array contains the following:
//- id = 1, the value of this id is 2 + 4 = 6.
//- id = 2, the value of this id is 3.
//- id = 3, the value of this id is 2.
//- id = 4, the value of this id is 5 + 1 = 6.
//Example 2:
//
//Input: nums1 = [[2,4],[3,6],[5,5]], nums2 = [[1,3],[4,3]]
//Output: [[1,3],[2,4],[3,6],[4,3],[5,5]]
//Explanation: There are no common ids, so we just include each id with its value in the resulting list.
// 
//
//Constraints:
//
//1 <= nums1.length, nums2.length <= 200
//nums1[i].length == nums2[j].length == 2
//1 <= idi, vali <= 1000
//Both arrays contain unique ids.
//Both arrays are in strictly ascending order by id.

package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MergeTwo2DArraysBySummingValues_2570 {
//	Brute Force approch :
//	go over each id in one array and find the same id in other array if found add their values other wise
//	just add the current element;

//	time complexity : O(N*M) -> sorting algo O(N*N) +searching elements O(N*M) + searching in array List O(N*M)
//	3*O(N*N)
//	space complexity : O(N+N)  -> intermediate array list 
	
	 public static int[][] mergeArraysBruteForce(int[][] nums1, int[][] nums2) {
		 List<int []> ans = new ArrayList<int []>();
//		search each key in one array and add to another
		 for(int i =0;i<nums1.length;i++) {
			 int id = nums1[i][0];
			 int foundidx= search(nums2,id);
			 if(foundidx!=-1) {
				 int sum[]= new int [2];
				 sum[0]=nums1[i][0];
				 sum[1]=nums1[i][1]+nums2[i][1]; 
				 ans.add(sum);
			 }else {
				 ans.add(nums1[i]);				 
			 }
		 }
		 
//		 search throught the ans list and add the key which are not present in the final ans:
		 for(int i=0;i<nums2.length;i++) {
			 int key = nums2[i][0];
			 int foundidx= search(ans,key);
			 if(foundidx==-1) {
				 ans.add(nums2[i]);
			 }
		 }
//		 here we need to convert the type of list to array in java Integer,int are different types :
		 
		 int [][] finalans = new int [ans.size()][];		 
		 for(int i =0;i<ans.size();i++) {
			 finalans[i]=ans.get(i);
		 }
		 
		 sort2Darray(finalans);
	       return finalans;
	    }
	 

	 
	 public static int search(int [][]nums,int key) {
		 for(int i =0;i<nums.length;i++) {
			 if(nums[i][0]==key) {
				 return i;
			 }
		 }
		 return -1;
		 
	 }
	 public static int search(List<int []> nums,int key) {
		 for(int i =0;i<nums.size();i++) {
			 if(nums.get(i)[0]==key) {
				 return i;
			 }
		 }
		 return -1;
		 
	 }
	 
	 public static void sort2Darray(int [][] mat) {
		 
		 for(int i =0;i<mat.length-1;i++) {
			 for(int j =i+1;j<mat.length;j++) {
				 if(mat[i][0]>mat[j][0]) {
					 int [] temp = mat[i];
					 mat[i]=mat[j];
					 mat[j]=temp;
				 }
			 }
		 }
		 
	 }
	 
	 public static boolean check(int [][] ans,int [][] output) {
	    	if(ans.length!=output.length  || ans[0].length != output[0].length) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.length;i++) {
	    		if(ans[i].length!=output[i].length) return false;
	    		for(int j=0;j<ans[i].length;j++) {
	    			if(ans[i][j]!=output[i][j]) {
	    				return false;
	    			}
	    		}
	    	}
	    	return true;
	    }
	 
//	 use binary search to search the key :
//		go over each id in one array and find the same id in other array if found add their values other wise
//		just add the current element;

//		time complexity : O(N*M) -> sorting algo O(N*N) +searching elements O(log N) + searching in array List O(og n)
//		3*O(N*N)
//		space complexity : O(N+M)  -> intermediate array list 
		
	 public static int[][] mergeArraysBetterApproch(int[][] nums1, int[][] nums2) {
		 List<int []> ans = new ArrayList<int []>();
//			search each key in one array and add to another
			 for(int i =0;i<nums1.length;i++) {
				 int id = nums1[i][0];
				 int foundidx= BinarySearch(nums2,id);
				 if(foundidx!=-1) {
					 int sum[]= new int [2];
					 sum[0]=nums1[i][0];
					 sum[1]=nums1[i][1]+nums2[i][1]; 
					 ans.add(sum);
				 }else {
					 ans.add(nums1[i]);				 
				 }
			 }
			 
//			 search throught the ans list and add the key which are not present in the final ans:
			 for(int i=0;i<nums2.length;i++) {
				 int key = nums2[i][0];
				 int foundidx= BinarySearch(ans,key);
				 if(foundidx==-1) {
					 ans.add(nums2[i]);
				 }
			 }
//			 here we need to convert the type of list to array in java Integer,int are different types :
			 
			 int [][] finalans = new int [ans.size()][];		 
			 for(int i =0;i<ans.size();i++) {
				 finalans[i]=ans.get(i);
			 }
			 
			 sort2Darray(finalans);
		       return finalans;
		 
		 
	 }
	 
	 
	 
	 
	 
	 private static int BinarySearch(List<int[]> ls, int key) {
		 int start=0;
		 int end = ls.size()-1;
		 while(start<=end) {
			 int mid=start+(end-start)/2;
			 if(ls.get(mid)[0]>key) {
				 end=mid-1;
			 }else if(ls.get(mid)[0]<key) {
				 start=mid+1;
			 }else {
				 return mid;
			 }
			 
		 }
		 return -1;
		 
		
	}
	 
//	 Optimize :
//	 create a treemap which iteate on both array :
//	 and put its key as key and value as val 
//	 once it iterate first in second we check key already exists then we update the old vval 
//	 as old+new val and iterate over entire array
//	 last convert hashmap in array 
	 public static int[][] mergeArraysBest(int[][] nums1, int[][] nums2) {
		 TreeMap<Integer,Integer> map = new TreeMap();
		 
		 for(int i=0;i<nums1.length;i++) {
			 int key=nums1[i][0];
			 int val=nums1[i][1];
			 map.put(key,val);
		 }
		 for(int i=0;i<nums2.length;i++) {
			 int key=nums2[i][0];
			 int val=nums2[i][1];
			 if(map.containsKey(key)) {
				 map.put(key, map.get(key)+val);
			 }else {
				 map.put(key, val);
			 }
		 }
		 
		 int [][] ans = new int [map.size()][2];
		 int idx=0;
		 for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			 int k=e.getKey();
			 int v=e.getValue();
			 ans[idx][0]=k;
			 ans[idx][1]=v;
			 idx++;
		 }

		 return ans;
	    }

	private static int BinarySearch(int[][] nums, int key) {
		 int start=0;
		 int end = nums.length-1;
		 while(start<=end) {
			 int mid=start+(end-start)/2;
			 if(nums[mid][0]>key) {
				 end=mid-1;
			 }else if(nums[mid][0]<key) {
				 start=mid+1;
			 }else {
				 return mid;
			 }
			 
		 }
		 return -1;
	}



	public static String printImage(int [][]img) {
	    	
	    	StringBuilder str = new StringBuilder("[");
	    	for(int i =0;i<img.length;i++) {
	    		str.append(Arrays.toString(img[i]));
	    	}
	    	str.append("]");
	    	return str.toString();
	    }
	 
	 
	public static void main(String[] args) {
		
		
		//Example 1:
		
		int [][]nums11 = {{1,2},{2,3},{4,5}}, nums12 = {{1,4},{3,2},{4,1}};
		int [][] output1= {{1,6},{2,3},{3,2},{4,6}};
		
		//Explanation: The resulting array contains the following:
		//- id = 1, the value of this id is 2 + 4 = 6.
		//- id = 2, the value of this id is 3.
		//- id = 3, the value of this id is 2.
		//- id = 4, the value of this id is 5 + 1 = 6.
		//Example 2:
		//
		int [][]nums21 = {{2,4},{3,6},{5,5}}, nums22 = {{1,3},{4,3}};
		int [][] output2= {{1,3},{2,4},{3,6},{4,3},{5,5}};
		
		System.out.println("Brute Force Approch :");
		
		int ans1[][]=mergeArraysBruteForce(nums11,nums12);
		int ans2[][]=mergeArraysBruteForce(nums21,nums22);

    	if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printImage(output1));
			System.out.println("Your Answer :"+ printImage(ans1));
		}
		if(check(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ printImage(output2));
			System.out.println("Your Answer :"+printImage(ans2) );
		}
		
		
		System.out.println("Better Approch :");
		
		ans1=mergeArraysBetterApproch(nums11,nums12);
		ans2=mergeArraysBetterApproch(nums21,nums22);
		
		if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printImage(output1));
			System.out.println("Your Answer :"+ printImage(ans1));
		}
		if(check(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ printImage(output2));
			System.out.println("Your Answer :"+printImage(ans2) );
		}
		
		
		System.out.println("Best Approch :");
		
		ans1=mergeArraysBest(nums11,nums12);
		ans2=mergeArraysBest(nums21,nums22);
		
		if(check(output1, ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ printImage(output1));
			System.out.println("Your Answer :"+ printImage(ans1));
		}
		if(check(output2, ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ printImage(output2));
			System.out.println("Your Answer :"+printImage(ans2) );
		}
		
		

		

	}

}
