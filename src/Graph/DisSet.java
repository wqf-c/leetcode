package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wqf
 * @date 2020/9/13 22:31
 * @Email:284660487@qq.com
 */
public class DisSet {

    //并查集 图是否形成环
    private List<Integer> parents = null;
    private List<Integer> rank = null;

    void initialise(int size){
        parents = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i = 0; i < size; ++i){
            parents.add(-1);
            rank.add(0);
        }
    }

    int find_root(int x){
        int x_root = x;
        while (parents.get(x_root) != -1){
            x_root = parents.get(x_root);
        }
        return x_root;
    }

    boolean union_vertices(int x, int y){
        int x_root = find_root(x);
        int y_root = find_root(y);
        if(x_root == y_root){
            return false;
        }
        //防止变成链表
        if(rank.get(x_root) < rank.get(y_root)){
            parents.set(x_root, y_root);
        }else if(rank.get(x_root) > rank.get(y_root)){
            parents.set(y_root, x_root);
        }else{
            parents.set(y_root, x_root);
            rank.set(x_root, rank.get(x_root) + 1);
        }
        return true;
    }

    public static void main(String[] args){
        DisSet disSet = new DisSet();
        int[][] edges = {
                {0, 1}, {1, 2}, {1, 3},
                {2, 4}, {3, 4}, {2, 5}
        };
        disSet.initialise(6);
        for(int i = 0; i < edges.length; ++i){
            int x = edges[i][0];
            int y = edges[i][1];
            if(!disSet.union_vertices(x, y)){
                System.out.println("cycle detect");;
                return;
            }
        }
        System.out.println("no cycle found");
    }
}
