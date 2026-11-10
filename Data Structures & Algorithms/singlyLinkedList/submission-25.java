class LinkedList {

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

    public LinkedList() { 
        head = null;
        tail = null;
    }

    public int get(int index) {
        Node curr = head;
        for(int i = 0; curr != null; i++, curr = curr.next)
            if(i == index) return curr.val;
        return -1;
    }

    public void insertHead(int val) {
        Node node = new Node(val);
        if(head == null && tail == null) {
            head = node;
            tail = head;
            return;
        }
        node.next = head;
        head = node;
        if(head.next == null) tail = head;
    }

    // [1]-[2]
    public void insertTail(int val) {
        Node node = new Node(val);
        if(tail == null && head == null) {
            tail = node;
            head = tail;
            return;
        }
        tail.next = node;
        tail = node;
        if(head == null) head = tail;
    }

    // [0]-[1]-[2]-[3]
    public boolean remove(int index) {
        // Handle Empty List.
        if(head == null & tail == null) return false;
        // Handle at Head.
        if(index == 0) {
            // Handle 1 element.
            if(head.next == null) {
                head = null;
                tail = null;
                return true;
            }
            head = head.next;
            // Handle 2 elements.
            if(head.next == null)
                tail = head;
            return true;
        }

        Node curr = head;
        Node prev = null;
        for(int i = 0; i < index && curr != null; i++, curr = curr.next)
            prev = curr;
        // Handle OOB Index.    
        if(curr == null) 
            return false;
        prev.next = prev.next.next;
        if(prev.next == null) tail = prev;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for(Node curr = head; curr != null; curr = curr.next)
            values.add((Integer) curr.val);
        
        return values;
    }
}
