//5-year-old Shinchan had just started learning mathematics. Meanwhile, one of his studious classmates, Kazama, had already written a basic calculator which supports only three operations on integers: multiplication , addition , and subtraction . Since he had just learned about these operations, he didn't know about operator precedence, and so, in his calculator, all operators had the same precedence and were left-associative.
//
//As always, Shinchan started to irritate him with his silly questions. He gave Kazama a list of  integers and asked him to insert one of the above operators between each pair of consecutive integers such that the result obtained after feeding the resulting expression in Kazama's calculator is divisible by . At his core, Shinchan is actually a good guy, so he only gave lists of integers for which an answer exists.
//
//Can you help Kazama create the required expression? If multiple solutions exist, print any one of them.
//
//Input Format
//
//The first line contains a single integer  denoting the number of elements in the list. The second line contains  space-separated integers  denoting the elements of the list.
//
//Constraints
//
//The length of the output expression should not exceed .
//Output Format
//
//Print a single line containing the required expressoin. You may insert spaces between operators and operands.
//
//Note
//
//You are not allowed to permute the list.
//All operators have the same precedence and are left-associative, e.g.,  is interpreted as 
//Unary plus and minus are not supported, e.g., statements like , , or  are invalid.
//Sample Input 0
//
//3
//22 79 21
//Sample Output 0
//
//22*79-21
//Explanation 0
//
//Solution 1: , where , so it is perfectly divisible by .
//Solution 2: , which is also divisible by .
//
//Sample Input 1
//
//5
//55 3 45 33 25
//Sample Output 1
//
//55+3-45*33-25
//Explanation 1
//
// which is divisible by .
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ArithmeticExpression_HackerRank {
//	BruteForceapproch :
//	we take 2 numbers and try to apply  each opeartion + - * on them and try to get the condition satisfied 
//	time complexity : O(3^n)
//	space complexity : O(n)
	public static String arithmeticExpressionsBruteForce(List<Integer> nums) {
		result="";
		int f= nums.get(0);
		helperBruteForce(nums,1,f+"",f);
		return result;
	}
	
	static String result ;
	
	public static boolean helperBruteForce(List<Integer>nums, int idx, String expression, long res) {
			if(idx==nums.size()) {
				if( res%101==0) {
					result=expression;
					return true;
				}
				return false;
			}
			int s = nums.get(idx);
//			add
			StringBuilder exp = new StringBuilder();
			exp.append(expression);			
			exp.append("+");		
			exp.append(s);		
//			substract
			helperBruteForce(nums,idx+1,exp.toString(),res+s);
			exp = new StringBuilder();
			exp.append(expression);			
			exp.append("-");		
			exp.append(s);		
			helperBruteForce(nums,idx+1,exp.toString(),res-s) ;
			exp = new StringBuilder();
			exp.append(expression);			
			exp.append("*");		
			exp.append(s);		
			helperBruteForce(nums,idx+1,exp.toString(),res*s);
			return false;
	}
	
//	approch :
//	we take 2 numbers and try to apply  each opeartion + - * on them and try to get the condition satisfied 
//	time complexity : O(3^n)
//	space complexity : O(n)
	public static String arithmeticExpressionsBetter(List<Integer> nums) {
		result="";
		int f= nums.get(0);
		HashMap<String, Boolean> memo = new HashMap();
		helperBetter(nums,1,f+"",f,memo);
		return result;
	}
	
	
	public static boolean helperBetter(List<Integer>nums, int idx, String expression, int res,HashMap<String,Boolean> memo) {
		String key = idx+","+res;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		if(idx==nums.size()) {
			if( res%101==0) {
				result=expression;
				memo.put(key, true);
			
				return true;
			}
			memo.put(key, false);			
			return false;
		}
		int s = nums.get(idx);
//			add
		StringBuilder exp = new StringBuilder();
		exp.append(expression);			
		exp.append("+");		
		exp.append(s);		
//			substract
		if(helperBetter(nums,idx+1,exp.toString(),res+s,memo)) {
			memo.put(key, true);			
			return true;
		}
		exp = new StringBuilder();
		exp.append(expression);			
		exp.append("-");		
		exp.append(s);		
		if(helperBetter(nums,idx+1,exp.toString(),res-s,memo)) {
			memo.put(key, true);			
			return true;
		}
		exp = new StringBuilder();
		exp.append(expression);			
		exp.append("*");		
		exp.append(s);		
		
		if(helperBetter(nums,idx+1,exp.toString(),res*s,memo)) {
			memo.put(key, true);			
			return true;
		}
		memo.put(key, false);			
		return false;
	}
	
	
	
	public static void main(String[] args) {
		
//		Example 1 :
		
		List<Integer> nums1 = new ArrayList(Arrays.asList(22,79,21));
		String output1= "22*79-21";
		
//		Example 2 :
		
		List<Integer> nums2 = new ArrayList(Arrays.asList(55,3,45,33,25));
		String output2= "55+3-45*33-25";
		
//		Example 3 :
		
		List<Integer> nums3 = new ArrayList(Arrays.asList(100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100 ,100, 100 ,100 ,100 ,100 ,100 ,100 ,100 ,100,100,100));
		
		
		System.out.println(arithmeticExpressionsBruteForce(nums3));
		
		System.out.println(8028684878046298112L%101L);

	}

}
