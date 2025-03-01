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
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TopKFrequentElements_NEETCODE {
	
//	Approch : 
//	first create a frequecy hashmap then just sort it by values 
//	at last return top k elements;
//	time complexity :O(n)+O(n log n)
//	time complexity :O(n)
	 public static int[] topKFrequentSimpleHashMap(int[] nums, int k) {
	     HashMap<Integer,Integer> map= new HashMap();  
	     for(int x :nums) {
	    	 if(map.containsKey(x)) {
	    		 map.put(x, map.get(x)+1);
	    	 }else {
	    		 map.put(x, 1);
	    	 }
	     }
//	     sort the map keys by values and store it in the linked list :
	     
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
	 
	 
	 public static int[] topKFrequentLinkedHashMap(int[] nums, int k) {
		 LinkedHashMap<Integer,Integer> map= new LinkedHashMap();  
		 for(int x :nums) {
			 if(map.containsKey(x)) {
				 map.put(x, map.get(x)+1);
			 }else {
				 map.put(x, 1);
			 }
		 }
//	     sort the map keys by values and store it in the linked list :
		 
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

//	 using tree map :
	 public static int[] topKFrequentTreeMap(int[] nums, int k) {
		 TreeMap<Integer,Integer> map= new TreeMap();  
		 for(int x :nums) {
			 if(map.containsKey(x)) {
				 map.put(x, map.get(x)+1);
			 }else {
				 map.put(x, 1);
			 }
		 }
//	     sort the map keys by values and store it in the linked list :
		 
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
	 

	public static void main(String[] args) {
		
		
		//Example 1:
	
		int []nums1 = {1,2,2,3,3,3};
		int k1 = 2;
		int [] output1= {2,3};
	
		//Example 2:
		
		int []nums2 = {7,7};
		int k2 = 1;
		int [] output2= {7};
		
		int []nums3 = {5,5,5,5,5,5,1,1,3,3,4,5};
		int k3 = 3;
		int [] output3= {5,1,2};
		
		System.out.println("Simple Hash Map Case 1 :");
		long before = System.currentTimeMillis();
	    topKFrequentSimpleHashMap(nums1, k1);
	    long after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds 
		
	    System.out.println("Simple Hash Map Case 2 :");
	    before = System.currentTimeMillis();
	    topKFrequentSimpleHashMap(nums2, k2);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
		
	    System.out.println("Simple Hash Map Case 3 :");
	    before = System.currentTimeMillis();
	    topKFrequentSimpleHashMap(nums3, k3);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
	    
	    System.out.println("Linked Hash Map Case 1 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums1, k1);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds 
	    
	    System.out.println("Linked Hash Map Case 2 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums2, k2);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
	    
	    System.out.println("Linked Hash Map Case 3 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums3, k3);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
	    
	    System.out.println("Tree  Map Case 1 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums1, k1);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds 
	    
	    System.out.println("Tree  Map Case 2 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums2, k2);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
	    
	    System.out.println("Tree  Map Case 3 :");
	    before = System.currentTimeMillis();
	    topKFrequentLinkedHashMap(nums3, k3);
	    after = System.currentTimeMillis();
	    System.out.println("run time : " + (after- before) );// mili seconds
	    
	}

}
