//1048. Longest String Chain
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of words where each word consists of lowercase English letters.
//
//wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.
//
//For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
//A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.
//
//Return the length of the longest possible word chain with words chosen from the given list of words.
//
//
//
//Example 1:
//
//Input: words = ["a","b","ba","bca","bda","bdca"]
//Output: 4
//Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
//Example 2:
//
//Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
//Output: 5
//Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
//Example 3:
//
//Input: words = ["abcd","dbqca"]
//Output: 1
//Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
//["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.
//
//
//Constraints:
//
//1 <= words.length <= 1000
//1 <= words[i].length <= 16
//words[i] only consists of lowercase English letters.
package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class LongestStringChain_1048 {
//   time complexity: O(n*n)
//   space complexity: O(n)
public static int longestStrChain(String[] words) {
    int []table= new int[words.length+1];
    Arrays.sort(words, new Comparator<String>(){
        public int compare(String s1, String s2){
            return s1.length()-s2.length();
        }
    });
    int res=1;
    for(int i=0;i<table.length;i++){
        table[i]=1;
    }
    for(int i=0;i<words.length;i++){
        for(int j=0;j<i;j++){
            if(isPredecessor(words[j],words[i])){
                table[i]= Math.max(table[i],table[j]+1);
                res=Math.max(table[i],res);
            }
        }
    }
    return res;
}
public static boolean isPredecessor(String parent , String child){
    if(child.length()-parent.length()!=1){
        return false;
    }
    int idx1=0;
    int idx2=0;
    boolean extraAllow=true;
    while(idx1<parent.length() || idx2<child.length()){
        char ch1= ' ';
        char ch2= ' ';
        if(idx1<parent.length()){ch1=parent.charAt(idx1);}
        if(idx2<child.length()){ch2=child.charAt(idx2);}
        if(ch1==ch2){
            idx1++;
            idx2++;
        }else if(extraAllow){
            extraAllow=false;
            idx2++;
        }else{
            return false;
        }
    }
    return child.length()==idx2 && parent.length()==idx1;
}
    public static void main(String[] args) {
        //Example 1:

        String [] words1 = {"a","b","ba","bca","bda","bdca"};
        int output1= 4;

        //Example 2:

        String [] words2 = {"xbc","pcxbcf","xb","cxbc","pcxbc"};
        int output2= 5;

        //Example 3:

        String [] words3 = {"abcd","dbqca"};
        int output3= 1;

        int ans1= longestStrChain(words1);
        int ans2= longestStrChain(words2);
        int ans3= longestStrChain(words3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
