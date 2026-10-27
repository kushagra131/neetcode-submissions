class LinkedList {

    class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = new Node(-1);
        this.tail = this.head;
    }

    public int get(int index) {
        Node currNode = head.next;
        int i = 0;
        while (currNode != null) {
            if (i == index) {
                return currNode.value;
            }
            currNode = currNode.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
    }

    public boolean remove(int index) {
        int i = 0;
        Node currNode = head;
        while (i < index && currNode != null) {
            currNode = currNode.next;
            i++;
        }
        if (currNode != null && currNode.next != null) {
            if (currNode.next == tail) {
                tail = currNode;
            }
            currNode.next = currNode.next.next;
            return true;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> values = new ArrayList<>();
        Node currNode = head.next;
        while (currNode != null) {
            values.add(currNode.value);
            currNode = currNode.next;
        }
        return values;
    }
}