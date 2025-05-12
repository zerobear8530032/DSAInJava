//17. Letter Combinations of a Phone Number
//Solved
//Medium
//Topics
//Companies
//Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
//
//A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
// 
//
//Example 1:
//
//Input: digits = "23"
//Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
//Example 2:
//
//Input: digits = ""
//Output: []
//Example 3:
//
//Input: digits = "2"
//Output: ["a","b","c"]
// 
//
//Constraints:
//
//0 <= digits.length <= 4
//digits[i] is a digit in the range ['2', '9'].


package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber_17 {

//	approch :
//	we use subset method
//	where first we use a map where we map each character with string it can create
//	now we will use subset method where first we get the string from map
//	and use recursion to apply subset method
//	time complexity : O(n* 4^n)
//	space complexity : O(n)

	   public static List<String> letterCombinations(String digits) {
	        String []map = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	        if(digits.length()==0){
	            return new ArrayList();
	        }
	        List<String> ans= new ArrayList();
	        helper("",digits,map,ans);
	        return ans;
	        }
	    public static void helper(String p, String unp,String []map, List<String> res){
	        if(unp.isBlank()){
	            res.add(p);
	            return ;
	        }
	        char ch = unp.charAt(0);
	        String str= map[ch-'2'];
	        for( int  i =0;i<str.length();i++){
	            String process= p+str.charAt(i);
	            String unprocess= unp.substring(1);
	            helper(process,unprocess,map,res);
	        }
	    }
	    
	    
		public static boolean check(List<String> output, List<String> ans) {
			if(output.size()!=ans.size()) {
				return false;
			}
			for(int i =0;i<ans.size();i++) {
				if(!ans.get(i).equals(output.get(i))) {
					return false;
				}
			}
			return true;
		}

	
	public static void main(String[] args) {
		
		//Example 1:

		String digits1 = "23";
		List<String> output1= new ArrayList(Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf"));
	
		//Example 2:

		String digits2 = "";
		List<String> output2= new ArrayList();

		//Example 3:
		
		String digits3 = "2";
		List<String> output3= new ArrayList(Arrays.asList("a","b","c"));
		
		
		List<String> ans1= letterCombinations(digits1);
		List<String> ans2= letterCombinations(digits2);
		List<String> ans3= letterCombinations(digits3);
		
		if(check(output1,ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);
		}
		if(check(output2,ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ output2);
			System.out.println("Your Answer :"+ ans2);
		}
		if(check(output3,ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ output3);
			System.out.println("Your Answer :"+ ans3);
		}
		
		
		

	}

}
