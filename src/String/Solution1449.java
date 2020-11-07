package String;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author wqf
 * @date 2020/10/24 10:54
 * @Email:284660487@qq.com
 */
public class Solution1449 {

    char[] maxArray = null;
    int maxIndex = 0;
    int[] data = null;

    public String largestNumber(int[] cost, int target) {
        data = new int[target + 1];
        int[] newCost = new int[cost.length];
        maxArray = new char[target];
        char[] curArray = new char[target];
        int newCostIndex = 0;
        for(int i = 0; i < cost.length; ++i){
            if(cost[i] > target) continue;
            if(data[cost[i]] == 0){
                newCost[newCostIndex] = cost[i];
                newCostIndex++;
            }
            data[cost[i]] = i + 1;
        }
        Arrays.sort(newCost, 0, newCostIndex);
        dfs(target, newCost, 0, newCostIndex, curArray, 0);
        if(maxIndex == 0) return "0";
        return new String(maxArray, 0, maxIndex);
    }

    public boolean judge(char[] chars1, int index1, char[] chars2, int index2){
        if(index1 > index2) return true;
        if(index1 < index2) return false;
        for(int i = 0; i < index1; ++i){
            if(chars1[i] != chars2[i]){
                return chars1[i] > chars2[i];
            }
        }
        return false;
    }

    public void dfs(int target, int[] cost, int costIndex, int costSize,  char[] curArray, int curIndex){

        if(target == 0){
            if(judge(curArray, curIndex, maxArray, maxIndex)){
                maxIndex = curIndex;
                for (int i = 0; i < maxIndex; ++i) {
                    maxArray[i] = curArray[i];
                }
            }
            return;
        }

        if(target < 0) return;
        if(costIndex >= costSize) return;
        if(target >= cost[costIndex]){
            int newIndex;
            for(newIndex = 0; newIndex < curIndex; ++newIndex){
                if(curArray[newIndex] <= '0' + data[cost[costIndex]]){
                    break;
                }
            }
            for(int i = curIndex; i > newIndex; --i){
                curArray[i] = curArray[i - 1];
            }
            curArray[newIndex] =(char) ('0' + data[cost[costIndex]]);

            dfs(target - cost[costIndex], cost, costIndex, costSize, curArray, curIndex + 1);
            for(int i = newIndex; i < curIndex; ++i){
                curArray[i] = curArray[i + 1];
            }
            dfs(target, cost, costIndex+1, costSize, curArray, curIndex);
        }

    }

    public String getBigger(String s1, String s2){
        if(s1.equals("#")) return s2;
        if(s2.equals("#")) return s1;
        if(s1.length() != s2.length()){
            return s1.length() > s2.length() ? s1 : s2;
        }
        if(s1.equals("85") || s2.equals("85")){
            System.out.println("");
        }
        for(int i = 0; i < s1.length(); ++i){
            if(s1.charAt(i) > s2.charAt(i)) return s1;
            if(s2.charAt(i) > s1.charAt(i)) return s2;
        }
        return s2;
    }



    public String largestNumber1(int[] cost, int target){
        String[][] dp = new String[10][5000 + 1];
        int[] newCost = new int[cost.length + 1];
        for(int i = 0; i < cost.length; ++i){
            newCost[i + 1] = cost[i];
        }
        for(int i = 0; i <= target; ++i){
            dp[0][i] = "#";
        }
        for(int i = 0; i < 10; ++i){
            dp[i][0] = "";
        }
        for(int i = 1; i <= target; ++i){
            for(int j = 1; j <= 9; ++j){
                String b = "";
                String a = dp[j - 1][i];
                if(i - newCost[j] >= 0 && !dp[j][i - newCost[j]].equals("#")){
                    b = j + "" + dp[j][i - newCost[j]];
                }
                if(b.equals("")) dp[j][i] = a;
                else dp[j][i] = getBigger(a, b);
            }
        }
        if(dp[9][target].equals("#")) return "0";
        else return dp[9][target];
    }


    //完全背包问题（一个元素可以选择多次的问题 称为完全背包问题）  一般看到(恰好)构成target的字样, 大多与背包有关.
    public static void main(String[] args){
        Solution1449 solution1449 = new Solution1449();
        System.out.println(solution1449.largestNumber1(new int[]{7,6,5,5,5,6,8,7,8}, 12));
    }
}


