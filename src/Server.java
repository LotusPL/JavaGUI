import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;

/**
 * Created by Lotus on 2015-04-20.
 */
public class Server implements Runnable{
    List<SingleClient> clients = new LinkedList<SingleClient>();
    public static void main(String[] args){
        new Server().run();
    }
    Answer ans;
    FakeDatabase FDB;
    public void run(){
        ans = new Answer();
        ans.serv = this;
        new Thread(ans).start();

        try {
            Selector selector = Selector.open();

            ServerSocketChannel channel = ServerSocketChannel.open();
            channel.configureBlocking(false);
            channel.bind(new InetSocketAddress(33060));
            channel.register(selector, SelectionKey.OP_ACCEPT);


            while(true)
            {
                if(selector.select()>0) {
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> i = keys.iterator();
                    while(i.hasNext()) {
                        SelectionKey key = i.next();
                        i.remove();
                        if (key.isAcceptable()) {
                            SocketChannel socketchannel = channel.accept();
                            SingleClient client = new SingleClient();
                            client.ch = socketchannel;
                            client.serv = this;
                            client.scan = new Scanner(socketchannel);

                            client.pw = new PrintWriter(socketchannel.socket().getOutputStream());

                            socketchannel.configureBlocking(false);
                            socketchannel.register(selector,SelectionKey.OP_READ,client);
                            clients.add(client);

                        }
                        if (key.isReadable()){
                            SingleClient client = (SingleClient)key.attachment();
                            client.Read();
                        }
                    }


                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
