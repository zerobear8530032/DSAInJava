//30. Substring with Concatenation of All Words
//Hard
//Topics
//premium lock icon
//Companies
//You are given a string s and an array of strings words. All the strings of words are of the same length.
//
//A concatenated string is a string that exactly contains all the strings of any permutation of words concatenated.
//
//For example, if words = ["ab","cd","ef"], then "abcdef", "abefcd", "cdabef", "cdefab", "efabcd", and "efcdab" are all concatenated strings. "acdbef" is not a concatenated string because it is not the concatenation of any permutation of words.
//Return an array of the starting indices of all the concatenated substrings in s. You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: s = "barfoothefoobarman", words = ["foo","bar"]
//
//Output: [0,9]
//
//Explanation:
//
//The substring starting at 0 is "barfoo". It is the concatenation of ["bar","foo"] which is a permutation of words.
//The substring starting at 9 is "foobar". It is the concatenation of ["foo","bar"] which is a permutation of words.
//
//Example 2:
//
//Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//
//Output: []
//
//Explanation:
//
//There is no concatenated substring.
//
//Example 3:
//
//Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//
//Output: [6,9,12]
//
//Explanation:
//
//The substring starting at 6 is "foobarthe". It is the concatenation of ["foo","bar","the"].
//The substring starting at 9 is "barthefoo". It is the concatenation of ["bar","the","foo"].
//The substring starting at 12 is "thefoobar". It is the concatenation of ["the","foo","bar"].
//
//
//
//Constraints:
//
//1 <= s.length <= 104
//1 <= words.length <= 5000
//1 <= words[i].length <= 30
//s and words[i] consist of lowercase English letters.

package slidingwindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubstringWithConcatenationOfAllWords_30 {
        public static List<Integer> findSubstringBruteForce(String s, String[] words) {
            List<Integer> output= new ArrayList();
            int wlen = words[0].length();
            int idx=0;
            HashMap<String,Integer> map = new HashMap<>();
            while(idx<s.length()){
                int skip=idx+(wlen*words.length);
                if(skip>s.length()){break;}
                String substr= s.substring(idx,skip);
//                System.out.println(substr);
                if(checkStringPresent(words,substr,wlen,map)){
                    output.add(idx);
                    idx+=wlen;
                }else{
                    idx++;
                }

            }

            return output;
        }

        public static boolean checkStringPresent(String [] words, String str, int wlen, HashMap<String, Integer> map){
            for(String s:words){
                map.put(s,map.getOrDefault(s,0)+1);
            }
            for(int i =0;i<str.length();i+=wlen){
                String substr= str.substring(i,i+wlen);
                if(map.containsKey(substr)){
                    map.put(substr,map.get(substr)-1);
                    if(map.get(substr)<0){
                        return false;
                    }
                }else{
                    return false;
                }
            }

            return true;
        }

// approch :
// apply sliding window on each substring of size word length
// use hashmap to keep track of every thing
// if the size of window becomes equal to what our concatination will get
// add the left pointers
// time complexity : O(words[i].length * O(n))// we consider the hashmap look up is O(1)
// space complexity : O(words[i].length * O(n))// cause each time new hashmap will be used for each offset
    public static List<Integer> findSubstringBetter(String s, String[] words) {
        //  points to be noted: every single word in wordsis of sam elength
        // means our concatination string can be only words[i].length*words.length
        // so we can search this  only this much using sliding window
        //  approch : maintain a hashmap of words and frequency
        //  now we can take every single substring of length words[i].length
        // from the S then we can use a sliding window in with a new haashmap and
        // try to equalize the frequency maps
        HashMap<String, Integer> need= new HashMap<>();
        List<Integer> res= new ArrayList<>();
        for(String word:words){// here we created the frequency of words as hashmap
            need.put(word,need.getOrDefault(word,0)+1);
        }
        int len = words[0].length();
        int concatinationSize= len*words.length;
        for(int i =0;i<len;i++){
            HashMap<String,Integer> available = new HashMap<>();
            int start=i;
            for(int end=i;end<s.length() && end+len<=s.length();end+=len){
                String word= s.substring(end,end+len);
                available.put(word,available.getOrDefault(word,0)+1);
                while((need.containsKey(word) && available.containsKey(word) && available.get(word)> need.get(word)) || (!need.containsKey(word) && available.containsKey(word))){
                    String remove = s.substring(start,start+len);
                    available.put(remove,available.getOrDefault(remove,0)-1);
                    if(available.get(remove)<=0) {
                        available.remove(remove);
                    }
                    start=start+len;
                }
                int windowSize = (end+len)-start;
                if(concatinationSize==windowSize){
                    res.add(start);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //Example 1:

        String s1 = "barfoothefoobarman";
        String [] words1 = {"foo","bar"};
        List<Integer> output1= new ArrayList(Arrays.asList(0,9));

        //Example 2:

        String s2 = "wordgoodgoodgoodbestword";
        String [] words2 = {"word","good","best","word"};
        List<Integer> output2= new ArrayList();

        //Example 3:

        String s3 = "barfoofoobarthefoobarman";
        String [] words3 = {"bar","foo","the"};
        List<Integer> output3= new ArrayList(Arrays.asList(6,9,12));

        //Example 4:

        String s4 = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String [] words4 = {"fooo","barr","wing","ding","wing"};
        List<Integer> output4= new ArrayList(Arrays.asList(13));

        System.out.println(findSubstringBetter(s1,words1));
        System.out.println(findSubstringBetter(s2,words2));
        System.out.println(findSubstringBetter(s3,words3));
        System.out.println(findSubstringBetter(s4,words4));
    }
}
