package leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Sunshine
 */
public class Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int map[] = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++)
            map[prerequisites[i][1]]++;
        
        Queue<Integer> que = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++){
            if (map[i] == 0)
                que.add(i);
        }
        int count = que.size();
        while (!que.isEmpty()){
            int k = que.remove();
            for (int i = 0; i < prerequisites.length; i++){
                if (prerequisites[i][0] == k){
                    int to = prerequisites[i][1];
                    map[to]--;
                    if (map[to] == 0){
                        que.add(to);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
    
    public static void main(String[] args) {
        Course_Schedule test = new Course_Schedule();
        int numCourses = 3;
        int prerequisites[][] = {{1,0}, {2,1}};
        System.out.println(test.canFinish(numCourses, prerequisites));
    }
}
