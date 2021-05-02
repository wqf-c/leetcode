package CodeTop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wqf
 * @date 2021/5/2 21:45
 * @Email:284660487@qq.com
 */
public class LRUCache {

    class Node{
        Node next;
        Node prev;
        int key;
        int val;

        Node(int _key, int _val){
            key = _key;
            val = _val;
        }
    }

    Map<Integer, Node> map;
    Node head;
    Node tail;
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }else{
            Node node = map.get(key);
            removeNode(node);
            addToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addToHead(node);
            return;
        }
        if(map.size() >= cap){
            map.remove(tail.prev.key);
            removeNode(tail.prev);

        }
        Node node = new Node(key, value);
        addToHead(node);
        map.put(key, node);
    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
    }

}
