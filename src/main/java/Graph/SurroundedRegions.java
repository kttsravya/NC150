package Graph;

import java.util.Arrays;

public class SurroundedRegions {
    public static void main(String[] args){
        SurroundedRegions surroundedRegions = new SurroundedRegions();
        char[][] board={{'X','X','X','X'},{'X','O','O','X'},{'X','O','O','X'},{'X','X','X','O'}};

        surroundedRegions.solve(board);

        for(int i = 0; i < board.length; i ++){
            System.out.println(Arrays.toString(board[i]));
        }
    }

    public void solve(char[][] board) {
        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col ++){
                if(board[row][col] == 'O' &&
                        (row == 0 || col == 0 || row == board.length - 1 || col == board[row].length - 1)){
                    solveHelper(row, col, board);
                }
            }
        }
        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col ++){
                if(board[row][col] == 'O'){
                    board[row][col] = 'X';
                }
            }
        }

        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col ++){
                if(board[row][col] == 'T'){
                    board[row][col] = 'O';
                }
            }
        }
    }

    private void solveHelper(int row, int col, char[][] board) {
        if(row < 0 || col < 0 || row == board.length || col == board[row].length || board[row][col] != 'O'){
            return;
        }
        board[row][col] = 'T';
        solveHelper(row+1, col, board);
        solveHelper(row-1, col, board);
        solveHelper(row, col+1, board);
        solveHelper(row, col-1, board);
    }

}
