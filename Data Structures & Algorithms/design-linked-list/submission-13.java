class MyLinkedList {

    static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node() { }
        public Node(int val) {
            this.val = val;
        }
    }
    
    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = new Node(); // dummy
        tail = new Node(); // dummy
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // [head]-[0]-[1]-[2]-[3]-[tail]
    public Node getNode(int index) {
        Node curr = (index < size / 2) ? head.next : tail.prev;
        if(index < size / 2) {
            for(int i = 0; i < index; i++)
                curr = curr.next;
        } else {
            for(int i = 0; i < size - 1 - index; i++)
                curr = curr.prev;
        }
        return curr;
    }
    // [head]-[0]-[1]-[2]-[3]-[tail]
    public Node getPrevFor(int index) {
        Node curr = (index < size / 2) ? head : tail;
        if(index < size / 2) {
            for(int i = 0; i < index; i++)
                curr = curr.next;
        } else {
            for(int i = 0; i < size - index + 1; i++)
                curr = curr.prev;
        }
        return curr;
    }
    
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        return getNode(index).val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // [head]-[0]-[1]-[2]-[3]-[tail]
    public void addAtIndex(int index, int val) {
        // Handle Edge case
        if(index < 0 || index > size) return;

        Node node = new Node(val);
        Node prev = getPrevFor(index);
        Node next = prev.next;
        prev.next = node;
        node.prev = prev;
        node.next = next;
        next.prev = node;
        size++;
    }
    // [head]-[0]-[1]-[2]-[3]-[tail]
    public void deleteAtIndex(int index) {
        // Handle Edge case
        if(index < 0 | index >= size) return;

        Node prev = getPrevFor(index);
        Node curr = prev.next;
        prev.next = curr.next;
        curr.next.prev = prev;
        curr = null;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */