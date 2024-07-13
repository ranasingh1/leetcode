public class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> uniqueSequences = new HashSet<>();
        generateSequences("", tiles, uniqueSequences);
        return uniqueSequences.size();
    }

    private void generateSequences(String p, String up, Set<String> uniqueSequences) {
        if (!p.isEmpty()) {
            uniqueSequences.add(p);
        }
        for (int i = 0; i < up.length(); i++) {
            generateSequences(p + up.charAt(i), up.substring(0, i) + up.substring(i + 1), uniqueSequences);
        }
    }
}