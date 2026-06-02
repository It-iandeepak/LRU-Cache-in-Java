class Node {
    // Doubly Linked List Node
    String key;
    int value;
    Node next;
    Node prev;

    public Node(String key, int value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}
