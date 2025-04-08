import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MainForm extends JFrame {
    private JPanel mainPanel;
    private JCheckBox checkBox1;
    private JRadioButton female;
    private JRadioButton male;

    public MainForm() {
        this.setContentPane(mainPanel);
        checkBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JCheckBox checkBox = (JCheckBox) e.getSource();
                checkBox.setText((e.getStateChange() == ItemEvent.SELECTED) ? "You agree" : "You don't agree");
            }
        });


        ActionListener al= new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("male")){
                    JOptionPane.showMessageDialog(null, "You are male");
                }else if(e.getActionCommand().equals("female")){
                    JOptionPane.showMessageDialog(null, "You are female");
                }
            }
        };

        female.addActionListener(al);
        male.addActionListener(al);


    }

    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        JToggleButton tb = new JToggleButton("Hello, click me");
        frame.add(tb);

        tb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JToggleButton tb = (JToggleButton) e.getSource();
                tb.setText((e.getStateChange() ==
                        ItemEvent.SELECTED) ? "Active" : "Inactive");
            }
        });



        frame.setVisible(true);
    }

}
