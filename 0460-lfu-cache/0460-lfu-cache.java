import java.util.*;

class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value){
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLL {
        Node head, tail;
        int size;

        DLL(){
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        void add(Node node){
            Node temp = head.next;
            head.next = node;
            node.prev = head;
            node.next = temp;
            temp.prev = node;
            size++;
        }

        void remove(Node node){
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLast(){
            if(size > 0){
                Node node = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int capacity, minFreq;
    HashMap<Integer, Node> map;
    HashMap<Integer, DLL> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {

        if(capacity == 0) return;

        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            update(node);
        } else {

            if(map.size() == capacity){
                DLL list = freqMap.get(minFreq);
                Node nodeToRemove = list.removeLast();
                map.remove(nodeToRemove.key);
            }

            Node node = new Node(key, value);
            minFreq = 1;

            DLL list = freqMap.getOrDefault(1, new DLL());
            list.add(node);
            freqMap.put(1, list);

            map.put(key, node);
        }
    }

    private void update(Node node){

        int freq = node.freq;
        DLL list = freqMap.get(freq);
        list.remove(node);

        if(freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;

        DLL newList = freqMap.getOrDefault(node.freq, new DLL());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */