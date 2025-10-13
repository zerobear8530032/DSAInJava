//2273. Find Resultant Array After Removing Anagrams
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 0-indexed string array words, where words[i] consists of lowercase English letters.
//
//In one operation, select any index i such that 0 < i < words.length and words[i - 1] and words[i] are anagrams, and delete words[i] from words. Keep performing this operation as long as you can select an index that satisfies the conditions.
//
//Return words after performing all operations. It can be shown that selecting the indices for each operation in any arbitrary order will lead to the same result.
//
//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase using all the original letters exactly once. For example, "dacb" is an anagram of "abdc".
//
//
//
//Example 1:
//
//Input: words = ["abba","baba","bbaa","cd","cd"]
//Output: ["abba","cd"]
//Explanation:
//One of the ways we can obtain the resultant array is by using the following operations:
//- Since words[2] = "bbaa" and words[1] = "baba" are anagrams, we choose index 2 and delete words[2].
//  Now words = ["abba","baba","cd","cd"].
//- Since words[1] = "baba" and words[0] = "abba" are anagrams, we choose index 1 and delete words[1].
//  Now words = ["abba","cd","cd"].
//- Since words[2] = "cd" and words[1] = "cd" are anagrams, we choose index 2 and delete words[2].
//  Now words = ["abba","cd"].
//We can no longer perform any operations, so ["abba","cd"] is the final answer.
//Example 2:
//
//Input: words = ["a","b","c","d","e"]
//Output: ["a","b","c","d","e"]
//Explanation:
//No two adjacent strings in words are anagrams of each other, so no operations are performed.
//
//
//Constraints:
//
//1 <= words.length <= 100
//1 <= words[i].length <= 10
//words[i] consists of lowercase English letters.
package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams_2273 {
//    approch :
//    here we sort the the string and compare the consicutive string which are equal after sorting
//    we can take the first one
//    time complexity : O( n * k)
//    space complexity : O(1)
    static int [] charmap = new int [26];
    public static String sort(String s){
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            charmap[ch-'a']++;
        }
        StringBuilder str= new StringBuilder();
        for(int i =0;i<charmap.length;i++){
            for(int j=0;j<charmap[i];j++){
                str.append((char)(i+'a'));
            }
            charmap[i]=0;
        }
        return str.toString();
    }
    public static List<String> removeAnagrams(String[] words) {
        List<String> res= new ArrayList<>();
        String prev= sort(words[0]);
        res.add(words[0]);
        for(int i =1;i<words.length;i++){
            String sorted= sort(words[i]);
            if(!sorted.equals(prev)){
                res.add(words[i]);
                prev=sorted;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String [] words1 = {"abba","baba","bbaa","cd","cd"};
        List<String> output1= new ArrayList<>(Arrays.asList("abba","cd"));

        //Example 2:

        String [] words2 = {"a","b","c","d","e"};
        List<String> output2= new ArrayList<>(Arrays.asList("a","b","c","d","e"));


        List<String> ans1 = removeAnagrams(words1);
        List<String> ans2 = removeAnagrams(words2);

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

    }
}
