import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class Main extends JFrame {
    private JPanel panel;
    private JList list1;
    private JList list2;
    private JList list3;

    public Main() {
        this.setContentPane(panel);
        list2.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting()) {
                    return;
                }
                JList list = (JList)e.getSource();
                int[] is = list.getSelectedIndices();

                for(Integer i : is){
                    System.out.println(list2.getModel().getElementAt(i));
                }
            }
        });
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

}
