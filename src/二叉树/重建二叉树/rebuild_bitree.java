package 二叉树.重建二叉树;

import 二叉树.*;

class Solution {
    private int mast = 0;
    private int inf = 0;
    public TreeNode buildTree(int[] preorder, int[] postorder) {
        if (preorder.length==0) return null;
        //return preindfs(preorder, inorder,Integer.MIN_VALUE);
        return prepostdfs(preorder, postorder);
    }
    private TreeNode preindfs(int[] preorder, int[] inorder,int st){
        if(mast >=preorder.length) return null;
        if(inorder[inf]==st){
            inf++;
            return null;
        }
        int x = preorder[mast++];
        TreeNode root = new TreeNode(x);
        root.left = preindfs(preorder, inorder,x);
        root.right = preindfs(preorder, inorder,st);
        return root;
    }
    private TreeNode inpostdfs(int[] postorder, int[] inorder,int st){
        if(mast <0) return null;
        if(inorder[inf]==st){
            inf--;
            return null;
        }
        int x = postorder[mast--];
        TreeNode root = new TreeNode(x);
        root.right = inpostdfs(postorder, inorder,x);
        root.left = inpostdfs(postorder, inorder,st);
        return root;
    }
    private TreeNode prepostdfs(int[] preorder, int[] postorder){
        if(mast>=preorder.length) return null;
        int x = preorder[mast++];
        TreeNode root = new TreeNode(x);
        if(postorder[inf]!=x)root.left = prepostdfs(preorder, postorder);
        if(postorder[inf]!=x)root.right = prepostdfs(preorder, postorder);
        inf++;
        return root;
    }
}

public class rebuild_bitree {
    public static void main(String[] args) {

        System.out.println((912834723<<3)+(912834723<<1)+('7'-48));
//        Solution a = new Solution();
//        int[] preorder = new int[]{6,5,4,3,2,1,};
//        int[] postorder = new int[]{4,2,3,5,1,6};
//        System.out.println(Codec.serialize(a.buildTree(preorder, postorder)));
    }
}
