class Solution {
     public int numTilePossibilities(String tiles) {
        Set<String> result = new HashSet<>();
        boolean[] visited = new boolean[tiles.length()];
        backtrack(tiles, "", visited, result);
        return result.size();
    }

    private void backtrack(String tiles, String current, boolean[] visited, Set<String> result) {
        if (!current.isEmpty()) {
            result.add(current);
        }
        for (int i = 0; i < tiles.length(); i++) {
            if (visited[i]) continue;
            // Pick the tile
            visited[i] = true;
            backtrack(tiles, current + tiles.charAt(i), visited, result);
            // Un-pick the tile (backtrack)
            visited[i] = false;
        }
    }}