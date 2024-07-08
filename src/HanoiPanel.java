import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HanoiPanel extends JPanel {
    public HanoiPanel(){
        Dimension d = new Dimension(800,800);
        setSize(d);
        setBackground(Color.black);
        setLayout(null);

        Listener listener = new Listener();

        JLabel title = new JLabel("Tower of Hanoi");
        title.setForeground(Color.white);
        title.setFont(new Font("Helvetica", Font.ITALIC, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0,0,d.width,d.height/8);
        this.add(title);

        Drawer drawer = new Drawer(d);
        this.add(drawer);

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.black);
        bottom.setBounds(0,d.height*7/8,d.width,d.height / 8);
        bottom.setLayout(null);
        this.add(bottom);

        Font fnt = new Font("Helvetica", Font.ITALIC, 20);

        JLabel top = new JLabel("탑 입력");
        top.setBounds(50,25,100,50);
        top.setForeground(Color.white);
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setFont(fnt);
        bottom.add(top);

        JTextField input = new JTextField();
        input.setBounds(150,25,100,50);
        input.setFont(fnt);
        input.addActionListener(listener);
        bottom.add(input);

        JButton start = new JButton("시작");
        start.setBounds(250,25,100,50);
        start.addActionListener(listener);
        bottom.add(start);

        JButton next = new JButton("다음");
        next.setBounds(500,25,100,50);
        next.addActionListener(listener);
        bottom.add(next);

        JButton prev = new JButton("이전");
        prev.setBounds(650,25,100,50);
        prev.addActionListener(listener);
        bottom.add(prev);


    }
    public class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }
}
