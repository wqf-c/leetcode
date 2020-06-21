package Solution91to135;

public class Solution96 {

    public int numTrees(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        int[] g = new int[n + 1];
        g[0] = 1;
        g[1] = 1;
        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                g[i] += g[j] * g[i - j];
            }
        }
        return g[n];
    }
}
