package MathAndGeometry;

import java.util.Arrays;

public class RotateMatrix {
    public static void main(String[] args) {
     /*   int[][] matrix = {
                {2, 29, 20, 26, 16, 28},
                {12, 27, 9, 25, 13, 21},
                {32, 33, 32, 2, 28, 14},
                {13, 14, 32, 27, 22, 26},
                {33, 1, 20, 7, 21, 7},
                {4, 24, 1, 6, 32, 34}
        };*/
        int[][] matrix = {
                {1, 2,3,9},
                {4, 5, 6, 10},
                {7, 8, 9, 11},
                {12, 13, 14, 15}
        };
        RotateMatrix rotateMatrix = new RotateMatrix();
        rotateMatrix.rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public void rotate(int[][] matrix) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while ((left < right) && (top < bottom)) {
            int positionFromLeft = 0;
            while (left + positionFromLeft < right) {
                // save the topLeft
                int temp = matrix[top][left + positionFromLeft];
                // move bottom left into top left
                matrix[top][left + positionFromLeft] = matrix[bottom - positionFromLeft][left];
                // move bottom right into bottom left
                matrix[bottom - positionFromLeft][left] = matrix[bottom][right - positionFromLeft];
                // move top right into bottom right
                matrix[bottom][right - positionFromLeft] = matrix[top + positionFromLeft][right];
                // move top left into top right
                matrix[top + positionFromLeft][right] = temp;
                positionFromLeft++;
            }
            top++;
            bottom--;
            left++;
            right--;
        }
    }
}
