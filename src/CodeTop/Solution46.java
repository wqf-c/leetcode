package CodeTop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2021/5/15 23:11
 * @Email:284660487@qq.com
 */
public class Solution46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> rst = new ArrayList<>();
        int sum = jiechen(nums.length);
        boolean[] visited = new boolean[nums.length];
        for(int i = 0; i < sum; ++i){
            int temp = i;
            Arrays.fill(visited,false);
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < nums.length; ++j){
                if(temp == 0){
                    for(int k = 0; k < nums.length; ++k){
                        if(!visited[k]){
                            list.add(nums[k]);
                            visited[k] = true;
                            break;
                        }
                    }
                }else{
                    int jiec = jiechen(nums.length - j - 1);
                    int index = temp / jiec;
                    temp -= index * jiec;
                    int m = 0;
                    for(int k = 0; k < visited.length;++k){
                        if(!visited[k]){
                            if(m == index){
                                list.add(nums[k]);
                                visited[k] = true;
                                break;
                            }else{
                                m++;
                            }
                        }
                    }
                }
            }
            rst.add(list);
        }
        return rst;
    }

    int jiechen(int num){
        int rst = 1;
        for(int i = num; i > 0; --i){
            rst *= i;
        }
        return rst;
    }

    List<List<Integer>> rst = null;
    public List<List<Integer>> permute1(int[] nums) {
        rst = new ArrayList<>();
        dfs(nums, new boolean[nums.length], 0, new ArrayList<>());
        return rst;
    }

    public void dfs(int[] nums, boolean[] visited, int index, List<Integer> current){
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            list.addAll(current);
            rst.add(list);
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(!visited[i]){
                current.add(nums[i]);
                visited[i] = true;
                dfs(nums, visited, index + 1, current);
                visited[i] = false;
                current.remove(current.size() - 1);
            }
        }
    }
}
