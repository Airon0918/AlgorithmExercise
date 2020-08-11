package com.yangshm.leecode;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * 你需要将他们合并为一个新的二叉树。
 * 合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。
 */
public class _617_mergeTrees {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }

    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        // 0.过滤 => t1和t2都不为null
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        // 1.数据初始化
        Queue<Pair<TreeNode, TreeNode>> queue = new LinkedList<>();
        queue.add(new MutablePair<>(t1, t2));
        // 2.迭代
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                // a.队列头排出元素
                Pair<TreeNode, TreeNode> curPair = queue.poll();
                TreeNode curTree1 = curPair.getKey();
                TreeNode curTree2 = curPair.getValue();
                // b.改造curTree1
                curTree1.val = curTree1.val + curTree2.val;
                // c.队列装元素
                // 左节点
                if (curTree2.left != null) {
                    curTree1.left = curTree1.left != null ? curTree1.left : new TreeNode(0);
                    queue.add(new MutablePair<>(curTree1.left, curTree2.left));
                }
                // 右节点
                if (curTree2.right != null) {
                    curTree1.right = curTree1.right != null ? curTree1.right : new TreeNode(0);
                    queue.add(new MutablePair<>(curTree1.right, curTree2.right));
                }
            }
        }
        return t1;
    }

}
