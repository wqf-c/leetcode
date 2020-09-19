package Graph;

/**
 * @author wqf
 * @date 2020/9/19 22:13
 * @Email:284660487@qq.com
 */
public class Solution765 {

    public int minSwapsCouples_tanxin(int[] row) {
        int res = 0;
        int[] indexSave = new int[row.length];
        for(int i = 0; i < row.length; ++i){
            indexSave[row[i]] = i;
        }
        for(int i = 0; i < row.length; i += 2){
            if((row[i] % 2 == 0 && row[i + 1] == row[i]  + 1) ||
                    (row[i] % 2 == 1 && row[i + 1] == row[i] - 1)) continue;
            res ++;
            if(row[i] % 2 == 0){
                int next = row[i] + 1;
                int nextIndex = indexSave[next];
                int temp = row[i + 1];
                row[i + 1] = row[i] + 1;
                row[nextIndex] = temp;
                indexSave[row[i] + 1] = i + 1;
                indexSave[temp] = nextIndex;
            }else{
                int next = row[i] - 1;
                int nextIndex = indexSave[next];
                int temp = row[i + 1];
                row[i + 1] = row[i] - 1;
                row[nextIndex] = temp;
                indexSave[row[i] - 1] = i + 1;
                indexSave[temp] = nextIndex;
            }
        }
        return res;
    }

    //并查集
    int[] parent = null;
    int find_root(int x){
        int x_root = x;
        while (parent[x_root] != x_root) x_root = parent[x_root];
        return x_root;
    }

    void union(int x, int y){
        int x_root = find_root(x);
        int y_root = find_root(y);
        if(x_root != y_root) parent[x_root] = y_root;
    }
    public int minSwapsCouples_disSet(int[] row){
        int count = 0;
        int size = row.length / 2;
        parent = new int[size];
        for(int i = 0; i < size; i++){
            parent[i] = i;
        }
        for(int i = 0; i < row.length; i += 2){
            union(row[i] / 2, row[i + 1] / 2);
        }

        for(int i = 0; i < size; i++){
            if(i != find_root(i)) count++;
        }

        return count;
    }
}
