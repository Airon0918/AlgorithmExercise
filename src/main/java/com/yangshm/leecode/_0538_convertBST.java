package com.yangshm.leecode;

import java.util.Stack;

public class _0538_convertBST {

    private int sum = 0;

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 方法 1：回溯 [Accepted]
     * 想法
     * 一个反序中序遍历的方法是通过递归实现。通过调用栈回到之前的节点，我们可以轻松地反序遍历所有节点。
     * <p>
     * 算法
     * 在递归方法中，我们维护一些递归调用过程中可以访问和修改的全局变量。
     * 首先我们判断当前访问的节点是否存在，如果存在就递归右子树，递归回来的时候更新总和和当前点的值，然后递归左子树。
     * 如果我们分别正确地递归 root.right 和 root.left ，那么我们就能正确地用大于某个节点的值去更新此节点，然后才遍历比它小的值。
     */
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

    /**
     * 一个描述迭代栈的方法就是通过递归的思想。首先我们初始化一个空的栈并把根节点作为当前节点。
     * 然后只要在栈中有未遍历节点或者 node 节点不为空，我们就将当前节点到最右边叶子路径上的点全部压入栈中。
     * 这与递归过程中我们总是先走右子树的思路是一致的，这个思路确保我们总是降序遍历所有节点的值。
     * 接下来，我们访问栈顶节点，并考虑它的左子树，这就像我们递归中先遍历当前节点再遍历它的左子树的思路。
     * 最后，我们的栈为空并且 node 指向树中最小节点的左孩子 null ，循环结束。
     */
    public TreeNode convertBST2(TreeNode root) {
        int sum = 0;
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || node != null) {
            /* push all nodes up to (and including) this subtree's maximum on
             * the stack. */
            while (node != null) {
                stack.add(node);
                node = node.right;
            }

            node = stack.pop();
            sum += node.val;
            node.val = sum;

            /* all nodes with values between the current and its parent lie in
             * the left subtree. */
            node = node.left;
        }

        return root;
    }

}
