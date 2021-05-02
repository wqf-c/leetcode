package Hot100;

/**
 * @author wqf
 * @date 2021/4/13 0:12
 * @Email:284660487@qq.com
 */
public class Trie {

    public class TrieNode {
        TrieNode children[] = new TrieNode[26];
        public boolean isLast;
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root;
        for(char c : charArray){
            if(p.children[c - 'a'] == null){
                TrieNode child = new TrieNode();
                p.children[c - 'a'] = child;
                p = child;
            }else{
                p = p.children[c - 'a'];
            }
        }
        p.isLast = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] charArray = word.toCharArray();
        TrieNode p = root;
        for(char c : charArray){
            if(p.children[c - 'a'] == null){
                return false;
            }else{
                p = p.children[c - 'a'];
            }
        }
        return p.isLast;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] charArray = prefix.toCharArray();
        TrieNode p = root;
        for(char c : charArray){
            if(p.children[c - 'a'] == null){
                return false;
            }else{
                p = p.children[c - 'a'];
            }
        }
        return true;
    }
}
