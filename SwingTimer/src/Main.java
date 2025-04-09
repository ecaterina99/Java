import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel;
    static Integer elapsed = 0;
    public Main() {
        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        Main frame1 = new Main();
        frame1.setSize(600, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new FlowLayout());
        frame1.setVisible(true);

        Timer t = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame1.setTitle("Time elapsed: " + (elapsed++).toString());
            }
        });
        t.start();

        Action myAction = new AbstractAction("Button") {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Action performed!");
            }
        };
        JButton btn = new JButton();
        JButton btn2 = new JButton();
        frame1.add(btn);
        frame1.add(btn2);
        btn.setAction(myAction);
        btn2.setAction(myAction);
        
    }
}
