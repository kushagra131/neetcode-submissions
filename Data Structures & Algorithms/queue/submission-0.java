class Deque {
    static class Node {
        private int val;
        private Node next;
        private Node prev;

        public Node() {}
        public Node(int val) {
            this.val = val;
        }
    }
    private Node head, tail;
    private int size;

    public Deque() {
        head = new Node(); // Dummy Sentinel Head;
        tail = new Node(); // Dummy Sentinel Tail;
        size = 0;
    }

    public boolean isEmpty() {
        return (size > 0) ? false : true;
    }

    public void append(int value) {
        Node node = new Node(value);
        if (head.next == null && tail.prev == null) {
            head.next = node;
            node.prev = head;
            node.next = tail;
            tail.prev = node;
        } else {
            Node prev = tail.prev;
            prev.next = node;
            node.prev = prev;
            node.next = tail;
            tail.prev = node;
        }
        size++;
    }

    public void appendleft(int value) {
        Node node = new Node(value);
        if (head.next == null && tail.prev == null) {
            head.next = node;
            node.prev = head;
            node.next = tail;
            tail.prev = node;
        } else {
            Node next = head.next;
            head.next = node;
            node.prev = head;
            node.next = next;
            next.prev = node;
        }
        size++;
    }

    public int pop() {
        if (size == 0)
            return -1;
        Node popped = tail.prev;
        popped.prev.next = tail;
        tail.prev = popped.prev;
        size--;
        return popped.val;
    }

    public int popleft() {
        if(size == 0)
            return -1;
        Node popped = head.next;
        head.next = popped.next;
        popped.next.prev = head;
        size--;
        return popped.val;
    }
}
