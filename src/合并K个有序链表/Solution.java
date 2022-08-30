package 合并K个有序链表;

import 链表重排序.ListNode;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int l = 0,r = lists.length-1;
        return mergeKLists(lists,l, r);
    }

    public ListNode mergeKLists(ListNode[] lists,int l, int r) {
        if(l==r)return lists[l];
        int m = l+((r-l)>>1);
        ListNode list1 = mergeKLists(lists,l, m-1);
        ListNode list2 = mergeKLists(lists,m+1, r);
        return mergeTwoLists(list1,list2);
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode root = new ListNode();
        ListNode node = root;
        while(true){
            if(list1==null){
                node.next = list2;
                break;
            }
            if(list2==null){
                node.next = list2;
                break;
            }
            if(list1.val>list2.val){
                node = list2;
                list2 = list2.next;
            }else {
                node = list1;
                list1 = list2.next;
            }
            node = node.next;
        }
        return root;
    }
}
