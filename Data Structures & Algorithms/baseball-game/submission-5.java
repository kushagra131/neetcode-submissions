class Solution {
    public int calPoints(String[] operations) {
        // Read the list of operations as Strings -> Iterate over the Strings array.
        // IF a 'DIGIT', then convert the String to Integer and push(element) to stack.
        // IF an operation '+', then pop 2 times, store both values, sum them and push all three.
        // IF a character 'C', then invalidate the top element = pop().
        // IF a character 'D', then peek, multiply by 2 and push the new element.

        Deque<Integer> stack = new ArrayDeque<>();
        for(String op : operations) {
            // Edge case
            if(op.isBlank() || op.isEmpty())
                return -1;

            switch(op) {
                case "+" -> {
                    int top = stack.pop();
                    int newTop = top + stack.peek();
                    stack.push(top);
                    stack.push(newTop);
                }
                case "C" -> stack.pop();
                case "D" -> stack.push(2 * stack.peek());
                default -> stack.push(Integer.parseInt(op));
            }
        }
        return stack.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
    }
}