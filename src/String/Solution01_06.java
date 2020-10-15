package String;

/**
 * @author wqf
 * @date 2020/10/14 8:14
 * @Email:284660487@qq.com
 */
public class Solution01_06 {
    public String compressString(String S) {
        char[] rst = new char[S.length() * 2];
        int i = 0;
        int rstIndex = 0;
        while (i < S.length()){
            int len = 0;
            char cur = S.charAt(i);
            while (i < S.length() && S.charAt(i) == cur){
                len++;
                i++;
            }
            rst[rstIndex] = cur;
            rstIndex++;
            if(len < 10){
                rst[rstIndex] = (char) (len + '0');
                rstIndex++;
            }else{
                char[] temp = new char[5];
                int tempI = 0;
                while (len > 0){
                    temp[tempI] = (char)(len % 10 + '0');
                    len /= 10;
                    tempI++;
                }
                for(int j = tempI - 1; j >= 0; --j){
                    rst[rstIndex] = temp[j];
                    rstIndex++;
                }
            }
        }
        if(S.length() <= rstIndex) return S;
        else{
            return new String(rst, 0, rstIndex);
        }
    }

    public static void main(String[] args){
        Solution01_06 solution01_06 = new Solution01_06();
        solution01_06.compressString("rrrrrLLLLLPPPPPPRRRRRgggNNNNNVVVVVVVVVVDDDDDDDDDDIIIIIIIIIIlllllllAAAAqqqqqqqbbbNNNNffffff");
    }
}
