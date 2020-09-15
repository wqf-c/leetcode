package Graph;

import javafx.util.Pair;

import java.util.*;

/**
 * @author wqf
 * @date 2020/9/13 20:58
 * @Email:284660487@qq.com
 */
public class Solution399 {

    //并查集解法
    private HashMap<String, String> parents = null;
    private HashMap<String, Double> weights = null;

    Pair<String, Double> find_root(String a){
        if(!parents.containsKey(a)){
            return new Pair<>("", -1.0);
        }
        Double result = 1.0;
        while (a != parents.get(a)){
            result *= weights.get(a);
            a = parents.get(a);

        }
        return new Pair<>(a, result);
    }

    void union_vertices(String a, String b, double a_b){
        Pair<String, Double> a_root = find_root(a);
        Pair<String, Double> b_root = find_root(b);
        if("".equals(a_root.getKey()) || "".equals(b_root.getKey())){
            return;
        }

        if(a_root.getKey().equals(b_root.getKey())) return;

        parents.put(a_root.getKey(), b_root.getKey());
        weights.put(a_root.getKey(), 1 / a_root.getValue() * a_b * b_root.getValue());
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = queries.size();
        double[] res = new double[size];
        parents = new HashMap<>();
        weights = new HashMap<>();
        for(int i = 0; i < equations.size(); ++i){
            List<String> list = equations.get(i);

            String a = list.get(0);
            String b = list.get(1);
            if(!parents.containsKey(a)){
                parents.put(a, a);
                weights.put(a, 1.0);
            }
            if(!parents.containsKey(b)){
                parents.put(b, b);
                weights.put(b, 1.0);
            }
            union_vertices(a, b, values[i]);
        }
        int i = 0;
        for(List<String> ques : queries){
            String a = ques.get(0);
            String b = ques.get(1);
            Pair<String, Double> _a = find_root(a);
            Pair<String, Double> _b = find_root(b);
            if(!_a.getKey().equals(_b.getKey()) || "".equals(_a.getKey()) || "".equals(_b.getKey())){
                res[i] = -1.0;
            }else{
                res[i] = _a.getValue() / _b.getValue();
            }
            i++;
        }
        return res;
    }

    //floyd解法
    public double[] calcEquation_floyd(List<List<String>> equations, double[] values, List<List<String>> queries){
        int inf = Integer.MAX_VALUE;
        double[] res = new double[queries.size()];
        double[][] graph = new double[100][100];
        HashMap<String, Integer> store = new HashMap<>();
        for(int i = 0; i < 10; ++i){
            for(int j = 0; j < 10; ++j){
                graph[i][j] = inf;
            }
        }
        int index = 0;
        int i = 0;
        for(List<String> list : equations){
            if(!store.containsKey(list.get(0))){
                store.put(list.get(0), index);
                index++;
            }
            if(!store.containsKey(list.get(1))){
                store.put(list.get(1), index);
                index++;
            }
            graph[store.get(list.get(0))][store.get(list.get(1))] = values[i];
            graph[store.get(list.get(1))][store.get(list.get(0))] = 1 / values[i];
            i++;
        }
        for(int j = 0; j < index; ++j){
            for(int k = 0; k < index; ++k){
                for(int m = 0; m < index; ++m){
                    if(graph[j][m] != inf && graph[k][m] != inf && graph[j][k] == inf){
                        graph[j][k] = graph[j][m] * graph[m][k];
                    }
                }
            }
        }
        for(int l = 0; l < queries.size(); ++l){
            String a = queries.get(l).get(0);
            String b = queries.get(l).get(1);
            if(store.containsKey(a) && store.containsKey(b)){
                if(graph[store.get(a)][store.get(b)] != inf){
                    res[l] = graph[store.get(a)][store.get(b)];
                }else{
                    res[l] = -1;
                }
            }else{
                res[l] = -1;
            }
        }
        return res;
    }

    //dfs 和 bfs

    void buildGraph(List<List<String>> equations, double[] values, HashMap<String, HashMap<String, Double>> graph){
        for(int i = 0; i < equations.size(); ++i){
            List<String> list = equations.get(i);
            String a = list.get(0);
            String b = list.get(1);
            if(!graph.containsKey(a)){
                HashMap<String, Double> map = new HashMap<>();
                map.put(b, values[i]);
                graph.put(a, map);
            }else{
                graph.get(a).put(b, values[i]);
            }
            if(!graph.containsKey(b)){
                HashMap<String, Double> map = new HashMap<>();
                map.put(a, 1.0 / values[i]);
                graph.put(b, map);
            }else{
                graph.get(b).put(a, 1 / values[i]);
            }
        }
    }
    public double[] calcEquation_dfs(List<List<String>> equations, double[] values, List<List<String>> queries){
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        double[] res = new double[queries.size()];
        buildGraph(equations, values, graph);
        int index = 0;
        for(List<String> list : queries){
            if(list.get(0).equals(list.get(1)) && graph.containsKey(list.get(0))){
                res[index] = 1;
                index++;
                continue;
            }
            HashSet<String> visited = new HashSet<>();
            Pair<Boolean, Double> pair = dfs(list.get(0), list.get(1), graph, visited);
            res[index] = pair.getValue();
            if(pair.getKey()){
                graph.get(list.get(0)).put(list.get(1), pair.getValue());
                graph.get(list.get(1)).put(list.get(0), 1 / pair.getValue());
            }
            index++;
        }
        return res;
    }

    public double[] calcEquation_bfs(List<List<String>> equations, double[] values, List<List<String>> queries){
        HashMap<String, HashMap<String, Double>> graph = new HashMap<>();
        double[] res = new double[queries.size()];
        buildGraph(equations, values, graph);
        for(int i = 0; i < queries.size(); ++i){
            List<String> list = queries.get(i);
            if(list.get(0).equals(list.get(1)) && graph.containsKey(list.get(0))){
                res[i] = 1;
                continue;
            }else{
                Pair<Boolean, Double> pair =bfs(list.get(0), list.get(1), graph);
                res[i] = pair.getValue();
                if(pair.getKey()){
                    graph.get(list.get(0)).put(list.get(1), pair.getValue());
                    graph.get(list.get(1)).put(list.get(0), 1.0 / pair.getValue());
                }
            }
        }
        return res;
    }

    public Pair<Boolean, Double> bfs(String begin, String end, HashMap<String, HashMap<String, Double>> graph){
        if(!graph.containsKey(begin) || !graph.containsKey(end)){
            return new Pair<>(false, -1.0);
        }
        HashSet<String> visited = new HashSet<>();
        Queue<Pair<String, Double>> queue = new LinkedList<>();
        queue.offer(new Pair<>(begin, 1.0));
        while (!queue.isEmpty()){
            Pair<String, Double> cur = queue.poll();
            if(visited.contains(cur.getKey())) continue;
            visited.add(cur.getKey());
            if(cur.getKey().equals(end)) return new Pair<>(true, cur.getValue());
            for(Map.Entry<String, Double> set : graph.get(cur.getKey()).entrySet()){
                queue.offer(new Pair<>(set.getKey(), cur.getValue() * set.getValue()));
            }
        }
        return new Pair<>(false, -1.0);
    }

    public Pair<Boolean, Double> dfs(String begin, String end, HashMap<String, HashMap<String, Double>> graph, HashSet<String> visited){
        if(!graph.containsKey(begin) || graph.containsKey(end)){
            return new Pair<>(false, -1.0);
        }
        //如果判断成立，说明绕了一圈，又从之前的begin开始了
        if(visited.contains(begin)){
            return new Pair<>(false, -1.0);
        }
        if(graph.get(begin).containsKey(end)){
            return new Pair<>(true, graph.get(begin).get(end));
        }
        visited.add(begin);
        for(Map.Entry<String, Double> map : graph.get(begin).entrySet()){
            Pair<Boolean, Double> res = dfs(map.getKey(), end, graph, visited);
            if(res.getKey()){
                return new Pair<>(true, res.getValue() * graph.get(begin).get(map.getKey()));
            }
        }
        visited.remove(begin);
        return new Pair<>(false, -1.0);
    }


    public static void testYY(Double d){
        d = 2.0;
    }

    public static void main(String[] args){
        Double d = 1.0;
        testYY(d);
        System.out.println(d);
    }
}
