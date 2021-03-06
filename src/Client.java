import javax.swing.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Lotus on 2015-03-27.
 */
public class Client {
    Socket socket;
    ThreadOut out;
    ThreadIn in;

    LoginFrame lf;
    Friends fr;
    List<ChatFrame> chats = new LinkedList<ChatFrame>();
    //ChatFrame chats;
    void connector(){
        try {
            socket = new Socket("localhost", 33060);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out = new ThreadOut();
        out.c = this;
        try {
            out.outstream = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        out.start();
        in = new ThreadIn();
        in.c = this;
        try {
            in.input = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            try {
                socket.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        in.start();
    }

    void login(String login, String pass) {

        queue.add("login " + login + " " + pass);


    }
    void register(String login, String pass){
        queue.add("register " + login + " " + pass);

    }
    void send(String message, String odbiorca){
        System.out.println(message);
        queue.add("msg " + odbiorca + " " + message);
    }
    void friends(String login, int status){
        DefaultListModel model = (DefaultListModel)fr.friendsList.getModel();
        switch (status){
            case 0:
                ;
        }
    }
    Boolean isConnected() {
        return null;
    }
    void logs(boolean result){
        if(result == true)
        {
            lf.setVisible(false);
            lf.friends.setVisible(true);
        }
        else if(result == false) {
            JOptionPane.showMessageDialog(lf, "Spróbuj ponownie!");
        }
    }
    void display(String nadawca, String message) {
        for(ChatFrame cf : chats) {
            if(nadawca.equals(cf.nick)) {
                cf.textArea1.append("\n" + nadawca + "\n" + message);
                return;
            }

        }
        ChatFrame cf = new ChatFrame(this, nadawca);
        chats.add(cf);
        cf.textArea1.append("\n" + nadawca + "\n" + message);

    }
    BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
}
