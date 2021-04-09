package ReCall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2021/1/13 23:10
 * @Email:284660487@qq.com
 */
public class Solution842 {

    List<Integer> rst = null;

    public List<Integer> splitIntoFibonacci(String S) {
        rst = new ArrayList<>();
        dfs(S.toCharArray(), 0, 0, 0, 0);
        return rst;
    }

    public boolean dfs(char[] chars, int beginIndex, int currentIndex, int rstIndex, int current){
        if(rstIndex == 2){
            int end = currentIndex;
            while (end != -1){
                if(end == chars.length) return true;
                long num = rst.get(rst.size() - 1) + rst.get(rst.size() - 2);

                if(num > Integer.MAX_VALUE) return false;
                int start = end;
                end = check(chars, end, (int) num);
                if(end != -1){
                    rst.add((int) num);
                    end += 1;
                }else{
                    return false;
                }
            }
            return false;
        }
        long num = current * 10 + chars[currentIndex] - '0';
        if(num >= Integer.MAX_VALUE) return false;
        int restBits = chars.length - currentIndex;
        if(restBits <= (currentIndex - beginIndex + 1)) return false;
        rst.add((int) num);
        boolean flag = dfs(chars, currentIndex + 1, currentIndex + 1, rstIndex + 1, 0);
        if(flag) return true;
        while (rst.size() > rstIndex) rst.remove(rst.size() - 1);
        if(beginIndex == currentIndex && chars[beginIndex] == '0') return false;
        boolean flag1 = dfs(chars, beginIndex, currentIndex + 1, rstIndex, (int) num);
        return flag1;
    }

    int check(char[] chars, int start, int num){
        long temp = 0;
        for(int i = start; i < chars.length; ++i){
            temp = temp * 10 + chars[i] - '0';
            if(temp == num) return i;
            if(temp > num) return -1;
        }
        return  - 1;
    }


    private boolean split(List<Integer> list,String s,int index){
        if(index == s.length()){
            return list.size() > 2;
        }
        long cur = 0;
        for(int i = index;i < s.length();i++){
            if(i > index && s.charAt(index) == '0'){
                return false;
            }
            if((cur = cur * 10 + (s.charAt(i) - '0')) > Integer.MAX_VALUE){
                return false;
            }

            if(list.size() >= 2){
                long sum = (long)list.get(list.size() - 1) + (long)list.get(list.size() -2);
                if(sum > Integer.MAX_VALUE || sum < cur){
                    return false;
                }else if(sum > cur){
                    continue;
                }
            }
            //list.size() < 2 || sum == cur;
            list.add((int)cur);
            if(split(list,s,i + 1)){
                return true;
            }
            list.remove(list.size() - 1);
        }
        return false;
    }

    public static void main(String[] args){
        Solution842 solution842 = new Solution842();
        System.out.println(solution842.splitIntoFibonacci("123456579"));
    }

}
