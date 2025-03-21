class Solution {
      public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length, n = grid[0].length;
        int islandCount = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') { 
                    islandCount++; 
                    queue.offer(new int[]{i, j});
                    grid[i][j] = '0';

                    while (!queue.isEmpty()) {
                        int[] cell = queue.poll();
                        int row = cell[0], col = cell[1];

                        for (int[] dir : directions) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];

                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
                                queue.offer(new int[]{newRow, newCol});
                                grid[newRow][newCol] = '0';
                            }
                        }
                    }
                }
            }
        }
        return islandCount; 
    }

}