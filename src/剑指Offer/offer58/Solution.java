package 剑指Offer.offer58;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n)+s.substring(0,n);
    }
}
