import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawerPanel extends JPanel {
    private Graphics page;
    private Dimension dsize;
    private ArrayList<BlockInfo> now;

    DrawerPanel(Dimension d){
        setBackground(Color.white);
        setBounds(0,d.height / 8, d.width, d.height*3/4);
        setLayout(null);
        dsize = new Dimension(d.width, d.height*3/4);

        now = new ArrayList<>();

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

    public void DrawTower() {
        for (int i = 0; i < now.size(); i++) {
            BlockInfo info = now.get(i);
            page.setColor(info.getColor());
            page.fillRect(info.getPoint().x, info.getPoint().y, info.getWidth(), info.getHeight());
        }
    }
    public void DrawPillar(){
        page.fillRect(130,dsize.height/4,25,dsize.height*3/4-50);
        page.fillRect(370,dsize.height/4,25,dsize.height*3/4-50);
        page.fillRect(610,dsize.height/4,25,dsize.height*3/4-50);
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        page = g;
        DrawPillar();
        DrawTower();

    }

    public void setDataList(ArrayList<BlockInfo> current, int n){
        now.clear(); // 이거없으면 잔상 남음
        for (int i = 0; i < current.size(); i++) {
            BlockInfo info = current.get(i);
            now.add(new BlockInfo(info, n));
        }
    }

    public void dataDelete(){
        now = new ArrayList<>();
        DrawTower();
        DrawPillar();
    }

}
