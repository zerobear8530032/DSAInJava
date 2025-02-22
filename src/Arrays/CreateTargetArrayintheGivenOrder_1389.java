//1389. Create Target Array in the Given Order
//Solved
//Easy
//Topics
//Companies
//Hint
//Given two arrays of integers nums and index. Your task is to create target array under the following rules:
//
//Initially target array is empty.
//From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
//Repeat the previous step until there are no elements to read in nums and index.
//Return the target array.
//
//It is guaranteed that the insertion operations will be valid.
//
// 
//
//Example 1:
//
//Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
//Output: [0,4,1,3,2]
//Explanation:
//nums       index     target
//0            0        [0]
//1            1        [0,1]
//2            2        [0,1,2]
//3            2        [0,1,3,2]
//4            1        [0,4,1,3,2]
//Example 2:
//
//Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
//Output: [0,1,2,3,4]
//Explanation:
//nums       index     target
//1            0        [1]
//2            1        [1,2]
//3            2        [1,2,3]
//4            3        [1,2,3,4]
//0            0        [0,1,2,3,4]
//Example 3:
//
//Input: nums = [1], index = [0]
//Output: [1]
// 
//
//Constraints:
//
//1 <= nums.length, index.length <= 100
//nums.length == index.length
//0 <= nums[i] <= 100
//0 <= index[i] <= i

package Arrays;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CreateTargetArrayintheGivenOrder_1389 {
//	cheese approch :  
//	use array list and let java inbuild package handle the operation 
//	time complexity : O(n)
//	space complexity : O(1)
	public static int[] createTargetArrayArrayListApproch(int[] nums, int[] index) {
        ArrayList <Integer> arr = new ArrayList(nums.length);
        for(int i =0;i<nums.length;i++){
            arr.add(index[i],nums[i]);
        }
        int [] ans = new int [arr.size()];
        for(int i=0;i<arr.size();i++){
            ans[i]=arr.get(i);
        }
        return ans;
    }
	
//	Explicit approch :
//	working :
//	resize array and shift and implement each functionality our self 
	public static int[] createTargetArrayInsertionApproch(int[] nums, int[] index) {
		int ans[]= new int [nums.length];
		for(int i =0;i<nums.length;i++) {
			insert(ans,index[i],nums[i]);
		}
		return ans;
    }
	public static void insert(int [] arr, int index,int e) {
		if(index == arr.length) {
			arr[index]=e;
		}else {
			for(int i = arr.length-1;i>index;i--) {
				arr[i]=arr[i-1];
			}
			arr[index]=e;
			
		}
		
	}	
		public static void main(String[] args) {
			//Example 1:
			
			int []nums1 = {0,1,2,3,4}, index1 = {0,1,2,2,1}, output1= {0,4,1,3,2};
			
			//Example 2:
			
			int []nums2 = {1,2,3,4,0}, index2 = {0,1,2,3,0}, output2= {0,1,2,3,4};
			
			//Example 3:

			int []nums3 = {1}, index3 = {0}, output3= {1};
			
			int [] ans1= createTargetArrayArrayListApproch(nums1, index1);
			int [] ans2= createTargetArrayArrayListApproch(nums2, index2);
			int [] ans3= createTargetArrayArrayListApproch(nums3, index3);
			
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
			
			System.out.println("Optimize Approch :");
			
			ans1= createTargetArrayInsertionApproch(nums1, index1);
			ans2= createTargetArrayInsertionApproch(nums2, index2);
			ans3= createTargetArrayInsertionApproch(nums3, index3);
			
			
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
		}



}
