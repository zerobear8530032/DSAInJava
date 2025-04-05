//https://neetcode.io/problems/top-k-elements-in-list
//Top K Frequent Elements
//Solved 
//Given an integer array nums and an integer k, return the k most frequent elements within the array.
//
//The test cases are generated such that the answer is always unique.
//
//You may return the output in any order.
//
//Example 1:
//
//Input: nums = [1,2,2,3,3,3], k = 2
//
//Output: [2,3]
//Example 2:
//
//Input: nums = [7,7], k = 1
//
//Output: [7]
//Constraints:
//
//1 <= nums.length <= 10^4.
//-1000 <= nums[i] <= 1000
//1 <= k <= number of distinct elements in nums.




package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequentElements_NEETCODE {
	
//	Approch : 
//	first create a frequecy hashmap then just sort it by values 
//	at last return top k elements;
//	time complexity :O(n)+O(n log n)
//	time complexity :O(n)
	 public static int[] topKFrequentBruteForce(int[] nums, int k) {
	     HashMap<Integer,Integer> map= new HashMap();  
	     for(int x :nums) {
	    	 if(map.containsKey(x)) {
	    		 map.put(x, map.get(x)+1);
	    	 }else {
	    		 map.put(x, 1);
	    	 }
	     }
//	     sort the map keys and store it in the linked list :
	     
	     List <Map.Entry<Integer,Integer>>list = new LinkedList<>(map.entrySet());
	     Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
	    	 public int compare(Map.Entry<Integer, Integer> o1,Map.Entry<Integer, Integer>o2) {
	    		 return o2.getValue().compareTo(o1.getValue());
	    	 }
	     																		});
//	     now just return the starting top k element from linked list
	     int ans[] = new int[k];
	     for(int i=0;i<k;i++) {
	    	 ans[i]=list.get(i).getKey();
	     }

		return ans;
	    
	    }
	
//	Better Approch : 
//	first create a frequecy hashmap then just use nax heap where the  
//	at last return top k elements;
//	time complexity :O(n log n)
//	space complexity :O(n)
	 public static int[] topKFrequentBetter(int[] nums, int k) {
		 HashMap<Integer,Integer> map= new HashMap();  
		 for(int x :nums) {
			 if(map.containsKey(x)) {
				 map.put(x, map.get(x)+1);
			 }else {
				 map.put(x, 1);
			 }
		 }
//	     sort the use a priority queue to store key value pairs in that:
		 
		 PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(
		            (o1, o2) -> Integer.compare(o2.getValue(), o1.getValue())
		        );
		        // Add all entries to the minHeap (PriorityQueue)
		        maxHeap.addAll(map.entrySet());
		        int [] ans = new int [k];
		        for(int i =0;i<k;i++) {
		        	ans[i]=maxHeap.poll().getKey();
		        }
		 return ans;
	 }
//	Best Approch : 
//	 use bucket sort 
//	 where we create a list of same length of input array and at each index it store 
//	 elements how many time they occurred
//	time complexity :O(n)
//	space complexity :O(n)
	 public static int[] topKFrequentBest(int[] nums, int k) {
		 HashMap<Integer,Integer> map= new HashMap();  
		 for(int x :nums) {
			 if(map.containsKey(x)) {
				 map.put(x, map.get(x)+1);
			 }else {
				 map.put(x, 1);
			 }
		 }// here we create frequency map
//		 this array will map the number of elements which have frequency where each index 
//		 is a list and each element is at  having frequency as its index
		 List<Integer>[] bucketarray= new List[nums.length+1]; 
		 for(Map.Entry<Integer, Integer> e:map.entrySet()) {
			 int freq=e.getValue();
			 int key=e.getKey();
			 if(bucketarray[freq]==null) {
				 bucketarray[freq]=new ArrayList();
				 bucketarray[freq].add(key);
			 }else {
				 bucketarray[freq].add(key);
			 }
		 }
//		 this i creating the output array from the bucket array 
		 int resindex=0;
		 int[] ans = new int [k];
		 for(int i =bucketarray.length-1;i>=0;i--) {
			 
			 if(bucketarray[i]==null) {
				 continue;
			 }else {
				 if(resindex==k) {
					 break;
				 }
				 for(int j=0;j<bucketarray[i].size();j++) {
					 ans[resindex]=bucketarray[i].get(j);
					 resindex++;
				 }
				 
			 }
		 }
		 
		 
		 
		 return ans;
	 }
	 
	 public static boolean check(int [] ans,int []output) {
		 if(ans.length!=output.length) {
			 return false;
		 }
		 for(int i=0;i<ans.length;i++) {
			 boolean exists=false;
			 for(int j=0;j<output.length;j++) {
				 if(ans[i]==output[j]) {
					 exists=true;
					 break;
				 }
				 
			 }
			 if(exists==false) {
				 return false;
			 }
			 
		 }
		 return true;
	 }

	public static void main(String[] args) {
		
		
		//Example 1:
	
		int []nums1 = {1,2,2,3,3,3};
		int k1 = 2;
		int [] output1= {2,3};
	
		//Example 2:
		
		int []nums2 = {7,7};
		int k2 = 1;
		int [] output2= {7};
		
		int [] ans1=topKFrequentBruteForce(nums1, k1);
		int [] ans2=topKFrequentBruteForce(nums2, k2);
		
		System.out.println("Brute Force Approch :");
        
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
		ans1=topKFrequentBetter(nums1, k1);
		ans2=topKFrequentBetter(nums2, k2);
		
		System.out.println("Brute Force Approch :");
        
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
		ans1=topKFrequentBest(nums1, k1);
		ans2=topKFrequentBest(nums2, k2);
		
		System.out.println("Best Force Approch :");
		
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
	}

}
