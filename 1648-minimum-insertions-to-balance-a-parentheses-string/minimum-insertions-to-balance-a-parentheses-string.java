
class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int insertions = 0; 
        int i = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(ch);
            } else { // ch == ')'
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++; 
                } else {
                    insertions++; 
                }

                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    insertions++; 
                }
            }
            i++;
        }

        insertions += 2 * stack.size();

        return insertions;
    }
}
