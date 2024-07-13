import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class HanoiPanel extends JPanel {
    private JTextField input;
    private JButton start, prev, next, reset;
    private DrawerPanel drawer;
    private int inputValue, nSequence;
    private Logic logic;
    private Listener listener;
    private ArrayList<Sequence> sequence;
    private HanoiFrame frame;

    public HanoiPanel(HanoiFrame hanoiFrame){
        frame = hanoiFrame;
        Dimension d = new Dimension(800,800);
        setSize(d);
        setBackground(Color.black);
        setLayout(null);

        listener = new Listener();
        nSequence = 1;

        JLabel title = new JLabel("하노이 탑");
        title.setForeground(Color.white);
        title.setFont(new Font("Helvetica", Font.ITALIC, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBounds(0,0,d.width,d.height/8);
        this.add(title);

        drawer = new DrawerPanel(d);
        this.add(drawer);

        JPanel bottom = new JPanel();
        bottom.setBackground(Color.black);
        bottom.setBounds(0,d.height*7/8,d.width,d.height / 8);
        bottom.setLayout(null);
        this.add(bottom);

        Font fnt = new Font("Helvetica", Font.ITALIC, 20);

        JLabel top = new JLabel("탑 입력");
        top.setBounds(25,25,100,50);
        top.setForeground(Color.white);
        top.setHorizontalAlignment(SwingConstants.CENTER);
        top.setFont(fnt);
        bottom.add(top);

        input = new JTextField();
        input.setBounds(130,25,80,50);
        input.setFont(fnt);
        input.addActionListener(listener);
        bottom.add(input);

        start = new JButton("시작");
        start.setBounds(240,25,100,50);
        start.addActionListener(listener);
        bottom.add(start);

        next = new JButton("다음");
        next.setBounds(450,25,100,50);
        next.addActionListener(listener);
        bottom.add(next);

        prev = new JButton("이전");
        prev.setBounds(360,25,100,50);
        prev.addActionListener(listener);
        bottom.add(prev);

        reset = new JButton("리셋");
        reset.setBounds(650, 25, 80, 50);
        reset.addActionListener(listener);
        bottom.add(reset);

    }
    public class Listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if ((source == input) || (source == start)){
                try {
                    inputValue = Integer.parseInt(input.getText());
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(null, "숫자를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (inputValue <= 0){
                    JOptionPane.showMessageDialog(null, "양수를 입력해주세요.", "입력 오류", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                    logic = new Logic(inputValue);
            }else if (source == next) {
                nSequence++;
            }else if (source == prev) {
                nSequence--;
            } else if (source == reset) {
                frame.recall();
            }

            sequence = logic.getSequence();
            drawer.setDataList(sequence.get(nSequence-1).getNowData(), nSequence - 1);
            drawer.repaint();
        }
    }
}
