package leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Sunshine
 */
public class Merge_Intervals {
    
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
    
    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<Interval>();
        int i,j;
        if (intervals.size() == 0)
            return result;
        // We need use Comparator to sort the input List
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        };
        Collections.sort(intervals, comp);
        result.add(new Interval(intervals.get(0).start, intervals.get(0).end));
        for (i = 1; i < intervals.size(); i++){
            Interval item = intervals.get(i);
            Interval current = result.get(result.size()-1);
            if (current.end >= item.start)
                current.end = Math.max(current.end, item.end);
            else
                result.add(new Interval(item.start, item.end));
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(5, 6));
        //intervals.add(new Interval(6, 7));
        //intervals.add(new Interval(8, 9));
        //intervals.add(new Interval(1, 10));
        System.out.println(merge(intervals));
    }
}
