import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

public class AWT_text extends Frame {

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        FontRenderContext frc = g2d.getFontRenderContext();
        Font font = new Font("Arial", Font.PLAIN, 20);
        setBackground(Color.green);
        TextLayout layout = new TextLayout("Hello World", font, frc);
        layout.draw(g2d, 20, 80);


        Toolkit tk = Toolkit.getDefaultToolkit();
        Image i = tk.getImage("src/1.jpg");
        AffineTransform at = new AffineTransform();
        at.translate(50, 50);
        at.scale(0.3, 0.3);
        g2d.setTransform(at);
        g2d.drawImage(i, 100, 100, this);
    }

    public static void main(String[] args) {
        AWT_text f = new AWT_text();
        f.setSize(300,300);
        f.setVisible(true);

    }
}