//question link ://https://www.geeksforgeeks.org/program-for-length-of-a-string-using-recursion/
// Program for length of a string using recursion
//Last Updated : 01 Aug, 2022
//Given a string calculate length of the string using recursion. 
//
//Examples: 
//
//Input : str = "abcd"
//Output :4
//
//Input : str = "GEEKSFORGEEKS"
//Output :13
package Recursion;

public class ProgramForLengthOfAStringUsingrecursion_GFG {
	
//	useing iterative approch :
	public static int getStringLengthIterative(String s) {
		int idx=0;
		int counter=0;
		try {
			while(true) {
				counter++;
				s.charAt(counter);
			}			
		}catch(Exception e) {
			return counter;
		}
		
	}
//	useing iterative approch :
//	using substring can  make n number of copyes in the string pool because strings are immutable 

	public static int getStringLengthRec(String s) {
		return getLengthHelper(s, 0);
	}
	public static int getLengthHelper(String str, int counter) {
		if(str.isEmpty()) {
			return counter;
		}
		return getLengthHelper(str.substring(1),counter+1);
	}

	
//	useing iterative approch :
//	using substring can  make n number of copyes in the string pool because strings are immutable 
	
	public static int getStringLengthRecWithoutSubString(String s) {
		return getLengthHelperWithoutSubstring(s, 0);
	}
	public static int getLengthHelperWithoutSubstring(String str, int idx) {
		try {
			str.charAt(idx);
			return getLengthHelperWithoutSubstring(str, idx+1);
		}catch(Exception e) {
			return idx;
		}	
	}

	public static void main(String[] args) {
		//Examples: 
		//
		String str1 = "abcd";
		int output1=4;
		
		String str2 = "GEEKSFORGEEKS";
		int output2= 13;
		System.out.println("Iterative Approch :");
		
		int ans1=getStringLengthIterative(str1);
		int ans2=getStringLengthIterative(str2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		System.out.println("Recursion Approch :");
		
		ans1=getStringLengthRec(str1);
		ans2=getStringLengthRec(str2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		
		System.out.println("Recursion Without SubString Approch :");
		
		ans1=getStringLengthRecWithoutSubString(str1);
		ans2=getStringLengthRecWithoutSubString(str2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
	}

}
