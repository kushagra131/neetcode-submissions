// Singly Linked List Implementation
class MyLinkedList {
    static class Node {
        private int val;
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
        // Edge Case
        if (head == null & tail == null)
            return -1;
        Node curr = head;
        for (int i = 0; curr != null; i++, curr = curr.next)
            if (i == index)
                return curr.val;
        return -1;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    // [0]-[1]-[2]-[3]-[4]
    public void addAtIndex(int index, int val) {
        // Handle Edge Case
        if (index < 0 || index > size)
            return;
        Node newNode = new Node(val);
        // Handle addAtHead()
        if (index == 0) {
            if (head == null && tail == null) {
                head = newNode;
                tail = head;
            } else {
                newNode.next = head;
                head = newNode;
            }
            size++;
            return;
        }
        // [0]-[1]-[2]-[3]-[4]-[]
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < index; i++, curr = curr.next) {
            if (curr == null)
                return;
            prev = curr;
        }
        prev.next = newNode;
        newNode.next = curr;
        // Handle Tail
        if (newNode.next == null)
            tail = newNode;
        size++;
    }

    // [0]-[1]-[2]-[3]
    public void deleteAtIndex(int index) {
        // Handle Edge Cases
        if (index < 0 || index >= size)
            return;
        if (head == null && tail == null)
            return;
        // Handle the Head
        if (index == 0) {
            // Handle 1 element
            if (head.next == null) {
                head = null;
                tail = null;
            } else
                head = head.next;
            if (head.next == null)
                tail = head;
            size--;
            return;
        }
        // [0]-[1]-[2]-[3]-[4]
        Node curr = head;
        Node prev = null;
        for (int i = 0; i < index; i++, curr = curr.next) {
            // Handle Index OOB
            if (curr == null)
                return;
            prev = curr;
        }
        prev.next = prev.next.next;
        // Handle the Tail
        if (prev.next == null)
            tail = prev;
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