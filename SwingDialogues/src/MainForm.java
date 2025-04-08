import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileFilter;

public class MainForm extends JFrame {
    private JPanel mainPanel;

    public MainForm() {
        this.setContentPane(mainPanel);
    }

    public static void main(String[] args) {
        MainForm frame = new MainForm();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        //JOptionPane.showMessageDialog(null, "Hello from dialogue", "Hello World",JOptionPane.INFORMATION_MESSAGE);
        // JOptionPane.showMessageDialog(null, "Erorrrrrrrrrr", "Error",JOptionPane.ERROR_MESSAGE);

        int yourSide = JOptionPane.showOptionDialog(null, "Choose option", "Option dialog", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new String[]{"Dark side", "Bright side"}, null);

        switch (yourSide) {
            case JOptionPane.YES_OPTION:
                JOptionPane.showMessageDialog(null, "You have choosen dark side");
                break;
            case JOptionPane.NO_OPTION:
                JOptionPane.showMessageDialog(null, "You have choosen bright side");
                break;
            case -1:
                JOptionPane.showMessageDialog(null, "You have choosen side");
                break;
        }

        String answer = JOptionPane.showInputDialog(null, "Enter your age");

        if (answer != null) {
            if (!answer.equals("")) {
                JOptionPane.showMessageDialog(null, "Your age: " + answer);
            }
        }


        Color backgroundColor = JColorChooser.showDialog(null, "Choose background color", Color.pink);
        if (backgroundColor != null) {
            frame.getContentPane().setBackground(backgroundColor);
            frame.setVisible(true);
        }

        //show dialog
        JFileChooser jfc = new JFileChooser();
        int response = jfc.showOpenDialog(null);
        switch (response) {
            case JFileChooser.CANCEL_OPTION:
                JOptionPane.showMessageDialog(null, "File is not selected");
                break;
            default:
                JOptionPane.showMessageDialog(null, jfc.getSelectedFile().getPath());
        }

        //Save dialog
        JFileChooser jfc2 = new JFileChooser();
        int response2 = jfc2.showSaveDialog(null);
        switch (response2) {
            case JFileChooser.CANCEL_OPTION:
                break;
            default:
                JOptionPane.showMessageDialog(null, jfc2.getSelectedFile().getPath());
        }

    }
}


