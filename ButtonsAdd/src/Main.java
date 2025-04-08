import java.awt.FlowLayout;
import java.util.Hashtable;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setLayout(new FlowLayout()); //f.setLayout(new GridLayout(3, 2));
        f.setSize(200, 200);

        Hashtable<String, String> values = new Hashtable<>();
        values.put("www.yahoo.com", "Yahoo");
        values.put("www.bing.com", "Bing");
        values.put("www.google.com", "Google");

        ButtonsAdd.addPair(values, f);

        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}