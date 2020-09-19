package Graph.practice;

/**
 * @author wqf
 * @date 2020/9/19 17:24
 * @Email:284660487@qq.com
 */
public class Floyd {
    //所有点到其他点的最短路径

    void floyd(){
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        int[][] pre = new int[vertex.length][vertex.length];
        int[][] dis = new int[vertex.length][vertex.length];
        for(int i = 0; i < vertex.length; ++i){
            for (int j = 0; j < vertex.length; ++j){
                dis[i][j] = matrix[i][j];
            }
        }
        for(int i = 0; i < vertex.length; ++i){
            for(int j = 0; j < vertex.length; ++j){
                for(int k = 0; k < vertex.length; ++k){
                    int len = dis[j][i] + dis[i][k];
                    if(len < dis[j][k]){
                        dis[j][k] = len;
                        pre[j][k] = pre[i][k];
                    }
                }
            }
        }
    }
}
