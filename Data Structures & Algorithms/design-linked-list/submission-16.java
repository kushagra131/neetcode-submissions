// Singly Linked List with Dummy Sentinel Nodes.
class MyLinkedList {

    static class Node {
        private int val;
        private Node next;

        public Node() { }
        public Node(int val) {
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = new Node(); // dummy
        tail = head;
        size = 0;
    }

    // [head]-[0]-[1]-[2]-[3]-[tail]
    private Node getPrevFor(int index) {
        Node prev = head;
        for(int i = 0; i < index; i++)
            prev = prev.next;
        return prev;
    }

    // [head]-[0]-[1]-[2]-[3]-[tail]
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        return getPrevFor(index).next.val;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    // [head]-[0]-[1]-[2]-[3]-[tail]
    public void addAtIndex(int index, int val) {
        if(index < 0 || index > size) return;

        Node prev = getPrevFor(index);
        Node curr = prev.next;
        Node node = new Node(val);
        
        prev.next = node;
        node.next = curr;
        size++;
    }
    
    // [head]-[0]-[1]-[2]-[3]-[tail]
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;

        Node prev = getPrevFor(index);
        Node curr = prev.next;
        
        prev.next = curr.next;
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