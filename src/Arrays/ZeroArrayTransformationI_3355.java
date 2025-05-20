//3355. Zero Array Transformation I
//Solved
//Medium
//Topics
//Companies
//Hint
//You are given an integer array nums of length n and a 2D array queries, where queries[i] = [li, ri].
//
//For each queries[i]:
//
//Select a subset of indices within the range [li, ri] in nums.
//Decrement the values at the selected indices by 1.
//A Zero Array is an array where all elements are equal to 0.
//
//Return true if it is possible to transform nums into a Zero Array after processing all the queries sequentially, otherwise return false.
//
// 
//
//Example 1:
//
//Input: nums = [1,0,1], queries = [[0,2]]
//
//Output: true
//
//Explanation:
//
//For i = 0:
//Select the subset of indices as [0, 2] and decrement the values at these indices by 1.
//The array will become [0, 0, 0], which is a Zero Array.
//Example 2:
//
//Input: nums = [4,3,2,1], queries = [[1,3],[0,2]]
//
//Output: false
//
//Explanation:
//
//For i = 0:
//Select the subset of indices as [1, 2, 3] and decrement the values at these indices by 1.
//The array will become [4, 2, 1, 0].
//For i = 1:
//Select the subset of indices as [0, 1, 2] and decrement the values at these indices by 1.
//The array will become [3, 1, 0, 0], which is not a Zero Array.
// 
//
//Constraints:
//
//1 <= nums.length <= 105
//0 <= nums[i] <= 105
//1 <= queries.length <= 105
//queries[i].length == 2
//0 <= li <= ri < nums.length

package Arrays;

public class ZeroArrayTransformationI_3355 {
	
	
// brute force approch:
//	apply the query on array as said 
//	we will look if the element is already zero we can skip that element or we can just let them  become negative
//	time complexity :O(n*q)
//	space complexity :O(1)
	public static boolean isZeroArrayBruteForce(int[] nums, int[][] queries) {
		int n = queries.length;
		for(int [] query : queries) {
			int l=query[0];
			int r=query[1];
			for(int i=l;i<=r;i++) {
				nums[i]--;
			}
		}
		for(int x:nums) {
			if(x>0) {
				return false;
			}
		}
		return true;
	}
	
// best approch:
//	we can use a difference array algorithm to create a array which hold all operation and apply at pnce
//	diff array use extra array which map the operation on start index
//	and reverse the action at right+1 index
//	so if query = [0,2],[1,2]
//	diff= [-1,0,0,+1]
//	diff= [-1,-1,0,2]
//	now if we take prefix sum
//	diffarr=[-1,-2,-2,2]
//	now we can apply sum of both array element by element and get a result in O(n) time
//	here we will let the nums element be decremented because we only care we can make zero 
//	so if its less then zero means its possible to make them zero 
//	time complexity :O(n+q)
//	space complexity :O(n)
	    public static boolean isZeroArrayBest(int[] nums, int[][] queries) {
	       int n = nums.length;
	       int [] diffArr = new int[n];
	       for(int [] query:queries){
	        int l= query[0];
	        int r= query[1];
	        diffArr[l]--;
	        if(r+1<n){
	            diffArr[r+1]++;
	        }
	       }
	       for(int i =1;i<n;i++){
	        diffArr[i]= diffArr[i]+diffArr[i-1];
	       }
	    //    System.out.println(Arrays.toString(diffArr));
	       for(int i =0;i<n;i++){
	    	   
	        nums[i]= nums[i]+diffArr[i];
	        if(nums[i]>0){
	            return false;
	        }
	       }
	       return true;
	    }
	
	public static void main(String[] args) {

		//Example 1:

		int [] nums1 = {1,0,1};
		int [][] queries1 = {{0,2}};
		boolean output1=true;

		//Example 2:

		int [] nums2 = {4,3,2,1};
		int [][] queries2 = {{1,3},{0,2}};
		boolean output2=false;

		//Example 3:
		
		int [] nums3= {2,0,3};
		int [][] queries3 = {{0,2},{0,1},{0,2},{1,2}};
		boolean output3=true;
		
		
		
		System.out.println("Brute Force Approch :");

		boolean ans1=isZeroArrayBruteForce(nums1, queries1);
		boolean ans2=isZeroArrayBruteForce(nums2, queries2);
		boolean ans3=isZeroArrayBruteForce(nums3, queries3);
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}
		
		
		
		System.out.println("Best Approch :");
		
		ans1=isZeroArrayBest(nums1, queries1);
		ans2=isZeroArrayBest(nums2, queries2);
		ans3=isZeroArrayBest(nums3, queries3);
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ ans3);
			System.out.println("Actual Output :"+ output3);			
		}

	}

}
