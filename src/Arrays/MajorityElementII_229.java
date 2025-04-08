//229. Majority Element II
//Solved
//Medium
//Topics
//Companies
//Hint
//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
//
// 
//
//Example 1:
//
//Input: nums = [3,2,3]
//Output: [3]
//Example 2:
//
//Input: nums = [1]
//Output: [1]
//Example 3:
//
//Input: nums = [1,2]
//Output: [1,2]
// 
//
//Constraints:
//
//1 <= nums.length <= 5 * 104
//-109 <= nums[i] <= 109
// 
//
//Follow up: Could you solve the problem in linear time and in O(1) space?


package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII_229 {
    public static List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap();
        int n = nums.length;
        for(int x:nums){
            if(map.containsKey(x)){
                map.put(x,map.get(x)+1);
            }else{
                map.put(x,1);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            int key= e.getKey();
            int val= e.getValue();
            if(val>(n/3)){
                ans.add(key);
            }
        }
        return ans;
    }
    
    
   public static boolean check(List<Integer> ans, List<Integer> output) {
		// TODO Auto-generated method stub
		if(ans.size()!=output.size()) return false;
		for(int i=0;i<ans.size();i++) {
			if(ans.get(i)!=output.get(i)) return false;
		}
		return true;
	}
    
    public static void main(String[] args) {
    	
    	
    	//Example 1:
    	//
    	int [] nums1 =  {3,2,3};
    	List<Integer> output1= new ArrayList<Integer>(Arrays.asList(3));

    	//Example 2:
    	
    	int [] nums2 =  {1};
    	List<Integer> output2= new ArrayList<Integer>(Arrays.asList(1));

    	//Example 3:

    	int [] nums3 =  {1,2};
    	List<Integer> output3= new ArrayList<Integer>(Arrays.asList(1,2));

    	System.out.println("Brute Force Approch :");
    	List<Integer> ans1 =  majorityElement(nums1);
    	List<Integer> ans2 =  majorityElement(nums2);
    	List<Integer> ans3 =  majorityElement(nums3);
		
		
		if(check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
	}
		if(check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
	}

	
}