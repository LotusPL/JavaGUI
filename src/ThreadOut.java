import java.io.PrintStream;

/**
 * Created by Lotus on 2015-03-27.
 */
public class ThreadOut implements Runnable {
    Thread t = new Thread(this);
    Client c;
    PrintStream outstream;
    void start(){
        t.start();
    }
    public void run() {
        while(true)
        {
            String text = null;
            try {
                text = c.queue.take();
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("> " + text);
            outstream.println(text);
        }
    }

}