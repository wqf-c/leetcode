package Solution91to135;

import java.util.ArrayList;
import java.util.List;

public class Solution120 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if(size == 0) return 0;
        int[][] dp = new int[size][size];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < size; ++i){
            for(int j = 0; j <= i; ++j){
                if(j == 0){
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
                }else if(j == i){
                    dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int min = dp[size - 1][0];
        for(int i = 1; i < size; ++i){
            if (dp[size - 1][i] < min) min = dp[size - 1][i];
        }
        return min;
    }

    //只用了O(n)的空间
    public int minimumTotal1(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }


    public static void main(String[] args){
        Solution120 s120 = new Solution120();
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        lists.add(list1);
        lists.add(list2);
        lists.add(list3);
        lists.add(list4);
        System.out.println(s120.minimumTotal(lists));
    }
}
