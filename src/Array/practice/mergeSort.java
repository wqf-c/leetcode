package Array.practice;

/**
 * @author wqf
 * @date 2020/9/26 19:25
 * @Email:284660487@qq.com
 */
public class mergeSort {

    public static void main(String[] args){
        int[] arrays = {8, 4, 5, 7, 1, 3, 6};
        int[] temp = new int[arrays.length];
        mergeSort(arrays, 0, arrays.length - 1, temp);
        for(int i = 0; i < arrays.length; ++i){
            System.out.println(arrays[i]);
        }
    }

    public static void mergeSort(int[] arrys, int left, int right, int[] temp){
        if(left < right){
            int mid = (left + right) / 2;
            mergeSort(arrys, left, mid, temp);
            mergeSort(arrys, mid + 1, right, temp);
            merge(arrys, left, mid, right, temp);
        }
    }

    public static void merge(int[] arrays, int left, int mid, int right, int[] temp){
        int l1 = left;
        int l2 = mid + 1;
        int t = 0;
        while (l1 <= mid && l2 <= right){
            if(arrays[l1] <= arrays[l2]){
                temp[t] = arrays[l1];
                t++;
                l1++;
            }else{
                temp[t] = arrays[l2];
                t++;
                l2++;
            }
        }
        while (l1 <= mid){
            temp[t] = arrays[l1];
            t++;
            l1++;
        }
        while (l2 <= right){
            temp[t] = arrays[l2];
            l2++;
            t++;
        }
        t = 0;
        int tempLeft = left;
        for(; tempLeft <= right; ++tempLeft, ++t){
            arrays[tempLeft] = temp[t];
        }
    }
}
