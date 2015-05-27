import java.util.Scanner;

/**
 * Created by Lotus on 2015-03-27.
 */
public class ThreadIn implements Runnable{
    Client c;
    Thread t = new Thread(this);
    Scanner input;
    void start(){
        t.start();
    }
    public void run () {
        while(true)
        {
            String text = input.nextLine();
            String[] parts = text.split("\\s");
            if( text.equals("ok")) {
                c.logs(true);
            }
            else if(text.equals("error")) {
                c.logs(false);
            }
            if (text.startsWith("FRIEND")) {
                c.friends(parts[1], Integer.valueOf(parts[2]));
            }
            if (text.startsWith("msg")) {
                c.display(parts[1], text.substring(parts[1].length() + 5));
            }
        }

    }
}