//728. Self Dividing Numbers
//Solved
//Easy
//Topics
//Companies
//Hint
//A self-dividing number is a number that is divisible by every digit it contains.
//
//For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
//A self-dividing number is not allowed to contain the digit zero.
//
//Given two integers left and right, return a list of all the self-dividing numbers in the range [left, right] (both inclusive).
//
// 
//
//Example 1:
//
//Input: left = 1, right = 22
//Output: [1,2,3,4,5,6,7,8,9,11,12,15,22]
//Example 2:
//
//Input: left = 47, right = 85
//Output: [48,55,66,77]
// 
//
//Constraints:
//
//1 <= left <= right <= 104

package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelfDividingNumbers_728 {
// solution
//	here we just simulate what asked 
//	time complexity :O(n)
//	space complexity :O(1);
	
	    public static List<Integer> selfDividingNumbers(int left, int right) {
	        List<Integer> ans = new ArrayList();
	        for(int i =left;i<=right;i++){
	            if(checkDivisibility(i)){
	                ans.add(i);
	            }
	        }
	        return ans;
	    }
	    public static boolean checkDivisibility (int x){
	        int n=x;
	        while(x!=0){
	            int r= x%10;
	            if(r==0) return false;
	            if(n%r!=0) return false;
	            x=x/10;
	        }
	        return true;
	     
	    }
	
	public static void main(String[] args) {
		
		//Example 1:

		int left1 = 1, right1 = 22;
		List<Integer> output1= new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,11,12,15,22));
		//Example 2:

		int left2 = 47, right2 = 85;
		List<Integer> output2= new ArrayList<Integer>(Arrays.asList(48,55,66,77));
		
		
		List<Integer>ans1=selfDividingNumbers(left1,right1);
		List<Integer>ans2=selfDividingNumbers(left2,right2);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}

	}

}
