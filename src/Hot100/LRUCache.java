package Hot100;

import java.util.HashMap;

/**
 * @author wqf
 * @date 2021/4/8 20:21
 * @Email:284660487@qq.com
 */
public class LRUCache {

    class Node{
        Node prev;
        Node next;
        int val;
        int key;
        Node(int _val, int _key){
            val = _val;
            key = _key;
        }
    }

    private HashMap<Integer, Node> map;
    private int mapCapacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        mapCapacity = capacity;
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
            addNodeToHead(node);
            return node.val;
        }
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            removeNode(node);
            addNodeToHead(node);
            return;
        }
        if(map.size() >= mapCapacity){
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
        Node node = new Node(value, key);
        addNodeToHead(node);
        map.put(key, node);
    }

    void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    void addNodeToHead(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }




}
