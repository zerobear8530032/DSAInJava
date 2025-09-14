//966. Vowel Spellchecker
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a wordlist, we want to implement a spellchecker that converts a query word into a correct word.
//
//For a given query word, the spell checker handles two categories of spelling mistakes:
//
//Capitalization: If the query matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the case in the wordlist.
//Example: wordlist = ["yellow"], query = "YellOw": correct = "yellow"
//Example: wordlist = ["Yellow"], query = "yellow": correct = "Yellow"
//Example: wordlist = ["yellow"], query = "yellow": correct = "yellow"
//Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o', 'u') of the query word with any vowel individually, it matches a word in the wordlist (case-insensitive), then the query word is returned with the same case as the match in the wordlist.
//Example: wordlist = ["YellOw"], query = "yollow": correct = "YellOw"
//Example: wordlist = ["YellOw"], query = "yeellow": correct = "" (no match)
//Example: wordlist = ["YellOw"], query = "yllw": correct = "" (no match)
//In addition, the spell checker operates under the following precedence rules:
//
//When the query exactly matches a word in the wordlist (case-sensitive), you should return the same word back.
//When the query matches a word up to capitlization, you should return the first such match in the wordlist.
//When the query matches a word up to vowel errors, you should return the first such match in the wordlist.
//If the query has no matches in the wordlist, you should return the empty string.
//Given some queries, return a list of words answer, where answer[i] is the correct word for query = queries[i].
//
//
//
//Example 1:
//
//Input: wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
//Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"]
//Example 2:
//
//Input: wordlist = ["yellow"], queries = ["YellOw"]
//Output: ["yellow"]
//
//
//Constraints:
//
//1 <= wordlist.length, queries.length <= 5000
//1 <= wordlist[i].length, queries[i].length <= 7
//wordlist[i] and queries[i] consist only of only English letters.
package HashMap;

import java.util.Arrays;
import java.util.HashMap;

public class VowelSpellchecker_966 {

    public static String[] spellchecker(String[] wordlist, String[] queries) {
        HashMap<String,String> equalMap = new HashMap();
        HashMap<String,String> capitalErrorMap = new HashMap();
        HashMap<String,String> vovelErrorMap = new HashMap();
        String [] res= new String[queries.length];
        for(String word:wordlist){
            equalMap.put(word,word);
            String lowerWord= word.toLowerCase();
            capitalErrorMap.putIfAbsent(lowerWord,word);
            vovelErrorMap.putIfAbsent(markVovels(lowerWord),word);
        }
        // System.out.println(equalMap);
        // System.out.println(capitalErrorMap);
        // System.out.println(vovelErrorMap);
        for(int i=0;i<queries.length;i++){
            String query= queries[i];
            String lowerQuery= query.toLowerCase();
            String markedVovels= markVovels(lowerQuery);

            if(equalMap.containsKey(query)){
                res[i]=query;
            }else if(capitalErrorMap.containsKey(lowerQuery)){
                res[i]= capitalErrorMap.get(lowerQuery);
            }else if(vovelErrorMap.containsKey(markedVovels)){
                res[i]= vovelErrorMap.get(markedVovels);
            }else{
                res[i]="";
            }
        }
        return res;
    }
    //  this will only take lowercase letters
    public static String markVovels(String s){
        StringBuilder processed= new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(isVovel(ch)){
                processed.append('*');
            }else{
                processed.append(ch);
            }
        }
        return processed.toString();
    }

    public static boolean isVovel(char ch){
        return ch=='a' || ch =='e' || ch =='i'||  ch=='o' ||  ch=='u' ||  ch=='A'||  ch=='E'||  ch=='I' ||  ch=='O' ||  ch=='U';
    }
    public static void main(String[] args) {

        //Example 1:

        String [] wordlist1 = {"KiTe","kite","hare","Hare"}, queries1 = {"kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"};
        String [] output1 = {"kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"};

        //Example 2:

        String [] wordlist2 = {"yellow"}, queries2 = {"YellOw"};
        String [] output2 = {"yellow"};


        String [] ans1= spellchecker(wordlist1,queries1);
        String [] ans2= spellchecker(wordlist2,queries2);

        if(Arrays.equals(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
    }
}
