package HeapsAndPriorityQueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin {
    public static void main(String[] args) {
        KClosestPointsToOrigin kthClosest = new KClosestPointsToOrigin();
        int[][] input = new int[][]{{0, 2}, {2, 0}, {2, 2}};
        int[][] result = kthClosest.kClosest(input, 2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        int originX = 0;
        int originY = 0;
        int[][] result = new int[k][];
        PriorityQueue<double[]> minHeap = new PriorityQueue<>(new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                Double d = Double.valueOf(o1[2]);
                Double d1 = Double.valueOf(o2[2]);
                return Double.compare(d, d1);
            }
        });
        for (int i = 0; i < points.length; i++) {
            int targetX = points[i][0];
            int targetY = points[i][1];
            double euclideanDistance = Math.sqrt(Math.pow((originX - targetX), (double) 2) +
                    Math.pow((originY - targetY), (double) 2));
            double[] pointDistance = new double[3];
            for (int j = 0; j < points[i].length; j++) {
                pointDistance[j] = points[i][j];
            }
            pointDistance[2] = euclideanDistance;
            minHeap.add(pointDistance);
        }
        int i = 0;
        while (i < k) {
            double[] minElement = minHeap.poll();
            int[] currentElement = new int[2];
            if (minElement != null) {
                currentElement[0] = (int) minElement[0];
                currentElement[1] = (int) minElement[1];
            }
            result[i] = currentElement;
            i++;
        }
        return result;
    }

}
