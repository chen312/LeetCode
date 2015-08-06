package leetcode;

/**
 * @author Sunshine
 */

class TrieNode {
    // Initialize your data structure here.
    TrieNode[] child;
    boolean isEnd;
    char val;
        
    public TrieNode() {
        child = new TrieNode[26];
        isEnd = false;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if (word.length() == 0)
            return;
        
        TrieNode node = root;
        char letters[] = word.toCharArray();
        for (int i = 0; i < letters.length; i++){
            int pos = letters[i] - 'a';
            if (node.child[pos] == null){
                node.child[pos] = new TrieNode();
                node.child[pos].val = letters[i];
            }
            node = node.child[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if (word.length() == 0)
            return false;
        
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if (node.child[pos] == null)
                return false;
            else{
                node = node.child[pos];
            }
        }
        if (node.isEnd)
            return true;
        else
            return false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if (prefix.length() == 0)
            return false;
        
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++){
            int pos = prefix.charAt(i) - 'a';
            if (node.child[pos] == null)
                return false;
            else{
                node = node.child[pos];
            }
        }
        return true;
    }
}
