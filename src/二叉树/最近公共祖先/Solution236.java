package 二叉树.最近公共祖先;

import 二叉树.TreeNode;

public class Solution236 {
    TreeNode v,w;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        v=p;
        w=q;
        return backtrace(root);
    }
    public TreeNode backtrace(TreeNode node) {
        if(node==null||node==v||node==w)return node;
        TreeNode l = backtrace(node.left);
        if(l==null) return backtrace(node.right);
        if(backtrace(node.right)==null) return l;
        return node;
    }
}
