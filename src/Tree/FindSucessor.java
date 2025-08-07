package Tree;

import java.util.LinkedList;
import java.util.Queue;

import TreeUtil.TreeNode;

public class FindSucessor {
	
	public TreeNode findSucessor(TreeNode root, int key) {
		if(root==null) {
			return null;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			TreeNode poped = queue.remove();
			if(poped.left!=null) {
				queue.add(poped.left);
			}
			if(poped.right!=null) {
				queue.add(poped.right);
			}
			if(poped.val==key && queue.isEmpty()) {
				return queue.peek();
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		TreeNode root1 = new TreeNode(1);
		
	}

}
