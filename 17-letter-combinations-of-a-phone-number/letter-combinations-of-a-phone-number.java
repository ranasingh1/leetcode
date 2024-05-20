class Solution {

private static final String[] KEYPAD = {
        "",     // 0 (no mapping)
        "",     // 1 (no mapping)
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
            if(digits.isEmpty()){
   return new ArrayList<>();
}
            List<String> list = new ArrayList<>();

            list=solve("", digits);
return list;
      }


         
    



 private static List<String> solve(String ans, String ip) {
        // Base case: if the input string is empty, return the accumulated answer
        if (ip.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(ans);
            return list;
        }

        int digit = ip.charAt(0) - '0';
        String letters = KEYPAD[digit];  // Retrieve the corresponding letters

        ArrayList<String> list = new ArrayList<>();
        // Recursive case: append each letter and call solve on the remaining string
        for (char ch : letters.toCharArray()) {
            list.addAll(solve(ans + ch, ip.substring(1)));
        }

        return list;
    }
        
    

}