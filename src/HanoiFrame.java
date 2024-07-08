import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class HanoiFrame extends JFrame {
    HanoiFrame() {
        setTitle("Tower of Hanoi");
        Dimension d = new Dimension(800,900);
        setSize(d);
        HanoiPanel hanoiPanel = new HanoiPanel();
        add(hanoiPanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
