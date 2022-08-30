package 剑指Offer.offer33;

class Solution1 {
    public boolean dfs(int[] postorder,int l,int r,int s,int x){
        if (l>r)return true;
        if (l==r)return postorder[l]<x&&postorder[l]>s;
        int node = postorder[r];
        int i;
        for (i = r; i >=l&&postorder[i]>=node ; i--) {
            if (postorder[i]<s||postorder[i]>x)return false;
        }
        return dfs(postorder,l,i,s,node)&&dfs(postorder,i+1,r-1,node,x);
    }
    public boolean verifyPostorder(int[] postorder) {
        if (postorder.length<=0)return false;
        return dfs(postorder,0,postorder.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
}
public class offer33{
    public static void main(String[] args) {
        Solution1 a = new Solution1();
        System.out.println(a.verifyPostorder(new int[]{6, 7}));
    }
}