//1470. Shuffle the Array
//Solved
//Easy
//Topics
//Companies
//Hint
//Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
//
//Return the array in the form [x1,y1,x2,y2,...,xn,yn].
//
// 
//
//Example 1:
//
//Input: nums = [2,5,1,3,4,7], n = 3
//Output: [2,3,5,4,1,7] 
//Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
//Example 2:
//
//Input: nums = [1,2,3,4,4,3,2,1], n = 4
//Output: [1,4,2,3,3,2,4,1]
//Example 3:
//
//Input: nums = [1,1,2,2], n = 2
//Output: [1,2,1,2]
// 
//
//Constraints:
//
//1 <= n <= 500
//nums.length == 2n
//1 <= nums[i] <= 10^3
package Arrays;

import java.util.Arrays;
import java.util.HashMap;

public class ShuffleTheArray_1470 {
//	approch :
//	allocate a new array of same length and now  get  x1 and y1 
//	because the array is in x1,x2,x3...xn,y1,y2,y3....,yn
//	we can say from 0 till n-1 is x and from n till n*2-1 is y
//	now we can iterate over array  to get x we can use i and get y we can use i+n
//	now we can use a pointer which will put the element in place called index 
//	which will increment by 2 at each iteration
//	
	    public static int[] shuffle(int[] nums, int n) {
	    	int ans [] = new int [n*2];// n = length of array of x and y so we need 2 xn
	    	int index =0;// filling pointer of array 
	    	for(int i =0;i<n;i++) {
	    		ans[index]=nums[i];// put x value at index
	    		ans[index+1]=nums[i+n];// put y value at index+1
	    		index+=2; // increment by 2 for each iteration
	    	}
	    	return ans;
	    }

	    public static boolean check(int [] arr1, int [] arr2) {
			if(arr1.length!=arr2.length) {
				return false;
			}
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			return true;
		}

		public static void main(String[] args) {
			
			//Example 1:
			
			int [] nums1 = {2,5,1,3,4,7};
			int n1 = 3;
			int [] output1= {2,3,5,4,1,7}; 
			
			//Example 2:
			
			int [] nums2 = {1,2,3,4,4,3,2,1};
			int n2 = 4;
			int [] output2= {1,4,2,3,3,2,4,1}; 
			
			//Example 3:
			
			int [] nums3 = {1,1,2,2};
			int n3 = 2;
			int [] output3= {1,2,1,2}; 
			HashMap<Integer,Integer> ans = new HashMap();


			int []ans1 = shuffle(nums1,n1);
			int []ans2 = shuffle(nums2,n2);
			int []ans3 = shuffle(nums3,n3);
			
			
			if(check(ans1,output1)) {
				System.out.println("Case 1 Passed ");
			}else {
				System.out.println("Case 1 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output1));
				System.out.println("Your Output : "+ Arrays.toString(ans1));
			}
			if(check(ans2,output2)) {
				System.out.println("Case 2 Passed ");
			}else {
				System.out.println("Case 2 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(ans2));
			}
			
			if(check(ans3,output3)) {
				System.out.println("Case 3 Passed ");
			}else {
				System.out.println("Case 3 Failed");
				System.out.println("Excepted Output : "+ Arrays.toString(output2));
				System.out.println("Your Output : "+ Arrays.toString(ans2));
			}
			
		}
}
