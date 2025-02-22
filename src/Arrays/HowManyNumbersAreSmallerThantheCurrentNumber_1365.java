//1365. How Many Numbers Are Smaller Than the Current Number
//Solved
//Easy
//Topics
//Companies
//Hint
//Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
//
//Return the answer in an array.
//
// 
//
//Example 1:
//
//Input: nums = [8,1,2,2,3]
//Output: [4,0,1,1,3]
//Explanation: 
//For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3). 
//For nums[1]=1 does not exist any smaller number than it.
//For nums[2]=2 there exist one smaller number than it (1). 
//For nums[3]=2 there exist one smaller number than it (1). 
//For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
//Example 2:
//
//Input: nums = [6,5,4,8]
//Output: [2,1,0,3]
//Example 3:
//
//Input: nums = [7,7,7,7]
//Output: [0,0,0,0]
// 
//
//Constraints:
//
//2 <= nums.length <= 500
//0 <= nums[i] <= 100

package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
public class HowManyNumbersAreSmallerThantheCurrentNumber_1365 {
//	brute force approch : use a nested loop where a single loop will goes through each element and a nested loop which check for entire array
//	update count in answer array :
//	time complexity :O(n*n)
//	space complexity :O(1)
	public static int[] smallerNumbersThanCurrentBruteForce(int[] nums) {
		int [] ans = new int [nums.length];
		for(int i =0;i<nums.length;i++) {
			int counter =0;
			for(int j=0;j<nums.length;j++) {
				if(nums[i]>nums[j]) {
					counter++;
				}
			}
			ans[i]=counter;
		}
		return ans;
    }
//	optimize approch :
//	working :
//	create a copy of array and sort it by sorting now we know every element is in ascending order
//	now copy array have in a position where each index represent how many elements are smaller then them 
//	so we can create a hash map by which we can have key as copyarr[i] and value as index i and we only store the first occurence of number in hashmap
//	now we can map each number to its index and send as output 
//	example :[8,1,2,2,3]
//	copy arr = [8,1,2,2,3]
//	sort it =[1,2,2,3,8]
//	create hashmap of it where copyarr[i](key): i(value)  here we only put each element first occurence only
//	map = {
//	1:0
//	2:1
//	3:3
//	8:4
//}
//	now if we see it we have our output we just need to map it to the output array 
//	we iterate over the input array and fill value of ans[i]=map.get(nums[i])
//	this will create ans =[4,0,1,1,3];
	
//	time complexity: O(n lon n) +O(2n)  almost O(N Log N)
//	space complexity : O(n) +O(n) or O(n): if we use copy array as output 
//	we can only consider the hashmap as extra space
	public static int[] smallerNumbersThanCurrentOptimize(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap();     
//         create a copy of original array 
        int [] copyarr = Arrays.copyOf(nums,nums.length);
        Arrays.sort(copyarr);// sort the array
        for(int i =0;i<copyarr.length;i++) {// create hashmap 
        	if(!map.containsKey(copyarr[i]))
        	map.put(copyarr[i],i);
        }
        // create  answer array by mapping input arrray element with their index value 
        for(int i =0;i<copyarr.length;i++) {
        	copyarr[i]= map.get(nums[i]);// here we update the copyy array as final answer for not using a new array as output 
        }
        return copyarr;
}

//	Alternative Better approch :// not suitable for very large input work great in this constrain
//	approch : create a max integer size array of max nums[i] +1 possible
//	here it was 100 so we take 100+1
//	now iterate over the nums array ans increment arr[nums[i]]++
//	this will map the nums[i] on array rest index will be 0
//	now convert array as cf array where we take a cf of entire array 
//	once we done this now we can getsmaller number at arr[nums[i]-1]
//	because of cf each element index previous element will hold the cf of its previous elements 
//	example :
//	[8,1,2,2,3]
//	arr=[0,0,0,0,0,0,0,0,0,0,......]
//	after mapping nums at arr = [0,1,2,1,0,0,0,0,1,0,0....]
//	now we can see we have frequency of each element at its index it means if index = 8  arr[i]= frequnecy or occurence of 8 which is 1 
//	now we make cf of entire array :
//	[0,1,3,4,4,4,4,4,5,5,5....]
//	now its simple if we take arr[nums[i]]  we will get the total number including  nums[i]
//	but if we take arr[num[i]-1] we will get all number excluding nums[i]
//	so that our answer 
//	if we reiterate over nums[i] and check ans[num[i]-1] we can store this in ans [i] and build ans array 
//	time complexity O(n+N): here n is num.length N is arr.length which is max number according to contrain
//	space complexity O(1): because we have arr whose length does not change according to output means its O(1) and output array is not counted
//	as extra space we can also use input array as output but its not a good practice if its not allowed

	public static int[] smallerNumbersThanCurrentBetterApproch(int[] nums) {
		int [] arr = new int [100+1];
		for (int i =0;i<nums.length;i++) {
			arr[nums[i]]++;
		}
		int sum =0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			arr[i]=sum;
		}
		int [] ans = new int [nums.length];
		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0){// this case check if nums[i]==0 which will give array outof bound in case nums[i]-1=-1 so we need to check it first 
                ans[i]=0;
            }else {
            	ans[i]=arr[nums[i]-1];
            }
			
		}
		return ans;
		
	}
	
	
    
		public static void main(String[] args) {
			
			//Example 1:
			
			int [] nums1 = {8,1,2,2,3};
			int []output1= {4,0,1,1,3};
			
			//Example 2:
			
			int [] nums2 = {6,5,4,8};
			int [] output2= {2,1,0,3};
			
			//Example 3:
			
			int []nums3 = {7,7,7,7};
			int []output3 = {0,0,0,0};
			
			//Example 4:
			
			int []nums4 = {5,0,10,0,10,6};
			int []output4 = {2,0,4,0,4,3};
			
			
			
			int []ans1 = smallerNumbersThanCurrentBruteForce(nums1);
			int []ans2 = smallerNumbersThanCurrentBruteForce(nums2);
			int []ans3 = smallerNumbersThanCurrentBruteForce(nums3);
			int []ans4 = smallerNumbersThanCurrentBruteForce(nums4);
			
			
			if(Arrays.equals(ans1, output1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
		}
			if(Arrays.equals(ans2, output2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output2));
				System.out.println("Your Answer :"+ Arrays.toString(ans2));
			}
			if(Arrays.equals(ans3, output3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output3));
				System.out.println("Your Answer :"+ Arrays.toString(ans3));	}
			if(Arrays.equals(ans4, output4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output4));
				System.out.println("Your Answer :"+ Arrays.toString(ans4));
			}
			
			System.out.println("Optimize Approch :");
			
			ans1 = smallerNumbersThanCurrentOptimize(nums1);
			ans2 = smallerNumbersThanCurrentOptimize(nums2);
			ans3 = smallerNumbersThanCurrentOptimize(nums3);
			ans4 = smallerNumbersThanCurrentOptimize(nums4);
			
			
			if(Arrays.equals(output1, ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
			}
			if(Arrays.equals(output2, ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output2));
				System.out.println("Your Answer :"+ Arrays.toString(ans2));
			}
			if(Arrays.equals(output3, ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output3));
				System.out.println("Your Answer :"+ Arrays.toString(ans3));
			}
			if(Arrays.equals(output4, ans4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output4));
				System.out.println("Your Answer :"+ Arrays.toString(ans4));
			}
			
//			works for this contrain onlyy 
			System.out.println("Better Optimize Approch :");
			
			ans1 = smallerNumbersThanCurrentBetterApproch(nums1);
			ans2 = smallerNumbersThanCurrentBetterApproch(nums2);
			ans3 = smallerNumbersThanCurrentBetterApproch(nums3);
			
			
			if(Arrays.equals(output1, ans1)) {
				System.out.println("Case 1 Passed");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output1));
				System.out.println("Your Answer :"+ Arrays.toString(ans1));
			}
			if(Arrays.equals(output2, ans2)) {
				System.out.println("Case 2 Passed");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output2));
				System.out.println("Your Answer :"+Arrays.toString(ans2) );
			}
			if(Arrays.equals(output3, ans3)) {
				System.out.println("Case 3 Passed");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output3));
				System.out.println("Your Answer :"+ Arrays.toString(ans3));
			}
			if(Arrays.equals(output4, ans4)) {
				System.out.println("Case 4 Passed");
			}else {
				System.out.println("Case 4 Failed");
				System.out.println("Expected Ouput :"+ Arrays.toString(output4));
				System.out.println("Your Answer :"+ Arrays.toString(ans4));
			}
			
			
			
		}



}
