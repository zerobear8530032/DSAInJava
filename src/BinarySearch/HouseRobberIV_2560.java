//2560. House Robber IV
//Medium
//Topics
//Companies
//Hint
//There are several consecutive houses along a street, each of which has some money inside. There is also a robber, who wants to steal money from the homes, but he refuses to steal from adjacent homes.
//
//The capability of the robber is the maximum amount of money he steals from one house of all the houses he robbed.
//
//You are given an integer array nums representing how much money is stashed in each house. More formally, the ith house from the left has nums[i] dollars.
//
//You are also given an integer k, representing the minimum number of houses the robber will steal from. It is always possible to steal at least k houses.
//
//Return the minimum capability of the robber out of all the possible ways to steal at least k houses.
//
// 
//
//Example 1:
//
//Input: nums = [2,3,5,9], k = 2
//Output: 5
//Explanation: 
//There are three ways to rob at least 2 houses:
//- Rob the houses at indices 0 and 2. Capability is max(nums[0], nums[2]) = 5.
//- Rob the houses at indices 0 and 3. Capability is max(nums[0], nums[3]) = 9.
//- Rob the houses at indices 1 and 3. Capability is max(nums[1], nums[3]) = 9.
//Therefore, we return min(5, 9, 9) = 5.
//Example 2:
//
//Input: nums = [2,7,9,3,1], k = 2
//Output: 2
//Explanation: There are 7 ways to rob the houses. The way which leads to minimum capability is to rob the house at index 0 and 4. Return max(nums[0], nums[4]) = 2.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//1 <= k <= (nums.length + 1)/2
package BinarySearch;

import java.util.HashMap;
import java.util.TreeSet;

public class HouseRobberIV_2560 {
	
//	we can use binary search :
//	to search for capability btw min max 
	
	  public static int minCapability(int[] nums, int k) {
	        int res=0;
	        int start=Integer.MAX_VALUE;
	        int end= Integer.MIN_VALUE;
	        for(int x: nums) {
	        	start=Math.min(start, x);
	        	end=Math.max(end, x);
	        }
	        while(start<=end) {
	        	int mid=start+(end-start)/2;
	        	if(is_valid(nums,mid,k)) {
	        		res=mid;
	        		end=mid-1;
	        	}else {
	        		start=mid+1;
	        	}
	        }
	        return res;
	    }
	  
	  public static boolean is_valid(int[] nums,int cap,int k) {
		  int i=0;
		  int c=0;
		  while(i<nums.length) {
			  
			  if(nums[i]<=cap) {
				  i=i+2;
				  c++;
			  }else {
				  i=i+1;
			  }
			  if(c==k)  {
				  break;
			  }
			  
		  }
		  
		  return c==k;
		   
	  }

	public static void main(String[] args) {
		//Example 1:
		//
		int []nums1 = {2,3,5,9};
		int k1 = 2;
		int output1=5;
		
		//Example 2:
		//
		int []nums2 = {2,7,9,3,1};
		int k2 = 2;
		int output2=2;
		
		int ans1=minCapability(nums1,k1);
		int ans2=minCapability(nums2,k2);
		
		System.out.println("Best Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}


        TreeSet<Integer> set= new TreeSet<>();
        set.add(12);class Solution {
            public int[] avoidFlood(int[] rains) {
                HashMap<Integer,Integer> rainyDays = new HashMap<Integer,Integer>();
                TreeSet<Integer> dryDays = new TreeSet<Integer>();
                int [] output= new int [rains.length];
                for(int i =0;i<rains.length;i++){
                    if(rains[i]!=0){
                        if(rainyDays.containsKey(rains[i])){
                            int lastRainedDay = rainyDays.get(rains[i]);
                            Integer lastDryDay = dryDays.higher(lastRainedDay);
                            if(lastDryDay==null){
                                return new int [] {};
                            }else{
                                output[lastDryDay]= rains[i];
                                dryDays.remove(lastDryDay);
                                rainyDays.put(rains[i],i);
                                output[i]=-1;
                            }
                        }else{
                            output[i]=-1;
                            rainyDays.put(rains[i],i);
                        }
                    }else{
                        dryDays.add(i);
                        output[i]=1;// by default we consider we will dry 1 lake for not
                    }
                }
                return output;
            }
        }
        set.add(1);
        set.add(2);
        set.add(15);
        set.add(11);
        set.add(143);
        set.add(11);

        System.out.println(set);

        System.out.println(set.higher(213));
        System.out.println(set.higher(1));

	}

}
