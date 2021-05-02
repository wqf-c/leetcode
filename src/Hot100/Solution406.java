package Hot100;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author wqf
 * @date 2021/4/22 0:24
 * @Email:284660487@qq.com
 */
public class Solution406 {

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int[] used = new int[people.length];
        Arrays.fill(used, -1);
        int[][] rst = new int[people.length][2];
        for(int[] p : people){
            int index = 0;
            for(int i = 0, j = 0; i < used.length; i++){
                if(used[i] == -1 || used[i] == p[0]){
                    if(j == p[1]){
                        index = i;
                        used[i] = p[0];
                        break;
                    }
                    j++;
                }
            }
            rst[index][0] = p[0];
            rst[index][1] = p[1];
        }
        return rst;
    }

    public static void main(String[] args) {
        Solution406 solution406 = new Solution406();
        solution406.reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
    }

}
