class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();
        for(char c : characters) {
            if(c == '(')
                stack.push(')');
            else if(c == '{')
                stack.push('}');
            else if(c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();    
    }
}
