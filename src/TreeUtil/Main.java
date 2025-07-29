package TreeUtil;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
//		BinaryTree tree= new BinaryTree();
//		tree.populate(new Scanner(System.in));
//		tree.display();
//		tree.prettyDisplay();
		
		
		BinarySearchTree tree = new BinarySearchTree(5,2,7,1,4,6,9,8,3,10);
		System.out.println(tree.isBalanced());
		tree.display();
		
		System.out.println(tree.preorder());
		System.out.println(tree.postorder());
		System.out.println(tree.inorder());
	}
}
