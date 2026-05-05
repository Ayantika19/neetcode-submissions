class Solution {
    private int rows, columns;
    public boolean exist(char[][] board, String word) {
        rows = board.length;
        columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int row, int column, int start) {
        if (start == word.length())
            return true;
        if (row < 0 || column < 0 || column >= columns || row >= rows
            || board[row][column] != word.charAt(start) || board[row][column] == '#') {
            return false;
        }
        board[row][column] = '#';
        boolean result = dfs(board, word, row + 1, column, start + 1)
            || dfs(board, word, row - 1, column, start + 1)
            || dfs(board, word, row, column + 1, start + 1)
            || dfs(board, word, row, column - 1, start + 1);
        board[row][column] = word.charAt(start);
        return result;
    }
}
