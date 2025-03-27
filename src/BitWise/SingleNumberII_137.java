//137. Single Number II
//Solved
//Medium
//Topics
//Companies
//Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.
//
//You must implement a solution with a linear runtime complexity and use only constant extra space.
//
// 
//
//Example 1:
//
//Input: nums = [2,2,3,2]
//Output: 3
//Example 2:
//
//Input: nums = [0,1,0,1,0,1,99]
//Output: 99
// 
//
//Constraints:
//
//1 <= nums.length <= 3 * 104
//-231 <= nums[i] <= 231 - 1
//Each element in nums appears exactly three times except for one element which appears once.

package BitWise;

import java.util.HashMap;
import java.util.Map;

class SingleNumberII_137 {
    
//	brute force : create a hashmap :
//	make a frequency map and return the key of number having frequnecy as 1
//	time complexity : O(n)
//	Space complexity : O(n)
	public static int singleNumberBruteForce(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else{
                map.put(nums[i],1);
            }
        }
        for(Map.Entry<Integer,Integer> e: map.entrySet()){
            if(e.getValue()==1){
                return e.getKey();
            }
        }
        return -1;
    }
	
//	Better approch : 
//	we can reduce space with some small time increase 
//	we know each number is coming exactly three times 
//	so can we just create a array of 32 size and check
//	map each bit frequency at its position in number 
//	means if n= 3
//	it occur three times 
//	array = [0,0,0,0,0,0,0,0,0,....3,3]
//	so when a number come only 1 time like 2 
//	array = [0,0,0,0,0,0,0,0,0,....4,3]
//	we can mod each index by 3 
//	array = [0,0,0,0,0,0,0,0,0,....1,0]
//	now if we convert this to int we will get our answer  as  2
//	time complexity : O(n)
//	Space complexity : O(1)
//	Space complexity : O(n): if we consider creating a string of number as extra space 
	public static int singleNumberBetter(int[] nums) {
		int []map= new int [32]; 
		for(int x : nums) {
			String num=Integer.toBinaryString(x);
			int arridx=31;
			for(int i=num.length()-1;i>=0;i--) {
				if(num.charAt(i)=='1') {
					map[arridx]++;
				}
				arridx--;
			
			}
		}
		
		for(int i =0;i<map.length;i++) {
			map[i]%=3;
		}
		int ans =0;
		int p=0;
		if(map[0]!=1) {	
		for(int i =31;i>=0;i--) {
			if(map[i]!=0) {
				ans+= Math.pow(2, p);
			}
			p++;
		}
		}else {
			for(int i =31;i>=0;i--) {
				if(map[i]==0) {
					ans+= Math.pow(2, p);
				}
				p++;
			}			
			return -(ans+1);
		}
		
		return ans;
	}
//	Best approch : 
//	every thing will remain same just we will use bit wise opertions to find
//	bits
//	setbits instead  of using the string method
//	here are some edge cases 1 :  the number we need to convert could be a negative number also
//	so we need to use 2 s complemennt of a number 
//	time complexity : O(n)
//	space complexity : O(1)
	public static int singleNumberBest(int[] nums) {
		int []map= new int [32]; 
		for(int x : nums) {
			for(int i =0;i<32;i++) {
				int bit = x&(1<<i);
				if(bit!=0) {
					map[31-i]++;
				}
			}
		
		}
		
		for(int i =0;i<map.length;i++) {
			map[i]%=3;
		}
		int ans =0;
		int p=0;
		if(map[0]!=1) {	// cheking number is a positive or negative
			for(int i =31;i>=0;i--) {
				if(map[i]!=0) {
					ans+= Math.pow(2, p);
				}
				p++;
			}
		}else {
//			taking 2 s complemet 
			for(int i =31;i>=0;i--) {
				if(map[i]==0) {
					ans+= Math.pow(2, p);
				}
				p++;
			}			
//			here we reverse the 2 s complement
			return -(ans+1);
		}
		
		return ans;
	}
    
    
    public static void main(String[] args) {
    	
    	//Example 1:

    	int nums1[] =  {2,2,3,2};
    	int output1=3;

    	//Example 2:
    	int nums2[] =  {0,1,0,1,0,1,99};
    	int output2=99;
    	
    	//Example 3:
    	int nums3[] =  {-2,-2,1,1,4,1,4,4,-4,-2};
    	int output3=-4;
    	
    	System.out.println("Brute Force Approch :");
    	
    	int ans1= singleNumberBruteForce(nums1);
    	int ans2= singleNumberBruteForce(nums2);
    	int ans3= singleNumberBruteForce(nums3);
    	
    	if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		
		System.out.println("Better Approch :");
		ans1= singleNumberBetter(nums1);
		ans2= singleNumberBetter(nums2);
		ans3= singleNumberBetter(nums3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		System.out.println("BestApproch :");
		ans1= singleNumberBest(nums1);
		ans2= singleNumberBest(nums2);
		ans3= singleNumberBest(nums3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		

		
	}
}