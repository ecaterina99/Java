import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel;

    public Main() {
        this.setContentPane(panel);
    }
    public static void main(String[] args) {
        Main frame1 = new Main();
        frame1.setSize(600, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new FlowLayout());

        ImageIcon icon = new ImageIcon("C:\\Users\\Admin\\Desktop\\Learning\\Java\\SwingImageIcon\\src\\icon.png");
        ImageIcon done = new ImageIcon("C:\\Users\\Admin\\Desktop\\Learning\\Java\\SwingImageIcon\\src\\done.png");


        Image scaledImage = icon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        Image scaledDone = done.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        frame1.setIconImage(icon.getImage());


       JButton btn = new JButton(icon);
        btn.setIcon(scaledIcon);
        frame1.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                scaledIcon.setImage(scaledDone);
                SwingUtilities.updateComponentTreeUI(frame1);
            }
        });

        frame1.setVisible(true);

    }
}
