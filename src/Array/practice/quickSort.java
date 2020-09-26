package Array.practice;

/**
 * @author wqf
 * @date 2020/9/26 14:03
 * @Email:284660487@qq.com
 */
public class quickSort {

    static void sort(int[] array, int left, int right){
        if(left >= right) return;
        int l = left, r = right;
        int mid = (left + right) / 2;
        int temp = array[mid];
        array[mid] = array[left];
        array[left] = temp;
        while (l < r){
            while (r > l && temp <= array[r]) r--;
            while (l < r && temp >= array[l]) l++;
            if(l < r){
                int t = array[l];
                array[l] = array[r];
                array[r] = t;
            }
        }
        array[left] = array[l];
        array[l] = temp;
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }

    public static void main(String[] args){
        int[] array = {-9, 78, 0, 23, -567, 70};
        sort(array, 0, array.length - 1);
        for(int i = 0; i < array.length; ++i){
            System.out.println(array[i]);
        }
    }
}
