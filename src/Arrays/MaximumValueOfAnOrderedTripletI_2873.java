//2873. Maximum Value of an Ordered Triplet I
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a 0-indexed integer array nums.
//
//Return the maximum value over all triplets of indices (i, j, k) such that i < j < k. If all such triplets have a negative value, return 0.
//
//The value of a triplet of indices (i, j, k) is equal to (nums[i] - nums[j]) * nums[k].
//
// 
//
//Example 1:
//
//Input: nums = [12,6,1,2,7]
//Output: 77
//Explanation: The value of the triplet (0, 2, 4) is (nums[0] - nums[2]) * nums[4] = 77.
//It can be shown that there are no ordered triplets of indices with a value greater than 77. 
//Example 2:
//
//Input: nums = [1,10,3,4,19]
//Output: 133
//Explanation: The value of the triplet (1, 2, 4) is (nums[1] - nums[2]) * nums[4] = 133.
//It can be shown that there are no ordered triplets of indices with a value greater than 133.
//Example 3:
//
//Input: nums = [1,2,3]
//Output: 0
//Explanation: The only ordered triplet of indices (0, 1, 2) has a negative value of (nums[0] - nums[1]) * nums[2] = -3. Hence, the answer would be 0.
// 
//
//Constraints:
//
//3 <= nums.length <= 100
//1 <= nums[i] <= 106


package Arrays;
class MaximumValueOfAnOrderedTripletI_2873 {
//	brute force approch :
//	here we check every single triplets
//	time complexity :O(n^3)
//	space complexity :O(1)
	public static long maximumTripletValueBruteForce(int[] nums) {
	        int n= nums.length;
	        long ans=0;
	        for(int i =0;i<n-2;i++){
	            for(int j=i+1;j<n-1;j++){
	                for(int k=j+1;k<n;k++){
	                    ans= Math.max((((long)nums[i]-(long)nums[j])*(long)nums[k]),ans);
	                }
	            }
	        }
	        return ans;
	    }
	
//	better approch :
//	 here intution is equation : (nums[i] - nums[j])* nums[k]
//	so to make is max we need to find max value at nums[i] , min value at nums[j] and max  value at nums[k]
//	so with that in mind we can use the j pointer to move
//	from 0 till n-1 and when we get any value which is bigger we can put it in the left pointer
//	and check j, k with nested loops 
//	where j start from 1 till n-1
//	and k start from j+1 till n
//	time complexity :O(n^2)
//	space complexity :O(1)
    public static long maximumTripletValueBetter(int[] nums) {
        long ans=0;
        int n = nums.length;
        int left=nums[0];
        for(int j =0;j<n-1;j++){
            if(left<nums[j]){
                left=nums[j];
            }
            for(int k=j+1;k<n;k++){
                ans=Math.max(((long)(left-nums[j])*(long)nums[k]),ans);
            }
        }
        return ans;
    }
    
//	Best approch :
//  from better approch if we can say we get the i as max 
//  now and thing on the left side of i could not be our j or k
//  so can we use a suffix max array to get max value from right to left
//	time complexity :O(n)
//	space complexity :O(1)
    public static long maximumTripletValueBest(int[] nums) {
    	long ans=0;
    	int n = nums.length;
    	int left=nums[0];
    	int [] suffixMax= new int [n];
    	int currMax=0;
    	for(int k=n-1;k>=0;k--) {
    		currMax=Math.max(currMax,nums[k]);
    		suffixMax[k]=currMax;
    	}
    	for(int j=1;j<n-1;j++) {
    		if(left<nums[j]) {
    			left=nums[j];
    		}
    		long eq= (long)(left-nums[j])*(long)suffixMax[j+1];
    		ans=Math.max(eq, ans);
    	}
    	return ans;
    }
    
    
    public static void main(String[] args) {
    	
    	//Example 1:
    	//
    	int [] nums1 = {12,6,1,2,7};
    	long output1=77;
    	
    	//Example 2:

    	int [] nums2 = {1,10,3,4,19};
    	long output2=133;
    	

    	//Example 3:
    	//
    	//Input: nums = [1,2,3]
    	int [] nums3 = {1,2,3};
    	long output3=0;
    	
    	
    	System.out.println("Brute Force :");
    	
    	long ans1=maximumTripletValueBruteForce(nums1);
    	long ans2=maximumTripletValueBruteForce(nums2);
    	long ans3=maximumTripletValueBruteForce(nums3);
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
    	System.out.println("Better Approch :");
    	
    	ans1=maximumTripletValueBetter(nums1);
    	ans2=maximumTripletValueBetter(nums2);
    	ans3=maximumTripletValueBetter(nums3);
   
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	
    	System.out.println("Best Approch ");
    	
    	ans1=maximumTripletValueBest(nums1);
    	ans2=maximumTripletValueBest(nums2);
    	ans3=maximumTripletValueBest(nums3);
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}
    	

    	
	}
}
