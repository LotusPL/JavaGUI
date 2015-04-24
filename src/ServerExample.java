/**
 * Created by Lotus on 2015-03-30.
 */
import java.io.*;
import java.net.*;
import java.util.*;


public class ServerExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ServerSocket s = new ServerSocket(33060);
        Socket c = s.accept();
        Scanner sc = new Scanner(c.getInputStream());
        PrintWriter pw = new PrintWriter(c.getOutputStream());
        Scanner console = new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
            pw.println(console.nextLine());
            pw.flush();
        }
    }
}
