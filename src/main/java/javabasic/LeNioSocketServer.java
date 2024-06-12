package javabasic;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.SocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class LeNioSocketServer {
    public static void main(String[] args) throws Exception{
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(6666));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()){
                SelectionKey next = iterator.next();

                if(next.isAcceptable()){
                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) next.channel();
                    SocketChannel channel = serverSocketChannel1.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);
                }else if(next.isReadable()){
                    SocketChannel channel = (SocketChannel) next.channel();
                    ByteBuffer bf = ByteBuffer.allocate(1024);
                    int read = channel.read(bf);
                    if (read>0){
                        bf.flip();
                        byte[] bytes = new byte[bf.remaining()];
                        bf.get(bytes);
                        String s = new String(bytes);
                        System.out.println(s);

                        Thread.sleep(10);
                        String resp = "ACK " + s;
                        bf.clear();
                        bf.put(resp.getBytes(StandardCharsets.UTF_8));
                        bf.flip();
                        while (bf.hasRemaining()){
                            channel.write(bf);
                        }
                    }else{
                        channel.close();
                    }
                }
                iterator.remove();
            }
        }


    }
}
