import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame {
    private JPanel mainPanel;

    public MainForm() {
        mainPanel = new JPanel();
        this.setContentPane(mainPanel);
    }
    public static void main(String[] args) {
        MainForm f = new MainForm();
        f.setVisible(true);
        f.setSize(600, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setLayout(new FlowLayout());


        // container JPanel
        JPanel p = new JPanel();
        p.add(new JButton("Button1"));
        p.add(new JButton("Button2"));
        p.add(new JButton("Button3"));

        p.setSize(100, 100);
        p.setBackground(Color.gray);

        f.add(p);

        //container JScrollPanel
        JTextArea ta = new JTextArea(10, 10);
        ta.setLineWrap(true);

        JScrollPane sp = new JScrollPane(ta);
        sp.setColumnHeaderView(new JLabel("header column"));
        sp.setRowHeaderView(new JLabel("header row"));
        sp.setPreferredSize(new Dimension(500, 200));
        sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        f.add(sp);


        //JSplitPanel
        JSplitPane jsp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

        JPanel leftC = new JPanel();
        leftC.setBackground(Color.gray);
        leftC.setPreferredSize(new Dimension(200,200));

        JPanel rightC = new JPanel();
        rightC.setBackground(Color.green);
        rightC.setPreferredSize(new Dimension(200,200));

        jsp.setLeftComponent(leftC);
        jsp.setRightComponent(rightC);

        f.add(jsp);

        //JTabbedPane
        JTabbedPane jtp = new JTabbedPane();
        JPanel red = new JPanel();
        red.setBackground(Color.red);
        red.setPreferredSize(new Dimension(300, 100));
        jtp.addTab("Red tab", red);

        JPanel yellow = new JPanel();
        yellow.setBackground(Color.yellow);
        yellow.setPreferredSize(new Dimension(300, 100));
        jtp.addTab("Yellow tab", yellow);

        JPanel white = new JPanel();
        white.setBackground(Color.white);
        white.setPreferredSize(new Dimension(300, 100));
        jtp.addTab("White tab", white);

        f.add(jtp);

        //JInternalFrame
        JInternalFrame jif = new JInternalFrame("My internal frame ");
        jif.add(new JButton("click"));
        jif.setPreferredSize(new Dimension(200, 100));
        f.add(jif);

        jif.setVisible(true);
        f.setVisible(true);
    }
}
