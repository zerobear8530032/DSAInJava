//Remove all consecutive duplicates from the string
//Last Updated : 22 Aug, 2023
//Given a string S, The task is to remove all the consecutive duplicate characters of the string and return the resultant string. 
//
//Note: that this problem is different from Recursively remove all adjacent duplicates. Here we keep one character and remove all subsequent same characters.
//
//Examples: 
//
//
//Input: S= “aaaaabbbbbb”
//Output: ab
//
//
//Input: S = “geeksforgeeks”
//Output: geksforgeks
//
//
//Input: S = “aabccba”
//Output: abcba



package Recursion;

public class RemoveAllConsecutiveDuplicatesFromTheString {
//iterative approch : used a stringbulder to construct the string
//time complexity :O(n)	
//space complexity :O(n)	
	public static String removeConsicutiveDuplicatesIterative(String str) {
		int n = str.length();
		int previdx=0;
		int curridx=0;
		StringBuilder ans = new StringBuilder();
		ans.append(str.charAt(0));
		while(curridx<n) {
			if(str.charAt(curridx)==str.charAt(previdx)) {
				curridx++;				
			}else {
				ans.append(str.charAt(curridx));
				previdx=curridx;
				curridx++;
			}			
		}
		return ans.toString();
	}
	public static String removeConsicutiveDuplicatesRec(String str) {
		StringBuilder ans = new StringBuilder();
		ans.append(str.charAt(0));
		removeConsicutiveDuplicateHelper(str, 0, 0, ans);
		return ans.toString();
		
	}
	public static void  removeConsicutiveDuplicateHelper(String str,int prev,int curr,StringBuilder ans) {
		if(curr>=str.length()) {
			return ;
		}
		if(str.charAt(curr)==str.charAt(prev)) {
			removeConsicutiveDuplicateHelper(str, prev, curr+1, ans);
		}else {
			ans.append(str.charAt(curr));
			removeConsicutiveDuplicateHelper(str, curr, curr+1, ans);
		}	
	}
	
	public static void main(String[] args) {
		
		String s1= "aaaaabbbbbb";
		String output1="ab";
		
		String s2= "geeksforgeeks";
		String output2="geksforgeks";
		
		String s3= "aabccba";
		String output3="abcba";
		
		
		String ans1=removeConsicutiveDuplicatesIterative(s1);
		String ans2=removeConsicutiveDuplicatesIterative(s2);
		String ans3=removeConsicutiveDuplicatesIterative(s3);
		
		System.out.println("Iterative Approch :");
		
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
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		ans1=removeConsicutiveDuplicatesRec(s1);
		ans2=removeConsicutiveDuplicatesRec(s2);
		ans3=removeConsicutiveDuplicatesRec(s3);
		
		System.out.println("Iterative Approch :");
		
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
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
	}

}
