//Container With Most Water
//Solved 
//You are given an integer array heights where heights[i] represents the height of the 
// ith bar.
//
//You may choose any two bars to form a container. Return the maximum amount of water a container can store.
//
//Example 1:
//
//
//
//Input: height = [1,7,2,5,4,7,3,6]
//
//Output: 36
//Example 2:
//
//Input: height = [2,2,2]
//
//Output: 4
//Constraints:
//
//2 <= height.length <= 1000
//0 <= height[i] <= 1000


package TwoPointers;

public class ContainerWithMostWater_NEETCODE {
	
//	brute force :
//	check every pair of pillars and give the max water we ca have :
//	how we can find how much water is present btw the contains:
//	so it can be found finding which pillar is min height 
//	and take product of that by the distance btw both pillars
//	time complexity: O(n*n)
//	space complexity: O(1)
	public static int maxAreaBruteForce(int[] heights) {
	        int res=0;
	        for(int i =0;i<heights.length-1;i++){
	            for(int j =i+1;j<heights.length;j++){
	                int height = Math.min(heights[i],heights[j]);
	                int water= (j-i)*height;
	                res=Math.max(res,water);
	            }
	        }
	        return res;
	    }
//	Better force :
// approch we use 2 pointer one at start one at end 
//	now we check how much water is in btw them
//	and then we will check which pillar is smaller
//	if its left pillar we iincremenet left
//	its right pillar we decrement right
//	if both equal we can do any increment or derement at l or r
//	at last just get the max water
//	time complexity: O(n)
//	space complexity: O(1)
	public static int maxAreaBest(int[] height) {
		        int l=0;
		        int r=height.length-1;
		        int res=0;
		        int n = height.length;
		        while(l<r){
		            res=Math.max(res,(r-l)*Math.min(height[l],height[r]));
		            if (height[l]<height[r]){
		                l++;
		            }else{
		                r--;
		            }
		            }

		        
		        return res;
		    }
	
	


	public static void main(String[] args) {
		
		
		//Example 1:
		int [] height1 = {1,7,2,5,4,7,3,6};
		int output1=36;
		

		//Example 2:
		int [] height2 = {2,2,2};
		int output2=4;
		
		System.out.println("Brute Force Approch : ");
		
		int ans1 = maxAreaBruteForce(height1);
		int ans2 = maxAreaBruteForce(height2);
		
		if(ans1== output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(ans2== output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		
		System.out.println("Better Approch : ");
		
		ans1 = maxAreaBest(height1);
		ans2 = maxAreaBest(height2);
		
		if(ans1== output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(ans2== output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}


	}

}
