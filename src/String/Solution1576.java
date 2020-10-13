package String;

/**
 * @author wqf
 * @date 2020/10/11 11:58
 * @Email:284660487@qq.com
 */
public class Solution1576 {

    public String modifyString(String s) {
        char[] chars = s.toCharArray();
        if(s == null || s.length() == 0) return s;
        char before = 'a';
        for(int i = 0; i < chars.length; ++i){
            char append = 'a';
            if(chars[i] != '?') append = chars[i];
            else{
                char after = i == chars.length - 1 ? 'a' : chars[i + 1];
                while (append == before || append == after){
                    append ++;
                }
            }
            chars[i] = append;
            before = append;
        }
        return new String(chars);
    }
}
