package ReCall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/20 23:26
 * @Email:284660487@qq.com
 */
public class Solution08_08 {

    List<String> list = null;

    public String[] permutation(String S) {
        String[] rst = null;
        list = new ArrayList<>();
        dfs(0, S.toCharArray(), 0, new char[S.length()]);
        rst = new String[list.size()];
        for(int i = 0; i < rst.length; ++i){
            rst[i] = list.get(i);
        }

        return rst;
    }

    public void dfs(int visit, char[] str, int curIndex, char[] chars){
        if(curIndex == chars.length){
            list.add(new String(chars));
            return;
        }
        int same1 = 0;
        int same2 = 0;

        for(int i = 0; i < str.length; ++i){
            boolean visited = ((visit >> i) % 2) == 1;
            if(!visited){
                boolean used =  false;
                if(str[i] >= 'a' && str[i] <= 'z') used = ((same1 >> (str[i] - 'a')) % 2) == 1;
                else used = ((same2 >> (str[i] - 'A')) % 2) == 1;
                if(!used){
                    if(str[i] >= 'a' && str[i] <= 'z') same1 |= (1 << (str[i] - 'a'));
                    else same2 |= (1 << (str[i] - 'A'));
                    chars[curIndex] = str[i];
                    dfs(visit | (1 << i), str, curIndex + 1, chars);
                }else {
                   // System.out.println("used");
                }
            }
        }
    }

    public static void main(String[] args){
        Solution08_08 solution08_08 = new Solution08_08();
        String[] strs = solution08_08.permutation("RNShOY");
        System.out.println(strs.length);
    }

}
