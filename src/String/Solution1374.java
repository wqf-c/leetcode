package String;

/**
 * @author wqf
 * @date 2020/10/18 23:01
 * @Email:284660487@qq.com
 */
public class Solution1374 {

    public String generateTheString(int n) {
        char[] rst = new char[n];
        for(int i = 0; i < n; ++i){
            rst[i] = 'a';
        }
        if(n % 2 == 0) rst[n - 1] = 'b';
        return new String(rst);
    }
}
