package 链表重排序;

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow=head,fast = head;
        int cnt=1;
        while(fast.next!=null&&fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            cnt++;
        }
        ListNode [] queue = new ListNode [cnt];
        cnt=0;
        while(slow.next!=null){
            queue[cnt]=slow.next;
            slow = slow.next;
            cnt++;
        }
        slow = head;
        int i = 0;
        while(i<=cnt){
            fast = slow.next;
            slow.next = queue[i];
            queue[i].next = fast;
            slow = fast;
        }
        System.out.println(queue.toString());
    }
}
