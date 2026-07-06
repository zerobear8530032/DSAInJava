//767. Reorganize String
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
//
//Return any possible rearrangement of s or return "" if not possible.
//
//
//
//Example 1:
//
//Input: s = "aab"
//Output: "aba"
//Example 2:
//
//Input: s = "aaab"
//Output: ""
//
//
//Constraints:
//
//1 <= s.length <= 500
//s consists of lowercase English letters.
package heaps;

import java.util.PriorityQueue;

public class ReorganizeString_767 {
//approch :
// we can count frequency of each character put them in max heap sorted by frequency
// then we can simply pop most frequent element from heap if the string is empty append the
// character to the string and reduce frequency and put it back if frequency is not 0
// if the string is not empty check last character is top of heap then pop the second character
//    append it to res and reduce its frequency and push both first top, second top in max heap if frequency is not 0
//    other wise we can just append the top in the res and update frequency
//    if the last character of res the only character inheap then its not possible to create the valid answer
//    time complexity : O(N log n)
//    space complexity : O(n) because of res
    static  class  Pair{
        char character;
        int frequency;

        @Override
        public String toString() {
            return "Pair{" +
                    "character=" + character +
                    ", frequency=" + frequency +
                    '}';
        }

        public Pair(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }
    }
    public static String reorganizeString(String s) {
        int [] map = new int [26];
        for(int i =0;i<s.length();i++){
            map[s.charAt(i)-'a']++;
        }
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((p1, p2)-> p2.frequency-p1.frequency);
        for(int i =0;i<map.length;i++){
            if(map[i]!=0){
                char ch =(char) ('a'+i);
                Pair p= new Pair(ch,map[i]);
                maxHeap.add(p);
            }
        }
        StringBuilder res= new StringBuilder();
        while(!maxHeap.isEmpty()){
            Pair top= maxHeap.poll();
            if(res.length()==0){
                res.append(top.character);
                top.frequency--;
                if(top.frequency>0){
                    maxHeap.add(top);
                }
                continue;
            }
            if(res.charAt(res.length()-1)==top.character){
                if(maxHeap.isEmpty()){
                    return "";
                }
                Pair secondTop = maxHeap.poll();
                res.append(secondTop.character);
                secondTop.frequency--;
                if(secondTop.frequency>0){
                    maxHeap.add(secondTop);
                }
                maxHeap.add(top);
            }else{
                res.append(top.character);
                top.frequency--;
                if(top.frequency>0){
                    maxHeap.add(top);
                }
            }
        }
        return res.toString();

    }

    public static void main(String[] args) {
        //Example 1:
        //
        String s1 = "aab";
        String output1= "aba";

        //Example 2:

        String s2 = "aaab";
        String output2="";

        String ans1 = reorganizeString(s1);
        String ans2 = reorganizeString(s2);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }



    }
}
