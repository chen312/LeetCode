package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sunshine
 */
public class Insert_Interval {
    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }

        @Override
        public String toString() {
            return "["+ start + "," + end + "]";
        }
    }
    
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        if (intervals.size() == 0){
            result.add(newInterval);
            return result;
        }
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start){
            result.add(intervals.get(i));
            i++;
        }
        if (i < intervals.size()){
            newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
        }
        result.add(newInterval);
        while (i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            i++;
        }
        while (i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(2, 5));
        intervals.add(new Interval(6, 7));
        intervals.add(new Interval(8, 9));
        //intervals.add(new Interval(8, 9));
        Interval newInterval = new Interval(0, 1);
        System.out.println(insert(intervals, newInterval));
    }
}
