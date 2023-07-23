class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class TrieNode {
    TrieNode[] children;
    boolean isEnd;

    TrieNode() {
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Trie {
    TrieNode root;
 
    public Trie() {
        root = new TrieNode();
    }
 
    public void insert(String word) {
        TrieNode cur = root;
        for (char x : word.toCharArray()) {
            if (cur.children[x - 'a'] == null) {
                cur.children[x - 'a'] = new TrieNode();
            }
            cur = cur.children[x - 'a'];
        }
        cur.isEnd = true;
    }
}
