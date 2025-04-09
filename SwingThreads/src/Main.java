import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;

public class Main extends JFrame {
    private JPanel panel;
    static SwingWorker sw;

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {

        //blocheza totul daca operatia dureaza mult timp

        Runnable myGUI = new Runnable() {
            @Override
            public void run() {
                Main frame1 = new Main();
                frame1.setSize(600, 300);
                frame1.setLocationRelativeTo(null);
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setLayout(new FlowLayout());
                frame1.setVisible(true);

                JButton button = new JButton("Click Me");
                frame1.add(button);

                JTextField textField = new JTextField(50);
                frame1.add(textField);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        for(int i=0; i<10000000;i++){
                            System.out.println(i);
                        }
                    }
                });
            }
        };
        SwingUtilities.invokeAndWait(myGUI);

        }

    }
