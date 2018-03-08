package facebook.phone.AprilJune.NearestKth;

import java.util.Random;

public class Solution {

    public Point findNearestKthPoint(Point[] points, int k){
        if(k > points.length || k == 0){
            throw new IllegalArgumentException("K's value is invaild.\n");
        }
        return quickSelect(points, 0, points.length - 1, k - 1);
    }

    private Point quickSelect(Point[] points, int left, int right, int k) {
        Random rand = new Random();
        int pivotIndex = 0;
        if(right != 0){
            pivotIndex = rand.nextInt(right) % (right -left + 1) + left;
        }
        pivotIndex = partition(pivotIndex, points, left, right);
        if (pivotIndex == k) {
            return points[k];
        } else if (pivotIndex > k) {
            return quickSelect(points, left, pivotIndex - 1, k);
        } else {
            return quickSelect(points, pivotIndex + 1, right, k);
        }
    }

    private int partition(int pivotIndex, Point[] points, int left, int right) {
        int i = left;
        int j = right;
        Point temp = points[pivotIndex];
        int tempDistance = distance(temp);
        swap(points, left, pivotIndex);
        while (i < j) {
            while (j > i && distance(points[j]) >= tempDistance) {
                j--;
            }
            points[i] = points[j];
            while (j > i && distance(points[i]) <= tempDistance) {
                i++;
            }
            points[j] = points[i];
        }
        points[i] = temp;
        return i;
    }

    private void swap(Point[] points, int left, int pivotIndex) {
        Point temp = points[left];
        points[left] = points[pivotIndex];
        points[pivotIndex] = temp;
    }

    private int distance(Point point) {
        return point.x * point.x + point.y * point.y;
    }

}
