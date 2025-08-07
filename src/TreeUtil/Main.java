package TreeUtil;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
//		BinaryTree tree= new BinaryTree();
//		tree.populate(new Scanner(System.in));
//		tree.display();
//		tree.prettyDisplay();
		AVL tree= new AVL();
		for(int i =0;i<10;i++) {
			tree.insert(i);
		}
		BinarySearchTree BST= new BinarySearchTree();
		for(int i =0;i<10;i++) {
			BST.insert(i);
		}
//		System.out.println("Binary Search Tree:");
//		System.out.println(BST.getHeight(BST.root));
//		
//		System.out.println("Self Balancing Binary Search Tree:");
//		System.out.println(tree.getHeight(tree.root));
		
		BST.BreadthFirstTraversal();
		tree.BreadthFirstTraversal();
		
	}
}
