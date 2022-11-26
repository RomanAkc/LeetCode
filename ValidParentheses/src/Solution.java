import java.util.EmptyStackException;
import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(c == ')' || c == '}' || c == ']') {
                Character peek = null;
                try {
                    peek = stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }

                if(!isCorresponding(peek, c))
                    return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }

    private boolean isCorresponding(char open, char close) {
        return (open == '(' && close == ')')
            || (open == '{' && close == '}')
            || (open == '[' && close == ']');
    }
}
