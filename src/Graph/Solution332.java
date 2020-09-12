package Graph;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;

/**
 * @author wqf
 * @date 2020/9/12 21:14
 * @Email:284660487@qq.com
 */
public class Solution332 {

    HashMap<String, List<String>> graph = null;
    HashMap<String, List<Boolean>> visited = null;
    int total = 0;
    List<String> res = null;
    int index = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        graph = new HashMap<>();
        visited = new HashMap<>();
        res = new ArrayList<>();
        total = tickets.size() + 1;
        for(List<String> list : tickets){
            String src = list.get(0);
            String dest = list.get(1);
            if(!graph.containsKey(src)){
                graph.put(src, new ArrayList<>());
                visited.put(src, new ArrayList<>());
            }

            graph.get(src).add(dest);
            visited.get(src).add(false);
        }
        for(List<String> dest : graph.values()){
            Collections.sort(dest);
        }
        dfs("JFK");
        return res;
    }

    public void dfs(String src){
        res.add(src);
        index++;
        if(!graph.containsKey(src) && index < total) {
            index --;
            res.remove(res.size() - 1);
            return;
        }

        if(index == total) return;
       // int size = graph.get(src).size();
        for(int i = 0; i < graph.get(src).size() ; ++i){
            if(visited.get(src).get(i)) continue;
            String dest = graph.get(src).get(i);
            visited.get(src).set(i, true);
            dfs(dest);
            visited.get(src).set(i, false);
            if(index >= total) return;
        }
        index --;
        res.remove(res.size() - 1);
    }

    public static void main(String[] args){
        Solution332 s = new Solution332();
        List<List<String>> lists = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("KUL");

        List<String> list2 = new ArrayList<>();
        list2.add("NRT");
        list2.add("JFK");

        List<String> list3 = new ArrayList<>();
        list3.add("JFK");
        list3.add("NRT");

//        List<String> list4 = new ArrayList<>();
//        list4.add("ATL");
//        list4.add("JFK");
//
//        List<String> list5 = new ArrayList<>();
//        list5.add("ATL");
//        list5.add("SFO");

        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
//        lists.add(list4);
//        lists.add(list5);
        s.findItinerary(lists);
    }
}
