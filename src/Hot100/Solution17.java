package Hot100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/2/28 16:27
 * @Email:284660487@qq.com
 */
public class Solution17 {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0) return list;
        char[][] chars = {
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        int[] dight = new int[digits.length()];
        int[] jiec = new int[digits.length()];
        jiec[digits.length() - 1] = 1;
        for(int i = digits.length() - 1; i >= 0; --i){
            dight[i] = digits.charAt(i) - '2';
            if(i < digits.length() - 1){
                jiec[i] = jiec[i + 1] * chars[dight[i + 1]].length;
            }
        }

        int total = 1;
        for(int d : dight){
            total *= chars[d].length;
        }
        for(int i = 0; i < total; ++i){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < dight.length; ++j){
                sb.append(chars[dight[j]][(i / jiec[j]) % chars[dight[j]].length]);
            }
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args){
        Solution17 solution17 = new Solution17();
        List<String> list = solution17.letterCombinations("7");
        list.forEach(System.out::println);
    }
}
