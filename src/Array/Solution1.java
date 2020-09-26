package Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wqf
 * @date 2020/9/23 22:05
 * @Email:284660487@qq.com
 */
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> seat = new HashMap<>();
        for(int i = 0; i < nums.length; ++i){
            if(!seat.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                seat.put(nums[i], list);
            }else{
                seat.get(nums[i]).add(i);
            }
        }
        int[] res = new int[2];
        for(int i : seat.keySet()){
            int another = target - i;
            if(seat.containsKey(another)){
                if(another == i){
                    List<Integer> l = seat.get(another);
                    if(l.size() >= 2){
                        res[0] = l.get(0);
                        res[1] = l.get(1);
                        break;
                    }
                }else{
                    res[0] = seat.get(i).get(0);
                    res[1] = seat.get(another).get(0);
                    break;
                }
            }
        }
        return res;
    }

    public int[] twoSum1(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length; ++i){
            int dif = target - nums[i];
            if(map.get(dif) != null){
                return new int[]{i, map.get(dif)};
            }
            map.put(nums[i], i);
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args){
        Solution1 s = new Solution1();
        int[] i = new int[]{0, 4, 3, 0};
        s.twoSum(i, 0);
    }
}
