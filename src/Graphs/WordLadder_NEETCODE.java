//Word Ladder
//You are given two words, beginWord and endWord, and also a list of words wordList. All of the given words are of the same length, consisting of lowercase English letters, and are all distinct.
//
//Your goal is to transform beginWord into endWord by following the rules:
//
//You may transform beginWord to any word within wordList, provided that at exactly one position the words have a different character, and the rest of the positions have the same characters.
//You may repeat the previous step with the new word that you obtain, and you may do this as many times as needed.
//Return the minimum number of words within the transformation sequence needed to obtain the endWord, or 0 if no such sequence exists.
//
//Example 1:
//
//Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sag","dag","dot"]
//
//Output: 4
//Explanation: The transformation sequence is "cat" -> "bat" -> "bag" -> "sag".
//
//Example 2:
//
//Input: beginWord = "cat", endWord = "sag", wordList = ["bat","bag","sat","dag","dot"]
//
//Output: 0
//Explanation: There is no possible transformation sequence from "cat" to "sag" since the word "sag" is not in the wordList.
//
//Constraints:
//
//1 <= beginWord.length <= 10
//1 <= wordList.length <= 100

package Graphs;

import java.util.*;

public class WordLadder_NEETCODE {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }

        return DFS(beginWord,"",endWord,wordList, new HashSet<>())+1;
    }
    public static int DFS(String beginWord, String prev, String endWord, List<String> wordList, HashSet<String> visited){
        if(beginWord.equals(endWord)){
            return 0;
        }
        int res=Integer.MAX_VALUE;
        for(String s: wordList){
            if(visited.contains(s) || s.equals(beginWord)){continue;}
            if(checkSimilarWords(beginWord,s)){
                visited.add(s);
                int steps= DFS(s,beginWord,endWord,wordList,visited)+1;
                res=Math.min(steps,res);
                visited.remove(s);
            }
        }
        return res;
    }
    public static boolean checkSimilarWords(String word1, String word2){
        int [] charMap= new int [26];
        for(int i =0;i<word1.length();i++){
            charMap[word1.charAt(i)-'a']++;
        }
        boolean oneAllow = true;
        for(int i =0;i<word1.length();i++){
            int idx = word2.charAt(i)-'a';
            if(charMap[idx]>0 ){
                charMap[idx]--;
            }else if(charMap[idx]==0 && oneAllow){
                charMap[idx]--;
                oneAllow=false;
            }else{
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        String beginWord1 = "cat", endWord1 = "sag";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("bat","bag","sag","dag","dot"));
        int output1= 4;

        //Example 2:

        String beginWord2 = "cat", endWord2 = "sag";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("bat","bag","sat","dag","dot"));
        int output2= 0;

        int ans1 = ladderLength(beginWord1,endWord1,wordList1);
        int ans2 = ladderLength(beginWord2,endWord2,wordList2);

        System.out.println(ans1);
        System.out.println(ans2);


    }
}
