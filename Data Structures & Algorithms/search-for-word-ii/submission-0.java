
class Solution {

    public class TrieNode {
        public Map<Character, TrieNode> children;
        public String word;

        public TrieNode() {
            this.children = new HashMap<>();
            this.word = null;
        }
    }

    public List<String> result = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        int m = board.length;
        int n = board[0].length;

            for(int row = 0; row < m; row++) {
                for(int col = 0; col < n; col++) {
                search(board, row, col, root);
            }
            }
        return result;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for(String word: words) {
            TrieNode node = root;

            for(char c: word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.word = word;
        }
        return root;
    }

    private void search(char[][] board, int row, int col, TrieNode parent) {

        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return;
        }

        char c = board[row][col];

        if(c == '#' || !parent.children.containsKey(c)) {
            return;
        }

        TrieNode currNode = parent.children.get(c);
        if(currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }

        board[row][col] = '#';

        search(board, row + 1, col, currNode);
        search(board, row - 1, col, currNode);
        search(board, row, col + 1, currNode);
        search(board, row, col - 1, currNode);

        board[row][col] = c;

        if(currNode.children.isEmpty()) {
            parent.children.remove(c);
        }
    }
}

