package plain.NIO;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;

/**
 * @author 13314409603@163.com
 * @date 2019/3/26
 * @time 16:59
 * @Description
 */
public class  BufferTest {
    public static void main(String[] args) {
        try {
            RandomAccessFile afile = new RandomAccessFile("E://test.txt","rw") ;
            FileChannel channel = afile.getChannel(); //获得一个FileChannel实例
            ByteBuffer buf = ByteBuffer.allocate(48);
            int read = channel.read(buf);
            while (read != -1){
                System.out.println("Read"+read);
                buf.flip() ;//将ByteBuffer从写模式转换为读模式，为后续从buff中读作准备

                while (buf.hasRemaining()){
                    System.out.println((char)buf.get());
                }

                buf.clear();//将ByteBuffer从读模式转为写模式，为后续写入buff作准备
                read = channel.read(buf) ;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
