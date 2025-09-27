package BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args){
        Search2DMatrix search2DMatrix = new Search2DMatrix();
        boolean isFound = search2DMatrix.searchMatrixRev(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}}, 1);
        System.out.println(isFound);
    }

    public boolean searchMatrixRev(int[][] matrix, int target){
       int low = 0;
       int high = matrix[0].length * matrix.length;
       int row = 0;
       int col = 0;
       while(low <= high){
           System.out.println("low and high is "+ low + " "+ high);
           int mid = (low + high)/2;
           System.out.println("mid is "+ mid);
           row = (mid/matrix[0].length);
           col = (mid % matrix[0].length);
           if(col == 0 && row > 0){
               row = row - 1;
               col = matrix[0].length - 1;
           }else if (mid == matrix[0].length){
               col = matrix[0].length - 1;
           }else if (col > 0){
               col = col - 1;
           }
           System.out.println("row and col is "+ row + " "+ col);
           if(matrix[row][col] == target){
               return true;
           }else if(matrix[row][col] < target){
               System.out.println(matrix[row][col] + " is less than target"+ target);
               low = mid + 1;
           }else{
               System.out.println(matrix[row][col] + " is greater than target"+ target);
               high = mid - 1;
           }
       }
       return false;
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
