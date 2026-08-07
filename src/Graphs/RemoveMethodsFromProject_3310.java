//3310. Remove Methods From Project
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are maintaining a project that has n methods numbered from 0 to n - 1.
//
//You are given two integers n and k, and a 2D integer array invocations, where invocations[i] = [ai, bi] indicates that method ai invokes method bi.
//
//There is a known bug in method k. Method k, along with any method invoked by it, either directly or indirectly, are considered suspicious and we aim to remove them.
//
//A group of methods can only be removed if no method outside the group invokes any methods within it.
//
//Return an array containing all the remaining methods after removing all the suspicious methods. You may return the answer in any order. If it is not possible to remove all the suspicious methods, none should be removed.
//
//
//
//Example 1:
//
//Input: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
//
//Output: [0,1,2,3]
//
//Explanation:
//
//
//
//Method 2 and method 1 are suspicious, but they are directly invoked by methods 3 and 0, which are not suspicious. We return all elements without removing anything.
//
//Example 2:
//
//Input: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
//
//Output: [3,4]
//
//Explanation:
//
//
//
//Methods 0, 1, and 2 are suspicious and they are not directly invoked by any other method. We can remove them.
//
//Example 3:
//
//Input: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
//
//Output: []
//
//Explanation:
//
//
//
//All methods are suspicious. We can remove them.
//
//
//
//Constraints:
//
//1 <= n <= 105
//0 <= k <= n - 1
//0 <= invocations.length <= 2 * 105
//invocations[i] == [ai, bi]
//0 <= ai, bi <= n - 1
//ai != bi
//invocations[i] != invocations[j]
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class RemoveMethodsFromProject_3310 {
//    approch :
//    we can do a dfs starting from k and mark all the incomming nodes suspicious
//    then we can do dfs from 0 to n and check are their nodes coming in path which are suspicious
//    if yes we can directly return  res 0 to n because its state
//    if we cannot remove any suspicous function we have to return anwer as it is
//    other wise we just return the nodes which are not suspicous
//    time complexity : O(E+V)// here n is invocations.length
//    space complexity : O(E+V)
public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    List<Integer> res= new ArrayList<>();
    HashMap<Integer,List<Integer>> nodeMap = new HashMap<>();
    boolean [] suspicious = new boolean [n];
    for(int i=0;i<n;i++){
        nodeMap.put(i,new ArrayList<>());
    }
    for(int [] inv:invocations){
        nodeMap.get(inv[0]).add(inv[1]);
    }
    boolean [] visited= new boolean [n];
    detectSuspiciousFunctions(k,nodeMap,visited,suspicious);
    // System.out.println("before ");
    // System.out.println(Arrays.toString(visited));
    // System.out.println(Arrays.toString(suspicious));
    int scount=0;
    for(int i =0;i<n;i++){
        if(suspicious[i]){
            scount++;
        }
    }
    visited= new boolean [n];
    for(int i =0;i<n;i++){
        if(!suspicious[i] && !visited[i]){
            // System.out.println("initiate dfs"+i);
            if(!canRemoveMethods(i,nodeMap,visited,suspicious)){
                for(int j =0;j<n;j++){
                    res.add(j);
                }
                return res;
            }
        }
    }

    for(int i=0;i<n;i++){
        if(!suspicious[i]){
            res.add(i);
        }
    }

    return res;
}

    public static boolean canRemoveMethods(int root,HashMap<Integer,List<Integer>> nodeMap,boolean [] visited,boolean []suspicious){
        if(visited[root]){return true;}
        visited[root]=true;
        if(suspicious[root]){
            return false;
        }
        for(int x: nodeMap.get(root)){
            if(!canRemoveMethods(x,nodeMap,visited,suspicious)){
                return false;
            }
        }
        return true;

    }

    public static void detectSuspiciousFunctions(int root , HashMap<Integer,List<Integer>> nodeMap, boolean [] visited, boolean [] suspicious){
        if(visited[root]){return;}
        visited[root]=true;
        suspicious[root]=true;
        for(int neighbour : nodeMap.get(root)){
            detectSuspiciousFunctions(neighbour,nodeMap,visited,suspicious);
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int  n1 = 4, k1 = 1;
        int [][]invocations1 = {{1,2},{0,1},{3,2}};
        List<Integer> output1= Arrays.asList(0,1,2,3);

        //Example 2:

        int  n2 = 5, k2 = 0;
        int [][] invocations2 = {{1,2},{0,2},{0,1},{3,4}};
        List<Integer> output2= Arrays.asList(3,4);

        //Example 3:

        int n3 = 3, k3 = 2;
        int [][] invocations3 = {{1,2},{0,1},{2,0}};
        List<Integer> output3= Arrays.asList();


        List<Integer> ans1= remainingMethods(n1,k1,invocations1);
        List<Integer> ans2= remainingMethods(n2,k2,invocations2);
        List<Integer> ans3= remainingMethods(n3,k3,invocations3);



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
    }
}
