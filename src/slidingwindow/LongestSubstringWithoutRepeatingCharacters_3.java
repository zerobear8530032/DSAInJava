//3. Longest Substring Without Repeating Characters
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s, find the length of the longest substring without duplicate characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//Constraints:
//
//0 <= s.length <= 5 * 104
//s consists of English letters, digits, symbols and spaces.
package slidingwindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap();
        int l=0;
        int res=0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            map.put(ch,map.getOrDefault(ch,0)+1);
            while(map.get(ch)>1){
                char chl= s.charAt(l);
                if(map.containsKey(chl)){
                    map.put(chl,map.get(chl)-1);
                }
                l++;
            }
            int length= (r-l)+1;
            res=Math.max(res,length);
        }
        return res;
    }

    public static void main(String[] args) {

    //Example 1:

    String s1 = "abcabcbb";
    int output1=3;

    //Example 2:

    String s2 = "bbbbb";
    int output2=1;

    //Example 3:

    String s3 = "pwwkew";
    int output3=3;

    int ans1= lengthOfLongestSubstring(s1);
    int ans2= lengthOfLongestSubstring(s2);
    int ans3= lengthOfLongestSubstring(s3);


        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}
