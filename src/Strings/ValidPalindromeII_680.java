//680. Valid Palindrome II
//Solved
//Easy
//Topics
//Companies
//Given a string s, return true if the s can be palindrome after deleting at most one character from it.
//
// 
//
//Example 1:
//
//Input: s = "aba"
//Output: true
//Example 2:
//
//Input: s = "abca"
//Output: true
//Explanation: You could delete the character 'c'.
//Example 3:
//
//Input: s = "abc"
//Output: false
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters.


package Strings;

public class ValidPalindromeII_680 {
//	approch :
//	we can start by 2 pointer an if its does not match we will check left and right side 
// time complexity :O(n)
// space complexity :O(1)
	public  static boolean validPalindrome(String str) {
	        int s=0;
	        int e=str.length()-1;
	        while(s<e){
	            if(str.charAt(s)!=str.charAt(e)){
	                return palindrome(str,s+1,e) || palindrome(str,s,e-1);
	            }
	            s++;
	            e--;
	        }
	        return true;
	    }
	    public static boolean palindrome(String str,int s, int e){
	        while(s<e){
	            if(str.charAt(s)!=str.charAt(e)){
	                return false;
	            }
	            s++;
	            e--;
	        }
	        return true;
	    }
		
	public static void main(String[] args) {
		//Example 1:
		//
		String s1 = "aba";
		boolean output1=true;

		//Example 2:
		
		String s2 = "abca";
		boolean output2=true;


		//Example 3:

		String s3 = "abc";
		boolean output3=false;
		
		System.out.println("Best Approch :");
		boolean ans1 = validPalindrome(s1);
		boolean ans2 = validPalindrome(s2);
		boolean ans3 = validPalindrome(s3);
		
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ output1);
			System.out.println("Your Output : "+ ans1);
		}
		
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}


	}
	

}
