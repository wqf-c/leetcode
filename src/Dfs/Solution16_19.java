package Dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wqf
 * @date 2020/11/19 21:34
 * @Email:284660487@qq.com
 */
public class Solution16_19 {

    public int[] pondSizes(int[][] land) {
        boolean[][] visited = new boolean[land.length][land[0].length];
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < land.length; ++i){
            for(int j = 0; j < land[0].length; ++j){
                if(!visited[i][j] && land[i][j] == 0){
                    int area = getLandArea(land, j, i, visited);
                    list.add(area);
                    count++;
                }
            }
        }
        int[] rst = new int[count];
        for(int i = 0; i < count; ++i){
            rst[i] = list.get(i);
        }
        Arrays.sort(rst);
        return rst;
    }

    public int getLandArea(int[][] land, int xPos, int yPos, boolean[][] visited){
        if(xPos < 0 || xPos >= land[0].length || yPos < 0 || yPos >= land.length || visited[yPos][xPos] || land[yPos][xPos] != 0){
            return 0;
        }
        int area1 = 0;
        int area2 = 0;
        int area3 = 0;
        int area4 = 0;
        int area5 = 0;
        int area6 = 0;
        int area7 = 0;
        int area8 = 0;
        visited[yPos][xPos] = true;
        area5 = getLandArea(land, xPos - 1, yPos - 1, visited);
        area6 = getLandArea(land, xPos, yPos - 1, visited);
        area7 = getLandArea(land, xPos + 1, yPos - 1, visited);
        area8 = getLandArea(land, xPos - 1, yPos, visited);
        area1 = getLandArea(land, xPos - 1, yPos + 1, visited);
        area2 = getLandArea(land, xPos, yPos + 1, visited);
        area3 = getLandArea(land, xPos + 1, yPos + 1, visited);
        area4 = getLandArea(land, xPos + 1, yPos, visited);

        return area1 + area2 + area3 + area4 + 1 + area5 + area6 + area7 + area8;
    }

    public static void main(String[] args){
        Solution16_19 solution16_19 = new Solution16_19();
        int[][] land = {
                {0,2,1,0},
                {0,1,0,1},
                {1,1,0,1},
                {0,1,0,1}
        };
        solution16_19.pondSizes(land);
    }

}
