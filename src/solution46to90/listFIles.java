package solution46to90;

import java.io.*;

/**
 * Author: wqf
 * Date: 2020/4/28
 * Time: 13:01
 */
public class listFIles {

  public static void main(String[] args) throws IOException {
    //File directory = new File("D:\\ebuptcode\\gesture\\src\\train\\Data\\thumb\\train");
    Writer is = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\ebuptcode\\gesture\\src\\train\\Data\\thumb\\train\\info.txt")));
    for(int i = 1; i <= 300; ++i){
      is.write("thumbwqf_" + i + ".jpg");
      is.write(System.getProperty("line.separator"));
    }
    is.close();
  }
}
