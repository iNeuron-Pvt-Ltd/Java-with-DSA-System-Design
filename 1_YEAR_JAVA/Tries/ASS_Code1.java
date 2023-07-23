import java.util.*;

public class Main{
	static int ALPHABET_SIZE = 26;
	static class TrieNode {
		TrieNode children[] = new TrieNode[ALPHABET_SIZE];
		boolean isEndOfWord;
	}
	static void insert(TrieNode root, String key) {
		TrieNode pCrawl = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				pCrawl.children[index] = new TrieNode();

			pCrawl = pCrawl.children[index];
		}
		pCrawl.isEndOfWord = true;
	}

	static boolean search(TrieNode root, String key) {
		TrieNode pCrawl = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (pCrawl.children[index] == null)
				return false;
			pCrawl = pCrawl.children[index];
		}
		return (pCrawl != null && pCrawl.isEndOfWord);
	}

	static boolean isEmpty(TrieNode root) {
		for (int i = 0; i < ALPHABET_SIZE; i++)
			if (root.children[i] != null)
				return false;
		return true;
	}

	static TrieNode remove(TrieNode root, String key, int depth) {
		if (root == null)
			return null;
		if (depth == key.length()) {
			if (root.isEndOfWord)
				root.isEndOfWord = false;
			if (isEmpty(root)) {
				root = null;
			}
			return root;
		}
		int index = key.charAt(depth) - 'a';
		root.children[index] =
			remove(root.children[index], key, depth + 1);

		if (isEmpty(root) && root.isEndOfWord == false){
			root = null;
		}

		return root;
	}

	public static void main(String args[]) {
		String keys[] = { "pwskills", "dsa", "physics", "physicswallah", "skills", "java", "decode", "padhlebeta" };
		int n = keys.length;

		TrieNode root = new TrieNode();
		for (int i = 0; i < n; i++)
			insert(root, keys[i]);

		if(search(root, "the"))
			System.out.println("Yes");
		else
			System.out.println("No");

		if(search(root, "these"))
			System.out.println("Yes");
		else
			System.out.println("No");

		remove(root, "heroplane", 0);
		
		if(search(root, "hero"))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> children;
    boolean isEndOfWord;

    public TrieNode() {
        children = new HashMap<>();
        isEndOfWord = false;
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
            if (!cur.children.containsKey(x)) {
                cur.children.put(x, new TrieNode());
            }
            cur = cur.children.get(x);
        }
        cur.isEndOfWord = true;
    }

    public void search(String s) {
        TrieNode cur = root;
        for (char x : s.toCharArray()) {
            if (!cur.children.containsKey(x)) {
                cur.isEndOfWord = true;
                break;
            }
            cur = cur.children.get(x);
        }
        cur.isEndOfWord = true;
    }

    public String longestPrefix(String s) {
        TrieNode curr = root;
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (curr.isEndOfWord) {
                return word.toString();
            }
            word.append(s.charAt(i));
            curr = curr.children.get(s.charAt(i));
        }
        return word.toString();
    }
}

public class Main {
    public static String longestCommonPrefix(String[] strs) {
        Trie root = new Trie();
        if (strs.length == 1) {
            return strs[0];
        }
        if (strs.length == 0) {
            return "";
        }
        root.insert(strs[0]);
        for (int i = 1; i < strs.length; i++) {
            root.search(strs[i]);
        }
        return root.longestPrefix(strs[0]);
    }

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }
}
