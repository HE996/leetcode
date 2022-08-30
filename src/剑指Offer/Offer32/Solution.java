package 剑指Offer.Offer32;

import 二叉树.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        TreeNode node = new TreeNode(0);
        node.left = root;
        TreeNode finalNode = node;
        ArrayDeque<TreeNode> queue = new ArrayDeque<TreeNode>(){{add(finalNode);}};
        List<List<Integer>> res = new ArrayList<>();
        int i = 1,cap = 1,a = 0;
        List<Integer> tmp = new LinkedList<>();
        while(!queue.isEmpty()){
            node = queue.pollFirst();
            if(node.left!=null){
                tmp.add(tmp.size()-a*tmp.size(),node.left.val);
                queue.offerLast(node.left);
                i++;
            }
            if(node.right!=null){
                tmp.add(tmp.size()-a*tmp.size(),node.right.val);
                queue.offerLast(node.right);
                i++;
            }
            if (i==cap){
                res.add(tmp);
                cap *= 2;
                tmp = new LinkedList<>();
                a = 1-a;
            }
        }
        return res;
    }
}
