import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.Calendar;
import java.util.Date;

public class Main extends JFrame {
    private JPanel panel;
    private JSpinner spinner1;

    public Main() {
        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        Main frame1 = new Main();
        frame1.setSize(600, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new FlowLayout());

        SpinnerNumberModel model = new SpinnerNumberModel();
        JSpinner js = new JSpinner(model);
        frame1.add(js);

        model.setValue(5);
        model.setMaximum(8);
        model.setMinimum(3);
        model.setStepSize(2);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.YEAR, -5);
        Date min = cal.getTime();
        cal.add(Calendar.YEAR, 5);
        Date max = cal.getTime();

        SpinnerDateModel sdm = new SpinnerDateModel(cal.getTime(), min, max, Calendar.DATE);
        JSpinner jsCalendar = new JSpinner(sdm);
        jsCalendar.setEditor(new JSpinner.DateEditor(jsCalendar, "dd. MM. yyyy."));
        frame1.add(jsCalendar);


        SpinnerListModel slm = new SpinnerListModel(new String[]{"Apple", "Orange", "Peach", "Grape"});

        JSpinner jsList = new JSpinner(slm);
        frame1.add(jsList);

        jsList.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JSpinner js = (JSpinner) e.getSource();
                System.out.println(js.getValue());
            }
        });
        frame1.setVisible(true);
    }
}