package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class FindAllPathsInATree {


    public static List<List<Integer>> findAllPaths(TreeNode root){
        List<List<Integer>> paths= new ArrayList<>();
        findPaths(root,paths,new ArrayList<>());
        return paths;
    }
    public static void findPaths(TreeNode root, List<List<Integer>> paths, List<Integer> currPath){
        if(root==null){return;}
        currPath.add(root.val);
        paths.add(new ArrayList<>(currPath));
        findPaths(root.left,paths,currPath);
        findPaths(root.right,paths,currPath);
    }
    public static void main(String[] args) {
        BinaryTree root1=  new BinaryTree(1,2,3,4,5);
        System.out.println(root1);
        System.out.println(findAllPaths(root1.getRoot()));
    }
}
