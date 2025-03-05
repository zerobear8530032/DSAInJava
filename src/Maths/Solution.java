//9. Palindrome Number
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer x, return true if x is a palindrome, and false otherwise.
//
// 
//
//Example 1:
//
//Input: x = 121
//Output: true
//Explanation: 121 reads as 121 from left to right and from right to left.
//Example 2:
//
//Input: x = -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//Example 3:
//
//Input: x = 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
// 
//
//Constraints:
//
//-231 <= x <= 231 - 1
// 
//
//Follow up: Could you solve it without converting the integer to a string?

package Maths;
class Solution {
    public static boolean isPalindrome(int x) {
        String strx= Integer.toString(x);
        String reversex= reverse(strx);
        return strx.equals(reversex);
    }
    public static String reverse(String x){
        StringBuilder str= new StringBuilder(x);
        str.reverse();
        return str.toString();
    }
    
        public static boolean isPalindromeWithOutStrings(int x) {
            int temp = x;
            int sum =0;
            if(x<0) return false;
            while(temp>0){
                int rem = temp%10;
                temp=temp/10;
                sum=sum*10+rem;
            }
            return sum==x ;
        }
    
    
    public static void main(String[] args) {
    	//Example 1:
    	//
    	int x1 = 121;
    	boolean output1=true;
    	
    	//Example 2:
    	//
    	int x2= -121;
    	boolean output2=false;
    	
    	//Example 3:
    	
    	int x3 = 10;
    	boolean output3=false;
    	
    	System.out.println("Brute Force Approch ");
    	
    	boolean ans1= isPalindrome(x1);
    	boolean ans2= isPalindrome(x2);
    	boolean ans3= isPalindrome(x3);

		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		
		System.out.println("Without converting to stirngs");
	
		 ans1= isPalindromeWithOutStrings(x1);
		 ans2= isPalindromeWithOutStrings(x2);
		 ans3= isPalindromeWithOutStrings(x3);
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ (output1));
			System.out.println("Your Output : "+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ output2);
			System.out.println("Your Output : "+ ans2);
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ output3);
			System.out.println("Your Output : "+ ans3);
		}
		


	}
    
}