package String;

/**
 * @author wqf
 * @date 2020/10/13 19:24
 * @Email:284660487@qq.com
 */
public class Solution1370 {

    public String sortString(String s) {
        int[] data = new int[26];
        char[] results = new char[s.length()];
        for(int i = 0; i < s.length(); ++i){
            data[s.charAt(i) - 'a'] ++;
        }
        int index = 0;
        while (true){
            boolean flag = false;
            for(int i = 0; i < data.length; ++i){
                if(data[i] > 0){
                    data[i] --;
                    flag = true;
                    results[index] = (char) (i + 'a');
                    index++;
                }
            }
            if(!flag) break;
            flag = false;
            for(int j = data.length - 1; j >= 0; --j){
                if(data[j] > 0){
                    data[j] --;
                    flag = true;
                    results[index] = (char)(j + 'a');
                    index ++;
                }
            }
            if(!flag) break;
        }
        return new String(results);
    }

    public static void main(String[] args){
        Solution1370 solution1370 = new Solution1370();
        solution1370.sortString("aaaabbbbcccc");
    }
}
