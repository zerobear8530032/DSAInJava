//3775. Reverse Words With Same Vowel Count
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English words, each separated by a single space.
//
//Determine how many vowels appear in the first word. Then, reverse each following word that has the same vowel count. Leave all remaining words unchanged.
//
//Return the resulting string.
//
//Vowels are 'a', 'e', 'i', 'o', and 'u'.
//
//
//
//Example 1:
//
//Input: s = "cat and mice"
//
//Output: "cat dna mice"
//
//Explanation:​​​​​​​
//
//The first word "cat" has 1 vowel.
//"and" has 1 vowel, so it is reversed to form "dna".
//"mice" has 2 vowels, so it remains unchanged.
//Thus, the resulting string is "cat dna mice".
//Example 2:
//
//Input: s = "book is nice"
//
//Output: "book is ecin"
//
//Explanation:
//
//The first word "book" has 2 vowels.
//"is" has 1 vowel, so it remains unchanged.
//"nice" has 2 vowels, so it is reversed to form "ecin".
//Thus, the resulting string is "book is ecin".
//Example 3:
//
//Input: s = "banana healthy"
//
//Output: "banana healthy"
//
//Explanation:
//
//The first word "banana" has 3 vowels.
//"healthy" has 2 vowels, so it remains unchanged.
//Thus, the resulting string is "banana healthy".
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists of lowercase English letters and spaces.
//Words in s are separated by a single space.
//s does not contain leading or trailing spaces.
package Strings;

public class ReverseWordsWithSameVowelCount_3775 {
//    paproch just simulate whats saked
//    time complexity : O(n*m)
//    space complexity : O(n*m)
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        int vovelCount = 0;
        String firstWord = words[0];
        for (int i = 0; i < firstWord.length(); i++) {
            String ch = Character.toString(firstWord.charAt(i));
            if ("aeiou".contains(ch)) {
                vovelCount++;
            }
        }
        for (int i = 1; i < words.length; i++) {
            int vovels = 0;
            for (int j = 0; j < words[i].length(); j++) {
                String ch = Character.toString(words[i].charAt(j));
                if ("aeiou".contains(ch)) {
                    vovels++;
                }
            }
            if(vovels==vovelCount){
                words[i]= reverse(words[i]);
            }
        }
        return "".join(" ",words);
    }

    public static String reverse(String str) {
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "cat and mice";
        String output1="cat dna mice";

        //Example 2:

        String s2 = "book is nice";
        String output2="book is ecin";

        //Example 3:

        String s3 = "banana healthy";
        String output3="banana healthy";

        String ans1= reverseWords(s1);
        String ans2= reverseWords(s2);
        String ans3= reverseWords(s3);

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
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}
