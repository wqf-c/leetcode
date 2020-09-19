package Graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/19 9:40
 * @Email:284660487@qq.com
 */
public class dfs {
    char[][] edges = {{'A', 'B'}, {'B', 'C'}, {'B', 'F'}, {'B', 'E'},
            {'E', 'B'}, {'D', 'C'}, {'E', 'D'}, {'C', 'E'}, {'F', 'G'}};

    HashMap<Character, Boolean> visited;
    HashMap<Character, List<Character>> graph = null;

    void init(){
        visited = new HashMap<>();
        graph = new HashMap<>();
        for(char[] e: edges){
            char start = e[0];
            char end = e[1];
            if(!graph.containsKey(start)){
                graph.put(start, new ArrayList<>());
            }
            visited.put(start, false);
            graph.get(start).add(end);
            visited.put(end, false);
        }
    }

    void DFSTraversal(char start){
        if(visited.get(start)) return;
        System.out.println(start);
        visited.put(start, true);
        if(graph.containsKey(start)){
            for(char nei : graph.get(start)){
                if(!visited.get(nei)) DFSTraversal(nei);
            }
        }

    }

    void dfs(char start){
        init();
        for(char nei : graph.get(start)){
            if(!visited.get(nei)){
                DFSTraversal(nei);
            }
        }
    }

    public static void main(String[] args){
        dfs d = new dfs();
        d.dfs('A');
    }
}
