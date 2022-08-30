package 二叉树;
import java.util.LinkedList;
import java.util.Queue;

public class Codec {
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node != null) {
                s.append(node.val);
                s.append(',');
                que.add(node.left);
                que.add(node.right);
            } else s.append("null,");
        }
        return s.substring(0, s.length() - 1);
    }
    public static TreeNode deserialize(String data) {
        if (data.equals("")) return null;
        String[] s = data.split(",");
        int i = 0, n = s.length;
        TreeNode root = new TreeNode(Integer.parseInt(s[i]));
        Queue<TreeNode> que = new LinkedList<TreeNode>() {{
            add(root);
        }};
        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (++i<n&&!s[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(s[i]));
                que.add(node.left);
            }
            if (++i<n&&!s[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(s[i]));
                que.add(node.right);
            }
        }
        return root;
    }
}
