//2476. Closest Nodes Queries in a Binary Search Tree
//Solved
//Medium
//You are given the root of a binary search tree and an array queries of size n consisting of positive integers.
//
//Find a 2D array answer of size n where answer[i] = [mini, maxi]:
//
//mini is the largest value in the tree that is smaller than or equal to queries[i]. If a such value does not exist, add -1 instead.
//maxi is the smallest value in the tree that is greater than or equal to queries[i]. If a such value does not exist, add -1 instead.
//Return the array answer.
//
//
//
//Example 1:
//
//
//Input: root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
//Output: [[2,2],[4,6],[15,-1]]
//Explanation: We answer the queries in the following way:
//        - The largest number that is smaller or equal than 2 in the tree is 2, and the smallest number that is greater or equal than 2 is still 2. So the answer for the first query is [2,2].
//        - The largest number that is smaller or equal than 5 in the tree is 4, and the smallest number that is greater or equal than 5 is 6. So the answer for the second query is [4,6].
//        - The largest number that is smaller or equal than 16 in the tree is 15, and the smallest number that is greater or equal than 16 does not exist. So the answer for the third query is [15,-1].
//Example 2:
//
//
//Input: root = [4,null,9], queries = [3]
//Output: [[-1,4]]
//Explanation: The largest number that is smaller or equal to 3 in the tree does not exist, and the smallest number that is greater or equal to 3 is 4. So the answer for the query is [-1,4].
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [2, 105].
//1 <= Node.val <= 106
//n == queries.length
//1 <= n <= 105
//1 <= queries[i] <= 106
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNodesQueriesInABinarySearchTree_2476 {
//    brute force approch:
//    here we can use a bst traversal where we can have 2 seperate function to getGreaterMin, and getSmallerMax
//    where we traverse the binary search tree and check for the node and update the global variables according to it
//    time complexity : O(q * h) :  q is the query  length and h is height of bst it can be a skweed tree making it O(q*n) n is the total nodes in binary tree
//    space complexity : O(q)

    static int smallMax;
    static int greaterMin;

    public static List<List<Integer>> closestNodesBruteForce(TreeNode root, List<Integer> queries) {
        List<List<Integer>> res = new ArrayList();
        for(int x:queries){
            smallMax= Integer.MIN_VALUE;
            greaterMin= Integer.MAX_VALUE;
            findSmallerMax(root,x);
            findGreaterMin(root,x);
            if(smallMax==Integer.MIN_VALUE){
                smallMax=-1;
            }
            if(greaterMin==Integer.MAX_VALUE){
                greaterMin=-1;
            }
            res.add(new ArrayList(Arrays.asList(smallMax,greaterMin)));
        }
        return res;

    }

    public static void findGreaterMin(TreeNode node, int val){
        if(node==null){
            return ;
        }
        if(node.val==val){// if we found exact value  there is no need to search for other values
            greaterMin= Math.min(greaterMin,node.val);
            return ;
        }
        if(node.val>val){
            greaterMin= Math.min(greaterMin,node.val);
            // here we need more smaller value then current node so we will go left
            findGreaterMin(node.left,val);
        }else{
            // but if the current value is greater then our val
            // we cannot consider it as answer so we go right for bigger values
            findGreaterMin(node.right,val);
        }

    }

    public static void findSmallerMax(TreeNode node, int val){
        if(node==null){
            return ;
        }
        if(node.val==val){// if we found exact value  there is no need to search for other values
            smallMax= Math.max(smallMax,node.val);
            return ;
        }
        if(node.val<val){
            // this node is smaller the our values means we can check right for greater onces
            smallMax= Math.max(smallMax,node.val);
            findSmallerMax(node.right,val);
        }else{
            // the node is greater then current val means we need to find smaller values
            findSmallerMax(node.left,val);
        }
    }




    // Better approch :
//   here we can first use iorder traversal over tree to get sorted array , list
// now we can just use binary search to find ciel and floor to get our anwers
//    in log n time every sing le time
//    time complexity : O(n log n);
//    space complexity : O( q); node of tree and output list
    public static List<List<Integer>> closestNodesBetter(TreeNode root, List<Integer> queries) {
        List<Integer> sortedTree = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        inOrder(root, sortedTree);
        for (int x : queries) {
            res.add(binarySearchCeilFloor(sortedTree, x));
        }

        return res;
    }


    public static void inOrder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }

    public static List<Integer> binarySearchCeilFloor(List<Integer> list, int val) {
        int s = 0;
        int e = list.size() - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int v = list.get(m);
            if (v == val) {
                return new ArrayList(Arrays.asList(v, v));
            } else if (v < val) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }


        int floor = (e >= 0) ? list.get(e) : -1;
        int ceil = (s < list.size()) ? list.get(s) : -1;
        return Arrays.asList(floor, ceil);
    }
    public static void main(String[] args) {

    //Example 1:

    BinaryTree root1 = new BinaryTree(6,2,13,1,4,9,15,null,null,null,null,null,null,14);
    List<Integer> queries1 = new ArrayList<>(Arrays.asList(2,5,16));
    List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(2,2),Arrays.asList(4,6),Arrays.asList(15,-1)));

    //Example 2:

    BinaryTree root2 = new BinaryTree(4,null,9);
    List<Integer> queries2 = new ArrayList<>(Arrays.asList(3));
    List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(-1,4)));

    System.out.println("Brute Force Approch :");

    List<List<Integer>> ans1 =closestNodesBruteForce(root1.getRoot(),queries1);
    List<List<Integer>> ans2 =closestNodesBruteForce(root2.getRoot(),queries2);
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


      ans1 =closestNodesBetter(root1.getRoot(),queries1);
      ans2 =closestNodesBetter(root2.getRoot(),queries2);
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
