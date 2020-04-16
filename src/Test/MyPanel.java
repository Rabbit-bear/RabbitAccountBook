package Test;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawOval(10,10,20,29);
    }

    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.setSize(400,200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
