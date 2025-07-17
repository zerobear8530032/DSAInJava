package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import TreeUtil.TreeNode;

public class LevelWiseLinkedListOfTree {
	
	
	
	
	public static void traverse(List<List<Integer>> list,TreeNode root, int depth) {
		if(root==null) {
			return ;
		}
		if(list.size()-1<depth) {
			list.add(new LinkedList<Integer>());
		}
		List <Integer> ll= list.get(depth);
		ll.add(root.val);
		traverse(list,root.left,depth+1);
		traverse(list,root.right,depth+1);
	}
	
	public static List<List<Integer>> getLevelLinkedList(TreeNode root){
		List<List<Integer>> list= new ArrayList<List<Integer>>();
//		list.add(new LinkedList());
		traverse(list ,root,0);
		return list;
		
	}
	
	
	
	public static void main(String[] args) {
		 TreeNode root1 = new TreeNode(1);
	        root1.left = new TreeNode(2);
	        root1.right = new TreeNode(3);
	        root1.left.left = new TreeNode(4);
	        root1.left.right = new TreeNode(5);
	        root1.right.right = new TreeNode(6);
	        System.out.println("Test Case 1: Balanced Tree");
	        List<List<Integer>> list1=getLevelLinkedList(root1);
	        System.out.println(list1);
	        
	        // ✅ Test Case 2: Left-Skewed Tree
	        TreeNode root2 = new TreeNode(1);
	        root2.left = new TreeNode(2);
	        root2.left.left = new TreeNode(3);
	        root2.left.left.left = new TreeNode(4);
	        System.out.println("Test Case 2: Left-Skewed Tree");
	        List<List<Integer>> list2=getLevelLinkedList(root2);
	        System.out.println(list2);

	        // ✅ Test Case 3: Right-Skewed Tree
	        TreeNode root3 = new TreeNode(1);
	        root3.right = new TreeNode(2);
	        root3.right.right = new TreeNode(3);
	        root3.right.right.right = new TreeNode(4);
	        System.out.println("Test Case 3: Right-Skewed Tree");
	        List<List<Integer>> list3=getLevelLinkedList(root3);
	        System.out.println(list3);

	        // ✅ Test Case 4: Single Node
	        TreeNode root4 = new TreeNode(42);
	        System.out.println("Test Case 4: Single Node");
	        List<List<Integer>> list4=getLevelLinkedList(root4);
	        System.out.println(list4);

	        // ✅ Test Case 5: Complete Binary Tree
	        TreeNode root5 = new TreeNode(10);
	        root5.left = new TreeNode(20);
	        root5.right = new TreeNode(30);
	        root5.left.left = new TreeNode(40);
	        root5.left.right = new TreeNode(50);
	        root5.right.left = new TreeNode(60);
	        root5.right.right = new TreeNode(70);
	        System.out.println("Test Case 5: Complete Binary Tree");
	        List<List<Integer>> list5=getLevelLinkedList(root5);
	        System.out.println(list5);

	        // ✅ Test Case 6: Random Sparse Tree
	        TreeNode root6 = new TreeNode(5);
	        root6.left = new TreeNode(3);
	        root6.right = new TreeNode(8);
	        root6.left.left = new TreeNode(1);
	        root6.right.right = new TreeNode(9);
	        root6.right.right.right = new TreeNode(10);
	        System.out.println("Test Case 6: Sparse Tree");
	        List<List<Integer>> list6=getLevelLinkedList(root6);
	        System.out.println(list6);
	}

}
