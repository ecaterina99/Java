import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;

public class MainForm extends JFrame{
    private JPanel mainPanel;
    private JTextField TextField;
    private JTextField TextField2;
    private JTextArea textArea1;
    private JPasswordField PasswordField;
    private JButton button1;
    private JEditorPane ep;
    private JTextField tf;
    private JButton b;

    public MainForm() {
    this.setContentPane(mainPanel);
    Caret c = TextField.getCaret();
    c.setDot(10);
    c.setBlinkRate(5);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Character c : PasswordField.getPassword())
                JOptionPane.showMessageDialog(null, c);
            }
        });


        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ep.setPage(new URL(tf.getText()));
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }

            }
        });
    }
    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }

}
