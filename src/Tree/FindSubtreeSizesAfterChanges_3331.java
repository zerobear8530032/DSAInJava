//3331. Find Subtree Sizes After Changes
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a tree rooted at node 0 that consists of n nodes numbered from 0 to n - 1. The tree is represented by an array parent of size n, where parent[i] is the parent of node i. Since node 0 is the root, parent[0] == -1.
//
//You are also given a string s of length n, where s[i] is the character assigned to node i.
//
//We make the following changes on the tree one time simultaneously for all nodes x from 1 to n - 1:
//
//Find the closest node y to node x such that y is an ancestor of x, and s[x] == s[y].
//If node y does not exist, do nothing.
//Otherwise, remove the edge between x and its current parent and make node y the new parent of x by adding an edge between them.
//Return an array answer of size n where answer[i] is the size of the subtree rooted at node i in the final tree.
//
//
//
//Example 1:
//
//Input: parent = [-1,0,0,1,1,1], s = "abaabc"
//
//Output: [6,3,1,1,1,1]
//
//Explanation:
//
//
//The parent of node 3 will change from node 1 to node 0.
//
//Example 2:
//
//Input: parent = [-1,0,4,0,1], s = "abbba"
//
//Output: [5,2,1,1,1]
//
//Explanation:
//
//
//The following changes will happen at the same time:
//
//The parent of node 4 will change from node 1 to node 0.
//The parent of node 2 will change from node 4 to node 1.
//
//
//Constraints:
//
//n == parent.length == s.length
//1 <= n <= 105
//0 <= parent[i] <= n - 1 for all i >= 1.
//parent[0] == -1
//parent represents a valid tree.
//s consists only of lowercase English letters.
package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindSubtreeSizesAfterChanges_3331 {
    public static int[] findSubtreeSizes(int[] parent, String s) {
        int [] output= new int [parent.length];
        HashMap<Integer,List<Integer>> tree= new HashMap<>();
        tree.put(-1,new ArrayList<>());
        for(int i =0;i<parent.length;i++){
            tree.put(i,new ArrayList<>());
        }
        for(int i =0;i<parent.length;i++){
            tree.get(parent[i]).add(i);
        }
        HashMap<Character,Integer> seenMap= new HashMap<>();
        operate(-1,tree,s,seenMap,parent);
        tree.clear();
        tree.put(-1,new ArrayList());
        for(int i =0;i<parent.length;i++){
            tree.put(i,new ArrayList<>());
        }
        for(int i =0;i<parent.length;i++){
            tree.get(parent[i]).add(i);
        }
        // System.out.println(tree);
        calculateHeight(-1,output,tree);
        return output;
    }

    public static int calculateHeight(int parent , int [] height, HashMap<Integer,List<Integer>> tree){
        if(tree.get(parent).isEmpty()){
            height[parent]=0;
            return 0;
        }
        int res=0;
        for(int child : tree.get(parent)){
            int h= 1+calculateHeight(child,height,tree);
            height[child] = h;
            res+=h;
        }
        return res;
    }

    public static void operate(int parent , HashMap<Integer, List<Integer>> tree, String s , HashMap<Character,Integer> seenMap, int [] parents){
        for(int child:tree.get(parent)){
            char ch = s.charAt(child);
            if(seenMap.containsKey(ch)){
                parents[child]=seenMap.get(ch);
                seenMap.put(ch,child);
                operate(child,tree,s,seenMap,parents);
                seenMap.put(ch,parents[child]);// back tracking;
            }else{
                seenMap.put(ch,child);
                operate(child,tree,s,seenMap,parents);
                seenMap.remove(ch);
            }
        }
    }
    public static void main(String[] args) {
        //Example 1:
       int [] parent1 = {-1,0,0,1,1,1};
       String s1 = "abaabc";
       int [] output1= {6,3,1,1,1,1};
       //Example 2:

        //Input: parent = [-1,0,4,0,1], s = "abbba"
       int [] parent2 = {-1,0,4,0,1};
       String s2 = "abbba";
       int [] output2= {5,2,1,1,1};

       int [] ans1= findSubtreeSizes(parent1,s1);
       int [] ans2= findSubtreeSizes(parent2,s2);

        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output1));
            System.out.println("Your Output : "+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2,output2)) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ Arrays.toString(output2));
            System.out.println("Your Output : "+ Arrays.toString(ans2));
        }

    }
}
