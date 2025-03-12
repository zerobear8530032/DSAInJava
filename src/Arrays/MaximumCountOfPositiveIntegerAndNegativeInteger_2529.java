//2529. Maximum Count of Positive Integer and Negative Integer
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an array nums sorted in non-decreasing order, return the maximum between the number of positive integers and the number of negative integers.
//
//In other words, if the number of positive integers in nums is pos and the number of negative integers is neg, then return the maximum of pos and neg.
//Note that 0 is neither positive nor negative.
//
// 
//
//Example 1:
//
//Input: nums = [-2,-1,-1,1,2,3]
//Output: 3
//Explanation: There are 3 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 2:
//
//Input: nums = [-3,-2,-1,0,0,1,2]
//Output: 3
//Explanation: There are 2 positive integers and 3 negative integers. The maximum count among them is 3.
//Example 3:
//
//Input: nums = [5,20,66,1314]
//Output: 4
//Explanation: There are 4 positive integers and 0 negative integers. The maximum count among them is 4.
// 
//
//Constraints:
//
//1 <= nums.length <= 2000
//-2000 <= nums[i] <= 2000
//nums is sorted in a non-decreasing order.
// 
//
//Follow up: Can you solve the problem in O(log(n)) time complexity?

package Arrays;

public class MaximumCountOfPositiveIntegerAndNegativeInteger_2529 {
//	brute force approch :
//	count every single  neg / pos number and return the max of both
//	Time complexity :O(n)
//	Space complexity :O(1)
	public static int maximumCount(int[] nums) {
		int pos=0;
		int neg=0;
		for(int x: nums) {
			if(x<0) neg++;
			if(x>0) pos++;
		}
		return Math.max(pos, neg);
    }
	
//	best approch :
//	here we use binary search to find the 0 because left side is all neg and right are all positive number
//	if mutiple zero so we need binary search to find first and last position
//	if not zero we need to hande that case by returning last mid 
//	check if the current ans is at negative or poss and what will output be
//	Time complexity :O(log n)
//	Space complexity :O(1)
	
	  public static int maximumCountBest(int[] nums) {
		    if(nums.length==1){
		        return nums[0]==0 ? 0 :1;
		    }
				int start=0;
		        int n=nums.length;
				int end= n-1;
				int target=0;
				int firstidx=binarySearch(nums, start, end, 0, true);		
				int lastidx=binarySearch(nums, start, end, 0, false);	
				int neg=0;
		        if(nums[firstidx]<0){neg=firstidx+1;}
		        if(nums[firstidx]>0){neg=firstidx;}
		        if(nums[firstidx]==0){neg=firstidx;}
		        int pos=0;
		        if(nums[lastidx]==0){pos=n-1-lastidx;}
		        if(nums[lastidx]<0){pos=n-lastidx-1;}
		        if(nums[firstidx]>0){pos=n-lastidx;}

				return Math.max(neg, pos);
				
				}
			
			public static int binarySearch(int [] nums,int s, int e,int t,boolean startindex ) {
				int ans=-1;
		        int m=0;
		        while(s<=e){
				 m = s+(e-s)/2;
				if(nums[m]<t) {
					s=m+1;
				}else if(nums[m]>t) {
					e=m-1;
				}else {
					ans=m;
					if(startindex) {
						e=m-1;
					}else {
						s=m+1;
					}
				}
		        }
		        if(ans==-1) return m;
				return ans;
			}
	public static void main(String[] args) {
		//Example 1:
		//
		int []nums1 = {-2,-1,-1,1,2,3};
		int output1=3;
		
		//Example 2:
		
		int [] nums2 = {-3,-2,-1,0,0,1,2};
		int output2=3;
		
		//Example 3:

		int []nums3 = {5,20,66,1314};
		int output3=4;
		
		//Example 4:
		int [] nums4= {0};
		int output4=4;
		
       System.out.println("Brute Force Approch :");
		
		int ans1 = maximumCount(nums1);
		int ans2 = maximumCount(nums2);
		int ans3 = maximumCount(nums3);
		int ans4 = maximumCount(nums4);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ (ans2));
		}			
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ (output3));
			System.out.println("Your Output : "+ (ans3));
		}			
		if(ans4==output4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Excepted Output : "+ (output4));
			System.out.println("Your Output : "+ (ans4));
		}			
		System.out.println("Best Approch :");
		
		ans1 = maximumCount(nums1);
		ans2 = maximumCount(nums2);
		ans3 = maximumCount(nums3);
		ans4 = maximumCount(nums4);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ (output2));
			System.out.println("Your Output : "+ (ans2));
		}			
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ (output3));
			System.out.println("Your Output : "+ (ans3));
		}			
		if(ans4==output4) {
			System.out.println("Case 4 Passed ");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Excepted Output : "+ (output4));
			System.out.println("Your Output : "+ (ans4));
		}			
		

}

}
