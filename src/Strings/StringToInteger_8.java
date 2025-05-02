//8. String to Integer (atoi)
//Solved
//Medium
//Topics
//Companies
//Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.
//
//The algorithm for myAtoi(string s) is as follows:
//
//Whitespace: Ignore any leading whitespace (" ").
//Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
//Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached. If no digits were read, then the result is 0.
//Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range. Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
//Return the integer as the final result.
//
// 
//
//Example 1:
//
//Input: s = "42"
//
//Output: 42
//
//Explanation:
//
//The underlined characters are what is read in and the caret is the current reader position.
//Step 1: "42" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "42" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "42" ("42" is read in)
//           ^
//Example 2:
//
//Input: s = " -042"
//
//Output: -42
//
//Explanation:
//
//Step 1: "   -042" (leading whitespace is read and ignored)
//            ^
//Step 2: "   -042" ('-' is read, so the result should be negative)
//             ^
//Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
//               ^
//Example 3:
//
//Input: s = "1337c0d3"
//
//Output: 1337
//
//Explanation:
//
//Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
//             ^
//Example 4:
//
//Input: s = "0-1"
//
//Output: 0
//
//Explanation:
//
//Step 1: "0-1" (no characters read because there is no leading whitespace)
//         ^
//Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
//         ^
//Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
//          ^
//Example 5:
//
//Input: s = "words and 987"
//
//Output: 0
//
//Explanation:
//
//Reading stops at the first non-digit character 'w'.
//
// 
//
//Constraints:
//
//0 <= s.length <= 200
//s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.


package Strings;
public class StringToInteger_8 {
//	brute force :
//	first skip all white space
//	then check for operator
//	then append all character in a string which are numeric
//	exit loop if any kind of non numeric character comes
//	at last check for 2 things
//	entire string is made up of zero
//	if the string length is less then 10 then check it can be convert to intteger
//	if yes return it
//	if not return the max value of integer if its positive other wise min value
//	if the length is higer then 10 then also if its positive return max value otherwise min value
//   time complexity : O(n)
//   space complexity : O(n)
	public static int myAtoi(String s) {
        int index=0;
        int n= s.length();
        while(index<n  && s.charAt(index)==' '){
            index++;
        }
        boolean minus=false;
        if(index<n && s.charAt(index)=='-'){
            minus=true;
            index++;
        }else if(index<n && s.charAt(index)=='+'){
            index++;
        }
        StringBuilder num= new StringBuilder();
        while(index<n ){
            char ch = s.charAt(index);
            if(ch>='0' && ch<='9'){
                num.append(ch);
            }else{
                break;
            }
            index++;
        }


        int i =0;
        boolean allzero=true;
        while(i<num.length()){
            if(num.charAt(i)!='0'){
            num= new StringBuilder(num.substring(i));
            allzero=false;
            break;
            }
            i++;
        }
        if(allzero) return 0;
        if(num.length()>10){
         if(minus){
            return Integer.MIN_VALUE;
         }else{
            return Integer.MAX_VALUE;
         }   
        }
    
        if(num.length()<=10){
            try{
               int res=Integer.parseInt(num.toString());
               if(minus){
                return -res;
               }else{
               return res; 
               }
            }catch(Exception e){
                if(minus){
                return Integer.MIN_VALUE;
                }else{
                return Integer.MAX_VALUE;
                }      
            }
        }
        return 0;
    }
    public static void main(String[] args) {


    	//Example 1:
    	
    	String s1 = "42";
    	int output1=42;
    	
    	//Example 2:
    	
    	String s2 = "-042";
    	int output2=-42;
    	
    	
    	//Example 3:
    	
    	String s3 = "1337c0d3";
    	int output3=1337;
    	
    	//Example 4:
    	
    	String s4 = "-91283472332";
    	int output4=-2147483648;
    	
    	
    	//Example 5:
    	
    	String s5 = "       0000000000012345678";
    	int output5=12345678;
    	
    	//Example 6:
    	
    	String s6 = "   0000000000000   ";
    	int output6=0;
    	
    	
    	//Example 7:
    	
    	String s7 = "  -0012a42";
    	int output7=-12;
    	
    	//Example 8:
    	
    	String s8 = "-4435345345234234234234353453456554654654";
    	int output8=-2147483648;
    	
    	
    	//Example 9:
    	
    	String s9 = "4364876578346857634785634658732";
    	int output9=2147483647;
    	
    	
    	
    	int ans1=myAtoi(s1);    	
    	int ans2=myAtoi(s2);    	
    	int ans3=myAtoi(s3);    	
    	int ans4=myAtoi(s4);    	
    	int ans5=myAtoi(s5);    	
    	int ans6=myAtoi(s6);    	
    	int ans7=myAtoi(s7);    	
    	int ans8=myAtoi(s8);    	
    	int ans9=myAtoi(s9);    	
    	
		System.out.println("Brute force Approch :");
		
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
		if(output4==ans4) {
			System.out.println("Case 4 Passed");
		}else {
			System.out.println("Case 4 Failed");
			System.out.println("Actual Output :"+output4);
			System.out.println("Your Output :"+ans4);
		}
		if(output5==ans5) {
			System.out.println("Case 5 Passed");
		}else {
			System.out.println("Case 5 Failed");
			System.out.println("Actual Output :"+output5);
			System.out.println("Your Output :"+ans5);
		}
		if(output6==ans6) {
			System.out.println("Case 6 Passed");
		}else {
			System.out.println("Case 6 Failed");
			System.out.println("Actual Output :"+output6);
			System.out.println("Your Output :"+ans6);
		}
		if(output7==ans7) {
			System.out.println("Case 7 Passed");
		}else {
			System.out.println("Case 7 Failed");
			System.out.println("Actual Output :"+output7);
			System.out.println("Your Output :"+ans7);
		}
		if(output8==ans8) {
			System.out.println("Case 8 Passed");
		}else {
			System.out.println("Case 8 Failed");
			System.out.println("Actual Output :"+output8);
			System.out.println("Your Output :"+ans8);
		}
		if(output9==ans9) {
			System.out.println("Case 9 Passed");
		}else {
			System.out.println("Case 9 Failed");
			System.out.println("Actual Output :"+output9);
			System.out.println("Your Output :"+ans9);
		}

    	
	}
}