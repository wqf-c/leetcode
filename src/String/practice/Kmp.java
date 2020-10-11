package String.practice;

/**
 * @author wqf
 * @date 2020/10/9 22:28
 * @Email:284660487@qq.com
 */
public class Kmp {

    int kmpSearch(String s, String p){
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        int[] next = new int[p.length()];
        getNext(p, next);
        while (i < sLen && j < pLen){
            if(j == -1 || s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }else{
                j = next[j];
            }
        }
        if(j == p.length()){
            return  i - j;
        }else{
            return -1;
        }
    }

    void getNext(String p, int[] next){
        next[0] = -1;
        int k = -1;
        int j = 0;
        for(; j < p.length() - 1; ){
            if(k == -1 || p.charAt(j) == p.charAt(k)){
                k ++;
                j ++;
                next[j] = k;
            }else{
                k = next[k];
            }
        }
    }

    public static void main(String[] args){
        Kmp kmp = new Kmp();
        kmp.kmpSearch("BBC ABCDAB ABCDABCDABDE", "ABCDABD");
    }
}
