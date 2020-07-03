package trie;

/**
 * @author Sandesh Mendan on 03/07/20
 * @project algorithms-and-datastructures
 */
public class TrieMain {
    public static void main(String[] args) {
        Trie t  =new Trie();

        t.insert("bcde");   //CASE#1#insertion
        t.insert("bckg");   //CASE#2#insertion
        t.delete("bcde");   //CASE#1#deletion
        t.search("bcde");
        t.search("bckg");


        t.insert("bcde");
		t.insert("bcdefg"); //CASE#3#insertion
		t.delete("bcde");   //CASE#2#deletion
		t.search("bcde");
		t.search("bcdefg");


		t.insert("bcde");
		t.insert("bc");
		t.delete("bcde");   //CASE#3#deletion
		t.search("bcde");
		t.search("bc");
		t.search("b");


		t.insert("bcde");
		t.delete("bcde");   //CASE#4#deletion
		t.search("bcde");

    }
}
