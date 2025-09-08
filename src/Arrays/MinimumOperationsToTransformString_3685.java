//3675. Minimum Operations to Transform String
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string s consisting only of lowercase English letters.
//
//You can perform the following operation any number of times (including zero):
//
//Choose any character c in the string and replace every occurrence of c with the next lowercase letter in the English alphabet.
//
//Return the minimum number of operations required to transform s into a string consisting of only 'a' characters.
//
//Note: Consider the alphabet as circular, thus 'a' comes after 'z'.
//
//
//
//Example 1:
//
//Input: s = "yz"
//
//Output: 2
//
//Explanation:
//
//Change 'y' to 'z' to get "zz".
//Change 'z' to 'a' to get "aa".
//Thus, the answer is 2.
//Example 2:
//
//Input: s = "a"
//
//Output: 0
//
//Explanation:
//
//The string "a" only consists of 'a'​​​​​​​ characters. Thus, the answer is 0.
//
//
//Constraints:
//
//1 <= s.length <= 5 * 105
//s consists only of lowercase English letters.
package Arrays;


public class MinimumOperationsToTransformString_3685 {
// we need to take farthest character from goal
//    because it will go through all middle character
//    taking them together
// so we can find first character which is not A
//    and all the characters should come in btw that character and a
//    time complexity : O(n)
//    space complexity : O(1)
    public static int minOperations(String s) {
        int [] present = new int [26];
        for(int i =0;i<s.length();i++){
            char ch =s.charAt(i);
            if(ch=='a'){continue;}

            present[ch-'a']= 1;
        }
        // System.out.println(Arrays.toString(present));
        for(int i =0;i<present.length;i++){
            if(present[i]==1){
                return 26-i;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "yz";
        int output1=2;

        //Example 2:

        String s2 = "a";
        int output2=0;

        int ans1= minOperations(s1);
        int ans2= minOperations(s2);
        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ (output1));
            System.out.println("Your Output : "+ (ans1));
        }
        if((ans2==output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ (output2));
            System.out.println("Your Output : "+ (ans2));
        }

    }
}
