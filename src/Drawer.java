import javax.swing.*;
import java.awt.*;

public class Drawer extends JPanel {
    Drawer(Dimension d){
        setBackground(Color.white);
        setBounds(0,d.height / 8, d.width, d.height*3/4);
        setLayout(null);
        dsize = new Dimension(d.width, d.height*3/4);

        Font fnt = new Font("Helvetica", Font.ITALIC, 20);

        JPanel bottom = new JPanel();
        bottom.setBounds(0,dsize.height-50,dsize.width,50);
        bottom.setBackground(Color.gray);
        bottom.setLayout(null);
        this.add(bottom);

        JLabel A = new JLabel("A");
        A.setBounds(130,0,50,50);
        A.setFont(fnt);
        A.setForeground(Color.white);
        bottom.add(A);

        JLabel B = new JLabel("B");
        B.setBounds(375,0,50,50);
        B.setFont(fnt);
        B.setForeground(Color.white);
        bottom.add(B);

        JLabel C = new JLabel("C");
        C.setBounds(615,0,50,50);
        C.setFont(fnt);
        C.setForeground(Color.white);
        bottom.add(C);



    }
    public void pillar(){
        page.fillRect(120,dsize.height/4,40,dsize.height*3/4-50);
        page.fillRect(360,dsize.height/4,40,dsize.height*3/4-50);
        page.fillRect(600,dsize.height/4,40,dsize.height*3/4-50);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        page = g;
        pillar();

    }
    private Graphics page;
    private Dimension dsize;
}
