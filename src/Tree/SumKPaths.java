
//you are given a treenode root  and a integer k you have to give a list of paths inside the tree which exists any where
//does not required to include root , leaf but sum of upto k return all such paths as a list in any order
package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumKPaths {
    // approch we can do a dfs pre order traversal where we can add each node to the curr path list
//    and by reverse summing it up at each recursion level we can find the
//    count of sum ;
//    time complexity :O(n*n)
//    space complexity :O(n)
    public static List<List<Integer>> pathSumK(TreeNode root, int k){
        List<List<Integer>> paths= new ArrayList<>();
        List<Integer> currPath = new ArrayList<>();
        dfs(root,k,paths,currPath);
        return paths;
    }
    public static void dfs(TreeNode root, int k , List<List<Integer>> paths, List<Integer> currPath){
        if(root==null){return ;}
        currPath.add(root.val);
        int sum =0;
        List<Integer> currSumPath = new ArrayList<>();
        for(int i =currPath.size()-1;i>=0;i--){
            sum += currPath.get(i);
            if (sum == k) {
                // Extract the sublist [i, end] as a valid path
                paths.add(new ArrayList<>(currPath.subList(i, currPath.size())));
            }
        }
        dfs(root.left,k,paths,currPath);
        dfs(root.right,k,paths,currPath);
        currPath.remove(currPath.size()-1);

    }

    public static void main(String[] args) {
        BinaryTree tree1= new BinaryTree(1,2,3,4,5,6,7);
        int k1 = 6;
        System.out.println(pathSumK(tree1.getRoot(),k1));
    }
}
