import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Created by Karol on 2015-03-10.
 */
public class RegistrationFrame extends JFrame {
    private JLabel LoginLabel;
    public JTextField Login;
    private JLabel PasswordLabel;
    private JPasswordField ConfirmPassword;
    private JPasswordField Password;
    private JLabel ConfirmPasswordLabel;
    public JButton RegisterButton;
    private JButton ResetButton;
    private JPanel rootPanel1;

    Friends friends;

    public RegistrationFrame()
    {
        super("Registration");

        setContentPane(rootPanel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String login = Login.getText().trim();

                char[] pass = Password.getPassword();
                char[] confpass = ConfirmPassword.getPassword();

                //System.outstream.print(confpass);
                String pass1 = new String(pass);
                String confpass1 = new String(confpass);
                //System.out.print(login + '\n' + pass1 + '\n' + confpass1);
                friends.c.connector();
                friends.c.register(login, pass1);
                friends.setVisible(true);
                setVisible(false);

            }
        });
        ConfirmPassword.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    String login = Login.getText().trim();

                    char[] pass = Password.getPassword();
                    char[] confpass = ConfirmPassword.getPassword();

                    //System.outstream.print(confpass);
                    String pass1 = String.valueOf(pass);
                    String confpass1 = String.valueOf(confpass);
                    //System.out.print(login + '\n' + pass1 + '\n' + confpass1);
                    friends.c.connector();
                    friends.c.register(login, pass1);
                    friends.setVisible(true);
                    setVisible(false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        setVisible(true);
    }

}
