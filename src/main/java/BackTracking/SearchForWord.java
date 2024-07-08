package BackTracking;

import java.util.Arrays;

public class SearchForWord {
    public static void main(String[] args){
        SearchForWord searchForWord = new SearchForWord();
        boolean isExists = searchForWord.exist(new char[][]{{'C','A','A'}, {'A','A','A'}, {'B','C','D'}}, "AAB");
        System.out.println(isExists);
    }
    public boolean exist(char[][] board, String word){
        for(int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if(board[i][j] == word.charAt(0)){
                   int[][] visited =  new int[board.length][board[0].length];
                   visited[i][j] = 1;
                   boolean isExist = existsHelper(board, word, 1, i, j, visited);
                   if(isExist){
                       return true;
                   }
                }
            }
        }
        return false;
    }

    public boolean existsHelper(char[][] board, String word, int index, int posX, int posY, int[][] visited){
        if(index == word.length()){
            return true;
        }
        // important thing to note: setting visited[posX][posY] to one and resetting it to 0 once we are returning
        // from current node.
        visited[posX][posY] = 1;
        if(isValidPosition(posX -1, posY,visited) && (word.charAt(index) == board[posX - 1][posY]))
        {
            if(existsHelper(board, word, index + 1, posX - 1, posY, visited)){
                return true;
            }
        }

        if(isValidPosition(posX +1, posY,visited) && word.charAt(index) == board[posX + 1][posY]){
            if(existsHelper(board, word, index + 1, posX + 1, posY, visited)){
                return true;
            }
        }


        if(isValidPosition(posX, posY - 1,visited) && word.charAt(index) == board[posX][posY - 1]){
            if(existsHelper(board, word, index + 1, posX, posY - 1, visited)){
                return true;
            }
        }

        if(isValidPosition(posX, posY + 1,visited) && word.charAt(index) == board[posX][posY + 1]){
         /*   int[][] visitedCopy = getCopyOfVisited(visited);
            visitedCopy[posX][posY + 1] = 1;*/
            if(existsHelper(board, word, index + 1, posX, posY + 1, visited)){
                return true;
            }
        }
        visited[posX][posY] = 0;
        return false;
    }

    private void printVisited(int[][] visited) {
        for(int i = 0; i < visited.length; i ++){
            for(int j = 0; j < visited[i].length; j ++){
                System.out.print(visited[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    private int[][] getCopyOfVisited(int[][] visited) {
        int[][] copy = new int[visited.length][visited[0].length];
        for(int i = 0; i < visited.length; i ++){
            copy[i] = Arrays.copyOf(visited[i], visited[i].length);
        }
        return copy;
    }

    private boolean isValidPosition(int posX, int posY, int[][] visited) {
        if(posX < 0 || posX >= visited.length || posY < 0 || posY >= visited[0].length || visited[posX][posY] == 1){
            return false;
        }
        return true;
    }
}
