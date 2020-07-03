package node;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sandesh Mendan on 03/07/20
 * @project algorithms-and-datastructures
 */
public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean endOfWord;

    public TrieNode(){
        children = new HashMap<>();
        endOfWord = false;
    }
}
