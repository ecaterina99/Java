import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWT_test extends Frame {
    public AWT_test(String title) {
        this.setTitle(title);
        this.add(new Label("Label component"));
        this.add(new Button("Button component"));
        this.setSize(500, 300);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        AWT_test test = new AWT_test("Frame Test");
    }

}


/*Frame f = new Frame("Frame Test");
Label l = new Label("Hello World");
        f.add(l);

        Button b = new Button("Click Me");
        f.add(b);

        f.setSize(400, 400);
        f.setVisible(true);

                for(int i=0; i<100; i++) {
            Thread.sleep(300);
           // test.setVisible(i%2 == 0);
            test.setLocation(i,i/2);
        }
 */