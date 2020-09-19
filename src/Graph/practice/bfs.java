package Graph.practice;

import java.util.*;

/**
 * @author wqf
 * @date 2020/9/19 9:40
 * @Email:284660487@qq.com
 */
public class bfs {

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

    void bfs(char start){
        Queue<Character> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()){
            char cur = queue.poll();
            visited.put(cur, true);
            System.out.println(cur);
            if(graph.containsKey(cur)){
                for(char c : graph.get(cur)){
                    if(!visited.get(c) && !queue.contains(c)) queue.offer(c);
                }
            }
        }
    }

    public static void main(String[] args){
        bfs b = new bfs();
        b.init();
        b.bfs('A');
    }
}
