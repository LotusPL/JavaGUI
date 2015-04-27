import javax.swing.*;

class MyModel extends AbstractListModel<String> {

    @Override
    public int getSize() {
        return 10;
    }

    @Override
    public String getElementAt(int index) {
        return Integer.toString(index);
    }
}

/**
 * Created by Lotus on 2015-04-27.
 */
public class Test extends JFrame {
    private JList list1;
    private JPanel panel1;
    public Test(){
        super("Test");
        setContentPane(panel1);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        list1.setModel(new MyModel());

        setVisible(true);

    }
}
