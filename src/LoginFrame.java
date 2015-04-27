import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Karol on 2015-03-10.
 */
public class LoginFrame extends JFrame{
    private JPanel rootPanel;
    private JButton loginButton;
    private JLabel LoginLabel;
    private JLabel PasswordLabel;
    private JTextField Login;
    private JPasswordField Password;
    private JButton Register;

    Friends friends;

    public LoginFrame(final Friends friends){
        super("Logowanie");
        setContentPane(rootPanel);
        this.friends = friends;
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String login = Login.getText().trim();
                char[] pass = Password.getPassword();
                String pass1 = String.valueOf(pass);
                friends.c.connector();
                friends.c.login(login, pass1);

            }
        });
        Password.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String login = Login.getText().trim();
                    char[] pass = Password.getPassword();
                    String pass1 = String.valueOf(pass);
                    friends.c.login(login, pass1);
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RegistrationFrame().setVisible(true);
            }
        });

        setVisible(true);

    }


}
