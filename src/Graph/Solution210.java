package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/11 22:55
 * @Email:284660487@qq.com
 */
public class Solution210 {

    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    int[] res;
    int index = 0;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        edges = new ArrayList<>();
        for(int i = 0; i < numCourses; ++i){
            List<Integer> list = new ArrayList<>();
            edges.add(list);
        }
        for(int[] edge : prerequisites){
            edges.get(edge[0]).add(edge[1]);
        }
        visited = new int[numCourses];
        res = new int[numCourses];
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs(i);
            }
        }
        if(!valid) return null;
        return res;
    }

    public void dfs(int curCourse){
        visited[curCourse] = 1;
        for(int v : edges.get(curCourse)){
            if(visited[v] == 0){
                dfs(v);
                if(!valid) return;
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[curCourse] = 2;
        res[index] = curCourse;
        index++;
    }
}
