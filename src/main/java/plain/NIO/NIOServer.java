package plain.NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;

/**
 * @author 13314409603@163.com
 * @date 2019/3/26
 * @time 20:22
 * @Description
 */
public class NIOServer {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;
    private static final int BUFFER_SIZE = 1024;
    private int port = 8081;
    public NIOServer(int port){
        this.port = port ;
    }
    public NIOServer(){}

    public void start(){
        ServerSocketChannel ssc = null ;
        try {
            ssc = ServerSocketChannel.open() ;
            ssc.configureBlocking(false) ;
            ssc.bind(new InetSocketAddress(this.port)) ;

            //新建selector
            Selector sel = Selector.open() ;
            //注册该channel监听accept事件
            ssc.register(sel, SelectionKey.OP_ACCEPT) ;
            while (true){
                Set<SelectionKey> keySet = null ;
                try {
                    int numKeys = sel.select(); //Java 1.7之前jdk有个bug，没有关注的事件发生，但是NIO仍然从select阻塞中wake up,
                                                // 从而导致一直执行后续的空轮询，cpu100%
                    if(numKeys==0){
                        System.err.println("select wake up with zero");
                    }
                    keySet = sel.selectedKeys();
                }catch (Exception e){
                    e.printStackTrace();
                    break;
                }

                for(Iterator<SelectionKey> iterator = keySet.iterator(); iterator.hasNext();){
                    SelectionKey skey = iterator.next();
                    iterator.remove();
                    try{
                        //accept事件
                        if(skey.isAcceptable()){
                            ServerSocketChannel channel = (ServerSocketChannel) skey.channel();
                            SocketChannel accept = channel.accept();
                            //将新建的channel再次注册到selector，并且监听read事件
                            accept.configureBlocking(false) ;
                            SelectionKey skey2 = accept.register(sel, SelectionKey.OP_READ);
                            skey2.attach(ByteBuffer.allocate(BUFFER_SIZE));
                        }else if(skey.isReadable()){
                            //处理客户端数据传输过来事件,客户端一输入，这边就接到了，内容在attach的ByteBuffer中
                            SocketChannel channel = (SocketChannel) skey.channel();
                            ByteBuffer attachment = (ByteBuffer) skey.attachment();
                            String msg = "";
                            boolean isEnd = false ;
                            if(attachment.hasRemaining()){
                                int len = channel.read(attachment) ;
                                //检查是否已\r\n结尾
                                if(len!=-1 && attachment.position()>1){
                                    char lastChar = (char)attachment.get(attachment.position()-1) ;
                                    char last2Char = (char)attachment.get(attachment.position()-2) ;
                                    if(String.valueOf(new char[]{last2Char,lastChar}).equals("\r\n")){
                                        System.out.println("client input ent");
                                        isEnd = true ;
                                    }
                                }
                                if(len == -1){
                                    System.out.println("client closed");//?什么时候进入
                                    isEnd = true ;
                                }
                            }else {
                                System.out.println("buff is full");
                                msg = "you can only enter" +BUFFER_SIZE+"chars \r\n";
                                isEnd = true ;
                            }

                            if(isEnd){
                                ByteBuffer[] byteBuffers = processInput(attachment, msg);
                                channel.register(sel,SelectionKey.OP_WRITE,byteBuffers) ;
                            }
                        }else if(skey.isWritable()){
                            SocketChannel channel = (SocketChannel) skey.channel();
                            ByteBuffer[] attachment = (ByteBuffer[]) skey.attachment();
                            if(attachment[attachment.length-1].hasRemaining()){
                                channel.write(attachment);
                            }else {
                                channel.close();
                            }
                        }
                    }catch(Exception e){
                        skey.cancel();
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ByteBuffer[] processInput(ByteBuffer bf,String msg) throws Exception {
        bf.flip();
        ByteBuffer promMsg = ByteBuffer.wrap((msg + "You just input:\r\n").getBytes(DEFAULT_CHARSET));
        ByteBuffer[] att = {promMsg, bf};
        String input = new String(bf.array(), bf.position(), bf.limit(), DEFAULT_CHARSET).trim();
        if(input.indexOf("get file:")!=-1){
            String file = input.substring("get file:".length()).trim();
            System.out.println("fileName:"+file);
            URL resource = this.getClass().getClassLoader().getResource(file);
            if(resource!=null){
                Path path = Paths.get(resource.toURI()) ;
                System.out.println(path);
                ByteBuffer fileData = ByteBuffer.wrap(Files.readAllBytes(path));
                ByteBuffer info = ByteBuffer.wrap(("The content of file " + file + ":\r\n").getBytes(DEFAULT_CHARSET));
                att = new ByteBuffer[]{promMsg,bf,info,fileData};
            }else {
                String s = "fileName:"+file+" not found in the classpath";
                System.out.println(s);
                att = new ByteBuffer[]{promMsg,bf,ByteBuffer.wrap(s.getBytes(DEFAULT_CHARSET))} ;
            }
        }
        return att;
    }

    public static void main(String[] args) {
        new NIOServer().start();
    }
}
