package ReCall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/17 15:15
 * @Email:284660487@qq.com
 */
public class Solution216 {

    List<List<Integer>> rst = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(new ArrayList<>(), k, n, 1);
        return rst;
    }

    public void dfs(List<Integer> list, int restK, int restN, int curNumber){
        if(restK == 0 && restN == 0){
            rst.add(new ArrayList<>(list));
            return;
        }
        if(restN <= 0 || restK <= 0) return;
        for(int i = curNumber; i <= (9 - restK + 1); ++i){
            list.add(i);
            dfs(list, restK - 1, restN - i, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args){
        Solution216 solution216 = new Solution216();
        System.out.println(solution216.combinationSum3(9, 45));
    }
}
