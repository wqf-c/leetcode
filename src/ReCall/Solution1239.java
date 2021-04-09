package ReCall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/19 23:06
 * @Email:284660487@qq.com
 */
public class Solution1239 {

    int max = 0;
    boolean[] availiable;
    public int maxLength(List<String> arr) {
        boolean[] chars = new boolean[26 * 2];
        availiable = new boolean[arr.size()];
        for(int i = 0; i < arr.size(); ++i){
            boolean[] booleans = new boolean[26 * 2];
            for(char c : arr.get(i).toCharArray()){
                int index = c - 'a';
                if(booleans[index]){
                    availiable[i] = true;
                    break;
                }
                booleans[index] = true;
            }
        }
        dfs(chars, arr, 0, 0);
        return max;
    }

    public void dfs(boolean[] chars, List<String> arr, int arrIndex, int currentLen){
        if(currentLen > max) max = currentLen;
        for(int i = arrIndex; i < arr.size(); ++i){
            if(availiable[i]) continue;
            char[] strC = arr.get(i).toCharArray();
            boolean flag = false;
            for(char c : strC){
                if(chars[c - 'a']){
                    flag = true;
                    break;
                }
            }
            if(flag) continue;
            for(char c : strC){
                chars[c - 'a'] = true;
            }
            dfs(chars, arr, i + 1, currentLen + strC.length);
            for(char c : strC){
                chars[c - 'a'] = false;
            }
        }
    }
//["yy","bkhwmpbiisbldzknpm"]
    public static void main(String[] args){
        Solution1239 solution1239 = new Solution1239();
        List<String> list = new ArrayList<>();
        list.add("yy");
        list.add("bkhwmpbiisbldzknpm");
        System.out.println(solution1239.maxLength(list));
    }


}
