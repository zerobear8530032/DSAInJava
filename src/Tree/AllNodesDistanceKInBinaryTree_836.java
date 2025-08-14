
//863. All Nodes Distance K in Binary Tree
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given the root of a binary tree, the value of a target node target, and an integer k, return an array of the values of all nodes that have a distance k from the target node.
//
//You can return the answer in any order.
//
//
//
//Example 1:
//
//
//Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, k = 2
//Output: [7,4,1]
//Explanation: The nodes that are a distance 2 from the target node (with value 5) have values 7, 4, and 1.
//Example 2:
//
//Input: root = [1], target = 1, k = 3
//Output: []
//
//
//Constraints:
//
//The number of nodes in the tree is in the range [1, 500].
//0 <= Node.val <= 500
//All the values Node.val are unique.
//target is the value of one of the nodes in the tree.
//0 <= k <= 1000

package Tree;
import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.*;
public class AllNodesDistanceKInBinaryTree_836 {
    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return null;
        }
        Map<TreeNode, TreeNode> parentMap = new HashMap();
        mapNodeToParents(root,parentMap);
        HashSet<TreeNode> visited = new HashSet<>();
        return BFS(target,parentMap,k);
    }

    public static List<Integer> BFS(TreeNode root,Map<TreeNode, TreeNode> parentMap, int k){
        Queue<TreeNode> queue = new LinkedList();
        HashSet<TreeNode> visited = new HashSet();
        visited.add(root);
        queue.add(root);
        int distance =0;
        List<Integer> ans = new ArrayList();
        while(!queue.isEmpty()){
            int levelSize=queue.size();
            if(distance==k){
                break;
            }
            for(int i =0;i<levelSize;i++){
                TreeNode removed = queue.remove();
                if(removed.left!=null && !visited.contains(removed.left)){
                    queue.add(removed.left);
                    visited.add(removed.left);
                }
                if(removed.right!=null  && !visited.contains(removed.right)){
                    queue.add(removed.right);
                    visited.add(removed.right);
                }
                if(parentMap.get(removed)!=null  && !visited.contains(parentMap.get(removed))){
                    queue.add(parentMap.get(removed));
                    visited.add(parentMap.get(removed));
                }
            }
            distance++;

        }
        while(!queue.isEmpty()){
            ans.add (queue.remove().val);
        }
        return ans;
    }

    public static void mapNodeToParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        parentMap.put(root,null);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poped = queue.remove();
                if(poped.left!=null){
                    queue.add(poped.left);
                    parentMap.put(poped.left,poped);
                }
                if(poped.right!=null){
                    queue.add(poped.right);
                    parentMap.put(poped.right,poped);
                }
            }
        }
    }
    public static void main(String[] args) {
       // Example 1:
       BinaryTree root1 = new BinaryTree(3,5,1,6,2,0,8,null,null,7,4);
       int target1 = 5, k1 = 2;
       List<Integer> output1= new ArrayList<>( Arrays.asList(7,4,1));

       // Example 1:
       BinaryTree root2 = new BinaryTree(1);
       int target2 = 1, k2 = 3;
       List<Integer> output2= new ArrayList<>( );

       List<Integer> ans1 = distanceK(root1.getRoot(), root1.getNode(target1),k1);
       List<Integer> ans2 = distanceK(root2.getRoot(), root2.getNode(target2),k2);

        if(output1.equals( ans1)) {
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
