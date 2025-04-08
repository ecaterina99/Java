import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainForm extends JFrame {
    private JPanel myLabel;
    private JLabel testLabel2;
    private JLabel testLabel;
    private JButton myButtonButton;
    private JButton myButtonButton2;


    public MainForm() {
        this.setContentPane(myLabel);

        this.setTitle("Test");
        testLabel2 = new JLabel("Test Label");
        testLabel2 = new JLabel("<html>Hello World<br/>from<br/>my<br/>label!</html>");
        this.add(testLabel2);

        testLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel label = (JLabel) e.getComponent();
                label.setText("<html>Clicked!</html>");
            }
        });


       /* myButtonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, e.getActionCommand());
            }
        });
        */



        ActionListener myAl = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Hello"))
                    JOptionPane.showMessageDialog(null, "Hello!");
                if(e.getActionCommand().equals("Goodbye"))
                    JOptionPane.showMessageDialog(null, "Goodbye!");
            }
        };
        myButtonButton.setActionCommand("Hello");
        myButtonButton2.setActionCommand("Goodbye");
        myButtonButton.addActionListener(myAl);
        myButtonButton2.addActionListener(myAl);
    }

    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.setSize(600, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}


