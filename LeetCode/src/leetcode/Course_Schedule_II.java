package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sunshine
 */
public class Course_Schedule_II {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int map[] = new int[numCourses];
        int result[] = new int[numCourses];
        int pos = 0;
        
        for (int i = 0; i < prerequisites.length; i++)
            map[prerequisites[i][0]]++;
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++)
            if (map[i] == 0)
                queue.add(i);
        
        while (!queue.isEmpty()){
            int cur = queue.remove();
            result[pos] = cur;
            pos++;
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][1] == cur){
                    int to = prerequisites[i][0];
                    map[to]--;
                    if (map[to] == 0)
                        queue.add(to);
                }
            }
        }
        if (pos == numCourses)
            return result;
        return new int[0];
    }
}
