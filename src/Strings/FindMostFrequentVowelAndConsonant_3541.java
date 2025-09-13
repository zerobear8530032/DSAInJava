//3541. Find Most Frequent Vowel and Consonant
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s consisting of lowercase English letters ('a' to 'z').
//
//Your task is to:
//
//Find the vowel (one of 'a', 'e', 'i', 'o', or 'u') with the maximum frequency.
//Find the consonant (all other letters excluding vowels) with the maximum frequency.
//Return the sum of the two frequencies.
//
//Note: If multiple vowels or consonants have the same maximum frequency, you may choose any one of them. If there are no vowels or no consonants in the string, consider their frequency as 0.
//
//The frequency of a letter x is the number of times it occurs in the string.
//
//
//Example 1:
//
//Input: s = "successes"
//
//Output: 6
//
//Explanation:
//
//The vowels are: 'u' (frequency 1), 'e' (frequency 2). The maximum frequency is 2.
//The consonants are: 's' (frequency 4), 'c' (frequency 2). The maximum frequency is 4.
//The output is 2 + 4 = 6.
//Example 2:
//
//Input: s = "aeiaeia"
//
//Output: 3
//
//Explanation:
//
//The vowels are: 'a' (frequency 3), 'e' ( frequency 2), 'i' (frequency 2). The maximum frequency is 3.
//There are no consonants in s. Hence, maximum consonant frequency = 0.
//The output is 3 + 0 = 3.
//
//
//Constraints:
//
//1 <= s.length <= 100
//s consists of lowercase English letters only.
package Strings;

public class FindMostFrequentVowelAndConsonant_3541 {
    public static int maxFreqSum(String s) {
        int [] consonants= new int[26];
        int [] vovels= new int[26];
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVovel(ch)){
                vovels[ch-'a']++;
            }else{
                consonants[ch-'a']++;
            }
        }
        int maxVovel = 0;
        int maxConsonant = 0;
        for(int i =0;i<vovels.length;i++){
            maxVovel= Math.max(vovels[i],maxVovel);
            maxConsonant= Math.max(consonants[i],maxConsonant);
        }
        return maxVovel+maxConsonant;
    }
    public static boolean isVovel(char ch){
        return ch=='a' || ch =='e' || ch =='i' || ch =='o' || ch =='u';
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "successes";
        int output1= 6;

        //Example 2:

        String s2 = "aeiaeia";
        int output2= 3;

        int ans1= maxFreqSum(s1);
        int ans2= maxFreqSum(s2);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

    }

}
