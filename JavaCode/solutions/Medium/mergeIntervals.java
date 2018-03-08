/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0)
            return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval travel = intervals.get(0);
        if (intervals.size() == 1) {
            result.add(travel);
            return result;
        }

        for (int i = 1; i < intervals.size(); i++) {
            Interval temp = intervals.get(i);
            if (temp.end < travel.start || temp.start > travel.end) {
                result.add(travel);
                travel = temp;
            } else {
                travel.start = Math.min(travel.start, temp.start);
                travel.end = Math.max(travel.end, temp.end);
            }
        }
        result.add(travel);
        return result;
    }
}