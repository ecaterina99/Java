import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JLabel testLabel;
    private JLabel testLabel2;


    public Main() {
        this.setContentPane(mainPanel);

        testLabel2 = new JLabel("Hello World");
        this.add(testLabel2);

    }

    public static void main(String[] args) {
        Main f = new Main();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400, 300);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}

