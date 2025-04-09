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
import java.util.concurrent.ConcurrentHashMap;

public class MajorityElementII_229 {
   
//	
	public static List<Integer> majorityElementBruteFroce(int[] nums) {
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
	
	
	
    
//	this a hard question with optimize approch :
//	approch : we have already knew at most the answer will be 2 elements as output
//	we can use a hashmap  to calcualte frequecy where we take frequency of each element
//	every time we check hashset length is greater then 2 if it is we will decrement each
//	element frequncy by 2 if the frequency reaches 0 we will just remove it
//	other wise we will keep it in the hash set
//    time complexity :O(n)
//    space complexity :O(1): but it can be O(n) because tthe object willreside in memeory 
	public static List<Integer> majorityElementBetter(int[] nums) {
        ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap();
        for(int x:nums){
            map.put(x,map.getOrDefault(x,0)+1);
            if(map.size()>2){
                for(int key:map.keySet()){
                    if(map.get(key)==1){
                        map.remove(key);// we can use concurrent hashmap to remove element while iterating on it
                    }else{
                        map.put(key,map.get(key)-1);
                    }
                }
            }
        }
        List<Integer> ans = new ArrayList();
        for(int key:map.keySet()){
            int count=0;
            for(int x:nums){
                if(x==key){
                    count++;
                }
            }
            if(count>nums.length/3){
                ans.add(key);
            }
        }
        return ans;
    }   
	
//	this a hard question with optimize approch :
//	approch : we will do same thing as better solution but we will do it with 2 variables and counts
//	that will solve the proble of variable residing in storage
//    time complexity :O(n)
//    space complexity :O(1)
	public static List<Integer> majorityElementBest(int[] nums) {
		ConcurrentHashMap<Integer,Integer> map = new ConcurrentHashMap();
		List<Integer> ans = new ArrayList();
		int count1=0;
		int count2=0;
		int num1=0;
		int num2=0;
		int n=nums.length;
		for(int i=0;i<n;i++) {
			if(count1==0 && num2!=nums[i]) {// here we put element 1
				num1=nums[i];
				count1++;				
			}else if(count2==0 && num1!=nums[i]) {// here we put element 2
				num2=nums[i];
				count2++;				
			}else if(num1==nums[i]) {// here we take frequency of element 1
				count1++;
			}else if(num2==nums[i]) {// here we take frequnecy of element 2
				count2++;
			}else {// this is just decrement count if the element is not one of the hash map elements
				count1--;
				count2--;
			}
		}
//		re check final elements satisfy the condition
		int c1=0;
		int c2=0;
		for(int x:nums) {
			if(num1==x) {
				c1++;
			}
			if(num2==x) {
				c2++;
			}
		}
		if(c1>(n/3)) {// if yes add to answer
			ans.add(num1);
		}
		if(c2>(n/3)) {
			ans.add(num2);
		}
		
		return ans;// final answer 
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
    	List<Integer>ans1 =  majorityElementBruteFroce(nums1);
    	List<Integer>ans2 =  majorityElementBruteFroce(nums2);
    	List<Integer>ans3 =  majorityElementBruteFroce(nums3);
		
		
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
		System.out.println("Best Force Approch :");
		ans1 =  majorityElementBetter(nums1);
		ans2 =  majorityElementBetter(nums2);
		ans3 =  majorityElementBetter(nums3);
		
		
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