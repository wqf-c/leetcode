package Dfs;

import java.util.Stack;

/**
 * @author wqf
 * @date 2020/12/2 21:25
 * @Email:284660487@qq.com
 */
public class Solution394 {

    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<String> strs = new Stack<>();
        StringBuilder sbCur = new StringBuilder();
        for(int i = 0; i < s.length(); ){
            char c = s.charAt(i);
            if(c >= '0' && c < '9'){
                int num = 0;
                int j = i;
                for(;s.charAt(j) > '0' && s.charAt(j) < '9'; ++j){
                    num = num * 10 + s.charAt(j) - '0';
                }
                nums.push(num);
                i = j;
                continue;
            }
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')){
                sbCur.append(c);
            }else if(c == '['){
                if(sbCur.length() != 0){
                    strs.push(sbCur.toString());
                    sbCur.delete(0, sbCur.length());
                }
                strs.push("[");
            }else{
                int bei = nums.empty() ? 1 : nums.pop();
                String ss = sbCur.toString();
                StringBuilder ssb = new StringBuilder();
                while (true){
                    String sss = strs.pop();
                    if(sss.equals("[")) break;
                    ssb.insert(0, sss);
                }
                ssb.append(ss);
                String aa = ssb.toString();
                sbCur.delete(0, sbCur.length());
                for(int k = 0; k < bei; ++k){
                    sbCur.append(aa);
                }
                strs.push(sbCur.toString());
                sbCur.delete(0, sbCur.length());
            }
            i++;
        }
        StringBuilder rst = new StringBuilder();
        while (!strs.empty()){
            rst.insert(0, strs.pop());
        }
        if(sbCur.length() != 0){
            rst.append(sbCur.toString());
        }
        return rst.toString();
    }

    public static void main(String args[]){
        Solution394 solution394 = new Solution394();
        System.out.println(solution394.decodeString("3[a2[c]]"));
    }
}
