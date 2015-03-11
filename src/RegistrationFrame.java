import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Karol on 2015-03-10.
 */
public class RegistrationFrame extends JFrame{
    private JLabel LoginLabel;
    private JTextField Login;
    private JLabel PasswordLabel;
    private JPasswordField ConfirmPassword;
    private JPasswordField Password;
    private JTextField EMail;
    private JLabel ConfirmPasswordLabel;
    private JLabel EmailLaber;
    private JButton RegisterButton;
    private JButton ResetButton;
    private JPanel rootPanel1;

    public RegistrationFrame()
    {
        super("Registration");

        setContentPane(rootPanel1);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(RegistrationFrame.this,"Zarejestrowałeś się pomyślnie!");
            }
        });

        setVisible(true);
    }

}
