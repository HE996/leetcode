

import java.util.*;
class binTree{
    int val;
    binTree left;
    binTree right;
    binTree(int val){
        this.val = val;
    }
}
class Solution {
    static int target;
    public static void help(binTree node,int sum, ArrayDeque<Integer>stack){
        sum+=node.val;
        stack.add(node.val);
        if(node.left!=null)help(node.left,sum, stack);
        if(node.right!=null)help(node.right,sum, stack);

        if(node.left==null&&node.right==null){
            if(sum==target) System.out.println(stack.toString());
        }
        stack.remove(stack.removeLast());
    }
    public static void func(binTree root,int target){
        Solution.target = target;
        help(root,0,new ArrayDeque<>());
    }
    public static void main(String[] args) {
        binTree root = new binTree(10);
        root.left = new binTree(5);
        root.right = new binTree(12);
        root.left.left = new binTree(4);
        root.left.right = new binTree(7);
        func(root,22);
    }
}