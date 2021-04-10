package leetcode;

import java.util.ArrayList;
import java.util.List;

public class IncreaseBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}

		static TreeNode add(TreeNode root, int val) {
			if (root == null) {
				return new TreeNode(val);
			} else {
				TreeNode cur;
				if (val <= root.val) {
					cur = add(root.left, val);
					root.left = cur;
				} else {
					cur = add(root.right, val);
					root.right = cur;
				}
				return root;
			}
		}
	}

	public static TreeNode increasingBST(TreeNode root) {
		List<Integer> vals = new ArrayList<>();
		inorder(root, vals);
		TreeNode ans = new TreeNode(0);
		TreeNode cur = ans;
		for (int v : vals) {
			cur.right = new TreeNode(v);
			cur = cur.right;
		}
		return ans;
	}

	private static void inorder(TreeNode node, List<Integer> vals) {
		if(node == null) return;
		inorder(node.left, vals);
		vals.add(node.val);
		inorder(node.right, vals);
	}


	public static void main(String[] args) {
		var root = new TreeNode(5);
		TreeNode.add(root, 3);
		TreeNode.add(root, 6);
		TreeNode.add(root, 2);
		TreeNode.add(root, 4);
		TreeNode.add(root, 1);
		TreeNode.add(root, 8);
		TreeNode.add(root, 7);
		TreeNode.add(root, 9);
		increasingBST(root);
	}
}
