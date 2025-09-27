package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> result = nQueens.solveNQueens(4);
        for(int i = 0; i < result.size(); i ++){
             System.out.println(result.get(i).toString());
        }
    }

    public List<List<String>> solveNQueens(int n) {
        int boardSize = n;
        String[][] board = new String[n][n];
        prefillBoard(board, ".");
        List<int[]> currentPath = new ArrayList<>();
        int row = 0;
        List<List<String>> result = new ArrayList<>();
        solveNQueensHelper(boardSize, board, currentPath, row, result);
        return result;
    }

    private void prefillBoard(String[][] board, String s) {
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j ++){
                board[i][j] = s;
            }
        }
    }

    private void solveNQueensHelper(int boardSize, String[][] board, List<int[]> currentPath, int row, List<List<String>> result) {
        if(row == boardSize){
            List<String> currentRow = new ArrayList<>();
            addBoardToList(board, currentRow);
            result.add(currentRow);
            return;
        }

        String[] currentRow = Arrays.copyOf(board[row], board.length);
        for(int col = 0; col < board.length; col ++){
            if(isValid(row, col, currentPath)){
                currentPath.add(new int[]{row, col});
                currentRow[col] = "Q";
                board[row] = currentRow;
                solveNQueensHelper(boardSize, board, currentPath, row+1, result);
                currentPath.remove(currentPath.size() - 1);
                currentRow[col] = ".";
            }
        }
    }

    private void addBoardToList(String[][] board, List<String> currentRow) {
        for(int i = 0; i < board.length; i ++){
            String[] boardRow = board[i];
            StringBuilder currentRowString = new StringBuilder();
            for(int j = 0; j < boardRow.length; j ++){
                currentRowString.append(board[i][j]);
            }
            currentRow.add(currentRowString.toString());
        }
    }

    private boolean isValid(int row, int col, List<int[]> currentPath) {
        int k = 1;
        for(int i = currentPath.size() - 1; i >= 0; i --){
            int[] prev = currentPath.get(i);
            // vertical collision
            if(col == prev[1]){
                return false;
            }
            // diagonal collision
            if(row == prev[0] + k && (col == prev[1]+ k || col == prev[1]-k)){
                return false;
            }
            k ++;
        }
        return true;
    }
}
