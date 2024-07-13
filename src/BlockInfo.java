import java.awt.*;

public class BlockInfo {
    private Point point;
    private int	position, width, height;
    private Color blockColor;
    private int length; // 세로
    private int	standardX, total, standardPosition;
    private char location;

    public BlockInfo(int num, int total){
        point = new Point();
        location = 'A';
        point.x = 0;
        point.y = 0;

        this.total = total;
        position = num;

        standardPosition = total - position;

        length = 550;
        height = 30;

        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        blockColor = new Color(r, g, b);

        this.setData();
    }

    public BlockInfo(BlockInfo info, int n){
        point = getPoint();
        location = info.getLocation();
        total = info.getTotal();
        position = info.getPosition();
        standardPosition = info.getStandardPosition();
        length = 550;
        height = 40;
        width = info.getWidth();
        blockColor = info.getColor();

        this.setData();
    }


    public void changeData(char change, int tower) {
        location = change;
        standardPosition = tower;
    }

    public void setData(){
        point = getPoint();
        int tp; // A, B, C 타워의 각각 지점

        if(location == 'A') {
            tp = 140;
        } else if(location == 'B') {
            tp = 380;
        } else {
            tp = 620;
        }

        standardX = 90 / total;

        //if (point != null) {
            this.point.x = tp - standardX * (position + 1);
            this.point.y = length - height * standardPosition;

            width = (tp - point.x) * 2;
        //}
    }
    public Point getPoint()		{ return point; }
    public int getPosition()	{ return position; }
    public int getTotal()		{ return total; }
    public char getLocation()	{ return location; }
    public int getWidth()		{ return width; }
    public int getHeight()		{ return height; }
    public Color getColor()		{ return blockColor; }
    public int getStandardPosition()	{ return standardPosition; }
}
