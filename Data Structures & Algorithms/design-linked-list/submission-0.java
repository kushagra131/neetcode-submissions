class MyLinkedList {

    // Singly LinkedList Implementation
    static class Node {
        private int val;
        private Node next;

        public Node(){}
        
        public Node(int val) { this.val = val; }
    }

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        Node curr = head;
        for(int i = 0; curr != null; i++, curr = curr.next)
            if(i == index) return curr.val;
        return -1;
    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        // Handle edge case
        if(index < 0 || index > size) return;

        Node newNode = new Node(val);
        // Handle addAtHead(val)
        if(index == 0) {
            if(head == null) {
                head = newNode;
                tail = head;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
            return;
        }
        // Handle addAtTail(val)
        if(index == size) {
            if(tail == null) {
                tail = newNode;
                head = tail;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
            return;
        }
        // Handle anywhere else
        // [1]-[2]-[3]-[4]
        Node curr = head;
        Node prev = null;
        for(int i = 0; i < index; i++, curr = curr.next)
            prev = curr;
        prev.next = newNode;
        newNode.next = curr;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        // Handle head
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }
        // Handle anywhere else
        // [1]-[2]-[3]-[4]
        Node curr = head;
        Node prev = null;
        for(int i = 0; i < index && curr != null; i++, curr = curr.next)
            prev = curr;
        // Handle tail
        if(curr.next == null) {
            prev.next = null;
            tail = prev;
        } else {
            prev.next = curr.next;
        }
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