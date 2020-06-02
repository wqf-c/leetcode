package solution1to45;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
 * Author: wqf
 * Date: 2020/2/17
 * Time: 21:43
 */
public class SoundTest {

  public static void main(String[] args) {

    new Thread(() ->{
      AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
      SourceDataLine sdl = null;
      try {
        sdl = AudioSystem.getSourceDataLine(audioFormat);
        sdl.open(audioFormat);
        sdl.start();
        while (true){
          System.out.println("aa");
          Thread.sleep(10);
          byte[] bytes = new byte[5512];
//        for(int i = 0; i < bytes.length; ++i){
//          bytes[i] = (byte) i;
//        }
          sdl.write(bytes, 0, bytes.length);
        }
      } catch (Exception e) {
        System.out.println("pp");
        e.printStackTrace();
      }
    }).start();

    new Thread(() ->{
      AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, 44100F, 16, 2, 4, 44100F, true);
      SourceDataLine sdl = null;
      try {
        sdl = AudioSystem.getSourceDataLine(audioFormat);
        sdl.open(audioFormat);
        sdl.start();
        while (true){
          System.out.println("bb");
          Thread.sleep(10);
          byte[] bytes = new byte[5512];
//        for(int i = 0; i < bytes.length; ++i){
//          bytes[i] = (byte) i;
//        }
          sdl.write(bytes, 0, bytes.length);
        }
      } catch (Exception e) {
        System.out.println("kk");
        e.printStackTrace();
      }
    }).start();

  }
}
