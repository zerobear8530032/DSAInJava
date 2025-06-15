//Maximum number possible by doing at-most K swaps
//Last Updated : 12 May, 2025
//Given a string s and an integer k, the task is to find the maximum possible number by performing swap operations on the digits of s at most k times.
//
//Examples: 
//
//Input: s = "7599", k = 2
//Output: 9975
//Explanation: Two Swaps can make input 7599 to 9975. First swap 9 with 5 so number becomes 7995, then swap 9 with 7 so number becomes 9975
//
//Input: s = "1234567", k = 4
//Output: 7654321
//Explanation: Three swaps can make the input 1234567 to 7654321. First swap 1 with 7, then swap 2 with 6 and finally swap 3 with 5.
//
//Input: s = "76543", k = 1 
//Output: 76543
//Explanation: No swap is required.
//
//Try it on GfG Practice



package Backtracking;

public class MaximumNumberPossibleByDoingAtMostKSwaps_GFG {
	
	public static String largestNumber(String num , int k) {
		char [] str= num.toCharArray();
		res="0";
		helper(str,k);
		return res;
	}
	static String res;
	public static void helper(char [] str, int k) {
		if(Integer.parseInt(res)<Integer.parseInt(new String(str))) {
			res=new String(str);
		}
		if(k==0) {
			return;
		}
		
		for(int i =0;i<str.length-1;i++) {
			for(int j =i+1;j<str.length;j++) {
				if(str[i]<str[j]) {
					swap(str,i,j);
					helper(str,k-1);
					swap(str,i,j);
				}
			}
		}

	}
	public static void swap(char [] str, int i, int j) {
		char temp= str[i];
		str[i]=str[j];
		str[j]=temp;
	}

	public static void main(String[] args) {
		//Examples 1: 

		String s1 = "7599";
		int k1 = 2;
		String output1="9975";
		
		//Examples 2: 
		
		String s2 = "1234567";
		int k2 = 4;
		String output2="7654321";
		
		//Examples 2: 
		
		String s3 = "76543";
		int k3 = 1;
		String output3="76543";
		

    	String ans1=largestNumber(s1,k1);
    	String ans2=largestNumber(s2,k2);
    	String ans3=largestNumber(s3,k3);
    	
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
    	if(output3.equals(ans3)) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Ouput :"+ output3);
    		System.out.println("Your Answer :"+ ans3);  		
    	}

	}

}
