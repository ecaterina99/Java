import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {
    private JPanel panel;

    public Main() {
        this.setContentPane(panel);
    }

    public static void main(String[] args) {
        Main frame = new Main();
        frame.setSize(600, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);


        //Component listener
    /*    JLabel size = new JLabel();
        frame.add(size);
        JLabel location = new JLabel();
        frame.add(location);


        frame.addComponentListener(new ComponentListener() {

            public void componentResized(ComponentEvent e) {
                Component c = e.getComponent();
                size.setText("Width: " + c.getWidth() + " Height: " + c.getHeight());            }

            public void componentMoved(ComponentEvent e) {
                Component c = e.getComponent();
                Point p = c.getLocationOnScreen();
                location.setText("X: " + p.x + " Y: " + p.y);            }

            public void componentShown(ComponentEvent e) {
                JOptionPane.showMessageDialog(null, "Window is shown");
            }

            public void componentHidden(ComponentEvent e) {
                JOptionPane.showMessageDialog(null, "Window is hidden");
            }
        });

        //Key Listener
        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped " + e.getKeyChar());
            }
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed " + e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

     */

        //mouse listener

        /*frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("clicked on");
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("entered on");
            }
            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("exit");
            }
        });


        JLabel mouseInfo = new JLabel();
        frame.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseInfo.setText("Mouse position x: " + e.getX() + ", y: " + e.getY());
            }
        });
        frame.add(mouseInfo);

        frame.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if(e.getWheelRotation()>0)
                    frame.setLocation(frame.getLocation().x, 5 + frame.getLocation().y);
                else
                    frame.setLocation(frame.getLocation().x, frame.getLocation().y - 5);
            }
        });

         */

        Main frame1 = new Main();
        frame1.setSize(600, 300);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setLayout(new FlowLayout());
        frame1.setVisible(true);

        JButton button = new JButton("Send to over form");
        frame.add(button);


        JButton btn = new JButton("Change hierarchy");

        btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                frame.remove(btn);

                frame.repaint();

                frame1.add(btn);

            }

        });

        btn.addHierarchyListener(new HierarchyListener() {

            public void hierarchyChanged(HierarchyEvent e) {

                System.out.println("Hierarchy changed for : " + e.getChangedParent().getClass());

            }

        });

        frame.add(btn);

    }
}

