package CodeTop;

import org.omg.CORBA.INTERNAL;

/**
 * @author wqf
 * @date 2021/5/30 17:24
 * @Email:284660487@qq.com
 */
public class Solution8 {

    public int myAtoi(String s) {
        long rst = 0;
        boolean flag = false;
        if(s.length() == 0 || s == null) return 0;
        int startIndex = 0;
        for(; startIndex < s.length(); ++startIndex){
            if(s.charAt(startIndex) != ' ') break;
        }
        if(startIndex >= s.length() || (s.charAt(startIndex) != '-' && s.charAt(startIndex) != '+' && (s.charAt(startIndex) < '0' || s.charAt(startIndex) > '9'))){
            return 0;
        }
        if(s.charAt(startIndex) == '-' || s.charAt(startIndex) == '+'){
            if(s.charAt(startIndex) == '-'){
                flag = true;
            }
            startIndex++;
        }

        if(startIndex < s.length() && s.charAt(startIndex) >= '0' && s.charAt(startIndex) <= '9'){
            rst = s.charAt(startIndex) - '0';
            if(flag){
                rst = -1 * rst;
            }
        }else{
            return 0;
        }
        startIndex++;
        int index = startIndex;
        for(; index < s.length(); ++index){
            if(s.charAt(index) >= '0' && s.charAt(index) <= '9'){
                rst = rst * 10 + (flag ? (-1 * (s.charAt(index) - '0')) :  s.charAt(index) - '0');
                if(rst >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if(rst <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }else{
                break;
            }
        }
        return (int)rst;
    }

    public static void main(String[] args) {
        Solution8 solution8 = new Solution8();
        solution8.myAtoi("  -48");
    }

}
