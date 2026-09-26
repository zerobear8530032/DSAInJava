//1807. Evaluate the Bracket Pairs of a String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s that contains some bracket pairs, with each pair containing a non-empty key.
//
//For example, in the string "(name)is(age)yearsold", there are two bracket pairs that contain the keys "name" and "age".
//You know the values of a wide range of keys. This is represented by a 2D string array knowledge where each knowledge[i] = [keyi, valuei] indicates that key keyi has a value of valuei.
//
//You are tasked to evaluate all of the bracket pairs. When you evaluate a bracket pair that contains some key keyi, you will:
//
//Replace keyi and the bracket pair with the key's corresponding valuei.
//If you do not know the value of the key, you will replace keyi and the bracket pair with a question mark "?" (without the quotation marks).
//Each key will appear at most once in your knowledge. There will not be any nested brackets in s.
//
//Return the resulting string after evaluating all of the bracket pairs.
//
//
//
//Example 1:
//
//Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
//Output: "bobistwoyearsold"
//Explanation:
//The key "name" has a value of "bob", so replace "(name)" with "bob".
//The key "age" has a value of "two", so replace "(age)" with "two".
//Example 2:
//
//Input: s = "hi(name)", knowledge = [["a","b"]]
//Output: "hi?"
//Explanation: As you do not know the value of the key "name", replace "(name)" with "?".
//Example 3:
//
//Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
//Output: "yesyesyesaaa"
//Explanation: The same key can appear multiple times.
//The key "a" has a value of "yes", so replace all occurrences of "(a)" with "yes".
//Notice that the "a"s not in a bracket pair are not evaluated.
//
//
//Constraints:
//
//1 <= s.length <= 105
//0 <= knowledge.length <= 105
//knowledge[i].length == 2
//1 <= keyi.length, valuei.length <= 10
//s consists of lowercase English letters and round brackets '(' and ')'.
//Every open bracket '(' in s will have a corresponding close bracket ')'.
//The key in each bracket pair of s will be non-empty.
//There will not be any nested bracket pairs in s.
//keyi and valuei consist of lowercase English letters.
//Each keyi in knowledge is unique.
package HashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EvaluateTheBracketPairsOfAString_1807 {
//    approch :
//    create a hashmap out of knowledge and parse the string using string builder
//    we can append every singel character at res when we encounter brackets we extract key
//    look up in the map if present put the value other wise ?
//    keep doing it till end
//    time complexity : O(n)
//    space complexity : O(n)
    public static String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String , String> map= new HashMap<>();
        for(List<String> pair:knowledge){
            map.put(pair.get(0),pair.get(1));
        }
        StringBuilder res= new StringBuilder();
        int idx=0;
        while(idx<s.length()){
            char ch = s.charAt(idx);
            if(ch =='('){
                int count =0;
                StringBuilder key = new StringBuilder();
                while(s.charAt(idx)!=')'){
                    if(s.charAt(idx)!= ')' && s.charAt(idx)!='('){
                        key.append(s.charAt(idx));
                    }
                    idx++;
                }
                String k= key.toString();
                if(map.containsKey(k)){
                    // System.out.println(" h: "+map.get(k))
                    res.append(map.get(k));
                }else{
                    res.append("?");
                }
            }else{
                res.append(ch);
            }
            idx++;
        }
        return res.toString();
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "(name)is(age)yearsold";
        List<List<String>> knowledge1 = new ArrayList<>(Arrays.asList(
                Arrays.asList("name","bob"),
                Arrays.asList("age","two")
        ));

        String output1= "bobistwoyearsold";

        //Example 2:

        String s2 = "hi(name)";
        List<List<String>> knowledge2 = new ArrayList<>(Arrays.asList(
                Arrays.asList("a","b")  ));
        String output2="hi?";
        //Example 3:

        String s3 = "(a)(a)(a)aaa";
        List<List<String>> knowledge3 = new ArrayList<>(Arrays.asList(
                Arrays.asList("a","yes")  ));        //Output: "hi?"
        String output3="yesyesyesaaa";

        String ans1= evaluate(s1,knowledge1);
        String ans2= evaluate(s2,knowledge2);
        String ans3= evaluate(s3,knowledge3);


        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }


    }
}
