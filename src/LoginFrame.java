import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karol on 2015-03-10.
 */
public class LoginFrame extends JFrame{
    private JButton clickMeButton;
    private JPanel rootPanel;
    private JButton loginButton;
    private JPasswordField password;
    private JTextField login;
    private JLabel LoginLabel;
    private JLabel PasswordLabel;
    private JButton RegisterButton;
    private JButton zaloguj;

    public LoginFrame(){
        super("Logowanie");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LoginFrame.this,"Zalogowałes sie!");
            }
        });
        setVisible(true);

    }


}
