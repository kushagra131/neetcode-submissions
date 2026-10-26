class Solution {
    private Stack<Integer> stack = new Stack<>();

    public int calPoints(String[] operations) {
        // Read the list of operations as Strings -> Iterate over the Strings array.
        // IF a 'DIGIT', then convert the String to Integer and push(element) to stack.
        // IF an operation '+', then pop 2 times, store both values, sum them and push all three.
        // IF a character 'C', then invalidate the top element = pop().
        // IF a character 'D', then peek, multiply by 2 and push the new element.

        for(String op : operations) {
            // Edge case
            if(op.isBlank() || op.isEmpty())
                return -1;
            // handle '+'
            if(op.equals("+")) {
                int popped_top = stack.pop();
                int curr_top = stack.peek();
                int new_top = popped_top + curr_top;
                stack.push(popped_top);
                stack.push(new_top);
            }
            // handle 'C'
            else if(op.equals("C"))
                stack.pop();
            // handle 'D'
            else if(op.equals("D"))
                stack.push(stack.peek() * 2);
            // handle 'Digits'
            else
                stack.push(Integer.parseInt(op));
            
        }
        return stack.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
    }
}