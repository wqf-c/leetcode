package Solution91to135;

public class Solution718 {

    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length][B.length];
        for(int i = 0; i < B.length; ++i){
            dp[0][i] = (A[0] == B[i] ? 1 : 0);
        }
        for(int i = 0; i < A.length; ++i){
            dp[i][0] = (A[i] == B[0] ? 1 : 0);
        }
        int max = 0;
        for(int i = 1; i < A.length; ++i){
            for(int j = 1; j < B.length; ++j){
                if(A[i] == B[j]) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = 0;
                if(dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }
}
