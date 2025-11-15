//127. Word Ladder
//Hard
//Topics
//premium lock icon
//Companies
//A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
//
//Every adjacent pair of words differs by a single letter.
//Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
//sk == endWord
//Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
//
//
//
//Example 1:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
//Output: 5
//Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
//Example 2:
//
//Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
//Output: 0
//Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
//
//
//Constraints:
//
//1 <= beginWord.length <= 10
//endWord.length == beginWord.length
//1 <= wordList.length <= 5000
//wordList[i].length == beginWord.length
//beginWord, endWord, and wordList[i] consist of lowercase English letters.
//beginWord != endWord
//All the words in wordList are unique.
package Graphs;

import java.util.*;

public class WordLadder_127 {
//    approch :
//    we can create a graph as a hashmap where every single string as key
//    and its next string as a neghbour
//    then we can simply use BFS getting the answer
//    time complexity : O(n*n*L)
//    space complexity : O(n*n)
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord) || !wordList.contains(endWord)){
            return 0;
        }
        // create a graphs first :
        HashMap<String,List<String>> graph= new HashMap();
        graph.put(beginWord,new ArrayList());
        for(String s:wordList){
            graph.put(s,new ArrayList());
        }
        for(String key: graph.keySet()){
            for(String similar:wordList){
                if(checkSimilarWords(key,similar)){
                    graph.get(key).add(similar);
                }
            }
        }
        return BFS(beginWord,graph,wordList,endWord);
    }

    public static int BFS(String begin , HashMap<String,List<String>> graph, List<String> words, String endWord){
        int operations=0;
        Queue<String> queue= new LinkedList<>();
        queue.add(begin);
        HashSet<String> visited= new HashSet();
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i =0;i<size;i++){
                String poped=queue.remove();
                if(endWord.equals(poped)){return operations+1;}
                for(String s:graph.get(poped)){
                    if(visited.contains(s)){continue;}
                    else{visited.add(s);}
                    queue.add(s);
                }
            }
            operations++;
        }
        return 0;
    }
    public static boolean checkSimilarWords(String word1, String word2){
        boolean allowOne= true;
        for(int i=0;i<word1.length();i++){
            char ch1= word1.charAt(i);
            char ch2= word2.charAt(i);
            if(ch1==ch2){
                continue;
            }else if(allowOne){
                allowOne=false;
            }else{
                return false;
            }
        }
        return true && !allowOne;
    }

    public static void main(String[] args) {
        //Example 1:

        String beginWord1 = "hit", endWord1 = "cog";
        List<String> wordList1 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        int output1= 5;

        //Example 2:


        String beginWord2 = "hit", endWord2 = "cog";
        List<String> wordList2 = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log"));
        int output2= 0;

        int ans1= ladderLength(beginWord1,endWord1,wordList1);
        int ans2= ladderLength(beginWord2,endWord2,wordList2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }

    }
}
