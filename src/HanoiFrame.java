import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HanoiFrame extends JFrame {
    private HanoiPanel hanoiPanel;
    HanoiFrame() {
        setTitle("Tower of Hanoi");
        Dimension d = new Dimension(800,900);
        setSize(d);
        hanoiPanel = new HanoiPanel(this);
        add(hanoiPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
    public void recall() {
        remove(hanoiPanel);
        hanoiPanel = new HanoiPanel(this);
        add(hanoiPanel);
        revalidate();
        repaint();
    }
}
