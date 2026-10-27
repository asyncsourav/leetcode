class Solution {
    public String simplifyPath(String path) {
        
        Deque<String> stack = new ArrayDeque<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            
            if (part.isEmpty() || part.equals("."))
                continue;

            if (part.equals("..")) {
                if (!stack.isEmpty()) 
                    stack.pop();
            } else 
                stack.push(part);
        }

        StringBuilder str = new StringBuilder();
        Iterator<String> it = stack.descendingIterator();

        while (it.hasNext()) {
            str.append("/").append(it.next());
        }

        return str.length() == 0 ? 
                "/" : 
                str.toString();
    }
}