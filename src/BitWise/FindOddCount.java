package BitWise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.Manifest;

public class FindOddCount {
	
	
	
//	brute force approch :
//	sort the array and count the number frequency:
//	time complexity :O(n log n)
//	space complexity :O(1)
	public static int findOddOccurenceBruteForce(int [] nums) {
		Arrays.sort(nums);
		int i =0;
		while(i<nums.length) {
			int currentidx=i;
			int count=0;
			while(currentidx< nums.length && nums[currentidx]==nums[i]) {
				count++;
				currentidx++;
			}
			if(count==1) return nums[i];
			i=currentidx;
		}
		return -1;
	}
//	better approch :
//	sort the array and count the number frequency:
//	time complexity :O(n)
//	space complexity :O(n)
	public static int findOddOccurenceBetter(int [] nums) {
		HashMap<Integer, Integer> map = new HashMap();
		int i =0;
		for(int x:nums) {
			if(map.containsKey(x)) {
				map.put(x, map.get(x)+1);
			}else {
				map.put(x,1);
			}
		}
		for(Map.Entry<Integer, Integer> e: map.entrySet()) {
			if(e.getValue()==1) {
				return e.getKey();
			}
		}
		return -1;
	}
	
//	best approch :
//	xor entire array cause a ^a = 0 & a^ 0 =a
//	time complexity :O(n)
//	space complexity :O(1)
	public static int findOddOccurenceBest(int [] nums) {
		int ans =0;
		for(int x:nums) {
			ans= ans^x;
		}
		return ans;
	}

	public static void main(String[] args) {
		int [] nums= {1,1,34,2,3,34,2,3,4};
		System.out.println(findOddOccurenceBruteForce(nums));
		System.out.println(findOddOccurenceBetter(nums));
		System.out.println(findOddOccurenceBest(nums));
		

	}

}
