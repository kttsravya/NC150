package Trie;

import org.junit.Assert;

import java.util.HashMap;

public class PrefixTree {
    TrieNode root;

    public PrefixTree(){
        root = new TrieNode();
    }

    public void insert(String word) {
       if(word.isEmpty()){
           return;
       }
       TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children.get(word.charAt(i)) == null) {
                TrieNode createdNode = new TrieNode();
                current.children.put(word.charAt(i), createdNode);
                current = createdNode;
            } else {
                current = current.children.get(word.charAt(i));
            }
        }
        current.isWord = true;
    }

    public boolean search(String word){
        if(word.isEmpty()){
            return true;
        }
        TrieNode current = root;
        for(int i = 0; i < word.length(); i ++){
            if(current.children.get(word.charAt(i)) == null){
                return false;
            }
            current = current.children.get(word.charAt(i));
        }
        if(current.isWord){
            return true;
        }
        return false;
    }

    public boolean startsWith(String word){
        TrieNode current = root;
        for(int i = 0; i < word.length(); i ++){
            if(current.children.get(word.charAt(i)) == null){
                return false;
            }
            current = current.children.get(word.charAt(i));
        }
        return true;
    }

    public static void main(String[] args){
      PrefixTree prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        Assert.assertTrue(prefixTree.search("dog"));    // return true
        Assert.assertFalse(prefixTree.search("do"));;     // return false
        Assert.assertTrue(prefixTree.startsWith("do")); // return true
        prefixTree.insert("do");
        Assert.assertTrue(prefixTree.search("do"));     // return true
    }

}


class TrieNode {
    char value;
    HashMap<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
    }

    public void setTrieNode(char value){
        this.value = value;
    }
}
