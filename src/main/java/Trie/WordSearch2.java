package Trie;

import org.junit.Assert;

import javax.print.DocFlavor;
import java.util.*;

public class WordSearch2 {
    public static void main(String[] args){
       /* PrefixTree_WordSearch2 prefixTree = new PrefixTree_WordSearch2();
        prefixTree.insert("dog");
        prefixTree.insert("do");
        prefixTree.insert("cat");
        prefixTree.insert("back");
        prefixTree.insert("backend");
        Assert.assertTrue(prefixTree.isPrefix("dog"));    // return true
        Assert.assertTrue(prefixTree.isPrefix("do"));
        Assert.assertTrue(prefixTree.isPrefix("back"));// return true
        Assert.assertTrue(prefixTree.isPrefix("backend")); // return true
        Assert.assertFalse(prefixTree.isPrefix("dogs"));
        Assert.assertFalse(prefixTree.isWord("dogs"));
        Assert.assertTrue(prefixTree.isWord("back"));
        Assert.assertFalse(prefixTree.isWord("bac"));*/

        WordSearch2 wordSearch2 = new WordSearch2();
        char[][] board = {
                {'a','b','c','d'},
                {'s','a','a','t'},
                {'a','c','k','e'},
                {'a','c','d','n'}
        };
        char[][] board2 = {
                {'a','b'},
        };
        String[] words = {"bat","cat","back","backend","stack"};
        String[] words2 = {"ab"};
        List<String> result = wordSearch2.findWords(board2, words2);
        System.out.println(result.toString());
    }

    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree_WordSearch2 prefixTree = new PrefixTree_WordSearch2();
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> result = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        buildPrefixTree(prefixTree, words);
        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col ++){
                if(prefixTree.isPrefix(String.valueOf(board[row][col]))){
                    //System.out.println("print for row and col "+ row +" "+ col);
                    //printVisited(visited);
                    findWordsHelper(board, visited, row, col, prefixTree, result, stringBuilder.append(board[row][col]));
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                }
                //System.out.println();
            }
        }
        return new ArrayList<>(result);
    }



    private void findWordsHelper(char[][] board, boolean[][] visited, int row, int col,
                                 PrefixTree_WordSearch2 prefixTree, Set<String> result, StringBuilder word) {
        visited[row][col] = true;
        //System.out.println("word is " + word);
        if(prefixTree.isWord(word.toString())){
            //System.out.println("word found "+ word.toString());
            result.add(word.toString());
        }
        if(isValid(row+1, col, visited) && prefixTree.isPrefix(word.toString())){
            findWordsHelper(board, visited, row+1, col, prefixTree, result, word.append(board[row+1][col]));
            word.deleteCharAt(word.length() - 1);
        }
        if(isValid(row-1, col, visited) && prefixTree.isPrefix(word.toString())){
            findWordsHelper(board, visited, row-1, col, prefixTree, result, word.append(board[row-1][col]));
            word.deleteCharAt(word.length() - 1);
        }
        if(isValid(row, col+1, visited) && prefixTree.isPrefix(word.toString())){
            findWordsHelper(board, visited, row, col+1, prefixTree, result, word.append(board[row][col+1]));
            word.deleteCharAt(word.length() - 1);
        }
        if(isValid(row, col-1, visited) && prefixTree.isPrefix(word.toString())){
            findWordsHelper(board, visited, row, col-1, prefixTree, result, word.append(board[row][col-1]));
            word.deleteCharAt(word.length() - 1);
        }
        visited[row][col] = false;
    }

    private boolean isValid(int row, int col, boolean[][] visited) {
        if(row >= 0 && row < visited.length && col >= 0 && col < visited[0].length && !visited[row][col]){
            return true;
        }
        return false;
    }

    private void printVisited(boolean[][] visited) {
        for(int i = 0 ; i < visited.length; i ++){
            System.out.println(Arrays.toString(visited[i]));
        }
    }

    private void buildPrefixTree(PrefixTree_WordSearch2 prefixTree, String[] words) {
        for(int i = 0; i < words.length; i ++){
            prefixTree.insert(words[i]);
        }
    }
}

class PrefixTree_WordSearch2 {
    TrieNode2 root;

    public PrefixTree_WordSearch2() {
        root = new TrieNode2('0');
    }

    public void insert(String word) {
        TrieNode2 current = root;
        for(char c : word.toCharArray()){
            if(current.children[c-'a'] != null){
                current = current.children[c-'a'];
            }else{
                TrieNode2 newNode = new TrieNode2(c);
                current.children[c-'a'] = newNode;
                current = newNode;
            }
        }
        current.isEnd = true;
    }

    public boolean isPrefix(String word) {
        TrieNode2 current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a'] != null){
                current = current.children[c-'a'];
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isWord(String word) {
        TrieNode2 current = root;
        for(char c: word.toCharArray()){
            if(current.children[c-'a'] != null){
                current = current.children[c-'a'];
            }else{
                return false;
            }
        }
        return current.isEnd;
    }
}

class TrieNode2 {
    char value;
    boolean isEnd;
    TrieNode2[] children;

    public TrieNode2(char value) {
        this.value = value;
        children = new TrieNode2[26];
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public TrieNode2[] getChildren() {
        return children;
    }

    public void setChildren(TrieNode2[] children) {
        this.children = children;
    }
}
