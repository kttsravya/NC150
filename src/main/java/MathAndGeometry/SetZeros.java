package MathAndGeometry;

public class SetZeros {
    public static void main(String[] args){

    }

    public void setZeroes(int[][] matrix) {
        int rowZero = -1;
        for(int row = 0; row < matrix.length; row ++){
            for (int col = 0; col < matrix[row].length; col ++){
                if(matrix[row][col] == 0){
                    matrix[0][col] = 0;
                    if(row > 0){
                        matrix[row][0] = 0;
                    }else{
                        rowZero = 0;
                    }
                }
            }
        }

        for(int col = 1; col < matrix[0].length; col ++){
           if(matrix[0][col] == 0){
               for(int row = 1; row < matrix.length; row ++){
                   matrix[row][col] = 0;
               }
           }
        }

        for(int row = 1; row < matrix.length; row ++){
            if(matrix[row][0] == 0){
                for(int col = 0; col < matrix[0].length; col ++){
                    matrix[row][col] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int row = 0; row < matrix.length; row ++){
                matrix[row][0] = 0;
            }
        }

        if(rowZero == 0){
            for(int col = 0; col < matrix[0].length; col ++){
                matrix[0][col] = 0;
            }
        }
    }
}
