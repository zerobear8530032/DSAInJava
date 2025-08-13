// how many paths sum can get the sum equals to k these path can exists any where in tree and does not required to
// have root or leaf in them

package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class SumPathK {
// approch we can do a dfs pre order traversal where we can add each node to the curr path list
//    and by reverse summing it up at each recursion level we can find the
//    count of sum ;
//    time complexity :O(n*n)
//    space complexity :O(n)
    public static int pathSumK(TreeNode root, int k){
        List<Integer> currPath= new ArrayList<>();
        return dfs(root,k,currPath);
    }
    public static int dfs(TreeNode root, int k , List<Integer> currPath){
        if(root==null){return 0;}
        currPath.add(root.val);
         int sum =0;
         int count =0;
         for(int i =currPath.size()-1;i>=0;i--){
             sum+=currPath.get(i);
             if(sum==k){
                 count++;
             }
         }
         count+= dfs(root.left,k,currPath);
         count+= dfs(root.right,k,currPath);
         currPath.remove(currPath.size()-1);
         return count;
    }

    public static void main(String[] args) {
        BinaryTree tree1= new BinaryTree(1,2,3,4,5,6,7);
        int k1 = 6;
        System.out.println(pathSumK(tree1.getRoot(),k1));
    }
}
