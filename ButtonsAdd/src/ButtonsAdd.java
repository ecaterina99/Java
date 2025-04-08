import java.util.Enumeration;
import java.util.Hashtable;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ButtonsAdd {
    public static void addPair(Hashtable<String,String> values, JFrame f) {
        Enumeration e = values.keys();
        while(e.hasMoreElements()) {
            Object key = e.nextElement();

            JButton btn = new JButton(values.get(key));
            JTextField tf = new JTextField(key.toString());

            f.getContentPane().add(tf);
            f.getContentPane().add(btn);
        }
    }
}