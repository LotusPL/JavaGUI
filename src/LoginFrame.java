import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    public LoginFrame(){
        super("Logowanie");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LoginFrame.this, "Zalogowałes sie!");
                String text = Login.getText().trim();
                System.out.print(text);
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
