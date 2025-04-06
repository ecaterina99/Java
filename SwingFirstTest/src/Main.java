import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel mainPanel;
    private JTextField firstName;
    private JTextField lastName;
    private JButton cancel;
    private JButton ok;

    public Main() {
        this.setContentPane(mainPanel);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fn = firstName.getText();
                String ln = lastName.getText();

                if (fn.length() == 0 || ln.length() == 0) {
                    JOptionPane.showMessageDialog(mainPanel, "Please, enter your first name and last name!");
                    return;
                }
                JOptionPane.showMessageDialog(mainPanel, "Hello, " + fn + " " + ln);
            }
        });
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                firstName.setText("");
                lastName.setText("");
            }
        });
    }

    public static void main(String[] args) {
        Main f = new Main();

        f.setSize(400, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}


