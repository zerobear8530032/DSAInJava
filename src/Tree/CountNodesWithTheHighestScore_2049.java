//2049. Count Nodes With the Highest Score
//Attempted
//Medium
//There is a binary tree rooted at 0 consisting of n nodes. The nodes are labeled from 0 to n - 1. You are given a 0-indexed integer array parents representing the tree, where parents[i] is the parent of node i. Since node 0 is the root, parents[0] == -1.
//
//Each node has a score. To find the score of a node, consider if the node and the edges connected to it were removed. The tree would become one or more non-empty subtrees. The size of a subtree is the number of the nodes in it. The score of the node is the product of the sizes of all those subtrees.
//
//Return the number of nodes that have the highest score.
//
//
//
//Example 1:
//
//example-1
//Input: parents = [-1,2,0,2,0]
//Output: 3
//Explanation:
//        - The score of node 0 is: 3 * 1 = 3
//        - The score of node 1 is: 4 = 4
//        - The score of node 2 is: 1 * 1 * 2 = 2
//        - The score of node 3 is: 4 = 4
//        - The score of node 4 is: 4 = 4
//The highest score is 4, and three nodes (node 1, node 3, and node 4) have the highest score.
//Example 2:
//
//example-2
//Input: parents = [-1,2,0]
//Output: 2
//Explanation:
//        - The score of node 0 is: 2 = 2
//        - The score of node 1 is: 2 = 2
//        - The score of node 2 is: 1 * 1 = 1
//The highest score is 2, and two nodes (node 0 and node 1) have the highest score.
//
//
//Constraints:
//
//n == parents.length
//2 <= n <= 105
//parents[0] == -1
//0 <= parents[i] <= n - 1 for i != 0
//parents represents a valid binary tree.


package Tree;

import TreeUtil.TreeNode;

import java.util.HashMap;
import java.util.TreeMap;

public class CountNodesWithTheHighestScore_2049 {
    public static int countHighestScoreNodesBruteForce(int[] parents) {
        TreeMap<Integer,Integer> scoreFreq= new TreeMap();
        TreeNode root = createTree(parents);
        postOrder(root,root,scoreFreq,parents.length);
        return scoreFreq.lastEntry().getValue();
    }

    public static  void postOrder(TreeNode root,TreeNode node, TreeMap<Integer,Integer> scoreFreq, int totalNodes){
        if(node==null){
            return ;
        }
        postOrder(root,node.left,scoreFreq,totalNodes);
        postOrder(root,node.right,scoreFreq,totalNodes);
        int leftScore= getScore(node.left,node);//we can put null here or node also but it will never find node in recursion
        int rightScore= getScore(node.right,node);//we can put null here or node also but it will never find node in recursion
        int upScore = (totalNodes-1) - (leftScore+rightScore);
        leftScore=leftScore==0?1:leftScore;
        rightScore=rightScore==0?1:rightScore;
        upScore=upScore==0?1:upScore;
        // System.out.println(node.val+"  , LS"+ leftScore+"  , RS"+ rightScore+" upScore :"+upScore);
        int ans = leftScore*rightScore*upScore;

        scoreFreq.put(ans,scoreFreq.getOrDefault(ans,0)+1);
    }



    public static int getScore(TreeNode root, TreeNode removed){
        if(root==null || root==removed){
            return 0;
        }
        int left = getScore(root.left,removed);
        int right = getScore(root.right,removed);
        return left + right+1;
    }


    public static TreeNode createTree(int []parent){
        HashMap<Integer,TreeNode> nodemap = new HashMap();
        TreeNode root=null;
        for(int i =0;i<parent.length;i++){
            TreeNode  node= new TreeNode(i);
            if(parent[i]==-1){
                root=node;
            }
            nodemap.put(i,node);
        }
        for(int i =0;i<parent.length;i++){
            if(parent[i]==-1){continue;}
            TreeNode parentNode = nodemap.get(parent[i]);
            TreeNode child = nodemap.get(i);
            if(parentNode.left==null){
                parentNode.left=child;
            }else if(parentNode.right==null){
                parentNode.right=child;
            }else{
                System.out.println("Some Thing is not Right ");
            }
        }
        return root;
    }

//    better approch:
//    use any order traversal to get the leftside node and right side nodes of the tree
//    and compute score and update it with max in global variables
//    time complexity :O(n)
//    space complexity :O(h)

     static int maxScore;
    static int maxScoreFreq;
    public static  int countHighestScoreNodesBetter(int[] parents) {
        maxScore=0;
        maxScoreFreq=0;
        TreeNode root = createTree(parents);
        postOrder(root,parents.length);
        return maxScoreFreq;
    }

    public static int postOrder(TreeNode node, int totalNodes){
        if(node==null){
            return 0;
        }

        int totalScore=1;

        int leftScore = postOrder(node.left,totalNodes);
        int rightScore = postOrder(node.right,totalNodes);
        int upScore = (totalNodes-1)-(leftScore+rightScore);

        if(leftScore>0){totalScore*=leftScore;}
        if(rightScore>0){totalScore*=rightScore;}
        if(upScore>0){totalScore*=upScore;}

        if(totalScore==maxScore){
            maxScoreFreq++;
        }else if(totalScore>maxScore){
            maxScore=totalScore;
            maxScoreFreq=1;
        }
        return leftScore+rightScore+1;
    }







    public static void main(String[] args) {
        //Example 1:

        int []  parents1 = {-1,2,0,2,0};
        int output1=3;

        //Example 2:

        int[] parents2 = {-1,2,0};
        int output2=2;

        System.out.println("Brute Force Approch ");

        int ans1= countHighestScoreNodesBruteForce(parents1);
        int ans2= countHighestScoreNodesBruteForce(parents2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

        System.out.println("Better Approch :");

         ans1= countHighestScoreNodesBetter(parents1);
         ans2= countHighestScoreNodesBetter(parents2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }

}
