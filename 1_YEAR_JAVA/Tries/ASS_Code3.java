import java.util.ArrayList;
import java.util.List;
 
class TrieNode {
    TrieNode[] children;
    boolean isEnd;
 
    public TrieNode() {
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
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.isEnd = true;
    }
 
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        return curr.isEnd;
    }
}
 
class MagicDictionary {
    Trie root;
 
    public MagicDictionary() {
        root = new Trie();
    }
 
    public void buildDict(List<String> dictionary) {
        for (String word : dictionary) {
            root.insert(word);
        }
    }
 
    public boolean search(String word) {
        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < 26; j++) {
                char c = word.charAt(i);
                if (c == (char)(j + 'a')) {
                    continue;
                }
                char[] chars = word.toCharArray();
                chars[i] = (char)(j + 'a');
                String modifiedWord = new String(chars);
                if (root.search(modifiedWord)) {
                    return true;
                }
            }
        }
        return false;
    }
}
 
public class Main {
    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        List<String> dictionary = new ArrayList<>();
        dictionary.add("hello");
        dictionary.add("leetcode");
        magicDictionary.buildDict(dictionary);
        System.out.println(magicDictionary.search("hello")); // false
        System.out.println(magicDictionary.search("hhllo")); // true
        System.out.println(magicDictionary.search("hell")); // false
    }
}