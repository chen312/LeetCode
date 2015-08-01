package leetcode;

import java.util.HashMap;

/**
 * @author Sunshine
 */

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class Max_Points_on_a_Line {
    // Time complexity is O(n^3)
    public int maxPoints(Point[] points) {
        if (points.length <= 2)
            return points.length;
        if (allSame(points))
            return points.length;
        int max = 0;
        for (int i = 0; i < points.length; i++){
            for (int j = i+1; j < points.length; j++){
                if (points[i].x == points[j].x && points[i].y == points[j].y)
                    continue;
                int cur = 2;
                for (int k = 0; k < points.length; k++){
                    if (k != i && k != j && (points[i].x - points[j].x) * (points[j].y - points[k].y) == 
                            (points[j].x - points[k].x) * (points[i].y - points[j].y))
                        cur++;
                }
                max = Math.max(max, cur);
            }
        }
        return max;
    }
    
    public boolean allSame(Point[] points){
        for (int i = 1; i < points.length; i++){
            if (points[0].x != points[i].x || points[0].y != points[i].y)
                return false;
        }
        return true;
    }
    
    // Time complexity is O(n^2)
    public int maxPoints2(Point[] points) {
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();
         if (points.length <= 2)
            return points.length;
         int max = 0;
         double ratio = 0.0;
         for (int i = 0; i < points.length; i++){
             map.clear();
             int same = 0;
             int count = 0;
             
             for (int j = i+1; j < points.length; j++){
                 if (points[i].x == points[j].x && points[i].y == points[j].y){
                     same++;
                     continue;
                 }
                 if (points[i].x == points[j].x){
                     ratio = (double) Integer.MAX_VALUE;
                 }
                 else if (points[i].y == points[j].y){
                     ratio = 0.0;
                 }
                 else{
                     ratio = (double)(points[j].y - points[i].y) / (double) (points[j].x - points[i].x);
                 }
                 if (map.containsKey(ratio))
                     count = map.get(ratio)+1;
                 else{
                     count = 2;
                 }
                 map.put(ratio, count);
             }
             count = 1;
             for (Integer value : map.values()){
                 count = Math.max(count, value);
             }
             max = Math.max(max, count+same);
         }
         return max;
    }
    
    public static void main(String[] args) {
        Max_Points_on_a_Line test = new Max_Points_on_a_Line();
        Point p1 = new Point(1, 1);
        Point p2 = new Point(1, 1);
        Point p3 = new Point(1, 1);
        Point points[] = {p1, p2, p3};
        System.out.println(test.maxPoints2(points));
    }
}
