package Solution91to135;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution119 {

    //妙啊
    public List<Integer> getRow(int rowIndex) {
        Integer[] dp = new Integer[rowIndex + 1];
        Arrays.fill(dp,1);
        for(int i = 2;i < dp.length;i++){
            for(int j = i - 1;j > 0;j--)
                dp[j] = dp[j] + dp[j - 1];
        }
        List<Integer> res = Arrays.asList(dp);
        return res;
    }
}
