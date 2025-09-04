//49. Group Anagrams
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an array of strings strs, group the anagrams together. You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: strs = ["eat","tea","tan","ate","nat","bat"]
//
//Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
//Explanation:
//
//There is no string in strs that can be rearranged to form "bat".
//The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
//The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
//Example 2:
//
//Input: strs = [""]
//
//Output: [[""]]
//
//Example 3:
//
//Input: strs = ["a"]
//
//Output: [["a"]]
//
//
//
//Constraints:
//
//1 <= strs.length <= 104
//0 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.
package HashMap;

import java.util.*;

public class GroupAnagrams_49 {
//    approch :
//    we can sort the string to get equal key
//    then we can map each equal key string to a hashmap
//    to sort we can use count sort
//    time complexity : O(n *K)
//    space complexity : O(n)
    private static int [] charmap = new int [26];
    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String , List<String>> resMap = new HashMap();
        List<List<String>> res= new ArrayList();
        for(String s:strs){
            String sorted= sort(s);
            if(resMap.containsKey(sorted)){
                resMap.get(sorted).add(s);
            }else{
                List<String> list= new ArrayList();
                list.add(s);
                resMap.put(sorted,list);
            }
        }
        for(Map.Entry<String,List<String>> e:resMap.entrySet()){
            res.add(e.getValue());
        }
        return res;
    }

    public static String sort(String  str){
        for(int i=0;i<str.length();i++){
            charmap[str.charAt(i)-'a']++;
        }
        StringBuilder sorted= new StringBuilder();
        for(int i=0;i<charmap.length;i++){
            while(charmap[i]!=0){
                sorted.append((char)('a'+i));
                charmap[i]--;
            }
        }
        return sorted.toString();
    }

    public static void sort(List<List<String>> list){
        for(List<String> s:list){
            Collections.sort(s);
        }
        Collections.sort(list, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> o1, List<String> o2) {
                return o1.size()-o2.size();
            }
        });
    }
    public static void main(String[] args) {
        //Example 1:

        String [] strs1 = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> output1= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("bat"),
                        Arrays.asList("nat","tan"),
                        Arrays.asList("ate","eat","tea")
                )
        );

        //Example 2:

        String  [] strs2 = {""};
        List<List<String>> output2= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("")
                )
        );

        //Example 3:

        String  [] strs3 = {"a"};
        List<List<String>> output3= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList("a")
                )
        );

        List<List<String>> ans1= groupAnagrams(strs1);
        List<List<String>> ans2= groupAnagrams(strs2);
        List<List<String>> ans3= groupAnagrams(strs3);


        sort(ans1);
        sort(ans2);
        sort(ans3);
        sort(output1);
        sort(output2);
        sort(output3);


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
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

        int [] arr= new int[2];
        Arrays.sort(arr,new Comparator<>(){

        });


    }
}
