import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWT_Layouts {
    public static void main(String[] args) {
//border layout
        Frame f = new Frame();

        Button b = new Button("TOP_BUTTON");
        Button b1 = new Button("CENTER_BUTTON");
        Button b2 = new Button("BOTTOM_BUTTON");
        Button b3 = new Button("LEFT_BUTTON");
        Button b4 = new Button("RIGHT_BUTTON");

        f.add(b, BorderLayout.PAGE_START);
        f.add(b1, BorderLayout.CENTER);
        f.add(b2, BorderLayout.PAGE_END);
        f.add(b3, BorderLayout.LINE_START);
        f.add(b4, BorderLayout.LINE_END);

        f.setSize(600, 400);
        f.setVisible(true);

        //flow layout
        Frame f2 = new Frame();
        LayoutManager lm = new FlowLayout(FlowLayout.LEFT);
        f2.setLayout(lm);
        for (int i = 1; i < 10; i++) {
            Button button = new Button("Button" + i);
            f2.add(button);
        }
        f2.setSize(400, 300);
        f2.setVisible(true);


        //grid layout
        LayoutManager gridLayOut = new GridLayout(3, 3);
        Frame f3 = new Frame();
        f3.setLayout(gridLayOut);

        for (int i = 1; i < 5; i++)
            f3.add(new Button("Button " + i));

        f3.setSize(300, 300);
        f3.setVisible(true);

        //grid Bag Layout
        Frame f4 = new Frame();
        LayoutManager lm4 = new GridBagLayout();
        f4.setLayout(lm4);

        Button but = new Button("Button1");
        Button but1 = new Button("Button2");
        Button but2 = new Button("Button3");
        Button but3 = new Button("Button4");
        Button but4 = new Button("Button5");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        f4.add(but, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        f4.add(but1, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 0;
        f4.add(but2, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.BOTH;
        f4.add(but3, gbc);

        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 3;
        f4.add(but4, gbc);

        f4.setSize(400, 300);
        f4.setVisible(true);


        //Card Layout
        Frame f5 = new Frame();
        Panel hp = new Panel();

        Button button1 = new Button("Button 1");
        Button button2 = new Button("Button 2");

        hp.add(button1);
        hp.add(button2);

        f5.add(hp, BorderLayout.PAGE_START);

        Panel hp2 = new Panel();

        CardLayout cl = new CardLayout();
        hp2.setLayout(cl);

        Panel p1 = new Panel();
        Panel p2 = new Panel();

        p1.setBackground(Color.pink);
        p2.setBackground(Color.yellow);

        hp2.add(p1, "p1");
        hp2.add(p2, "p2");

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(hp2, "p1");
            }
        });


        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cl.show(hp2, "p2");
            }
        });

        f5.add(hp2, BorderLayout.CENTER);

        f5.setSize(500, 500);
        f5.setVisible(true);


    }
}