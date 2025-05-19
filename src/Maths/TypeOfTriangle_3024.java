//3024. Type of Triangle
//Solved
//Easy
//Topics
//Companies
//Hint
//You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.
//
//A triangle is called equilateral if it has all sides of equal length.
//A triangle is called isosceles if it has exactly two sides of equal length.
//A triangle is called scalene if all its sides are of different lengths.
//Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.
//
// 
//
//Example 1:
//
//Input: nums = [3,3,3]
//Output: "equilateral"
//Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.
//Example 2:
//
//Input: nums = [3,4,5]
//Output: "scalene"
//Explanation: 
//nums[0] + nums[1] = 3 + 4 = 7, which is greater than nums[2] = 5.
//nums[0] + nums[2] = 3 + 5 = 8, which is greater than nums[1] = 4.
//nums[1] + nums[2] = 4 + 5 = 9, which is greater than nums[0] = 3. 
//Since the sum of the two sides is greater than the third side for all three cases, therefore, it can form a triangle.
//As all the sides are of different lengths, it will form a scalene triangle.
// 
//
//Constraints:
//
//nums.length == 3
//1 <= nums[i] <= 100

package Maths;

import java.util.Arrays;

public class TypeOfTriangle_3024 {
//	approch:
//	check wheather the triangle is correct 
//	take any 2 side and check there sum are greater then the third side
//	if that is not followed for any pair of side its not a valid triangle
//	now check for different triangle conditions
	
	    public static String triangleType(int[] nums) {
	        int a = nums[0];
	        int b = nums[1];
	        int c = nums[2];
	        if((a+b)<=c || (b+c)<=a || (c+a)<=b){
	            return "none";
	        }
	        
	        if(a==b && b==c) {
	            return "equilateral";
	        }else if((a==b && b!=c) || (b==c && c!=a) || (c==a && a!=b)){
	            return "isosceles";
	        }else{
	            return "scalene";
	        }
	        }
	

	public static void main(String[] args) {
		//Example 1:

		int [] nums1 = {3,3,3};
		String output1= "equilateral";

		//Example 2:

		int [] nums2 = {3,4,5};
		String output2= "scalene";
		
		//Example 3:
		
		int [] nums3 = {5,3,8};
		String output3= "none";
		
		//Example 4:
		
		int [] nums4 = {5,5,8};
		String output4= "isosceles";
		
		
		
		
		String ans1=triangleType(nums1);
		String ans2=triangleType(nums2);
		String ans3=triangleType(nums3);
		String ans4=triangleType(nums4);
		if(ans1.equals(output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+(output1));
			System.out.println("Your Answer :"+(ans1));
		}
		if(ans2.equals(output2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+(output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3.equals(output3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+(output3));
			System.out.println("Your Answer :"+(ans3));
		}
		if(ans4.equals(output4)) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Ouput :"+(output4));
			System.out.println("Your Answer :"+ (ans4));
		}

	}

}
