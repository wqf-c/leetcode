package Hot100;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.List;

/**
 * @author wqf
 * @date 2021/4/24 21:38
 * @Email:284660487@qq.com
 */
public class Solution399 {

    //并查集
    //这一题的图是有向图，所以不用rank
    //int[] rank = new int[26];

    HashMap<String, String> parents = null;
    //保存的是节点到它父节点的数值,假设a节点父节点是b,这里weights.get("a") = a/b
    HashMap<String, Double> weights = null;

    Pair<String, Double> find_root(String a){
        if(!parents.containsKey(a)){
            return new Pair<>("", -1.0);
        }
        Double rst = 1.0;
        while (a != parents.get(a)){
            rst *= weights.get(a);
            a = parents.get(a);
        }
        return new Pair<>(a, rst);
    }

    public void union_vertices(String a, String b, double a_b){
        Pair<String, Double> a_root = find_root(a);
        Pair<String, Double> b_root = find_root(b);
        if(a_root.getKey().equals("") || b_root.getKey().equals("")){
            return;
        }
        if(a_root.getKey().equals(b_root.getKey())){
            return;
        }

        parents.put(a_root.getKey(), b_root.getKey());
        weights.put(a_root.getKey(), 1.0 / a_root.getValue() * b_root.getValue() * a_b);
    }


    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries){
        parents = new HashMap<>();
        weights = new HashMap<>();
        for(int i = 0; i < equations.size(); ++i){
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
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
        double[] rst = new double[queries.size()];
        for(int i = 0; i < queries.size(); ++i){
            List<String> querie = queries.get(i);
            String a = querie.get(0);
            String b = querie.get(1);
            Pair<String, Double> a_root = find_root(a);
            Pair<String, Double> b_root = find_root(b);
            if(a_root.getKey().equals("") || "".equals(b_root.getKey()) || !a_root.getKey().equals(b_root.getKey())) {
                rst[i] = -1.0;
            }else{
                rst[i] = a_root.getValue() / b_root.getValue();
            }
        }
        return rst;
    }
}
