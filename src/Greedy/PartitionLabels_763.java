//763. Partition Labels
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string s. We want to partition the string into as many parts as possible so that each letter appears in at most one part. For example, the string "ababcc" can be partitioned into ["abab", "cc"], but partitions such as ["aba", "bcc"] or ["ab", "ab", "cc"] are invalid.
//
//Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
//
//Return a list of integers representing the size of these parts.
//
//
//
//Example 1:
//
//Input: s = "ababcbacadefegdehijhklij"
//Output: [9,7,8]
//Explanation:
//The partition is "ababcbaca", "defegde", "hijhklij".
//This is a partition so that each letter appears in at most one part.
//A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits s into less parts.
//Example 2:
//
//Input: s = "eccbbbbdec"
//Output: [10]
//
//
//Constraints:
//
//1 <= s.length <= 500
//s consists of lowercase English letters.
package Greedy;

import java.lang.reflect.Array;
import java.util.*;

public class PartitionLabels_763 {
//    approch :
//    we can use a frequency mpa of character and maintain a curre freq character map
//     if currenet map all occurenece of character in string we can split it at that time
//    time complexity : O(n )
//     space complexity : O(n )
    public static List<Integer> partitionLabels(String s) {
        List<Integer> res= new ArrayList<>();
        HashMap<Character,Integer> charFreq= new HashMap();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            charFreq.put(ch,charFreq.getOrDefault(ch,0)+1);
        }
        int l= 0;
        HashMap<Character,Integer> currFreq= new HashMap<>();
        for(int r=0;r<s.length();r++){
            char ch = s.charAt(r);
            currFreq.put(ch,currFreq.getOrDefault(ch,0)+1);
            if(isValid(currFreq,charFreq)){
                res.add(r-l+1);
                currFreq.clear();
                l=r+1;
            }
        }

        return res;
    }

    public static boolean isValid(HashMap<Character,Integer> currFreq, HashMap<Character,Integer> charFreq){
        for(Map.Entry<Character,Integer> e:currFreq.entrySet()){
            char key = e.getKey();
            int value= e.getValue();
            if(charFreq.get(key)!=value){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        String s1 = "ababcbacadefegdehijhklij";
        List<Integer> output1= Arrays.asList(9,7,8);
        //Example 2:

        String s2 = "eccbbbbdec";
        List<Integer> output2= Arrays.asList(10);

        List<Integer> ans1=partitionLabels(s1);
        List<Integer> ans2=partitionLabels(s2);

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

    }
}
