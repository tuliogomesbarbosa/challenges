package trees;

public class ValidateBST {
    private static class TreeNode {
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
    }

    private static class Solution {
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        public boolean dfs(TreeNode node, long small, long large) {
            if (node == null) return true;

            if (small >= node.val || node.val >= large) return false;

            boolean left = dfs(node.left, small, node.val);
            boolean right = dfs(node.right, node.val, large);

            return left && right;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // [5,3,7,null,null,4,8]
        TreeNode root = new TreeNode(5, new TreeNode(3), new TreeNode(7, new TreeNode(4), new TreeNode(8)));
        System.out.println(solution.isValidBST(root));

        // [5,4,7,2,null,1,3,null]
        root = new TreeNode(5, new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), null), new TreeNode(7));
        System.out.println(solution.isValidBST(root));
    }
}
