package ReCall;

/**
 * @author wqf
 * @date 2021/1/10 15:55
 * @Email:284660487@qq.com
 */
public class Solution1415 {

    public String getHappyString(int n, int k) {
        if(k > 3 * Math.pow(2, n - 1)) return "";
        char[] chars = new char[]{'a', 'b', 'c'};
        int lastChooseIndex = -1;
        StringBuilder sb = new StringBuilder();
        int number = k;
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < chars.length; ++j){
                if(j == lastChooseIndex) continue;
                if(number <= Math.pow(2, n - i - 1)){
                    sb.append(chars[j]);
                    lastChooseIndex = j;
                    break;
                }else{
                    number -= Math.pow(2, n - i - 1);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution1415 solution1415 = new Solution1415();
        solution1415.getHappyString(1, 3);
    }

}
