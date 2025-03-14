//
//2226. Maximum Candies Allocated to K Children
//Medium
//Topics
//Companies
//Hint
//You are given a 0-indexed integer array candies. Each element in the array denotes a pile of candies of size candies[i]. You can divide each pile into any number of sub piles, but you cannot merge two piles together.
//
//You are also given an integer k. You should allocate piles of candies to k children such that each child gets the same number of candies. Each child can be allocated candies from only one pile of candies and some piles of candies may go unused.
//
//Return the maximum number of candies each child can get.
//
// 
//
//Example 1:
//
//Input: candies = [5,8,6], k = 3
//Output: 5
//Explanation: We can divide candies[1] into 2 piles of size 5 and 3, and candies[2] into 2 piles of size 5 and 1. We now have five piles of candies of sizes 5, 5, 3, 5, and 1. We can allocate the 3 piles of size 5 to 3 children. It can be proven that each child cannot receive more than 5 candies.
//Example 2:
//
//Input: candies = [2,5], k = 11
//Output: 0
//Explanation: There are 11 children but only 7 candies in total, so it is impossible to ensure each child receives at least one candy. Thus, each child gets no candy and the answer is 0.
// 
//
//Constraints:
//
//1 <= candies.length <= 105
//1 <= candies[i] <= 107
//1 <= k <= 1012
package BinarySearch;

public class MaximumCandiesAllocatedToKChildren_2226 {
//	brute force approch :
//	we will try to give candies from min 1  till max of candies array 
//	and return max possible candies  we can give  :
//	why because we can give multiple children candies with same pile
//	but  we cannot give one children from multiple piles
//	time complexity :O(n* max(candies))
//	space complexity :O(1)

	 public static  int maximumCandies(int[] candies, long k) {
	        int maxCandies=Integer.MIN_VALUE;
	        int totalcandies=0;
	        for(int x: candies) {
	        	maxCandies=Math.max(maxCandies, x);
	        	totalcandies+=x;
	        	}
	        if(totalcandies<k) return 0;
	        int ans=0;
	        for(int i=1;i<=maxCandies;i++) {
	        	if(tryGivingKcandies(candies,i,k)) {
	        		ans=i;
	        	}else {
	        		return ans;
	        	}
	        }
	        return ans;
	    }
	 
//	Best approch :
//	 from brute force approch we can see we are just doing linear search we can just do binary search
//	 instead of linear search;
//		time complexity :O(n*⋅log(maxCandies))
//		space complexity :O(1)
	 public static  int maximumCandiesBetter(int[] candies, long k) {
		 int maxCandies=Integer.MIN_VALUE;
		 int totalcandies=0;
		 for(int x: candies) {
			 maxCandies=Math.max(maxCandies, x);
			 totalcandies+=x;
		 }
		 int start=1;
		 int end=maxCandies;
		 int ans =0;
		 while(start<=end) {
			 int mid=start+(end-start)/2;
			 if(tryGivingKcandies(candies, mid, k)) {
				 ans=mid;
				 start=mid+1;
			 }else {
				 end=mid-1;				 
			 }
		 }
		 
		 return ans;
	 }
	 public static boolean tryGivingKcandies(int [] candies,int candy,long k) {
		 
		 for(int i =0;i<candies.length;i++) {
			 int children = candies[i]/candy;
			 k=k-children;
			 if(k<=0) return true;
		 }
		 
		 return k<=0;
	 }

	public static void main(String[] args) {
		
		//Example 1:
		//
		int [] candies1 = {5,8,6}; 
		int	k1 = 3;
		int output1=5;
		
		//Example 2:
		
		int [] candies2 = {2,5}; 
		int	k2 = 11;
		int output2=0;
		
		System.out.println("Brute Force : ");
		
		int ans1= maximumCandiesBetter(candies1, k1);	
		int ans2= maximumCandiesBetter(candies2, k2);	
		
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
		
		System.out.println("Best Approch :");
		 	
		ans1= maximumCandiesBetter(candies1, k1);	
		ans2= maximumCandiesBetter(candies2, k2);	
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
		
		
	}

}
