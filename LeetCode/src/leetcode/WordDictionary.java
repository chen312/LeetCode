package leetcode;

/**
 * @author Sunshine
 */
public class WordDictionary {
    
    private TrieNode root;
    
    public WordDictionary() {
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        if (word.length() == 0)
            return;
        
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            int pos = word.charAt(i) - 'a';
            if (node.child[pos] == null){
                node.child[pos] = new TrieNode();
                node.child[pos].val = word.charAt(i);
            }
            node = node.child[pos];
        }
        node.isEnd = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(root, word);
    }
    
    public boolean helper(TrieNode root, String word){
        if ((word.length() == 0 || word == ".") && root.isEnd)
            return true;
        
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++){
            if (word.charAt(i) != '.'){
                int pos = word.charAt(i) - 'a';
                if (node.child[pos] == null)
                    return false;
                node = node.child[pos];
            }
            else{
                boolean result = false;
                for (int j = 0; j < 26; j++){
                    if (node.child[j] != null)
                        result |= helper(root.child[j], word.substring(i+1));
                }
                return result;
            }
        }
        if (node.isEnd)
            return true;
        else
            return false;
    }
    
    public static void main(String[] args) {
        WordDictionary test = new WordDictionary();
        test.addWord("bad");
        System.out.println(test.search("b."));
    }
}
