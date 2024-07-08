class Solution{

    private int index = 0;

    public String decodeString(String s) {
        StringBuilder result = new StringBuilder();
        while (index < s.length()) {
            char currentChar = s.charAt(index);

            if (Character.isDigit(currentChar)) {
                int repeatCount = 0;
                // Build the repeat count number
                while (Character.isDigit(s.charAt(index))) {
                    repeatCount = repeatCount * 10 + (s.charAt(index) - '0');
                    index++;
                }

                // Skip the opening bracket '['
                index++;
                String decodedString = decodeString(s);
                // Repeat the decoded string and append to result
                for (int i = 0; i < repeatCount; i++) {
                    result.append(decodedString);
                }

            } else if (currentChar == ']') {
                // End of the current recursive call
                index++;
                return result.toString();

            } else {
                // Append the current character to the result
                result.append(currentChar);
                index++;
            }
        }

        return result.toString();
    }
}
