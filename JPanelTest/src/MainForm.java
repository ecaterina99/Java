package MyComponent;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JLabel testLabel;
    private JLabel testLabel2;

    public MainForm() {
        this.setContentPane(mainPanel);

        // добавляем второй лейбл программно
        testLabel2 = new JLabel("Hello World!");
        mainPanel.add(testLabel2); // добавляем его на mainPanel

        setTitle("Test Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MainForm f = new MainForm();
            f.setVisible(true);
        });
    }
}