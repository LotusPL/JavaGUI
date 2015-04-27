import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Lotus on 2015-03-30.
 */
public class ChatFrame extends JFrame{
    public JTextArea textArea1;
    private JTextField textField1;
    private JButton button1;
    private JPanel chat;

    Client c;
    String nick = "qwerty";
    public ChatFrame(){
        super("Chat");
        setContentPane(chat);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textArea1.setColumns(5);
        textArea1.setRows(5);
        textArea1.setTabSize(100);
        textArea1.setLineWrap(true);
        textArea1.setEditable(false);
        textField1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER) {
                    String message = textField1.getText().trim();
                    System.out.println("Msg");
                    c.send(message, nick);
                    textField1.setText("");
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String message = textField1.getText().trim();
                c.send(message, nick);

            }
        });
        setVisible(true);
    }

}
