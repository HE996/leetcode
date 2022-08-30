package 二叉树.二叉树的后序遍历;
import java.util.*;
import 二叉树.*;
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayDeque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode pre = null;
        while(!stack.isEmpty()||root!=null){
            if (root!=null){
                stack.push(root);
                root = root.left;
            }
            else{
                root = stack.pop();
                if (root.right==null||pre==root.right){
                    ans.add(root.val);
                    pre=root;
                    root = null;
                }else{
                    stack.push(root);
                    root = root.right;
                }
            }
        }
        return ans;
    }
}
