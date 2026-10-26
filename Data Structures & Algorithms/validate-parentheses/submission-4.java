class Solution {
    public boolean isValid(String s) {
        // Convert the String into character array and iterate over the array
        // Or Iterate over the String uisng charAt(index) till String length-1
        // Create a Map for storing the parenthesis mappings probably in close to open fashion ')' -> '('
        // While iterating, check if the parenthesis is open or closed
        // 1. if open then push to stack
        // 2. if close then pop and compare -> popped character == map.get(String.charAt(index))
        // IF true then continue till the last string character
        // At the end, check if stack is empty -> if yes then Valid Parenthesis

        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        int index = 0;
        while(index < s.length()) {
            if(s.charAt(index) == ')' || s.charAt(index) == '}' || s.charAt(index) == ']') {
                if(map.get(s.charAt(index)) != stack.peek())
                    return false;
                else stack.pop();
            } else
                stack.push(s.charAt(index));

            index++;
        }
        return (stack.isEmpty()) ? true : false;
    }
}
