package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/11 20:57
 * @Email:284660487@qq.com
 */
public class Solution207 {

    //检查图是否有回环  s深度优先遍历
    //用来保存已经访问过的节点
    public HashSet<Integer> visitedSet = new HashSet<>();
    //保存验证过的节点
    public HashSet<Integer> successSet = new HashSet<>();
    //保存每个节点的前驱节点
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < prerequisites.length; ++i){
            if(map.containsKey(prerequisites[i][0])){
                map.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][1]);
                map.put(prerequisites[i][0], list);
            }
        }
        for(Integer i : map.keySet()){
            if(!dfs(i)) return false;
            else{
                successSet.add(i);
            }
        }
        return true;
    }

    public boolean dfs(int curCourse){
        if(successSet.contains(curCourse)) return true;
        if(visitedSet.contains(curCourse)) return false;
        if(!map.containsKey(curCourse)) return true;
        List<Integer> nextCourse = map.get(curCourse);
        visitedSet.add(curCourse);
        boolean flag = true;
        for(int i = 0; i < nextCourse.size(); ++i){
            if(!dfs(nextCourse.get(i))){
                flag = false;
                break;
            }
        }
        if(flag) successSet.add(curCourse);
        visitedSet.remove(curCourse);
        return flag;
    }

    //官方解法
    List<List<Integer>> edges;
    int[] visited;
    boolean valid = true;
    public boolean canFinish1(int numCourses, int[][] prerequisites){
        edges = new ArrayList<>();
        visited = new int[numCourses];
        for(int i = 0; i < numCourses; ++i){
            List<Integer> list = new ArrayList<>();
            edges.add(list);
        }
        for(int[] edge : prerequisites){
            edges.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < numCourses && valid; ++i) {
            if (visited[i] == 0) {
                dfs1(i);
            }
        }
        return valid;

    }

    public void dfs1(int curCourse){
        visited[curCourse] = 1;
        for(int v : edges.get(curCourse)){
            if(visited[v] == 0){
                dfs1(v);
                if(!valid) return;
            }else if(visited[v] == 1){
                valid = false;
                return;
            }
        }
        visited[curCourse] = 2;
    }

}
