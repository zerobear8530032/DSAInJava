package Tree;

import TreeUtil.BinaryTree;
import TreeUtil.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree_297 {

//approch :
//   we can use a bfs traversal where we can also add values in a string an node ends as null
//    then we can just reverese what we did cause we have null points we can easily created back our tree
    public static String serialize(TreeNode root) {
        if(root==null) {

            return "[]";
        }

        StringBuilder res = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode poped = queue.remove();
            if(poped==null){
                res.append(poped+",");
                continue;
            }
            res.append(poped.val+",");
            queue.add(poped.left);
            queue.add(poped.right);

        }
        res.setCharAt(res.length()-1,']');
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("[]")){return null;}
        List<Integer> arr = convertStringToList(data);
        if(arr==null) {
            return null;
        }
        if(arr.size()==0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int idx =0;
        TreeNode root= new TreeNode(arr.get(idx));
        idx++;
        queue.add(root);
        while(!queue.isEmpty() ) {
            TreeNode currNode=queue.remove();
            if(idx <arr.size() && arr.get(idx)!=null) {
                int left = arr.get(idx);
                currNode.left= new TreeNode(left);
                queue.add(currNode.left);
            }
            idx++;
            if(idx <arr.size() && arr.get(idx)!=null ) {
                int right = arr.get(idx);
                currNode.right= new TreeNode(right);
                queue.add(currNode.right);
            }
            idx++;
        }
        return root;
    }
    public static List<Integer> convertStringToList(String str){
        str= str.substring(1,str.length()-1);

        String [] elements = str.split(",");
        List<Integer> res= new ArrayList<>();
        for(String s:elements){
            if(s.equals("null")){
                res.add(null);
                continue;
            }
            res.add(Integer.parseInt(s));
        }
        return res;
    }

    public static void main(String[] args) {

          //  Example 1:

          BinaryTree root1 = new BinaryTree(1,2,3,null,null,4,5);
          BinaryTree output1= new BinaryTree(1,2,3,null,null,4,5);

          // Example 2:

          BinaryTree root2 = new BinaryTree();
          BinaryTree output2= new BinaryTree();

          String serialized1 = serialize(root1.getRoot());
          TreeNode unserealized1 = deserialize(serialized1);

          String serialized2 = serialize(root2.getRoot());
          TreeNode unserealized2 = deserialize(serialized2);

          if(output1.equals(unserealized1)){
                  System.out.println("Case 1 Passed");
          }else{
              System.out.println("Case 1 Failed");
              System.out.println("Expected Ouput :"+ output1);
              System.out.println("Your Answer :"+ unserealized1);
          }
          if(output2.equals(unserealized2)){
                  System.out.println("Case 2 Passed");
          }else{
              System.out.println("Case 2 Failed");
              System.out.println("Expected Ouput :"+ output2);
              System.out.println("Your Answer :"+ unserealized2);
          }

    }
}
