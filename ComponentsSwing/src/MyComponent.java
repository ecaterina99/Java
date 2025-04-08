import javax.swing.*;
import java.awt.*;

public class MyComponent extends JComponent {
    public MyComponent() {
        this.setPreferredSize(new Dimension(200, 60));
        //toolTip
        this.setToolTipText("This is a tool tip");
        //Border
        this.setBorder(BorderFactory.createLineBorder(Color.red,3));
        //Title border
        this.setBorder(BorderFactory.createTitledBorder("Title"));
        //Shade border
        this.setBorder(BorderFactory.createBevelBorder(1));
    }

    @Override
    protected void paintComponent (Graphics g){
        System.out.println("PaintComponent");
        g.setColor(Color.lightGray);
        g.fillRect(0, 0, 200, 60);
        g.setColor(Color.red);
        g.drawString("Hello World", 10, 40);
    }


}
