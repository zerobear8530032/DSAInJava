//Valid Palindrome
//Given a string s, return true if it is a palindrome, otherwise return false.
//
//A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
//
//Example 1:
//
//Input: s = "Was it a car or a cat I saw?"
//
//Output: true
//Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
//
//Example 2:
//
//Input: s = "tab a cat"
//
//Output: false
//Explanation: "tabacat" is not a palindrome.
//
//Constraints:
//
//1 <= s.length <= 1000
//s is made up of only printable ASCII characters.



package Strings;

public class ValidPalindrome_NEETCODE {
//	brute force :
//	preprocess the string by removing all non alpanumeric char
//	and convert to lower case :
//	time complexity :O(n);
//	space complexity :O(n);
//	because each operation will create a new string in memeory
	
	public static boolean validPalindromeBruteForce(String str) {
		str=str.toLowerCase();
		StringBuilder temp = new StringBuilder();
		for (int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')  ) {
				temp.append(ch);
			}
		}
		
		return checkPalindrome(temp.toString());
	}
	public static boolean checkPalindrome(String str) {
		int start =0;
		int end = str.length()-1;
		while(start<=end) {
			if(str.charAt(end)!=str.charAt(start)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}
	
//	better approch :
//	we can skip all unrellavant character and only match the neccasy once 
	public static boolean validPalindromeBetter(String str) {
		int s=0;
		int e=str.length()-1;
		while(s<=e) {
			char chstart=str.charAt(s);			
			char chend=str.charAt(e);
			while(s<e && !isAlphanumeric(chstart)) {
				s++;
				chstart=str.charAt(s);							
			}
			while(s<e && !isAlphanumeric(chend)) {
				e--;
				chend=str.charAt(e);
			}
			if(chstart>='A' && chstart<='Z') {
				chstart=(char)(chstart+32);
			}
			if(chend>='A' && chend<='Z') {
				chend=(char)(chend+32);
			}
			
			if(chend!=chstart) return false;
			s++;
			e--;
		}
		
		
		return true;
	}
	
	public static boolean isAlphanumeric(char ch) {
		return (ch>='a' && ch<='z') || (ch>='A' && ch<='Z')  ||(ch>='0' && ch<='9');
	}


	public static void main(String[] args) {
		//Example 1:
		
		String s1 = "Was it a car or a cat I saw?";
		boolean output1=true;

		//Example 2:

		String s2 = "tab a cat";
		boolean output2 =false;

		//Example 3:
		
		String s3 = "0P";
		boolean output3 =false;
		
		System.out.println("Brute Force Approch : ");
	
		boolean ans1=validPalindromeBruteForce(s1);
		boolean ans2=validPalindromeBruteForce(s2);
		boolean ans3=validPalindromeBruteForce(s3);
		
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
		
		
		System.out.println("Better Approch : ");
		
		ans1=validPalindromeBetter(s1);
		ans2=validPalindromeBetter(s2);
		ans3=validPalindromeBetter(s3);
		
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
