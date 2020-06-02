package solution46to90;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FloydAlgorithm {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //点数不能超过26
    System.out.print("输入点数:");
    int totalPoints = sc.nextInt();
    System.out.print("输入边最小权值:");
    int minNum = sc.nextInt();
    System.out.print("输入边最大权值:");
    int maxNum = sc.nextInt();
    char[] vertex = new char[totalPoints];
    for(int i = 0; i < totalPoints; ++i){
      vertex[i] = (char)(i + 'A');
    }
    final int N = 65535;
    int[][] matrix = new int[totalPoints][totalPoints];
    for(int i = 0; i < totalPoints; ++i){
      for(int j = i + 1; j < totalPoints; ++j){
        Random rand = new Random();
        int randomNum = rand.nextInt(maxNum - minNum) + minNum;
        if(randomNum % 2 == 0){
          matrix[i][j] = randomNum;
          matrix[j][i] = randomNum;
        }else{
          matrix[i][j] = N;
          matrix[j][i] = N;
        }

      }
    }

    Graph1 graph = new Graph1(vertex.length, matrix, vertex);
    long time1 = System.currentTimeMillis();
    graph.floyd();
    long time2 = System.currentTimeMillis();
    System.out.println(time2 - time1);
    graph.show(vertex);
  }

}

class Graph1 {
  private char[] vertex;
  private int[][] dis;
  private int[][] pre;

  /**
   *
   * @param length
   *            ��С
   * @param matrix
   *            �ڽӾ���
   * @param vertex
   *            ��������
   */
  public Graph1(int length, int[][] matrix, char[] vertex) {
    this.vertex = vertex;
    this.dis = matrix;
    this.pre = new int[length][length];
    for (int i = 0; i < length; i++) {
      Arrays.fill(pre[i], i);
    }
  }

  public void show(char[] vertex) {
    for (int k = 0; k < dis.length; k++) {
      for (int i = 0; i < dis[k].length; i++) {
        System.out.print(dis[k][i] + " ");
      }

      System.out.println();
      System.out.println();

    }

  }

  public void floyd() {
    int len = 0;
    for(int k = 0; k < dis.length; k++) { //
      for(int i = 0; i < dis.length; i++) {
        for(int j = 0; j < dis.length; j++) {
          len = dis[i][k] + dis[k][j];
          if(len < dis[i][j]) {
            dis[i][j] = len;
            pre[i][j] = pre[k][j];
          }
        }
      }
    }
  }
}
