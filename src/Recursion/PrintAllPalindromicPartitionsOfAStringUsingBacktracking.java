//Print all Palindromic Partitions of a String using Backtracking
//Last Updated : 27 May, 2024
//Given a string, find all possible palindromic partitions of given string.
//
//Note that this problem is different from Palindrome Partitioning Problem, there the task was to find the partitioning with minimum cuts in input string. Here we need to print all possible partitions.
//
//Example: 
//
//Input:  nitin
//Output: n i t i n
//             n iti n
//             nitin
//
//
//
//Input:  geeks
//Output: g e e k s
//             g ee k s



package Recursion;
import java.util.ArrayList;
import java.util.List;
public class PrintAllPalindromicPartitionsOfAStringUsingBacktracking {

// Iterative Approch :
//	get all the sub string and add them in list :
	public static void printAllPalindromSubString(String str) {
		ArrayList <String> ans = new ArrayList();
		for(int i =0;i<str.length();i++) {
			for(int j=0;j<str.length();j++) {
				StringBuilder strb= new StringBuilder();
				for(int sub=i;sub<=j;sub++) {
					strb.append(str.charAt(sub));
				}
				if(palindrome(strb.toString())) {
					ans.add(strb.toString());
				}
			}
			
		}
		System.out.println(ans);
	}
// better iterative Approch :
//	get all the sub string and add them in list :
//	time complexity :O(N*N*N)
//	space complexity :O(N)
	public static void printAllPalindromSubStringBetter(String str) {
		ArrayList <String> ans = new ArrayList();
		for(int i =0;i<str.length();i++) {
			StringBuilder strb= new StringBuilder();
			for(int j=i;j<str.length();j++) {
				strb.append(str.charAt(j));
				if(palindrome(strb.toString())) {
					ans.add(strb.toString());
				}	
			}			
		}
		System.out.println(ans);
	}
	
// use recursion approch :
//	time complexity :O(N*N)
//	space complexity :O(N)
	
	public static void printAllPalindromSubStringRec(String str) {
		List<String> ans= new ArrayList();
		helper(ans,str,str.length());
		System.out.println(ans);
	}
	
	public static void helper(List<String> ans,String str,int i) {
		if(i==-1) {
			return ;
		}
		
		StringBuilder strb= new StringBuilder();
		
		for(int j=i;j<str.length();j++) {
			strb.insert(0,str.charAt(j));
			if(palindrome(strb.toString())) {
				ans.add(strb.toString());
			}	
		}	
		
		helper(ans,str,i-1);
	}
	
	
	
	
	
	
	public static boolean palindrome(String str) {
		if(str.length()==0) {
			return false;
		}
		int s=0;
		int e=str.length()-1;
		while(s<e) {
			if(str.charAt(e)!=str.charAt(s)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
	
	
	

	public static void main(String[] args) {
		
		String str1 ="nitin";
		String str2="geeks";
		
		printAllPalindromSubString(str1);
		printAllPalindromSubString(str2);
	
		printAllPalindromSubStringBetter(str1);
		printAllPalindromSubStringBetter(str2);
		
		printAllPalindromSubStringRec(str1);
		printAllPalindromSubStringRec(str2);
		
		
	}

}
