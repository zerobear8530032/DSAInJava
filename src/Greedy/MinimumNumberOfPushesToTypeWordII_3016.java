//3016. Minimum Number of Pushes to Type Word II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a string word containing lowercase English letters.
//
//Telephone keypads have keys mapped with distinct collections of lowercase English letters, which can be used to form words by pushing them. For example, the key 2 is mapped with ["a","b","c"], we need to push the key one time to type "a", two times to type "b", and three times to type "c" .
//
//It is allowed to remap the keys numbered 2 to 9 to distinct collections of letters. The keys can be remapped to any amount of letters, but each letter must be mapped to exactly one key. You need to find the minimum number of times the keys will be pushed to type the string word.
//
//Return the minimum number of pushes needed to type word after remapping the keys.
//
//An example mapping of letters to keys on a telephone keypad is given below. Note that 1, *, #, and 0 do not map to any letters.
//
//
//
//
//Example 1:
//
//
//Input: word = "abcde"
//Output: 5
//Explanation: The remapped keypad given in the image provides the minimum cost.
//"a" -> one push on key 2
//"b" -> one push on key 3
//"c" -> one push on key 4
//"d" -> one push on key 5
//"e" -> one push on key 6
//Total cost is 1 + 1 + 1 + 1 + 1 = 5.
//It can be shown that no other mapping can provide a lower cost.
//Example 2:
//
//
//Input: word = "xyzxyzxyzxyz"
//Output: 12
//Explanation: The remapped keypad given in the image provides the minimum cost.
//"x" -> one push on key 2
//"y" -> one push on key 3
//"z" -> one push on key 4
//Total cost is 1 * 4 + 1 * 4 + 1 * 4 = 12
//It can be shown that no other mapping can provide a lower cost.
//Note that the key 9 is not mapped to any letter: it is not necessary to map letters to every key, but to map all the letters.
//Example 3:
//
//
//Input: word = "aabbccddeeffgghhiiiiii"
//Output: 24
//Explanation: The remapped keypad given in the image provides the minimum cost.
//"a" -> one push on key 2
//"b" -> one push on key 3
//"c" -> one push on key 4
//"d" -> one push on key 5
//"e" -> one push on key 6
//"f" -> one push on key 7
//"g" -> one push on key 8
//"h" -> two pushes on key 9
//"i" -> one push on key 9
//Total cost is 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 1 * 2 + 2 * 2 + 6 * 1 = 24.
//It can be shown that no other mapping can provide a lower cost.
//
//
//Constraints:
//
//1 <= word.length <= 105
//word consists of lowercase English letters.
package Greedy;

import java.util.HashMap;
import java.util.PriorityQueue;

class Pair {
    char ch;
    int freq;
    public Pair(char ch , int freq){
        this.ch=ch;
        this.freq=freq;
    }
    public Pair(char ch){
        this.ch=ch;
    }

    public String toString(){
        return "[ char "+ch+" , freq "+freq+"]";
    }
}
public class MinimumNumberOfPushesToTypeWordII_3016 {

    public  static int minimumPushes(String word) {
        Pair [] charMap= new Pair[26];
        PriorityQueue<Pair> queue= new PriorityQueue<>((p1, p2)-> p2.freq-p1.freq);
        for(int i=0;i<word.length();i++){
            int idx = word.charAt(i)-'a';
            if(charMap[idx]==null){
                charMap[idx]= new Pair(word.charAt(i),1);
            }else{
                charMap[idx].freq++;
            }
        }
        for(Pair p:charMap){
            if(p!=null){
                queue.add(p);
            }
        }
        // System.out.println(Arrays.toString(charMap));
        // System.out.println("queue : "+queue);
        HashMap<Character,Integer> pushMap= new HashMap<>();
        while(!queue.isEmpty()){
            Pair p=queue.poll();
            if(pushMap.size()<8){
                pushMap.put(p.ch,1);
            }else if(pushMap.size()<16){
                pushMap.put(p.ch,2);
            }else if(pushMap.size()<24){
                pushMap.put(p.ch,3);
            }else{
                pushMap.put(p.ch,4);
            }
        }

        // System.out.println("map: "+pushMap);
        int res=0;
        for(Pair p : charMap){
            if(p!=null){
                res+= (pushMap.get(p.ch)*p.freq);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        String word1 = "abcde";
        int output1=5;

        //Example 2:

        String word2 = "xyzxyzxyzxyz";
        int output2=12;

        //Example 3:


        String word3= "aabbccddeeffgghhiiiiii";
        int output3=24;

        int ans1= minimumPushes(word1);
        int ans2= minimumPushes(word2);
        int ans3= minimumPushes(word3);


        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
    }
}
