// Doubly Linked List Implementation
class MyLinkedList {

    static class Node {
        private int val;
        private Node prev;
        private Node next;

        public Node() {}
        public Node(int val) {
            this.val = val;
        }
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
        // Handle Edge case
        if(index < 0 || index > size) return;
        Node newNode = new Node(val);
        // Handle addAtHead()
        if(index == 0) {
            // Handle empty list
            if(head == null && tail == null) {
                head = newNode;
                tail = head;
            } else {
                newNode.next = head;
                head.prev = newNode;
                head = newNode;
            }
            size++;
            return;
        }
        // [0]-[1]-[2]-[3]-[4]-[]
        // [1]-[2]-[3]
        Node curr = head;
        for(int i = 0; i < index && curr != null; i++)
            curr = curr.next;
        // Handle Tail
        if(curr == null) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
            if(head.next == null)
                head = tail;
            size++;
            return;
        }
        curr.prev.next = newNode;
        newNode.prev = curr.prev;
        newNode.next = curr;
        curr.prev = newNode;
        size++;
    }
    // [0]-[1]-[2]-[3]-[4]
    public void deleteAtIndex(int index) {
        // Handle Edge case
        if(index < 0 || index >= size)
            return;
        if(head == null && tail == null)
            return;
        // Handle Head
        if(index == 0) {
            // Handle 1 element
            if(head.next == null) {
                head = null;
                tail = null;
            }
            head = head.next;
            head.prev = null;
            size--;
            return;
        }
        // [0]-[1]-[2]-[3]-[4]
        // [1]-[2]-[3]
        Node curr = head;
        for(int i = 0; i < index && curr != null; i++)
            curr = curr.next;
            // Handle Tail
        if(curr.next == null) {
            tail = curr.prev;
            tail.next = curr.next;
            if(head.next == null)
                head = tail;
            size--;
            return;
        }
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
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