package trees;

import java.util.LinkedList;
import java.util.Queue;

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
	}

	public void inOrder(Node root) {

	}

	public void preOrder(Node root) {

	}

	public void postOrder(Node root) {

	}

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