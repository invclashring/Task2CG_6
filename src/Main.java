import javax.swing.*;
import java.awt.*;

public class Main extends JPanel {

    @Override
    public void paint(Graphics gr) {
        super.paint(gr);

        int cx = 400;
        int cy = 300;
        int r = 150;

        int x = -r;
        int y = 0;
        int error = 2 - 2 * r;

        do {
            putPixel(gr, cx - x, cy + y, cx, cy);
            putPixel(gr, cx - y, cy - x, cx, cy);
            putPixel(gr, cx + x, cy - y, cx, cy);
            putPixel(gr, cx + y, cy + x, cx, cy);

            int temp = error;
            if (temp <= y) error += ++y * 2 + 1;
            if (temp > x || error > y) error += ++x * 2 + 1;
        } while (x < 0);
    }

    void putPixel(Graphics gr, int x, int y, int cx, int cy) {
        double angle = Math.atan2(y - cy, x - cx);
        if (angle < 0) angle += 2 * Math.PI;

        if (angle < 0 || angle > Math.PI) return;

        double t = angle / Math.PI;
        int r = (int)(255 * (1 - t));
        int b = (int)(255 * t);

        gr.setColor(new Color(r, 0, b));
        gr.fillRect(x, y, 1, 1);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 600);
        window.add(new Main());
        window.setVisible(true);
    }
}
