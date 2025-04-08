import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPanel panel;
    private JComboBox comboBox1;

    public Main() {
        this.setContentPane(panel);
        comboBox1.addItem(new City(1,"London"));
        comboBox1.addItem(new City(2,"Paris"));
        comboBox1.addItem(new City(3,"Iași"));
        comboBox1.addItem(new City(4,"Vegas"));
        
        comboBox1.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                if(value instanceof City){
                    setText(((City)value).getName());
                }
                return this;
            }
        });

    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
    }
}
class City {
    public int id;
    public String name;

    public City(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public String getName() {
        return name;
    }

//    @Override
//    public String toString() {
//        return this.name;
//    }
}
