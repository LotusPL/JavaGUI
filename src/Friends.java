import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Lotus on 2015-03-30.
 */
public class Friends extends JFrame{
    public JList friendsList;
    private JPanel panel1;
    private JTextField textField1;
    private JButton openChatButton;

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

        openChatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String who = textField1.getText().trim();

                ChatFrame chat = new ChatFrame(c, who);
                c.chats.add(chat);


            }
        });
        friendsList.setModel(new DefaultListModel());

        frame.setVisible(true);

    }
}
