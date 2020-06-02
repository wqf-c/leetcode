package solution46to90;

import java.io.IOException;

/**
 * Author: wqf
 * Date: 2020/4/29
 * Time: 14:58
 */
public class SpliteVideo {

  public static void main(String[] args) throws IOException {
    Runtime run = Runtime.getRuntime();
    String inputVideo = "C:\\Users\\wqf\\Videos\\2020-04-3014-04-34.mkv";
    String outputFolder = "C:\\Users\\wqf\\Desktop\\gesture\\src\\test\\nothumb3\\";
    //ffmpeg -ss 00:00:00 -t 00:00:30 -i test.mp4 -vcodec copy -acodec copy output.mp4
    for(int i = 0; i < 24; ++i){
      String outputFile = outputFolder + "test_" + i + ".mkv";
      String start = "00:0" + i * 5 / 60 + ":" + (i * 5 % 60 < 10 ? "0" : "") + i * 5 % 60;
      String end = "00:0" + (i+1) * 5 / 60 + ":" + ((i+1) * 5 % 60 < 10 ? "0" : "") + (i+1) * 5 % 60;
      String cmd = "ffmpeg -ss "+ start +" -t " + 5 + " -i " + inputVideo +" -vcodec copy -acodec copy " + outputFile;
      System.out.println(cmd);
      run.exec(cmd);
    }
  }
}
