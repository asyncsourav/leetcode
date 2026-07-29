class Solution {
    public int longestValidParentheses(String s) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } 

            else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    ans = Math.max(ans, (i - stack.peek()));
                }
            }
        }

        return ans;
    }
}