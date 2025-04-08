import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingMyComponent extends JComponent {

    JTextField a;

    JTextField b;

    JTextField c;

    JButton add;



    public SwingMyComponent() {

        this.setLayout(new FlowLayout());



        a = new JTextField(2);

        b = new JTextField(2);

        c = new JTextField(2);

        add = new JButton("Add");



        add.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                Integer res = Integer.parseInt(a.getText()) + Integer.parseInt(b.getText());

                c.setText(res.toString());

            }

        });

        this.add(a);

        this.add(b);

        this.add(c);

        this.add(add);



        this.color = Color.green;



        a.setToolTipText("Operand a");

        b.setToolTipText("Operand b");

        c.setToolTipText("Result");

        add.setToolTipText("Press to calculate");

        this.setToolTipText("Calculator control");

    }



    private Color color;



    public void setOpA(Integer a) {

        this.a.setText(a.toString());

    }



    public Integer getOpA() {

        return Integer.parseInt(this.a.getText());

    }



    public void setOpB(Integer b)     {

        this.b.setText(b.toString());

    }



    public Integer getOpB() {

        return Integer.parseInt(this.b.getText());

    }



    @Override

    public void setBackground(Color c)     {

        firePropertyChange("background", this.color, c);

        this.color = c;

        repaint();

    }



    @Override

    public void paintComponent(Graphics g) {

        g.setColor(this.color);

        g.fillRect(0, 0, 165, 100);

    }

}
