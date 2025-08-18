//2096. Step-By-Step Directions From a Binary Tree Node to Another
//        Medium
//        Topics
//        premium lock icon
//        Companies
//        Hint
//        You are given the root of a binary tree with n nodes. Each node is uniquely assigned a value from 1 to n. You are also given an integer startValue representing the value of the start node s, and a different integer destValue representing the value of the destination node t.
//
//        Find the shortest path starting from node s and ending at node t. Generate step-by-step directions of such path as a string consisting of only the uppercase letters 'L', 'R', and 'U'. Each letter indicates a specific direction:
//
//        'L' means to go from a node to its left child node.
//        'R' means to go from a node to its right child node.
//        'U' means to go from a node to its parent node.
//        Return the step-by-step directions of the shortest path from node s to node t.
//
//
//
//        Example 1:
//
//
//        Input: root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
//        Output: "UURL"
//        Explanation: The shortest path is: 3 → 1 → 5 → 2 → 6.
//        Example 2:
//
//
//        Input: root = [2,1], startValue = 2, destValue = 1
//        Output: "L"
//        Explanation: The shortest path is: 2 → 1.
//
//
//        Constraints:
//
//        The number of nodes in the tree is n.
//        2 <= n <= 105
//        1 <= Node.val <= n
//        All the values in the tree are unique.
//        1 <= startValue, destValue <= n
//        startValue != destValue

package Tree;
import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.*;
public class StepByStepDirectionsFromABinaryTreeNodeToAnother_2096 {

//    try every single path using parent node;
//    time compelxity :O(n)
//    space compelxity :O(n): here the string will create so many copies it will get mle
    public static String getDirectionsBruteForce(TreeNode root, int startValue, int destValue) {
        HashMap<Integer,TreeNode > parentNodeMap = new HashMap();
        mapNodeToParent(root,null,parentNodeMap);
        HashSet<Integer> visited = new HashSet();
        TreeNode startParent =parentNodeMap.get(startValue);
        TreeNode start= null;
        if(startParent==null){
            start=root;
        }else if(startParent.left!=null && startParent.left.val==startValue){
            start=startParent.left;
        }
        else if(startParent.right!=null && startParent.right.val==startValue){
            start=startParent.right;
        }else{
            System.out.println("Some Thing is Wrong ");
            return "";
        }
        return getPath(start,parentNodeMap,visited,destValue,"");

    }

    public static String getPath(TreeNode root, HashMap<Integer,TreeNode> parentNodeMap,
                          HashSet<Integer> visited, int destValue, String path) {
        if (root == null) return "";
        if (visited.contains(root.val)) return "";

        visited.add(root.val);

        if (root.val == destValue) {
            return path;
        }

        // Try going up
        String up = getPath(parentNodeMap.get(root.val), parentNodeMap, visited, destValue, path + 'U');
        if (!up.equals("")) return up;

        // Try going left
        String left = getPath(root.left, parentNodeMap, visited, destValue, path + 'L');
        if (!left.equals("")) return left;

        // Try going right
        String right = getPath(root.right, parentNodeMap, visited, destValue, path + 'R');
        if (!right.equals("")) return right;

        return "";
    }



    public static void mapNodeToParent(TreeNode root,TreeNode parent, HashMap<Integer,TreeNode> nodemap){
        if(root==null){
            return ;
        }
        nodemap.put(root.val,parent);
        mapNodeToParent(root.left,root,nodemap);
        mapNodeToParent(root.right,root,nodemap);
    }


// approch : here we use  a stirng builder which will keep track of path and each time we get a validpath we will return true ;
//    time complexity :O(n)
//    space complexity :O(n)
    public static  String getDirectionsBetter(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();

        // get paths from root to start and dest
        findPathBetter(root, startValue, startPath);
        findPathBetter(root, destValue, destPath);

        // remove common prefix
        int i = 0, j = 0;
        while (i < startPath.length() && j < destPath.length() &&
                startPath.charAt(i) == destPath.charAt(j)) {
            i++;
            j++;
        }

        // build result: go up for the rest of startPath, then follow destPath
        StringBuilder result = new StringBuilder();
        for (int k = i; k < startPath.length(); k++) {
            result.append('U');
        }
        result.append(destPath.substring(j));

        return result.toString();
    }

    private static boolean findPathBetter(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false;
        if (root.val == target) return true;

        path.append('L');
        if (findPathBetter(root.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPathBetter(root.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
    public static void main(String[] args) {
        //        Example 1:

         BinaryTree root1 = new BinaryTree(5,1,2,3,null,6,4);
         int startValue1 = 3, destValue1 = 6;
         String output1="UURL";

        //        Example 2:

        BinaryTree root2 = new BinaryTree(2,1);
        int startValue2 = 2, destValue2 = 1;
        String output2="L";

        String ans1= getDirectionsBruteForce(root1.getRoot(),startValue1,destValue1);
        String ans2= getDirectionsBruteForce(root2.getRoot(),startValue2,destValue2);


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
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
        System.out.println("Better Approch :");



        ans1= getDirectionsBetter(root1.getRoot(),startValue1,destValue1);
        ans2= getDirectionsBetter(root2.getRoot(),startValue2,destValue2);


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
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }




    }
}
