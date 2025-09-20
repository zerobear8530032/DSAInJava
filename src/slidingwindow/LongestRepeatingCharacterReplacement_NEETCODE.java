//Longest Repeating Character Replacement
//You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
//
//After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
//
//Example 1:
//
//Input: s = "XYYX", k = 2
//
//Output: 4
//Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
//
//Example 2:
//
//Input: s = "AAABABB", k = 1
//
//Output: 5
//Constraints:
//
//1 <= s.length <= 1000
//0 <= k <= s.length
package slidingwindow;

public class LongestRepeatingCharacterReplacement_NEETCODE {
//     approch :
//    here we know if we take max freq - entire window size <=k are all valid substrings
//    other wise invalid so we can use sliding windows
//    time complexity : O(26*n)
//    space complexity : O(1)
    public static int characterReplacementBruteForce(String s, int k) {
        int [] map = new int [26];
        int res=0;
        int l =0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            map[ch-'A']++;
            while(((r-l+1) -maxFreq(map))>k){
                char lch= s.charAt(l);
                map[lch-'A']--;
                l++;
            }
            int size= r-l+1;
            res=Math.max(res,size);
        }
        return res;
    }

    public static int maxFreq(int [] map){
        int max=0;
        for(int x:map){
            max=Math.max(x,max);
        }
        return max;
    }



    //    here we know if we take max freq - entire window size <=k are all valid substrings
//    other wise invalid so we can use sliding windows
//    time complexity : O(26*n)
//    space complexity : O(1)
    public static int characterReplacementBetter(String s, int k) {
        int [] map = new int [26];
        int res=0;
        int maxFreq=0;
        int l =0;
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            map[ch-'A']++;
            maxFreq=Math.max(map[ch-'A'],maxFreq);
            while(((r-l+1) -maxFreq)>k){
                char lch= s.charAt(l);
                map[lch-'A']--;
                l++;
            }
            int size= r-l+1;
            res=Math.max(res,size);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "XYYX";
        int k1 = 2;
        int output1=4;

        //Example 2:
        String s2 = "AAABABB";
        int k2 = 1;
        int output2=5;

        //Example 3:
        String s3 = "AAAB";
        int k3 = 0;
        int output3=3;


        System.out.println("Brute Force Approch");
        int ans1= characterReplacementBruteForce(s1,k1);
        int ans2= characterReplacementBruteForce(s2,k2);
        int ans3= characterReplacementBruteForce(s3,k3);

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
        System.out.println("Better Force Approch");

        ans1= characterReplacementBetter(s1,k1);
        ans2= characterReplacementBetter(s2,k2);
        ans3= characterReplacementBetter(s3,k3);

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
