/*1358. Number of Substrings Containing All Three Characters
Medium
Topics
Companies
Hint
Given a string s consisting only of characters a, b and c.

Return the number of substrings containing at least one occurrence of all these characters a, b and c.

 

Example 1:

Input: s = "abcabc"
Output: 10
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again). 
Example 2:

Input: s = "aaacb"
Output: 3
Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb". 
Example 3:

Input: s = "abc"
Output: 1
 

Constraints:

3 <= s.length <= 5 x 10^4
s only consists of a, b or c characters.*/
package Strings;


public class NumberOfSubstringsContainingAllThreeCharacters_138 {
//	brute force approch :
//	find all substrings and check the substring is valid
//	time complexity :O(n*n)*O(l)
	   public static int countOfSubstringsBruteForce(String word) {
	    	int count=0;
	    	for(int i =0;i<word.length();i++) {
	    		for(int j=i;j<word.length();j++) {
	    			String str=word.substring(i,j+1);
	    			if(isValidSubstring(str)) {
	    				count++;
	    			}
	    		}
	    	}
	    	return count;
	        
	    }
	   
	   
	   
	   
	 static boolean isValidSubstring(String str) {
		 boolean APresent =false;		 
		 boolean BPresent =false;
		 boolean CPresent =false;
		 for(int i =0;i<str.length();i++) {
			 if(str.charAt(i)=='a') APresent=true;
			 if(str.charAt(i)=='b') BPresent=true;
			 if(str.charAt(i)=='c') CPresent=true;
			 if (APresent && BPresent && CPresent) return true;
		 }
	
		return false;
	}



	public static void main(String[] args) {
			
			
//		Example 1:

		String s1 = "abcabc";
		int output1=10;

//		Example 2:

		String s2 = "aaacb";
		int output2=3;
		
//		Example 3:

		String s3 = "abc";
		int output3=1;

		int ans1=countOfSubstringsBruteForce(s1);
		int ans2=countOfSubstringsBruteForce(s2);
		int ans3=countOfSubstringsBruteForce(s3);
		
		System.out.println("Brute Force Approch :");
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		
		
	}

}
