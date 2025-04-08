import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel mainPanel;
    private SwingMyComponent myComponent;

    public Main() {
        this.setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);


    }

    private void createUIComponents() {
        myComponent = new SwingMyComponent();


    }
}
