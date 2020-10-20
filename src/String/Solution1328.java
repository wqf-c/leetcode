package String;

/**
 * @author wqf
 * @date 2020/10/16 8:27
 * @Email:284660487@qq.com
 */
public class Solution1328 {

    public String breakPalindrome(String palindrome) {
        char[] chars = palindrome.toCharArray();
        if(chars.length == 0 || chars.length == 1) return "";
        boolean findFlag = false;
        for(int i = 0; i < chars.length; ++i){
            if(chars[i] != 'a' && !(chars.length % 2 == 1 && i == chars.length / 2)) {
                chars[i] = 'a';
                findFlag = true;
                break;
            }
        }
        if(!findFlag) chars[chars.length - 1] = 'b';
        return new String(chars);
    }

}
