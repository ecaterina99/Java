import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main extends JFrame {

    public Main() {
        JPanel mainPanel = new JPanel();
        this.setContentPane(mainPanel);
    }

    public static void main(String[] args) {

        Main f = new Main();
        f.setSize(600, 400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

       MyComponent mc = new MyComponent();
       f.add(mc);

        JButton b1 = new JButton("Button1");
        JButton b2 = new JButton("Button2");
        JButton b3 = new JButton("Button3");

        f.add(b1);
        f.add(b2);
        f.add(b3);

        b3.setFocusable(false);
        b1.requestFocusInWindow();


        b1.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                System.out.println("Hi, I gained focus from " + e.getOppositeComponent());
            }

            public void focusLost(FocusEvent e) {
                System.out.println("I lost focus from " + e.getOppositeComponent());
            }
        });

        System.out.println(b2.isFocusable());

    }
}