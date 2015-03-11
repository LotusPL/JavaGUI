import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Karol on 2015-03-11.
 */
public class Choose extends JFrame {
    private JButton Logowanie;
    private JButton Rejestracja;
    private JPanel rootPanel;

    public Choose()
    {
        super("Wybór");
        setContentPane(rootPanel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Logowanie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new LoginFrame().setVisible(true);
            }
        });

        Rejestracja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new RegistrationFrame().setVisible(true);
            }
        });

        setVisible(true);
    }
}

