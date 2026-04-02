//1888. Minimum Number of Flips to Make the Binary String Alternating
//Attempted
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:
//
//Type-1: Remove the character at the start of the string s and append it to the end of the string.
//Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
//Return the minimum number of type-2 operations you need to perform such that s becomes alternating.
//
//The string is called alternating if no two adjacent characters are equal.
//
//For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
// 
//
//Example 1:
//
//Input: s = "111000"
//Output: 2
//Explanation: Use the first operation two times to make s = "100011".
//Then, use the second operation on the third and sixth elements to make s = "101010".
//Example 2:
//
//Input: s = "010"
//Output: 0
//Explanation: The string is already alternating.
//Example 3:
//
//Input: s = "1110"
//Output: 1
//Explanation: Use the second operation on the second element to make s = "1010".
//
//
//Constraints:
//
//1 <= s.length <= 105
//s[i] is either '0' or '1'.
package slidingwindow;

public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating_1888 {

    public static int minFlips(String s) {
        int n = s.length();
        char ch1='0';
        int op1=0;
        char ch2='1';
        int op2=0;
        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(ch1!=ch){op1++;}
            if(ch2!=ch){op2++;}
            ch1= ch1=='0'? '1':'0';
            ch2= ch2=='0'? '1':'0';
        }
        int l =0;
        int r= n-1;
        s=s+s;
        int res= Math.min(op1,op2);
        while(r+1<s.length()){
            r++;
            if(s.charAt(l)!='0'){op1--;}
            if(s.charAt(l)!='1'){op2--;}
            char ch = s.charAt(r);
            if(ch1!=ch){op1++;}
            if(ch2!=ch){op2++;}
            ch1= ch1=='0'? '1':'0';
            ch2= ch2=='0'? '1':'0';
            res=Math.min(Math.min(op1,op2),res);
            l++;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "111000";
        int output1= 2;

        //Example 2:
        String s2 = "010";
        int output2= 0;

        //Example 3:
        String s3 = "1110";
        int output3= 1;

        int ans1= minFlips(s1);
        int ans2= minFlips(s2);
        int ans3= minFlips(s3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }


    }
}
