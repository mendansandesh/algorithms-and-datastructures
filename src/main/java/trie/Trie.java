package trie;

import node.TrieNode;

/**
 * @author Sandesh Mendan on 03/07/20
 * @project algorithms-and-datastructures
 */
public class Trie {
    private final TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String word) {
        /* INSERT cases:
        CASE#1  Trie is blank (air)
        CASE#2  String to be inserted (aio), its prefix is common with another existing Strings prefix
        CASE#3  String to be inserted (airk), its prefix is already exists as a complete String
        CASE#4  String to be inserted (air) is already exists in the Trie
         */
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                node = new TrieNode();
                current.children.put(ch, node);
            }
            current = node;
        }
        current.endOfWord = true;
        System.out.println("dione");
    }

    public boolean search(String word) {
        if(root == null){
            System.out.println("Empty root; word not exist!");
            return false;
        }
        TrieNode current = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if(node == null){
                System.out.println("Word not exist!");
                return false;
            }
            current = node;
        }
        System.out.println("Word exist!");
        return true;
    }

    public void delete(String word) {
        /* DELETE cases: examples in the form of (wordToBeDeleted, otherWord)
        // CASE#1 Some other word's prefix is same as Prefix of this word (BCDE, BCKG)
		// CASE#2 We are at last character of this word and This word is a Prefix of some other word (BCDE, BCDEFG)
		// CASE#3 Some other word is a Prefix of this word (BCDE, BC)
		// CASE#4 No one is dependent on this Word (BCDE, BCDE)
         */
        if(search(word))
            delete(root, word, 0);
    }

    private boolean delete(TrieNode parentNode, String word, int index) {
        char ch = word.charAt(index);
        TrieNode currentNode = parentNode.children.get(ch);
        boolean canBeDeleted;
        //Note: return true => as it returned to its parent node, indicating that current node(child node) is good for deletion
        if(currentNode.children.size() > 1){
            System.out.println("CASE#1..");
            delete(currentNode, word, index + 1);
            return false;
        }
        if(index == word.length()-1){
            System.out.println("CASE#2..");
            if(currentNode.children.size() >= 1){ //some word exists after this point
                currentNode.endOfWord = false;
                return false;
            }else { //this itself is the end of word; return true notifying parent to delete current node
                System.out.println("Character " + ch + " has no dependency, hence deleting it from last");
                parentNode.children.remove(ch);
                return true;
            }
        }
        if(currentNode.endOfWord){
            System.out.println("Entering CASE#3");
            delete(currentNode, word, index + 1);
            return false;
        }

        canBeDeleted = delete(currentNode, word, index + 1);
        if (canBeDeleted) {
            System.out.println("Character " + ch + " has no dependency, hence deleting it");
            parentNode.children.remove(ch);
            return true; // Current node can also be deleted
        } else
            return false; // Someone is dependent on this node, hence dont delete it

    }
}
