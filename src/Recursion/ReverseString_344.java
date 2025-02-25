//344. Reverse String
//Solved
//Easy
//Topics
//Companies
//Hint
//Write a function that reverses a string. The input string is given as an array of characters s.
//
//You must do this by modifying the input array in-place with O(1) extra memory.
//
// 
//
//Example 1:
//
//Input: s = ["h","e","l","l","o"]
//Output: ["o","l","l","e","h"]
//Example 2:
//
//Input: s = ["H","a","n","n","a","h"]
//Output: ["h","a","n","n","a","H"]
// 
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is a printable ascii character.
package Recursion;

import java.util.Arrays;

public class ReverseString_344 {
//	iterative approch :
//	time complexity O(n);
//	Space complexity O(1);
	  public static void reverseString_iterative(char[] s) { 
		 int start=0;
		 int end=s.length-1;
		 while(start<=end) {
			 swap(start,end,s);
			 start++;
			 end--;
		 }	        
	    }
	  public static void swap(int l,int r,char[] s) {
		  char t= s[l];
		  s[l]=s[r];
		  s[r]=t;
	  }
	  
	    public static boolean check(char [] arr1, char [] arr2) {
			if(arr1.length!=arr2.length) {
				return false;
			}
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			for(int i =0;i<arr1.length;i++) {
				if(arr1[i]!=arr2[i]) {
					return false;
				}
			}
			
			return true;
		}
	    
//	    recursion approcgh
//		time complexity O(n);
//		Space complexity O(n);
		public static void reverseStringRec(char[] s) {
			int start=0;
			int end= s.length-1;
			swaphelper(s,start,end);
		}


	private static void  swaphelper(char[] s, int start, int end) {
		if(start>=end) {
			return;
		}
		char t = s[start];
		s[start]=s[end];
		s[end]=t;
		swaphelper(s,start+1,end-1); // note never use increment operator in the recursion call this 
//		that will leave the recursion call in infinite loop
		}
	
	
	public static void main(String[] args) {
		
		//Example 1:
		//
		char[] s1 = {'h','e','l','l','o'};
		char [] output1= {'o','l','l','e','h'};
		
		
		//Example 2:
		//
		char [] s2 = {'H','a','n','n','a','h'};
		char []output2= {'h','a','n','n','a','H'};

		System.out.println("Iterative Approch :");
		 reverseString_iterative(s1);
		 reverseString_iterative(s2);

		
        if(check(s1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(s1));
		}
        
		if(check(s2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(s2));
		}
		
		
		s1 =new char[] {'h','e','l','l','o'};
		s2 = new char[] {'H','a','n','n','a','h'};
		System.out.println("Recursion Approch :");
		 reverseStringRec(s1);
		 reverseStringRec(s2);

		
       if(check(s1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(s1));
		}
       
		if(check(s2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(s2));
		}
		
				
		

		

	}

}
