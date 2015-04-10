import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Karol on 2015-03-10.
 */
public class RegistrationFrame extends JFrame {
    private JLabel LoginLabel;
    public JTextField Login;
    private JLabel PasswordLabel;
    private JPasswordField ConfirmPassword;
    private JPasswordField Password;
    private JTextField EMail;
    private JLabel ConfirmPasswordLabel;
    private JLabel EmailLaber;
    public JButton RegisterButton;
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

                String login = Login.getText().trim();

                char[] pass = Password.getPassword();
                char[] confpass = ConfirmPassword.getPassword();
                String mail = EMail.getText().trim();

                //System.outstream.print(confpass);
                String pass1 = String.valueOf(pass);
                String confpass1 = String.valueOf(confpass);
                System.out.print(login + '\n' + pass1 + '\n' + confpass1);
                if(pass1.equals(confpass1)) {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Zarejestrowałeś się pomyślnie!");
                }
                else {
                    JOptionPane.showMessageDialog(RegistrationFrame.this, "Gdzieś popełniłeś błąd!");
                }
            }
        });

        setVisible(true);
    }

}
