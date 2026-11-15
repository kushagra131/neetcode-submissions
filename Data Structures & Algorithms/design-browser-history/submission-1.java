class BrowserHistory {

    static class Node {
        private Node prev, next;
        private String url;

        public Node() { }
        public Node(String url) { this.url = url; }
    }

    private int size;
    private Node head, tail, curr;
    private Node homepageNode;
    
    public BrowserHistory(String homepage) {
        head = new Node(); // Dummy Sentinel Node
        tail = new Node(); // Dummy Sentinel Node
        homepageNode = new Node(homepage);
        head.next = homepageNode;
        homepageNode.prev = head; 
        homepageNode.next = tail;
        tail.prev = homepageNode;
        curr = homepageNode;
        size = 1;
    }
    // Add as the Tail / Last Node to mimic Stack push().
    // [head]-[neetcode.com]-[google.com]-[facebook.com]-[youtube.com]-[linkedin.com]-[tail]
    public void visit(String url) {
        Node node = new Node(url);
        // curr.next = null; // Clears all the forward nodes/history
        // tail.prev = null; // Unlinks the stale Tail prev ref
        curr.next = node; // Sets the Fresh new Visited Node
        node.prev = curr;
        node.next = tail;
        tail.prev = node;
        curr = node;
        size++;
    }

    // // [head]-[neetcode.com]-[google.com]-[facebook.com]-[youtube.com]-[linkedin.com]-[tail]
    public String back(int steps) {
        while(steps > 0 && curr.prev != head) {
            curr = curr.prev;
            steps--;
        }
        return curr.url;
    }

    // // [head]-[neetcode.com]-[google.com]-[facebook.com]-[youtube.com]-[linkedin.com]-[tail]
    public String forward(int steps) {
        int x = (steps > size - 1) ? size : steps;
        while(steps > 0 && curr.next != tail) {
            curr = curr.next;
            steps--;
        }
        return curr.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */