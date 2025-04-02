
import java.awt.*;

public class AWT_paint_test extends Frame {
    @Override
    public void paint(Graphics g)    {


        //create line
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.magenta);
        g2.setStroke(new BasicStroke(3));
        g2.drawLine(150,100,100,100);

        Graphics2D g3 = (Graphics2D) g;
        g3.setColor(Color.green);
        g3.setStroke(new BasicStroke(5));
        g3.drawLine(40,40,120,100);


        //create a circle
        Graphics2D g4 = (Graphics2D) g;
        g4.setColor(Color.yellow);
        g4.drawOval(100,100,50,80);
        g4.fillOval(100,100,50,80);

        //crate an arc
        Graphics2D g5 = (Graphics2D) g;
        g5.setColor(Color.red);
        g5.drawArc(100,100,50,80,180,180);

        //draw polygon
        Polygon p = new Polygon(new int[]{150, 200, 150, 100}, new int[]{50, 100, 150, 100}, 4);
        g.drawPolygon(p);

    }

    public static void main(String[] args) {
        AWT_paint_test f = new AWT_paint_test();
        f.setSize(300,300);
        f.setVisible(true);
    }
}