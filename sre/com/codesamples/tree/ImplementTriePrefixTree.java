class TrieNode {
    private TrieNode[] letters;
    private boolean isEnd;
    private static final int SIZE = 26;
    
    public TrieNode() {
        letters = new TrieNode[SIZE];
        isEnd = false;
    }
    
    public TrieNode get(char ch) {
        return letters[ch -'a'];
    }
    
    public void put(char ch, TrieNode node) {
        letters[ch -'a'] = node;
    }
    
    public void setEnd() {
        isEnd = true;
    }
    
    public boolean isEnd() {
        return isEnd;
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        int length = word.length();
        for(int i=0; i<length; i++) {
            char ch = word.charAt(i);
            if(node.get(ch) != null) {
                node = node.get(ch);
            }
            else {
                TrieNode addedNode = new TrieNode();
                node.put(ch, addedNode);
                node = addedNode;
            }
        }
        node.setEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        int length = word.length();
        for(int i=0; i<length; i++) {
            char ch = word.charAt(i);
            if(node.get(ch) == null) {
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int length = prefix.length();
        for(int i=0; i<length; i++) {
            char ch = prefix.charAt(i);
            if(node.get(ch) == null) {
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}
