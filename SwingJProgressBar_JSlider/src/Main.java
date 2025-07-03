import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JPanel panel;
    private JProgressBar progressBar1;
    private JSlider slider1;

    public Main() {
        this.setContentPane(panel);
        slider1.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println(((JSlider) e.getSource()).getValue());
            }
        });
    }

    public static void main(String[] args) {
        Main f = new Main();
        f.setSize(600, 300);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        int duration = 1000000;

        JProgressBar jpb = new JProgressBar(0, duration);
        f.add(jpb);

        JButton btn = new JButton("start");
        f.add(btn);

        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SwingWorker sw = new SwingWorker() {
                    @Override
                    protected String doInBackground() throws Exception {
                        for(int i = 0; i < duration; i++) {
                            if(i % 100 == 0) {
                                Thread.sleep(1);
                                publish(i);
                            }
                        }
                        return null;
                    }

                    @Override
                    protected void done() {
                        System.out.println("job done");
                    }

                    @Override
                    protected void process(java.util.List chunks) {
                        jpb.setValue((int) chunks.get(chunks.size() - 1));
                    }
                };
                sw.execute();
            }
        });
        
        f.setVisible(true);

    }
}
