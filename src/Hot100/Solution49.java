package Hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2021/3/20 11:25
 * @Email:284660487@qq.com
 */
public class Solution49 {

    //用hashMap做
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> rst = new ArrayList<>();
        if(strs.length == 0) return rst;
        List<String> list = new ArrayList<>();
        list.add(strs[0]);
        rst.add(list);
        String[] save = new String[strs.length];
        save[0] = strs[0];
        int saveSize = 1;
        for(int i = 1; i < strs.length; ++i){
            int findIndex = -1;
            for(int j = 0; j < saveSize; ++j){
                if(campareStr(save[j], strs[i])){
                    findIndex = j;
                    break;
                }
            }
            if(findIndex != -1){
                rst.get(findIndex).add(strs[i]);
            }else{
                save[saveSize] = strs[i];
                saveSize++;
                List<String> l = new ArrayList<>();
                l.add(strs[i]);
                rst.add(l);
            }
        }
        return rst;
    }

    public boolean campareStr(String str1, String str2){
        if(str1.length() != str2.length()) return false;
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        for(int i = 0; i < chars1.length; ++i){
            if(chars1[i] != chars2[i]) return false;
        }
        return true;
    }


}
