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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();

        for(Interval interval: intervals){
            // new interval is behind cur interval
            if(interval.end < newInterval.start){
                result.add(interval);
            }else if(interval.start > newInterval.end){
                // cur interval is behind new interval
                result.add(newInterval);
                newInterval = interval;
            }else if(interval.end >= newInterval.start || interval.start <= newInterval.end){
                // merge the current interval with new interval as new interval
                newInterval = new Interval(Math.min(interval.start, newInterval.start),
                        Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
        return result;
    }
}