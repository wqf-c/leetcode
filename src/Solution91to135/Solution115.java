package Solution91to135;

import java.util.HashMap;
import java.util.Map;

public class Solution115 {

    //暴力  超时
    int total = 0;

    public int numDistinct1(String s, String t) {
        if(s.length() < t.length()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); ++i){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); ++i){
            if(!map.containsKey(t.charAt(i))) return 0;
            else map.put(t.charAt(i), map.get(t.charAt(i) - 1));
        }
        function(s, t, 0, 0);
        return total;
    }

    public void function(String s, String t, int sIndex, int tIndex){
        if(tIndex == t.length()){
            total ++;
            return;
        }
        if(t.length() - tIndex > s.length() - sIndex) return;
        if(s.charAt(sIndex) == t.charAt(tIndex)) function(s, t, sIndex+1, tIndex+1);
        function(s, t, sIndex + 1, tIndex);

    }

    //动态规划
    public int numDistinct(String s, String t){
        int[][] nums = new int[s.length()][t.length()];
        if(s.length() < t.length()) return 0;
        nums[0][0] = s.charAt(0) == t.charAt(0) ? 1 : 0;
        for(int i = 1; i < t.length(); ++i) nums[0][i] = 0;
        for(int i = 1; i < s.length(); ++i){
            if(s.charAt(i) == t.charAt(0)) nums[i][0] = nums[i - 1][0] + 1;
            else nums[i][0] = nums[i - 1][0];
        }
        for(int i = 1; i < s.length(); ++i){
            for(int j = 1; j < t.length(); ++j){
                if(j > i) {
                    break;
                }
                if(t.charAt(j) != s.charAt(i)) nums[i][j] = nums[i - 1][j];
                else{
                    nums[i][j] = nums[i - 1][j - 1] + nums[i - 1][j];
                }
            }
        }
        return nums[s.length() - 1][t.length() - 1];
    }

    public static void main(String[] args){
        Solution115 s = new Solution115();
        s.numDistinct("bbbit", "bbit");
    }
}
