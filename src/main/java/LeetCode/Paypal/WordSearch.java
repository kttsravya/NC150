package LeetCode.Paypal;

public class WordSearch {
    public static void main(String[] args){
        WordSearch wordSearch = new WordSearch();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'}, {'A','D','E','E'} };
        System.out.println(wordSearch.exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                if(board[i][j] == word.charAt(0)){
                    int index = 0;
                    if(existHelper(i, j, board, index, word, visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean existHelper(int row, int col, char[][] board, int index, String word, boolean[][] visited) {
        if(index == word.length()){
            return true;
        }
        if(!isValid(row, col, visited)){
            return false;
        }
        if(board[row][col] == word.charAt(index)){
            visited[row][col] = true;
               if(existHelper(row+1, col, board, index+1, word, visited)){
                   return true;
               }
                if(existHelper(row - 1, col, board, index + 1, word, visited)){
                    return true;
                }
                if(existHelper(row , col+1, board, index + 1, word, visited)){
                    return true;
                }
               if(existHelper(row, col-1, board, index+1, word, visited)){
                   return true;
               }
            visited[row][col] = false;
        }
        return false;
    }

    private boolean isValid(int row, int col, boolean[][] visited) {
        if(row < 0 || row >= visited.length || col < 0 || col >= visited[0].length || visited[row][col] == true){
            return false;
        }
        return true;
    }


}
