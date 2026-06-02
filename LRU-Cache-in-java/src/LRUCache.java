import java.util.*;
 class LRUCache {
    private final int capacity;
    private final Map<String, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.map = new HashMap<>();

        // Dummy head and tail nodes to avoid null checks
        this.head = new Node("", 0);
        this.tail = new Node("", 0);
        head.next = tail;
        tail.prev = head;
    }

    // ---- Helper: Remove a node from the doubly linked list ----
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    // ---- Helper: Add node right after head (most recent position) ----
    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Get value by key — returns null if not found
    private Integer getValue(String key){
        if(!map.containsKey(key)) return null;

        Node node = map.get(key);

        // Move to front (most recently used)
        removeNode(node);
        addToFront(node);
        return node.value;
    }

    // Insert or update key-value pair
    private void insertKeyValue(String key, int value){
        if(map.containsKey(key)){
            // Update existing node
            Node node = map.get(key);
            node.value = value;

            // Move to front
            removeNode(node);
            addToFront(node);
        } else {
            if(capacity <= map.size()){
                // Evict LRU — node just before tail
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            // Insert new node at front
            Node newNode = new Node(key, value);
            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    // Returns the most recently used key
    private String mostRecentKey(){
        if(head.next == tail) return null;
        return head.next.key;
    }

    // setFunction
    public void set(String key, int value){
        insertKeyValue(key, value);
    }

    // getfunction
    public Integer get(String key){
        return getValue(key);
    }
    public String getMostRecentKey(){
       return mostRecentKey();
    }


}
