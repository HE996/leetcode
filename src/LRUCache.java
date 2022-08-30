
import java.util.*;
class dLink {
    int val;
    int key;
    dLink pre;
    dLink next;
    dLink(int key,int val){
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {
    Map<Integer,dLink> map;
    int capacity;
    int size;
    dLink head = new dLink(0,0);
    dLink tail = new dLink(0,0);

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head.next=tail;
        tail.pre = head;
    }

    public void removeNode(dLink node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(dLink node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
    }

    public void moveToHead(dLink node) {
        this.removeNode(node);
        this.addToHead(node);
    }
    public int get(int key) {
        dLink node = map.getOrDefault(key,null);
        if(node!=null){
            if(node!=head.next)moveToHead(node);
            return node.val;
        }
        return -1;
    }
    public void put(int key, int value) {
        dLink node = map.getOrDefault(key,null);
        if (node!=null){
            node.val=value;
            if(node!=head.next)moveToHead(node);
        }else{
            node = new dLink(key,value);
            this.addToHead(node);
            map.put(key,node);
            if(map.size()>capacity){
                removeNode(tail.pre);
                map.remove(tail.pre.key);
            }
        }
    }

}
