import javax.swing.*;

/**
 * Created by Lotus on 2015-03-30.
 */
public class Friends extends JFrame{
    public JList Friends;
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;

    Client c = new Client();

    public Friends()
    {
        super("friends");
        setContentPane(panel1);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(false);

        LoginFrame frame = new LoginFrame(this);

        c.lf = frame;
        c.fr = this;
        ChatFrame chat = new ChatFrame();
        chat.c = c;
        frame.setVisible(true);

    }
}
