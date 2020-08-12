package Solution91to135;

import java.util.ArrayList;
import java.util.List;

public class Solution123 {
    public int maxProfit(int[] prices) {
        int dp_i10 = 0, dp_i11 = Integer.MIN_VALUE, dp_i20 = 0, dp_i21 = Integer.MIN_VALUE;
        for(int price : prices){
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);
            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static void main(String[] args){

        Solution123 s123 = new Solution123();
        int[] prices = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(s123.maxProfit(prices));
    }
}
