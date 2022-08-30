package E回溯.复原ip地址;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        new Solution().restoreIpAddresses("000256");
    }
    List<String> res=new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        this.backtrace(0,0,0,s.toCharArray(),new char [s.length()+3]);
        return this.res;
    }

    public void backtrace(int i,int j ,int mod, char[] s,char[] stack){
        System.out.println("mod:"+mod+"  "+new String(stack));
        if(i==s.length){
            if(j-i==3)res.add(new String(stack));
        }else{
            if(mod*10+(s[i]-48)>255)return;
            if(j-i<3){
                stack[j]='.';
                this.backtrace(i,j+1,0,s,stack);
            }
            if(mod==0&&stack[j-1]==48)return;
            stack[j]=s[i];
            this.backtrace(i+1,j+1,mod*10+s[i],s,stack);
        }
    }
}





