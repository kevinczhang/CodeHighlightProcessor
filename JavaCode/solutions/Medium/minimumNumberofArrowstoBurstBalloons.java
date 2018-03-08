public class Solution {
    /***

     Idea:
     We know that eventually we have to shoot down every balloon, so for each ballon
     there must be an arrow whose position is between balloon[0] and balloon[1].
     Given that, we can sort the array of balloons by their ending position.
     Then we make sure that while we take care of each balloon from the beginning,
     we can shoot as many following balloons as possible.

     So what position should we pick? We should shoot as right as possible,
     because all balloons' end position is to the right of the current one.
     Therefore the position should be currentBalloon[1],
     because we still need to shoot down the current one.

     This is exactly what I do in the for loop:
     check how many balloons I can shoot down with one shot aiming at
     the ending position of the current balloon.
     Then I skip all these balloons and start again from the next one
     (or the leftmost remaining one) that needs another arrow.

     ***/
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return a[0] - b[0];
            }
        });

        int minArrows = 1;
        int arrowLimit = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int[] baloon = points[i];
            if (baloon[0] <= arrowLimit) {
                arrowLimit = Math.min(arrowLimit, baloon[1]);
            } else {
                minArrows++;
                arrowLimit = baloon[1];
            }
        }
        return minArrows;
    }
}