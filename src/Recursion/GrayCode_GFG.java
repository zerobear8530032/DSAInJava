//Gray Code
//Difficulty: MediumAccuracy: 63.64%Submissions: 9K+Points: 4
//Given a number N, generate bit patterns from 0 to 2^N-1 such that successive patterns differ by one bit. 
//A Gray code sequence must begin with 0.
// 
//Example 1:
//Input:
//N = 2
//Output: 
//00 01 11 10
//Explanation: 
//00 and 01 differ by one bit.
//01 and 11 differ by one bit.
//11 and 10 also differ by one bit.
// 
//Example 2:
//Input:
//N=3
//Output:
//000 001 011 010 110 111 101 100
//Explanation:
//000 and 001 differ by one bit.
//001 and 011 differ by one bit.
//011 and 010 differ by one bit.
//Similarly, every successive pattern 
//differs by one bit.
//Your task:
//You don't need to read input or print anything. Your task is to complete the function graycode() which takes an integer N as input and returns a la list of patterns.
// 
//Expected Time Complexity: O(2n)
//Expected Auxiliary Space: O(2n)
// 
//Constraints :
//1<=N<=16


package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class GrayCode_GFG {
	
	
//	brute force approch:
//	using recursion :
//	we can flip each bit in a inital 0000 string 
//	and check that string exists already or not
//	note : the question asking for valid gray code not a sequence of 
//	number difference by 1 bit thats why this is not accepted
//	time compelxity : O(n*2^n)
//	space compelxity : O(2^n)
	
	public static ArrayList<String> graycode(int n) {
		 ArrayList<String> res= new ArrayList();
		 HashSet<String> set= new HashSet();
		 StringBuilder str= new StringBuilder();
		 for(int i =0;i<n;i++) {
			 str.append('0');
		 }
		 res.add(str.toString());
		 set.add(str.toString());
		 helper(res,set,n);
		 return res;
	    }
	 public static void helper(ArrayList<String> res, HashSet<String> set,int n ) {
		 if(res.size()== Math.pow(2, n)) {
			 return ;
		 }
		
		 String s=res.getLast();
		 char [] chararr= s.toCharArray();
		 for(int i =chararr.length-1;i>=0;i--) {
			 char ch = chararr[i];
			 if(ch=='0') {
				 chararr[i]='1';
			 }else {
				 chararr[i]='0';				 
			 }
			 String str = new String(chararr);
			 if(set.contains(str)) {
				 continue ;
			 }
			 res.add(str);
			 set.add(str);
			 helper(res,set,n);
		 }
	 }
	 
//	 we can calculate gray code of each string using formula :
//	 graycode(i)= i^(i>>1)
//	 so we can apply it on out string to get valid string gray code
//	time complexity : O(n*2^n) 
//	time complexity : O(n*2^n) 
	 
	 public static String convertIntegertToBinary(int x, int bits) {
		 StringBuilder str= new StringBuilder();
		 for(int  i =0;i<bits;i++) {
			 int bit = x&1;
			 str.append(bit);
			 x= x>>1;
		 }
		 return str.reverse().toString();
	 }
	 
	 public static ArrayList<String> validGrayCode(int n){
		 ArrayList<String> res= new ArrayList();
		 
		 for(int i =0;i<Math.pow(2, n);i++) {
			 int graycode= i^(i>>1);
			 String strgraycode= convertIntegertToBinary(graycode,n);
			 res.add(strgraycode);
		 }
		 return res;
	 }
	 
	 
//	same approch using recursion
//	 so we can apply it on out string to get valid string gray code
//	time complexity : O(n*2^n) 
//	time complexity : O(n*2^n) 
	 
	 public static ArrayList<String> validGrayRec(int n){
		 ArrayList<String> res= new ArrayList();
		 helper(res,0,(int)Math.pow(2,n),n);
		 return res;
	 }
	 
	 public static void helper(ArrayList<String> res, int n, int limit,int bit) {
		 if(n==limit) {
			 return ;
		 }
		 int graycode = n^(n>>1);
		 String graycodestr= convertIntegertToBinary( graycode,bit);
		 res.add(graycodestr);

		 helper(res,n+1,limit,bit);
	 }
	 
	 
	 

	public static void main(String[] args) {
		
		//Example 1:

		int n1= 2;
		ArrayList<String>  output1= new ArrayList(Arrays.asList("00","01","11","10"));

		//Example 1:
		
		int n2= 3;
		ArrayList<String>  output2= new ArrayList(Arrays.asList("000","001","011","010","110","111","101","100"));
		
		
    	System.out.println("Recursive Approch :");

    	System.out.println("recursion  the answer is paritally correct but its not a valid sequence");
    	ArrayList<String>  ans1=graycode(n1);
    	ArrayList<String>  ans2=graycode(n2);
    	
    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	
    	System.out.println("valid sequence Recursion :");
    	ans1=validGrayRec(n1);
    	ans2=validGrayRec(n2);
    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}
    	
    	
    	System.out.println("Correct approch :");

    	ans1=validGrayCode(n1);
    	ans2=validGrayCode(n2);
    	
    	if(output1.equals(ans1)) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2.equals(ans2)) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}


	}

}
