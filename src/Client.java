import javax.swing.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
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
    ChatFrame chat;


    void login(String login, String pass) {
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
        queue.add("login " + login + " " + pass);


    }

    void Send(String message, String odbiorca){
        System.out.println(message);
        queue.add("msg " + odbiorca + " " + message);
    }
    void Friends(String login, int status){

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
    BlockingQueue<String> queue = new LinkedBlockingQueue<String>();
}
