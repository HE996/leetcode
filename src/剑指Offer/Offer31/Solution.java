package 剑指Offer.Offer31;

import java.util.Stack;

public class Solution {
//    public boolean validateStackSequences(int[] pushed, int[] popped) {
//        Stack<Integer> stack = new Stack<>();
//        int i = 0;
//        for (int n : pushed) {
//            stack.push(n);
//            while(!stack.isEmpty()&&popped[i]==stack.peek()){
//                stack.pop();
//                i++;
//            }
//        }
//        return i<popped.length;
//    }
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top = -1,index = 0;
        for (int i = 0; i < pushed.length; i++) {
            pushed[++top] = pushed[i];
            while(top>=0&&pushed[top]==pushed[i]){
                top--;
                index++;
            }
        }
        return index>=popped.length;
    }
}
