class LinkedList {
    private Node head;
    private Node tail;

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; } 
    }

    public LinkedList() {
        head = null;
        tail = null;
    }

    // [1]-[2]-[3]-[0]
    // [1]-[2]-[3]-[0]-[ ]
    public int get(int index) {
        Node curr = head;
        for(int i = 0; curr != null; i++, curr = curr.next)
            if(i == index) return curr.value;
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        // Handle empty list.
        if(head == null)
            head = newNode;
        // Handle non-empty list.
        else {
            newNode.next = head;
            head = newNode;
        }
        // Handle head and tail for list with 1 element.
        if(head.next == null)
            tail = newNode;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        // Handle empty list.
        if(head == null && tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // [1]-[2]-[3]-[0]
    // [1]-[2]-[3]-[0]-[ ]
    // [6]-[2]-[3]-[4]-[7]
    public boolean remove(int index) {
        Node curr = head;
        Node prev = curr;
        for(int i = 0; i < index && curr != null; i++) {
            prev = curr;
            curr = curr.next;
        }
        // Handle Edge Case for Null/Empty list.
        if(curr == null) return false;
        // Handle 1 or more elements.
        if(curr != null) {
            if(index == 0) {
                if(curr.next == null) {
                    head = null;
                    tail = null;
                    return true;
                } else {
                    head = head.next;
                    return true;
                }
            }
            prev.next = prev.next.next;
            if(prev.next == null)
                tail = prev;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        for(Node curr = head; curr != null; curr = curr.next)
            values.add(curr.value);
        return values;
    }
}