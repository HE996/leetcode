package 二叉树.绝对最小差值;

import 二叉树.Codec;
import 二叉树.TreeNode;

public class MinimumAbsoluteDifference530 {
    int ans = Integer.MAX_VALUE,pre = -1;
    public static void main(String[] args) {
        TreeNode root = Codec.deserialize("1,null,3,2");
        MinimumAbsoluteDifference530 A = new MinimumAbsoluteDifference530();
        System.out.println(A.getMinimumDifference(root));
    }
    public int getMinimumDifference(TreeNode root) {
        if (root==null) return 0;
        getMinimumDifference(root.left);
        if (pre!=-1) ans = Math.min(root.val-pre,ans);
        pre = root.val;
        getMinimumDifference(root.right);
        return ans;
    }
//    public int getMinimumDifference(TreeNode root) {
//        Deque<TreeNode> stack = new ArrayDeque<>();
//        TreeNode node = root;
//        long ans = Integer.MAX_VALUE,pre = -Integer.MAX_VALUE;
//        while(!stack.isEmpty()||node!=null){
//            if (node != null){
//                stack.offerLast(node);
//                node = node.left;
//            }else {
//                node = stack.pollLast();
//                ans = Math.min(node.val-pre,ans);
//                pre = node.val;
//                node = node.right;
//            }
//            if (ans == 1) return 1;
//        }
//        return (int)ans;
//    }
}
