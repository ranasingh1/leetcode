class Solution {
 public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.') { 
                    for (char num = '1'; num <= '9'; num++) { 
                        if (isSafe(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) { 
                                return true;
                            }
                            board[row][col] = '.'; 
                        }
                    }
                    return false; 
                }
            }
        }
        return true; 
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) { 
                return false;
            }
        }
        // Check the 3x3 sub-box
        int boxRowStart = (row / 3) * 3;
        int boxColStart = (col / 3) * 3;
        for (int r = boxRowStart; r < boxRowStart + 3; r++) {
            for (int c = boxColStart; c < boxColStart + 3; c++) {
                if (board[r][c] == num) {
                    return false;
                }
            }
        }
        return true; // The number can be placed safely
    }
}