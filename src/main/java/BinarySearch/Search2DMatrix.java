package BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args){
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean isFound = search2DMatrix.searchMatrix(new int[][]{{1,2,4,8},{10,11,12,13},{14,20,30,40}}, 15);
        System.out.println(isFound);
    }
    public boolean searchMatrix(int[][] matrix, int target){
        int lowRow = 0;
        int lowCol = 0;
        int highRow = matrix.length - 1;
        int highCol = matrix[lowRow].length - 1;

        while (isValidPosition(lowRow, lowCol, matrix) &&
               isValidPosition(highRow, highCol, matrix) &&
                (lowRow <= highRow)){
            int midLow = (lowRow + highRow)/2;
            int midHigh = (lowCol + highCol)/2;
            if(matrix[midLow][midHigh] == target){
                return true;
            }
            if(matrix[midLow][midHigh] < target){
                if(lowCol < matrix[0].length - 1){
                    lowCol = lowCol + 1;
                }else{
                    lowRow = lowRow + 1;
                    lowCol = 0;
                }
            }else {
                if(highCol > 0){
                    highCol = highCol - 1;
                }else{
                    highRow = highRow - 1;
                    highCol = matrix[0].length - 1;
                }
            }
        }
        return false;
    }

    private boolean isValidPosition(int row, int col, int[][] matrix) {
        if(row >=0 && row < matrix.length &&
                (col >= 0 && col < matrix[0].length)){
            return true;
        }
        return false;
    }

}
