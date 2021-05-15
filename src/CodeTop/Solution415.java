package CodeTop;

/**
 * @author wqf
 * @date 2021/5/9 22:48
 * @Email:284660487@qq.com
 */
public class Solution415 {

    public String addStrings(String num1, String num2) {
        int rstLen = Math.max(num1.length(), num2.length());
        char[] chars = new char[rstLen + 1];
        int add = 0;
        int charsIndex = chars.length - 1;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; --i, --j){
            int nums1 = '0', nums2 = '0';
            if(i >= 0) nums1 = num1.charAt(i);
            if(j >= 0) nums2 = num2.charAt(j);
            int r = nums1 + nums2 + add - '0' - '0';
            int m = r % 10;
            add = r / 10;
            chars[charsIndex] = (char) (m + '0');
            charsIndex--;
        }
        if(add != 0){
            chars[charsIndex] = (char)(add + '0');
            String rst = new String(chars);
            return rst;
        }else{
            String rst = new String(chars, 1, chars.length - 1);
            return rst;
        }
    }

}
