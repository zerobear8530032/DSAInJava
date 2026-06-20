//2196. Create Binary Tree From Descriptions
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given a 2D integer array descriptions where descriptions[i] = [parenti, childi, isLefti] indicates that parenti is the parent of childi in a binary tree of unique values. Furthermore,
//
//If isLefti == 1, then childi is the left child of parenti.
//If isLefti == 0, then childi is the right child of parenti.
//Construct the binary tree described by descriptions and return its root.
//
//The test cases will be generated such that the binary tree is valid.
//
//
//
//Example 1:
//
//
//Input: descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
//Output: [50,20,80,15,17,19]
//Explanation: The root node is the node with value 50 since it has no parent.
//The resulting binary tree is shown in the diagram.
//Example 2:
//
//
//Input: descriptions = [[1,2,1],[2,3,0],[3,4,1]]
//Output: [1,2,null,null,3,4]
//Explanation: The root node is the node with value 1 since it has no parent.
//The resulting binary tree is shown in the diagram.
//
//
//Constraints:
//
//1 <= descriptions.length <= 104
//descriptions[i].length == 3
//1 <= parenti, childi <= 105
//0 <= isLefti <= 1
//The binary tree described by descriptions is valid.
package Tree;

import Tree.TreeUtil.BinaryTree;
import Tree.TreeUtil.TreeNode;

import java.util.HashMap;
import java.util.HashSet;

public class CreateBinaryTreeFromDescriptions_2196 {
//    approch: create a hashmap which map value to node of tree
//    then reiterate the descriptions array and build the tree connection
//    now filter the node which does not have any child is our parent node of the tree
//    time complexity : O(n)
//    space complexity : O(n)
    public static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,TreeNode> nodeMap= new HashMap<>();
        for(int [] node:descriptions){
            if(!nodeMap.containsKey(node[0])){
                nodeMap.put(node[0],new TreeNode(node[0]));
            }
            if(!nodeMap.containsKey(node[1])){
                nodeMap.put(node[1],new TreeNode(node[1]));
            }
        }
        HashSet<Integer> childs= new HashSet<Integer> ();
        for(int [] node : descriptions){
            TreeNode parent = nodeMap.get(node[0]);
            if(node[2]==1){
                parent.left=nodeMap.get(node[1]);
            }else{
                parent.right=nodeMap.get(node[1]);
            }
            childs.add(node[1]);
        }
        for(int node:nodeMap.keySet()){
            if(!childs.contains(node)){
                return nodeMap.get(node);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] descriptions1 = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode output1= new BinaryTree(50,20,80,15,17,19).getRoot();

        //Example 2:

        int [][] descriptions2 = {{1,2,1},{2,3,0},{3,4,1}};
        TreeNode output2= new BinaryTree(1,2,null,null,3,4).getRoot();

        TreeNode ans1= createBinaryTree(descriptions1);
        TreeNode ans2= createBinaryTree(descriptions2);


        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
    }
}
