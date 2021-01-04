package ReCall;

/**
 * @author wqf
 * @date 2021/1/5 0:42
 * @Email:284660487@qq.com
 */
public class Solution357 {

    int count = 0;
    boolean[] visited = null;
    int wei = 0;
    public int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        visited = new boolean[10];
        wei = n;
        for(int i = 1; i < 10; ++i){
            visited[i] = true;
            count++;
            dfs(1);
            visited[i] = false;
        }
        //+ 0
        return count + 1;
    }

    void dfs(int cur){
        if(cur == wei) {
            return;
        }
        for(int i = 0; i <= 9; ++i){
            if(!visited[i]){
                visited[i] = true;
                count++;
                dfs(cur + 1);
                visited[i] = false;
            }
        }
    }

}
