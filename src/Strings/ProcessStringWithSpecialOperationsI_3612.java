//3612. Process String with Special Operations I
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English letters and the special characters: *, #, and %.
//
//Build a new string result by processing s according to the following rules from left to right:
//
//If the letter is a lowercase English letter append it to result.
//A '*' removes the last character from result, if it exists.
//A '#' duplicates the current result and appends it to itself.
//A '%' reverses the current result.
//Return the final string result after processing all characters in s.
//
// 
//
//Example 1:
//
//Input: s = "a#b%*"
//
//Output: "ba"
//
//Explanation:
//
//i	s[i]	Operation	Current result
//0	'a'	Append 'a'	"a"
//1	'#'	Duplicate result	"aa"
//2	'b'	Append 'b'	"aab"
//3	'%'	Reverse result	"baa"
//4	'*'	Remove the last character	"ba"
//Thus, the final result is "ba".
//
//Example 2:
//
//Input: s = "z*#"
//
//Output: ""
//
//Explanation:
//
//i	s[i]	Operation	Current result
//0	'z'	Append 'z'	"z"
//1	'*'	Remove the last character	""
//2	'#'	Duplicate the string	""
//Thus, the final result is "".
//
// 
//
//Constraints:
//
//1 <= s.length <= 20
//s consists of only lowercase English letters and special characters *, #, and %.
package Strings;

public class ProcessStringWithSpecialOperationsI_3612 {
	public static String processStr(String s) {
        StringBuilder res= new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>='a' && ch<='z'){
                res.append(ch);
            }else if(ch=='*'){
                if(res.length()==0){
                    continue;
                }
                res.deleteCharAt(res.length()-1);
            }else if(ch=='#'){
                res=res.append(res);
            }else{
                res.reverse();
            }
        }
        return res.toString();
    }

	public static void main(String[] args) {

		//Example 1:
	
		String s1 = "a#b%*";
		String output1= "ba";
		
		//Example 2:

		String s2 = "z*#";
		String output2= "";
		
    	String ans1=processStr(s1);
    	String ans2=processStr(s2);
		
		
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
