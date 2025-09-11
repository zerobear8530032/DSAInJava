//2785. Sort Vowels in a String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a 0-indexed string s, permute s to get a new string t such that:
//
//All consonants remain in their original places. More formally, if there is an index i with 0 <= i < s.length such that s[i] is a consonant, then t[i] = s[i].
//The vowels must be sorted in the nondecreasing order of their ASCII values. More formally, for pairs of indices i, j with 0 <= i < j < s.length such that s[i] and s[j] are vowels, then t[i] must not have a higher ASCII value than t[j].
//Return the resulting string.
//
//The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in lowercase or uppercase. Consonants comprise all letters that are not vowels.
//
//
//
//Example 1:
//
//Input: s = "lEetcOde"
//Output: "lEOtcede"
//Explanation: 'E', 'O', and 'e' are the vowels in s; 'l', 't', 'c', and 'd' are all consonants. The vowels are sorted according to their ASCII values, and the consonants remain in the same places.
//Example 2:
//
//Input: s = "lYmpH"
//Output: "lYmpH"
//Explanation: There are no vowels in s (all characters in s are consonants), so we return "lYmpH".
//
//
//Constraints:
//
//1 <= s.length <= 105
//s consists only of letters of the English alphabet in uppercase and lowercase.

package Sorting;

import java.util.ArrayList;
import java.util.List;

public class SortVowelsInAString_2785 {
//    approch :
//    first extract all the vovels from the string
//    sort them using any sorting algo i used count sort for better performance
//    now put put all the vovels in the sorted sequence back to where a vovel would be
//    time complexity : O(n) / ( O( n log n ) if other sorting would get used)
//    space complexity : O(n)
    public static String sortVowels(String s) {
        //  approch take all vovels from strings
        // sort them and put then in order where vovels will come
        List<Character> charlist = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char ch= s.charAt(i);
            if(isVovel(ch) ){
                charlist.add(ch);
            }
        }
        if(charlist.size()<=1){
            return s;
        }
        // sort the character list
        sort(charlist);
        int idx=0;
        StringBuilder res= new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch= s.charAt(i);
            if(isVovel(ch) ){
                res.append(charlist.get(idx));
                idx++;
            }else{
                res.append(ch);
            }
        }
        // System.out.println(res);
        return res.toString();
    }

    public static boolean isVovel(char ch){
        return ch=='A' || ch=='E' ||  ch== 'I' || ch=='O' || ch =='U' || ch=='a' || ch=='e' ||  ch== 'i' || ch=='o' || ch =='u';
    }

// time complexity : O(n)
// space complexity : O(n)
    public static void  sort(List<Character> charlist){
        int [] small = new int [26];
        int [] cap = new int [26];
        for(char ch:charlist){
            if(ch>='A' && ch<='Z'){
                cap[ch-'A']++;
            }else{
                small[ch-'a']++;
            }
        }
        int idx=0;
        for(int i=0;i<cap.length;i++){
            for(int j =0;j<cap[i];j++){
                charlist.set(idx,(char)(i+'A'));
                idx++;
            }
        }
        for(int i=0;i<small.length;i++){
            for(int j =0;j<small[i];j++){
                charlist.set(idx,(char)(i+'a'));
                idx++;
            }
        }

    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "lEetcOde";
        String output1="lEOtcede";

        //Example 2:

        String s2 = "lYmpH";
        String output2="lYmpH";

        String ans1= sortVowels(s1);
        String ans2= sortVowels(s2);


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
