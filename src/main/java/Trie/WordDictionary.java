package Trie;


import org.junit.Assert;

public class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        if (word.isEmpty()) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            if (current.children.get(word.charAt(i)) == null) {
                TrieNode createdNode = new TrieNode();
                createdNode.setTrieNode(word.charAt(i));
                current.children.put(word.charAt(i), createdNode);
                current = createdNode;
            } else {
                current = current.children.get(word.charAt(i));
            }
        }
        current.isWord = true;

    }

    public boolean search(String word) {
        int index = 0;
        TrieNode current = root;
        boolean isPresent = searchHelper(word, index, current);
        return isPresent;
    }

    private boolean searchHelper(String word, int index, TrieNode current) {
        if (index == word.length()) {
            if (current.isWord) {
                return true;
            } else {
                return false;
            }
        }
        char c = word.charAt(index);
        System.out.println("chracter at index " + c + " and word is " + word + "and current is " + current.value);
        if (c != '.') {
            current = current.children.get(c);
            if (current == null) {
                return false;
            }
            if (searchHelper(word, index + 1, current)) {
                return true;
            }
            ;
        } else {
            System.out.println("Inside c=='.' for index " + index + "and current is " + current.isWord);// if c == . (wild character)
            for (TrieNode child : current.children.values()) {
                System.out.println("inside for each loop");
                if (child != null) {
                    if (searchHelper(word, index + 1, child)) {
                        return true;
                    }
                    ;
                }
            }
        }
        return false;
    }

    public boolean searchRev(String word) {
        int index = 0;
        TrieNode current = root;
        boolean isPresent = searchHelperRev(word, index, current);
        return isPresent;
    }

    private boolean searchHelperRev(String word, int index, TrieNode current) {
        if(index == word.length()){
            return current.isWord;
        }

        if(word.charAt(index) != '.'){
            if(! current.children.containsKey(word.charAt(index))){
                return false;
            }else{
                return searchHelperRev(word, index+1, current.children.get(word.charAt(index)));
            }
        }
        if(word.charAt(index) == '.'){
            for(TrieNode child : current.children.values()){
                if(child != null){
                    if(searchHelperRev(word, index+1, child)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("day");
        wordDictionary.addWord("bay");
        wordDictionary.addWord("may");
        Assert.assertFalse(wordDictionary.searchRev("say")); // return false
        Assert.assertTrue(wordDictionary.searchRev("day"));
        ; // return true
        Assert.assertTrue(wordDictionary.searchRev(".ay")); // return true
        Assert.assertTrue(wordDictionary.searchRev("b..")); // return true
    }
}

