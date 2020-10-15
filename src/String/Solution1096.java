package String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * @author wqf
 * @date 2020/10/15 19:24
 * @Email:284660487@qq.com
 */
public class Solution1096 {

    //深度优先遍历   这里的深度的概念是 {}的层级

    void add(HashSet<String> s1, HashSet<String> s2){
        for(String s : s2){
            s1.add(s);
        }
        s2.clear();
    }

    void mul(HashSet<String> s1, HashSet<String> s2){
        if(s2.isEmpty()) return;
        List<String> list = new ArrayList<>();
        if(s1.isEmpty()){
            s1.addAll(s2);
        }else{
            for(String ss1 : s1){
                for (String ss2 : s2){
                    list.add(ss1 + ss2);
                }
            }
            s1.clear();
            s1.addAll(list);
        }
        s2.clear();
    }

    void mul(HashSet<String> s1, String s){
        if(s.isEmpty()) return;
        if(s1.isEmpty()) {
            s1.add(s);
            return;
        }
        List<String> list = new ArrayList<>();
        for(String ss : s1){
            list.add(ss + s);
        }
        s1.clear();
        s1.addAll(list);
    }

    public HashSet<String> parse(String exp, int left, int right){
        HashSet<String> rstS = new HashSet<>();
        HashSet<String> s = new HashSet<>();
        String t = "";
        int l = left, r = right;
        while (l <= right){
            if(exp.charAt(l) == '{'){
                int size = 1;
                int ll = l + 1;
                while (size > 0 && ++l <= r){
                    size += exp.charAt(l) == '{' ? 1 : 0;
                    size -= exp.charAt(l) == '}' ? 1 : 0;
                }
                mul(s, t);
                t = "";
                mul(s, parse(exp, ll, l - 1));
            }else if(exp.charAt(l) == ','){
                mul(s, t);
                t = "";
                add(rstS, s);
            }else{
                t += exp.charAt(l);
            }
            l++;
        }
        mul(s, t);
        add(rstS, s);
        return rstS;
    }

    public List<String> braceExpansionII(String expression) {
        List<String> rst = new ArrayList<>();
        rst.addAll(parse(expression, 0, expression.length() - 1));
        Collections.sort(rst);
        return rst;
    }

    public static void main(String[] args){
        Solution1096 solution1096 = new Solution1096();
        solution1096.braceExpansionII("{a,b}{c,{d,e}}");
    }
}
