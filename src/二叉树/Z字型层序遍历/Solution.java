package 二叉树.Z字型层序遍历;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        ArrayList<ArrayList<Integer>> res= new ArrayList<>();
        if(root==null)return res;
        ArrayDeque<Integer> list = new ArrayDeque<>();
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        TreeNode tmp = new TreeNode(0);
        deque.addFirst(root);
        boolean dir = false;
        while(!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollFirst();
                if (dir) {
                    list.addFirst(node.val);
                } else {
                    list.addLast(node.val);
                }
                if(node.left!=null)deque.addLast(node.left);
                if(node.right!=null)deque.addLast(node.right);
            }
            dir =!dir;

            res.add(new ArrayList<>(list));
        }
        return res;
    }
}