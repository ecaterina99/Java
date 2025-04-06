import javax.swing.*;

public class Main extends JFrame {
    private JPanel mainPanel;

    public Main() {
        mainPanel = new JPanel();
        this.setContentPane(mainPanel);
    }
    public static void main(String[] args) {
        Main f = new Main();
        f.setSize(600, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        //Box Layout
         /*
        f.setLayout(new BoxLayout(f.mainPanel, BoxLayout.PAGE_AXIS));
        JButton button = new JButton("Click Me");
        JButton button2 = new JButton("Click Me Too");
        f.add(button);
        f.add(button2);
        f.setLayout(gl);

          */

        //Group layout
        /*
        GroupLayout gl = new GroupLayout(f);
        JButton b1 = new JButton("Button1");
        JButton b2 = new JButton("Button2");
        JButton b3 = new JButton("Button3");
        JButton b4 = new JButton("Button4");

        gl.setAutoCreateGaps(true);
        gl.setAutoCreateContainerGaps(true);

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(b1)
                .addComponent(b2)
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(b3)
                        .addComponent(b4)));

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGroup(gl.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(b1)
                        .addComponent(b2)
                        .addComponent(b3))
                .addComponent(b4));
         */

        //spring layout
        SpringLayout layout = new SpringLayout();
        f.setLayout(layout);

        JButton button = new JButton("Button");
        f.add(button);

        layout.putConstraint(SpringLayout.WEST, button, 100, SpringLayout.WEST, f);
        layout.putConstraint(SpringLayout.NORTH, button, 100, SpringLayout.NORTH, f);

    }
}
