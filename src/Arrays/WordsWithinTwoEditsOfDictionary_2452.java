//2452. Words Within Two Edits of Dictionary
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two string arrays, queries and dictionary. All words in each array comprise of lowercase English letters and have the same length.
//
//In one edit you can take a word from queries, and change any letter in it to any other letter. Find all words from queries that, after a maximum of two edits, equal some word from dictionary.
//
//Return a list of all words from queries, that match with some word from dictionary after a maximum of two edits. Return the words in the same order they appear in queries.
//
//
//
//Example 1:
//
//Input: queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
//Output: ["word","note","wood"]
//Explanation:
//- Changing the 'r' in "word" to 'o' allows it to equal the dictionary word "wood".
//- Changing the 'n' to 'j' and the 't' to 'k' in "note" changes it to "joke".
//- It would take more than 2 edits for "ants" to equal a dictionary word.
//- "wood" can remain unchanged (0 edits) and match the corresponding dictionary word.
//Thus, we return ["word","note","wood"].
//Example 2:
//
//Input: queries = ["yes"], dictionary = ["not"]
//Output: []
//Explanation:
//Applying any two edits to "yes" cannot make it equal to "not". Thus, we return an empty array.
//
//
//Constraints:
//
//1 <= queries.length, dictionary.length <= 100
//n == queries[i].length == dictionary[j].length
//1 <= n <= 100
//All queries[i] and dictionary[j] are composed of lowercase English letters.
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsWithinTwoEditsOfDictionary_2452 {
//    approch : just simiulate the process
//    time complexity : O(n^3)
//    space complexity : O(1)
    public static List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> res= new ArrayList<>();
        for(String query:queries){
            for(String word:dictionary){
                if(canConvertByTwoEdit(query,word)){
                    res.add(query);
                    break;
                }
            }
        }
        return res;
    }

    public static boolean canConvertByTwoEdit(String original , String target){
        int count=0;
        for(int i =0;i<original.length();i++){
            if(original.charAt(i)!=target.charAt(i)){
                count++;
            }
            if(count>2){
                return false;
            }
        }
        return count<=2;
    }
    public static void main(String[] args) {
        //Example 1:

        String []  queries1 = {"word","note","ants","wood"}, dictionary1 = {"wood","joke","moat"};
        List<String> output1= Arrays.asList("word","note","wood");

        //Example 2:

        String []  queries2 = {"yes"}, dictionary2 = {"not"};
        List<String> output2= Arrays.asList();

        List<String> ans1 = twoEditWords(queries1,dictionary1);
        List<String> ans2 = twoEditWords(queries2,dictionary2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
