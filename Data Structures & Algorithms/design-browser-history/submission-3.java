class BrowserHistory {

    static class Node {
        private Node prev, next;
        private String url;

        public Node() { }
        public Node(String url) { this.url = url; }
    }

    private Node head, tail, curr;
    
    public BrowserHistory(String homepage) {
        head = new Node(); // Dummy Sentinel Node
        tail = new Node(); // Dummy Sentinel Node
        curr = new Node(homepage);
        head.next = curr;
        curr.prev = head; 
        curr.next = tail;
        tail.prev = curr;
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