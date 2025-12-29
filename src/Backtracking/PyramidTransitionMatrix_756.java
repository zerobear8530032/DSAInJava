//756. Pyramid Transition Matrix
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are stacking blocks to form a pyramid. Each block has a color, which is represented by a single letter. Each row of blocks contains one less block than the row beneath it and is centered on top.
//
//To make the pyramid aesthetically pleasing, there are only specific triangular patterns that are allowed. A triangular pattern consists of a single block stacked on top of two blocks. The patterns are given as a list of three-letter strings allowed, where the first two characters of a pattern represent the left and right bottom blocks respectively, and the third character is the top block.
//
//For example, "ABC" represents a triangular pattern with a 'C' block stacked on top of an 'A' (left) and 'B' (right) block. Note that this is different from "BAC" where 'B' is on the left bottom and 'A' is on the right bottom.
//You start with a bottom row of blocks bottom, given as a single string, that you must use as the base of the pyramid.
//
//Given bottom and allowed, return true if you can build the pyramid all the way to the top such that every triangular pattern in the pyramid is in allowed, or false otherwise.
//
//
//
//Example 1:
//
//
//Input: bottom = "BCD", allowed = ["BCC","CDE","CEA","FFF"]
//Output: true
//Explanation: The allowed triangular patterns are shown on the right.
//Starting from the bottom (level 3), we can build "CE" on level 2 and then build "A" on level 1.
//There are three triangular patterns in the pyramid, which are "BCC", "CDE", and "CEA". All are allowed.
//Example 2:
//
//
//Input: bottom = "AAAA", allowed = ["AAB","AAC","BCD","BBE","DEF"]
//Output: false
//Explanation: The allowed triangular patterns are shown on the right.
//Starting from the bottom (level 4), there are multiple ways to build level 3, but trying all the possibilites, you will get always stuck before building level 1.
//
//
//Constraints:
//
//2 <= bottom.length <= 6
//0 <= allowed.length <= 216
//allowed[i].length == 3
//The letters in all input strings are from the set {'A', 'B', 'C', 'D', 'E', 'F'}.
//All the values of allowed are unique.
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PyramidTransitionMatrix_756 {
//    approch :
//    we use recusive back tracking with memo to create the pyramid layer by layer
//    first we keep a prefix to string map of allowed string for O(1) look UP
//    second we will try to get all possible next layers bygetting all possible character on that layer
//    then we build all layers with possible characters and try every single layer
//    time complexity : O( 2^n)
//    space complexity : O( n)
    public static boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<String,List<String>> prefixMap= new HashMap();
        HashMap<String,Boolean> memo = new HashMap();
        for(String s:allowed){
            String prefix = s.substring(0,2);
            if(prefixMap.containsKey(prefix)){
                prefixMap.get(prefix).add(s);
            }else{
                List<String> strs= new ArrayList();
                strs.add(s);
                prefixMap.put(prefix,strs);
            }
        }
        return canConstruct(bottom.length(),bottom,allowed,prefixMap, memo);
    }
    public static boolean canConstruct(int level, String bottom, List<String> allowed,HashMap<String,List<String>> prefixMap,HashMap<String,Boolean> memo){
        if(level==0){return true;}
        if(memo.containsKey(bottom)){
            return memo.get(bottom);
        }
        int n = bottom.length();
        List<String> steps= new ArrayList();
        for(int i =0;i<bottom.length()-1;i++){
            String prefix=  bottom.charAt(i)+""+bottom.charAt(i+1);
            if(!prefixMap.containsKey(prefix)){
                memo.put(bottom,false);
                return false;
            }
            List<String> nextBlocks=prefixMap.getOrDefault(prefix,new ArrayList());
            StringBuilder step= new StringBuilder();
            for(String str:nextBlocks){
                step.append(str.charAt(2));
            }
            steps.add(step.toString());
        }
        List<String> nextLayers= new ArrayList();
        buildLayers("",steps,nextLayers);
        for(String next:nextLayers){
            if(canConstruct(level-1,next,allowed,prefixMap,memo)){
                memo.put(bottom,true);
                return true;
            }
        }
        memo.put(bottom,false);
        return false;
    }
    public static void buildLayers(String curr_res,List<String> str, List<String> output){
        if(curr_res.length()>=str.size()){
            output.add(curr_res);
            return ;
        }
        for(int i =0;i<str.get(curr_res.length()).length();i++){
            char ch = str.get(curr_res.length()).charAt(i);
            buildLayers(curr_res+ch,str,output);
        }
    }
    public static void main(String[] args) {
        //Example 1:

        String bottom1 = "BCD";
        List<String> allowed1 = new ArrayList<>(Arrays.asList("BCC","CDE","CEA","FFF"));

        boolean output1= true;

        //Example 2:

        String bottom2 = "AAAA";
        List<String> allowed2 = new ArrayList<>(Arrays.asList("AAB","AAC","BCD","BBE","DEF"));
        boolean output2= false;

        boolean ans1= pyramidTransition(bottom1,allowed1);
        boolean ans2= pyramidTransition(bottom2,allowed2);

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
    }
}
