package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/10/8 14:51
 * @Email:284660487@qq.com
 */
public class Solution1585 {

    public boolean isTransformable(String s, String t) {
        if(s.length() != t.length()) return false;
        int[] num1 = new int[10];
        int[] num2 = new int[10];
        for(int i = 0; i < s.length(); ++i){
            num1[s.charAt(i) - '0'] += 1;
            num2[t.charAt(i) - '0'] += 1;
        }
        for(int i = 0; i < 10; ++i){
            if(num1[i] != num2[i]) return false;
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int i = 0; i < 10; ++i) lists.add(new ArrayList<>());
        for(int i = 0; i < s.length(); ++i){
            lists.get(s.charAt(i) - '0').add(i);
        }
        for(int i = 0; i < t.length(); ++i){
            int index = t.charAt(i) - '0';
            if(lists.get(index).isEmpty()) return false;
            for(int j = 0; j < index; ++j){
                if(!lists.get(j).isEmpty() && lists.get(j).get(0) < lists.get(index).get(0)) return false;
            }
            lists.get(index).remove(0);
        }
        return true;
    }



    public static void main(String[] args){
        Solution1585 s = new Solution1585();
        System.out.println(s.isTransformable("84532", "34852"));
    }


}
