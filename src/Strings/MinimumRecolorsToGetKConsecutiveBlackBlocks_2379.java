//2379. Minimum Recolors to Get K Consecutive Black Blocks
//Easy
//Topics
//Companies
//Hint
//You are given a 0-indexed string blocks of length n, where blocks[i] is either 'W' or 'B', representing the color of the ith block. The characters 'W' and 'B' denote the colors white and black, respectively.
//
//You are also given an integer k, which is the desired number of consecutive black blocks.
//
//In one operation, you can recolor a white block such that it becomes a black block.
//
//Return the minimum number of operations needed such that there is at least one occurrence of k consecutive black blocks.
//
// 
//
//Example 1:
//
//Input: blocks = "WBBWWBBWBW", k = 7
//Output: 3
//Explanation:
//One way to achieve 7 consecutive black blocks is to recolor the 0th, 3rd, and 4th blocks
//so that blocks = "BBBBBBBWBW". 
//It can be shown that there is no way to achieve 7 consecutive black blocks in less than 3 operations.
//Therefore, we return 3.
//Example 2:
//
//Input: blocks = "WBWBBBW", k = 2
//Output: 0
//Explanation:
//No changes need to be made, since 2 consecutive black blocks already exist.
//Therefore, we return 0.
// 
//
//Constraints:
//
//n == blocks.length
//1 <= n <= 100
//blocks[i] is either 'W' or 'B'.
//1 <= k <= n


package Strings;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks_2379 {
	
//	brute force approch : we first start our window from the 0 and till k-1 index
//	where we count each white color onces done we know we need to recolor them so we assume it as our answer
//	now we will use the window where we slide it over the where from start we will remove elements
//	and end will add elements 
//	time complexity O:(n)
//	space complexity O:(1)
	
	  public static int minimumRecolors(String blocks, int k) {
	        int start =0;
	        int end =0;
	        int black=0;
	        int white=0;
	        int ans = Integer.MAX_VALUE;
	        while(end<k) {// start the window 
	        	if(blocks.charAt(end)=='W') white++;
	        	if(blocks.charAt(end)=='B') black++;
	        	end++;    	
	        }
	        // here our window will be of k size 
	        ans= Math.min(ans, white);
	        // here we will slide it over the array 
	        while(end<blocks.length()) {
	        	
	        	if(blocks.charAt(start)=='W') white--;
	        	if(blocks.charAt(start)=='B') black--;
	        	if(blocks.charAt(end)=='W') white++;
	        	if(blocks.charAt(end)=='B') black--;
	        	ans= Math.min(ans, white);	        	
	        	start++;
	        	end++;
	        }
	        
	       return ans; 
	        
	    }
	public static void main(String[] args) {
		//Example 1:
		
		String blocks1 = "WBBWWBBWBW";
		int k1 = 7;
		int output1=3;
		
		//Example 2:
		
		String blocks2 = "WBWBBBW";
		int k2 = 2;
		int output2=0;	
		
		int ans1=minimumRecolors(blocks1,k1);
		int ans2=minimumRecolors(blocks1,k2);
		
		System.out.println("brute Force Approch :");
		
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
			
	}

}
