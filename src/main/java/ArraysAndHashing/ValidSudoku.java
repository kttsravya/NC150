package ArraysAndHashing;

import java.util.*;

public class ValidSudoku {
    public static void main(String[] args){
        ValidSudoku validSudoku = new ValidSudoku();
        String[][] board = new String[][]{
                {"1","2",".",".","3",".",".",".","."},
                {"4","7",".","5",".",".",".",".","."},
                {".","9","7",".",".",".",".",".","3"},
                {"5",".",".",".","6",".",".",".","4"},
                {".",".",".","8",".","3",".",".","5"},
                {"7",".",".",".","2",".",".",".","6"},
                {".",".",".",".",".",".","2",".","."},
                {".",".",".","4","1","9",".",".","8"},
                {".",".",".",".","8",".",".","7","9"}};
       /*boolean isValid = validSudoku.isValidSudokuShortCode(board);
        System.out.println(isValid);*/
    }

    public boolean isValidSudokuShortCode(char[][] board) {
        HashMap<Integer, Set<Character>> rowMap = new HashMap<>();
        HashMap<Integer, Set<Character>> colMap = new HashMap<>();
        HashMap<List<Integer>, Set<Character>> cubeMap = new HashMap<>();

        for(int row = 0; row < board.length; row ++){
            for(int col = 0; col < board[row].length; col ++){
                if(isDigit(board[row][col])){
                    char c = board[row][col];
                    List<Integer> mapKey = Arrays.asList(row/3, col/3);
                    if(rowMap.getOrDefault(row, new HashSet<>()).contains(c) ||
                            colMap.getOrDefault(col, new HashSet<>()).contains(c) ||
                            cubeMap.getOrDefault(mapKey, new HashSet<>()).contains(c)){
                        return false;
                    }
                    rowMap.computeIfAbsent(row, k -> new HashSet<>()).add(c);
                    colMap.computeIfAbsent(col, k -> new HashSet<>()).add(c);
                    cubeMap.computeIfAbsent(mapKey, k -> new HashSet<>()).add(c);
                }
            }
        }
        return true;
    }
        public boolean isValidSudoku(char[][] board) {
        // check validity of each row
        for(int row = 0; row < board.length; row ++){
            Set<Character> rowSet = new HashSet<>();
            for(int col = 0; col < board[row].length; col ++){
                if(isDigit(board[row][col])){
                    if(! rowSet.contains(board[row][col])){
                        rowSet.add(board[row][col]);
                    }else{
                        return false;
                    }
                }
            }
        }

        // check validity of each column
        for(int col = 0; col < board[0].length; col ++){
            Set<Character> colSet = new HashSet<>();
            for(int row = 0; row < board.length; row ++){
                if(isDigit(board[row][col])){
                    if(! colSet.contains(board[row][col])){
                        colSet.add(board[row][col]);
                    }else{
                        return false;
                    }
                }
            }
        }

        // check validity for each cube
        for(int row = 0; row < board.length; row = row + 3){
            for (int col = 0; col < board[row].length; col = col + 3){
                System.out.println("row and col is "+ row + " "+ col);
                if(! checkValidityForCube(row, col, board)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkValidityForCube(int rowIndex, int colIndex, char[][] board) {
        Set<Character> cubeSet = new HashSet<>();
        for (int row = rowIndex; row < rowIndex+3; row ++){
            for(int col = colIndex; col < colIndex + 3; col ++){
                System.out.println("cube row and col is "+ row + " "+ col);
                if(isDigit(board[row][col])){
                    if(! cubeSet.contains(board[row][col])){
                        cubeSet.add(board[row][col]);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean isDigit(char c) {
        if(c != '.'){
            return true;
        }
        return false;
    }

    private boolean isDigit(String c) {
        if(! c.equals(".")){
            return true;
        }
        return false;
    }
}
