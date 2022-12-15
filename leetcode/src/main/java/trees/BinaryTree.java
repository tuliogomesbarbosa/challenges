package trees;

import java.util.LinkedList;
import java.util.Queue;

// DFS: 3 types -> in-order, pre-order, post-order
// BFS
public class BinaryTree {

	static class Node {
		int data;
		Node left;
		Node right;

		public Node(int data) {
			this.data = data;
		}

		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		@Override
		public String toString() {
			return "Node{" +
					"data=" + data +
					'}';
		}
	}

	/**
	 * For inorder traversal, we first recursively call the left child, then perform logic on the current node,
	 * then recursively call the right child. This means no logic will be done until we reach a node without a left
	 * child since calling on the left child takes priority over performing logic.
	 */
	public void inOrder(Node root) {

	}

	/**
	 * In preorder traversal, logic is done on the current node before moving to the children. Let's say that we wanted
	 * to just print the value of each node in the tree to the console. In that case, at any given node, we would print
	 * the current node's value, then recursively call the left child, then recursively call the right child (or right
	 * then left, it doesn't matter, but left before right is more common).
	 */
	public void preOrder(Node root) {
		if (root == null) return;

		System.out.println(root);
		preOrder(root.left);
		preOrder(root.right);
	}

	/**
	 * In postorder traversal, we recursively call on the children first and then perform logic on the current node.
	 * This means no logic will be done until we reach a leaf node since calling on the children takes priority over
	 * performing logic. In a postorder traversal, the root is the last node where logic is done.
	 */
	public void postOrder(Node root) {

	}

	/**
	 * Without recursion
	 */
	public void bfs(Node root) {
		Queue<Node> bfs = new LinkedList<>();
		bfs.add(root);
		while (!bfs.isEmpty()) {
			var current = bfs.remove();
			System.out.println(current.data + " - ");
			if (current.left != null) {
				bfs.add(current.left);
			}
			if (current.right != null) {
				bfs.add(current.right);
			}
		}
	}

	public Node invert(Node root) {
		if (root == null) {
			return null;
		}
		Node tmp = root.right;
		root.right = root.left;
		root.left = tmp;
		if (root.left != null) {
			invert(root.left);
		}
		if (root.right != null) {
			invert(root.right);
		}
		return root;
	}

	public static void main(String[] args) {
		Node root = new Node(5);
		root.left = new Node(10);
		root.right = new Node(15);
		root.left.left = new Node(20);
		root.left.right = new Node(25);
		root.right.left = new Node(30);
		root.right.right = new Node(35);

		BinaryTree btree = new BinaryTree();
		btree.bfs(root);
		btree.invert(root);
		System.out.println("\n");
		btree.bfs(root);
	}
}