package CodeTop;

/**
 * @author wqf
 * @date 2021/5/30 14:09
 * @Email:284660487@qq.com
 */
public class Solution69 {

    public int mySqrt(int x) {
        if(x >= 46340 * 46340) return 46340;
        int left = 0, right = 46340;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(mid * mid == x || (mid * mid < x && (mid + 1) * (mid + 1) > x)){
                return mid;
            }
            if(mid > 46339 || mid * mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(Math.sqrt(Integer.MAX_VALUE));
        Solution69 solution69 = new Solution69();
        System.out.println(solution69.mySqrt(562464195));
    }

}
