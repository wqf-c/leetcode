package solution46to90;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Author: wqf
 * Date: 2020/2/10
 * Time: 23:27
 */
public class dijkstra {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //点数不能超过26
    System.out.print("输入点数:");
    int totalPoints = sc.nextInt();
    System.out.print("输入起点:");
    int start = sc.nextInt();
    System.out.print("输入边最小权值:");
    int minNum = sc.nextInt();
    System.out.print("输入边最大权值:");
    int maxNum = sc.nextInt();
    char[] vertex = new char[totalPoints];
    for(int i = 0; i < totalPoints; ++i){
      vertex[i] = (char)(i + 'A');
    }
    int[][] matrix = new int[totalPoints][totalPoints];
    final int N = 65535;
    for(int i = 0; i < totalPoints; ++i){
      for(int j = i + 1; j < totalPoints; ++j){
        Random rand = new Random();
        int randomNum = rand.nextInt(maxNum - minNum) + minNum;
        if(randomNum % 2 == 0){
          matrix[i][j] = N;
          matrix[j][i] = N;
        }else{
          matrix[i][j] = randomNum;
          matrix[j][i] = randomNum;
        }
      }
    }
//    matrix[0]=new int[]{N,5,7,N,N,N,2};
//    matrix[1]=new int[]{5,N,N,9,N,N,3};
//    matrix[2]=new int[]{7,N,N,N,8,N,N};
//    matrix[3]=new int[]{N,9,N,N,N,4,N};
//    matrix[4]=new int[]{N,N,8,N,N,5,4};
//    matrix[5]=new int[]{N,N,N,4,5,N,6};
//    matrix[6]=new int[]{2,3,N,N,4,6,N};

    Graph graph = new Graph(vertex, matrix);

    graph.showGraph();
    long time1 = System.currentTimeMillis();
    graph.dsj(start);
    long time2 = System.currentTimeMillis();
    System.out.println(time2 - time1);

    graph.showDijkstra(vertex);
  }
}

class Graph {
  private char[] vertex; // ¶¥µãÊý×é
  private int[][] matrix; // ÁÚ½Ó¾ØÕó
  private VisitedVertex vv; //保存访问顶点

  public Graph(char[] vertex, int[][] matrix) {
    this.vertex = vertex;
    this.matrix = matrix;
  }

  public void showDijkstra(char[] vertex) {
    vv.show(vertex);
  }

  public void showGraph() {
    for (int[] link : matrix) {
      System.out.println(Arrays.toString(link));
    }
  }

  /**
   *
   * @param index 出发顶点的下标
   */
  public void dsj(int index) {
    vv = new VisitedVertex(vertex.length, index);
    update(index);
    for(int j = 1; j <vertex.length; j++) {
      index = vv.updateArr();
      update(index);
    }
  }



  //更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
  private void update(int index) {
    int len = 0;

    for(int j = 0; j < matrix[index].length; j++) {

      len = vv.getDis(index) + matrix[index][j];

      if(!vv.in(j) && len < vv.getDis(j)) {
        vv.updatePre(j, index);
        vv.updateDis(j, len);
      }
    }
  }
}

class VisitedVertex {
  // 顶点是否访问过，1表示访问过
  public int[] already_arr;
  //前一个顶点下标
  public int[] pre_visited;
  // 出发点到其他顶点的距离
  public int[] dis;

  //¹¹ÔìÆ÷
  /**
   *
   * @param length :±íÊ¾¶¥µãµÄ¸öÊý
   * @param index: ³ö·¢¶¥µã¶ÔÓ¦µÄÏÂ±ê, ±ÈÈçG¶¥µã£¬ÏÂ±ê¾ÍÊÇ6
   */
  public VisitedVertex(int length, int index) {
    this.already_arr = new int[length];
    this.pre_visited = new int[length];
    this.dis = new int[length];
    //³õÊ¼»¯ disÊý×é
    Arrays.fill(dis, 65535);
    this.already_arr[index] = 1; //ÉèÖÃ³ö·¢¶¥µã±»·ÃÎÊ¹ý
    this.dis[index] = 0;//ÉèÖÃ³ö·¢¶¥µãµÄ·ÃÎÊ¾àÀëÎª0

  }
  /**
   * 判断index是否被访问过
   * @param index
   * @return
   */
  public boolean in(int index) {
    return already_arr[index] == 1;
  }

  /**
   * 更新出发顶点到index顶点的距离
   * @param index
   * @param len
   */
  public void updateDis(int index, int len) {
    dis[index] = len;
  }
  /**
   * 更新前驱顶点为index
   * @param pre
   * @param index
   */
  public void updatePre(int pre, int index) {
    pre_visited[pre] = index;
  }
  /**
   * 放回出发顶点到index的距离
   * @param index
   */
  public int getDis(int index) {
    return dis[index];
  }


  /**
   *
   * @return
   */
  public int updateArr() {
    int min = 65535, index = 0;
    for(int i = 0; i < already_arr.length; i++) {
      if(already_arr[i] == 0 && dis[i] < min ) {
        min = dis[i];
        index = i;
      }
    }

    already_arr[index] = 1;
    return index;
  }

  //ÏÔÊ¾×îºóµÄ½á¹û
  //¼´½«Èý¸öÊý×éµÄÇé¿öÊä³ö
  public void show(char[] vertex) {

    System.out.println("==========================");
    //Êä³öalready_arr
    for(int i : already_arr) {
      System.out.print(i + " ");
    }
    System.out.println();
    //Êä³öpre_visited
    for(int i : pre_visited) {
      System.out.print(i + " ");
    }
    System.out.println();
    //Êä³ödis
    for(int i : dis) {
      System.out.print(i + " ");
    }
    System.out.println();
    //ÎªÁËºÃ¿´×îºóµÄ×î¶Ì¾àÀë£¬ÎÒÃÇ´¦Àí
    int count = 0;
    for (int i : dis) {
      if (i != 65535) {
        System.out.print(vertex[count] + "("+i+") ");
      } else {
        System.out.println("N ");
      }
      count++;
    }
    System.out.println();

  }

}



