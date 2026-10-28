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
        Node currNode = head;
        for(int i = 0; currNode != null; i++, currNode = currNode.next)
            if(i == index) return currNode.value;
        return -1;
        // int i = 0;
        // while(i < index && currNode != null) {
        //     currNode = currNode.next;
        //     i++;
        // }
        // return (currNode == null) ? -1 : currNode.value;
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
    public boolean remove(int index) {
        // Handle Edge Case for Null/Empty List.
        if(head == null)
            return false;
        // Handle at index = 0 with 1 element.
        if(index == 0 && head.next == null) {
            head = null;
            tail = null;
            return true;
        }
        // Handle at index = 0 with 2 or more elements.
        if(index == 0 && head.next != null) {
            head = head.next;
            return true;
        }
        
        Node currNode = head;
        Node prevNode = null;
        int i = 0;
        // Handle element in between the List.
        while(i < index && currNode != null) {
            prevNode = currNode;
            currNode = currNode.next;
            i++;
        }
        if(currNode == null) return false;
        if(i == index && currNode != null) {
            prevNode.next = prevNode.next.next;
            currNode = null;
            if(prevNode.next == null)
                tail = prevNode;
        }
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node currNode = head;
        ArrayList<Integer> values = new ArrayList<>();
        int i = 0;
        while(currNode != null) {
            values.add(currNode.value);
            currNode = currNode.next;
            i++;
        }
        return values;
    }
}