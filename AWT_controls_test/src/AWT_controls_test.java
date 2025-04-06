import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AWT_controls_test {
    public static void main(String[] args) throws InterruptedException {

        Frame f = new Frame();
        LayoutManager layOut = new FlowLayout();
        f.setLayout(layOut);
        f.setSize(300,300);
        f.setVisible(true);


        //Label

       /* Label l = new Label("label text");
        f.add(l);

        for(int i = 0; i < 35; i++)   {
            Label label = new Label("Hello " + i + "!");
            f.add(label);
            Thread.sleep(100);
            f.setVisible(true);
        }

        Label l2 = new Label("click me");
        f.add(l2);

        l2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                l2.setText("clicked");
            }
        });

        */


        //Button

       /* Button b = new Button("button text");
        b.setPreferredSize(new Dimension(550, 20));
        f.add(b);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Button b1 = (Button) e.getSource();
                b1.setLabel("Click performed");
                b1.setBackground(Color.orange);
            }
        });

        */

        //Checkbox
       /*
        CheckboxGroup cbg = new CheckboxGroup();

        Checkbox cb1 = new Checkbox("c1",cbg,true);
        f.add(cb1);
        Checkbox cb2 = new Checkbox("c2",cbg,false);
        f.add(cb2);
        Checkbox cb3 = new Checkbox("c3",cbg,false);
        f.add(cb3);

        */

        //Choice

        /*
        Choice c = new Choice();
        c.add("Audi");
        c.add("BMW");
        c.add("Honda");
        f.add(c);

         */

        /*
        Choice c = new Choice();

        ArrayList<Car> cars = new ArrayList<>();

        cars.add(new Car(5, "Audi"));
        cars.add(new Car(6, "BMW"));
        cars.add(new Car(7, "Mercedes"));

        final Choice myChoice = new Choice();
        for(Car car: cars)
            myChoice.add(car.name);

        myChoice.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                Choice c = (Choice) e.getSource();
                Car selectedCar = cars.get(c.getSelectedIndex());
                System.out.println(selectedCar.id);
            }
        });
        f.add(myChoice);
        f.setVisible(true);


    }
}
    class Car {
    public int id;
    public String name;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;

         */

        //List
        /*
        List myCars = new List(10, true);
        myCars.add("Renault");
        myCars.add("BMW");
        myCars.add("Mercedes");

        Button b = new Button("Show selected");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] selectedCars = myCars.getSelectedItems();
                for(int i = 0; i < selectedCars.length; i++)
                    System.out.println(selectedCars[i]);
            }
        });
        f.add(myCars);
        f.add(b);
        f.setVisible(true);

         */

        //TEXT
        /*
        TextField tf = new TextField();
        TextArea ta = new TextArea(5,25);
        tf.setText("This is text field");
        ta.setText("This is text area");
        f.add(tf);
        f.add(ta);


        tf.addTextListener(new TextListener() {
            public void textValueChanged(TextEvent e) {
                TextField textField = (TextField) e.getSource();
                System.out.println(textField.getText());
            }
        }); TextField tf = new TextField();
        TextArea ta = new TextArea(5,25);
        tf.setText("This is text field");
        ta.setText("This is text area");
        f.add(tf);
        f.add(ta);

         */


        TextField tf_source = new TextField(20);
        TextField tf_destination = new TextField(20);

        Button b = new Button("copy");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tf_destination.setText(tf_source.getSelectedText());
            }
        });

        f.add(tf_source);
        f.add(b);
        f.add(tf_destination);
        f.setSize(300, 300);
        f.setVisible(true);

    }
}

