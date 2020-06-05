package solution46to90;

import java.util.HashMap;

public class Solution87 {

    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) return false;
        return judge(s1, s2);
    }

    public boolean judge(String s1, String s2){
      //  System.out.println("index:" + index + "  s1:" + s1 + "  s2:" + s2);
        if(s1.equals(s2)){
            return true;
        }

        if(s1.length() == 2){
            return s1.charAt(0) == s2.charAt(1) && s1.charAt(1) == s2.charAt(0);
        }
        //加上这个不超时了
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        for(int i = 1; i < s1.length(); ++i){
            String left = s1.substring(0, i);
            String right = s1.substring(i, s1.length());

            if(judge(left, s2.substring(0, left.length()))
                    && judge(right, s2.substring(left.length(), s1.length()))){
                return true;
            }
            if(judge(right, s2.substring(0, right.length()))
                    && judge(left, s2.substring(right.length(), s1.length()))){
                return true;
            }
           
        }
        return false;
    }

    //动态规划。。。多抽象出一个维度。。。
    public boolean isScrambledp(String s1, String s2) {
        if(s1==null&&s2!=null||s2==null&&s1!=null||s1.length()!=s2.length()) return false;
        boolean[][][] dp=new boolean[s1.length()][s2.length()][s1.length()+1];
        //初始化len=1
        for (int i = 0; i < s1.length(); i++) {//第一个字符串的起点
            for (int j = 0; j < s2.length(); j++) {//第二个字符串的起点
                if(s1.charAt(i)==s2.charAt(j)) dp[i][j][1]=true;
            }
        }
        for (int len = 2; len <=s1.length(); len++) {//区间长度
            for (int i = 0; i < s1.length(); i++) {//第一个字符串的起点,终点i+len-1
                for (int j = 0; j < s2.length(); j++) {//第二个字符串的起点,终点j+len-1
                    for (int k = 1; k <len; k++) {//左边区间的长度，因为要划分成两个区间，所以左边那个区间的长度是1...len-1（至少为一，至多也得给第二个区间留一个）
                        if(i+k<s1.length()&&j+k<s1.length()&&j+len-k<s1.length()&&((dp[i][j][k]&&dp[i+k][j+k][len-k])||(dp[i][j+len-k][k]&&dp[i+k][j][len-k]))){
                            dp[i][j][len]=true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][s1.length()];
    }

    public static void main(String[] args) {
        Solution87 s87 = new Solution87();
        System.out.println(s87.isScramble("abcd", "badc"));
    }


}
