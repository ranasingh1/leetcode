/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>(); 
        List<Integer> rightNodes = new ArrayList<>(); 

        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Stack<Integer> stack = new Stack<>(); 

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                stack.push(node.val); 

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            rightNodes.add(stack.pop());
        }

        return rightNodes;
    }
}