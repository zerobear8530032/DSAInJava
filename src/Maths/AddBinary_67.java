//67. Add Binary
//Solved
//Easy
//Topics
//Companies
//Given two binary strings a and b, return their sum as a binary string.
//
// 
//
//Example 1:
//
//Input: a = "11", b = "1"
//Output: "100"
//Example 2:
//
//Input: a = "1010", b = "1011"
//Output: "10101"
// 
//
//Constraints:
//
//1 <= a.length, b.length <= 104
//a and b consist only of '0' or '1' characters.
//Each string does not contain leading zeros except for the zero itself.


package Maths;

import java.util.List;

public class AddBinary_67 {
//	brute force solution :
//	we can get place value by summing carry current place values /2
//	we can also get place value of result by sum of carray and place values %2
//	at last we wil check if othe rstirng is remaining if yes we will add them with carry
//	time complexity :O(n)
//	space complexity :O(n)
	    public static String addBinary(String a, String b) {
	        int carry =0;
	        StringBuilder ans = new StringBuilder();
	        int idx1=a.length()-1;
	        int idx2=b.length()-1;
	        while(idx1>=0 && idx2>=0){
	            int val1=a.charAt(idx1)-'0';
	            int val2=b.charAt(idx2)-'0';
	            int sum= carry+val1+val2;
	            carry=sum/2;
	            int place=sum%2;	       
	            ans.append(Integer.toString(place));
	            idx1--;
	            idx2--;     
	        }
	        
	        while(idx1>=0){
	            int val1=a.charAt(idx1)-'0';
	            int sum= val1+carry;
	            carry=sum/2;
	            int place=sum%2;
	            ans.append(Integer.toString(place));    
	            idx1--;
	        }
	        while(idx2>=0){
	            int val2=b.charAt(idx2)-'0';
	            int sum= val2+carry;
	            carry=sum/2;
	            int place=sum%2;
	            ans.append(Integer.toString(place));    
	            idx2--;
	        }
	        if(carry==1) {
	        	ans.append(1);
	        }

	        return ans.reverse().toString();
	    }
	 
	    public static void main(String[] args) {
	    	//Example 1:

	    	String a1 = "11", b1 = "1";
	    	String output1="100";

	    	//Example 2:

	    	String a2 = "1010", b2 = "1011";
	    	String output2="10101";

	    	String ans1=addBinary(a1,b1);
			String ans2=addBinary(a2,b2);
			
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


		}
	
}
