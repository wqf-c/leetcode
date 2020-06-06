package solution46to90;

public class Solution88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int [] nums3 = new int[nums1.length];
        int i = 0;
        int j = 0;
        int k = 0;
        for(; i < m && j < n;){
            if(nums1[i] <= nums2[j]){
                nums3[k] = nums1[i];
                i++;
            }else{
                nums3[k] = nums2[j];
                j++;
            }
            k++;
        }
        if(i < m){
            for(; i < m; ++i){
                nums3[k] = nums1[i];
                k++;
            }
        }
        if(j < n){
            for(; j < n; ++j){
                nums3[k] = nums2[j];
                ++k;
            }
        }
        for(int l = 0; l < m+n; l++){
            nums1[l] = nums3[l];
        }
    }
}
