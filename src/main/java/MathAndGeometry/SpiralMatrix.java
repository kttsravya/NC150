package MathAndGeometry;

import java.util.ArrayList;
import java.util.List;
// leet-code editorial
public class SpiralMatrix {
    public static void main(String[] args) {
        SpiralMatrix matrix = new SpiralMatrix();
        List<Integer> res = matrix.spiralOrder(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}});
        System.out.println(res.toString());
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if(top != bottom){
                for (int j = right - 1; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
            }
            if(left != right){
                for (int i = bottom - 1; i > top; i--) {
                    result.add(matrix[i][left]);
                }
            }

            top++;
            left++;
            bottom--;
            right--;
            System.out.println();
        }
        return result;
    }
}
