//1358. Number of Substrings Containing All Three Characters
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s consisting only of characters a, b and c.
//
//Return the number of substrings containing at least one occurrence of all these characters a, b and c.
//
// 
//
//Example 1:
//
//Input: s = "abcabc"
//Output: 10
//Explanation: The substrings containing at least one occurrence of the characters a, b and c are "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" and "abc" (again).
//Example 2:
//
//Input: s = "aaacb"
//Output: 3
//Explanation: The substrings containing at least one occurrence of the characters a, b and c are "aaacb", "aacb" and "acb".
//Example 3:
//
//Input: s = "abc"
//Output: 1
//
//
//Constraints:
//
//3 <= s.length <= 5 x 10^4
//s only consists of a, b or c characters.
package slidingwindow;

public class NumberOfSubstringsContainingAllThreeCharacters_1358 {
//    approch :
//    use simple sliding window when the window have all characters
//    we can count windows including current window and the rest of character right side of window
//    as proper substring so we can use fomruala r-s.length
//    when all character are present we reduce size
//    other wise we expand window
//    time complexity : O(n)
//    space complexity : O(1)
//
    public static int numberOfSubstrings(String s) {
        int l =0;
        int n= s.length();
        int [] map = new int [3];
        int res=0;
        for(int r =0;r<n;r++){
            char ch =s.charAt(r);
            map[ch-'a']++;
            while(map[0]>0 && map[1]>0 && map[2]>0){
                res+= n-r;
                char c= s.charAt(l);
                map[c-'a']--;
                l++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "abcabc";
        int output1=10;

        //Example 2:

        String s2 = "aaacb";
        int output2=3;

        //Example 3:

        String s3 = "abc";
        int output3=1;

        int ans1= numberOfSubstrings(s1);
        int ans2= numberOfSubstrings(s2);
        int ans3= numberOfSubstrings(s3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }


    }
}
