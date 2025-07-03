import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    public LoginForm() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // layout vertical

        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JButton b = new JButton("Login");

        tf1.setToolTipText("e-mail");
        tf2.setToolTipText("password");

        tf1.addFocusListener(new FocusAdapter() {
            public void focusLost(FocusEvent evt) {
                JTextField tf = (JTextField) evt.getSource();
                String email = tf.getText();
                if (email.equals("no@email.com")) {
                    JOptionPane.showMessageDialog(null,
                            "E-mail " + email + " este invalid", "Invalid email", JOptionPane.ERROR_MESSAGE);
                    tf.setText("");
                    tf.requestFocusInWindow();
                }
            }
        });

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (tf1.getText().equals("")) {
                    tf1.requestFocusInWindow();
                } else if (tf2.getText().equals("")) {
                    tf2.requestFocusInWindow();
                } else {
                    JOptionPane.showMessageDialog(null, "Userul " + tf1.getText() +
                            " s-a autentificat cu succes", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        tf1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        tf2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // spațiu
        panel.add(tf1);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(tf2);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(b);

        this.setTitle("Autentificare");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}