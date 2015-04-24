import java.io.PrintWriter;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * Created by Lotus on 2015-04-20.
 */
public class SingleClient {
    String nick;
    SocketChannel ch;
    Server serv;
    Scanner scan;
    PrintWriter pw;
    void Receive(String message){
        pw.println(message);
        pw.flush();
    }
    void Read(){
        String line = scan.nextLine();
        System.out.println(line);
        String[] parts = line.split("\\s");
        if (parts[0].equals("msg")){
            line.substring(5+parts[1].length());
        }
        if (parts[0].equals("login")){
            nick = parts[1];
            serv.ans.queue.add(nick + " ok");
        }
    }

}
