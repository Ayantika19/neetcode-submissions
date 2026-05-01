class Solution {
    List<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, root, r, c, words);
            }
        }
        return result;
    }
    private void dfs(char[][] board, TrieNode root, int r, int c, String[] words) {
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] == '*'
            || root.children[board[r][c] - 'a'] == null) {
            return;
        }
        char temp = board[r][c];
        board[r][c] = '*';
        TrieNode prev = root;
        root = root.children[temp - 'a'];
        if (root.idx != -1) {
            result.add(words[root.idx]);
            root.idx = -1;
            root.refs--;
            if (root.refs == 0) {
                root = null;
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }
        dfs(board, root, r + 1, c, words);
        dfs(board, root, r - 1, c, words);
        dfs(board, root, r, c + 1, words);
        dfs(board, root, r, c - 1, words);

        board[r][c] = temp;
    }
    public class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int idx = -1;
        int refs = 0;
        public void addWord(String word, int i) {
            TrieNode current = this;
            current.refs++;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (current.children[index] == null)
                    current.children[index] = new TrieNode();
                current = current.children[index];
                current.refs++;
            }
            current.idx = i;
        }
    }
}
