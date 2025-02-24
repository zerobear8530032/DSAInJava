//Question link :
// https://www.geeksforgeeks.org/first-uppercase-letter-in-a-string-iterative-and-recursive/
//First uppercase letter in a string (Iterative and Recursive)
//Last Updated : 09 Dec, 2022
//Given a string find its first uppercase letter
//Examples : 
//
//Input : geeksforgeeKs
//Output : K
//
//Input  : geekS
//Output : S

package Recursion;
public class FirstUppercaseLetterInAstring {
// iterative approch : use simple loop
	public static char getFirstCapitalLetter(String str) {
		for(int i =0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch>='A' && ch<='Z') {
				return ch;
			}
		}
		return (char)-1;
	}
	
	
	
// Recursive approch : use Recursion 
	
	
	public static char getFirstCapitalLetterRec(String str) {
		return getFirstCapCharacterHelper(str,0);
	}
	
	
	
		private static char getFirstCapCharacterHelper(String str, int i) {
			if(i==str.length()) {
				return (char)-1;
			}
			char ch = str.charAt(i);
			if(ch>='A' && ch<='Z') {
				return ch;
			}
			return getFirstCapCharacterHelper(str, i+1);
		}
// this approch create mutiple strings in string pool  so not prefer for large string inputs 
// different recursion approch : using substring where we take substring from 1 index which will
//		make each time the recusion call n-1  length string 
//		example :
//		str= geEksS
//		1 : call(geEksS) :
//		geEksS.substring(1)= eEksS
//		2: call(eEksS) :
//		eEksS.substring(1)= EksS
//		3: call(EksS) :
//		 here E is captial this will trigget the return and E will be output
//		
		
		private static char getFirstCapCharacterRec_UsingSubstring(String str) {
			if(str.isEmpty()) {
				return (char)-1;
			}
			char ch = str.charAt(0);
			if(ch>='A' && ch<='Z') {
				return ch;
			}
			return getFirstCapCharacterRec_UsingSubstring(str.substring(1));
			
			
		}

		public static void main(String[] args) {
			
			
			//Examples : 
			//
			String str1 ="geeksforgeeKs";
			char output1='K';
			
			//Examples : 
			//			
			String str2 = "geekS";
			char output2 = 'S';
			
			
			char ans1=getFirstCapitalLetter(str1);
	    	char ans2=getFirstCapitalLetter(str2);
	    	
	    	System.out.println("Iterative Approch :");
	    	
	    	if(output1==ans1) {
	    		System.out.println("Case 1 Passed");
	    	}else {
	    		System.out.println("Case 1 Failed");
	    		System.out.println("Expected Ouput :"+ output1);
				System.out.println("Your Answer :"+ ans1);  		
	    	}
	    	if(output2==ans2) {
	    		System.out.println("Case 2 Passed");
	    	}else {
	    		System.out.println("Case 2 Failed");
	    		System.out.println("Expected Ouput :"+ output2);
	    		System.out.println("Your Answer :"+ ans2);  		
	    	}

//	    	Recursion Approch 
	    	
	    	System.out.println("Recursive Approch :");

	    	ans1=getFirstCapitalLetterRec(str1);
	    	ans2=getFirstCapitalLetterRec(str2);
	    	
	    	if(output1==ans1) {
	    		System.out.println("Case 1 Passed");
	    	}else {
	    		System.out.println("Case 1 Failed");
	    		System.out.println("Expected Ouput :"+ output1);
	    		System.out.println("Your Answer :"+ ans1);  		
	    	}
	    	
	    	if(output2==ans2) {
	    		System.out.println("Case 2 Passed");
	    	}else {
	    		System.out.println("Case 2 Failed");
	    		System.out.println("Expected Ouput :"+ output2);
	    		System.out.println("Your Answer :"+ ans2);  		
	    	}
	    	
	    	System.out.println("Recursive Approch 2:");

	    	ans1=getFirstCapCharacterRec_UsingSubstring(str1);
	    	ans2=getFirstCapCharacterRec_UsingSubstring(str2);
	    	
	    	if(output1==ans1) {
	    		System.out.println("Case 1 Passed");
	    	}else {
	    		System.out.println("Case 1 Failed");
	    		System.out.println("Expected Ouput :"+ output1);
	    		System.out.println("Your Answer :"+ ans1);  		
	    	}
	    	
	    	if(output2==ans2) {
	    		System.out.println("Case 2 Passed");
	    	}else {
	    		System.out.println("Case 2 Failed");
	    		System.out.println("Expected Ouput :"+ output2);
	    		System.out.println("Your Answer :"+ ans2);  		
	    	}

		}
}