import java.util.ArrayList;

public class Logic {
    private int count;
    private int a, b, c;
    private ArrayList<BlockInfo> nowList;
    private ArrayList<Sequence> sequence;

    public Logic(int n){
        count = 0;
        a = n;
        b = 0;
        c = 0;

        nowList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            nowList.add(new BlockInfo(i, n));
        }

        sequence = new ArrayList<>();
        ArrayList<BlockInfo> tmp = new ArrayList<>();
       /* for (int i = 0; i < nowList.size(); i++) {
            BlockInfo info = nowList.get(i);
            tmp.add(new BlockInfo(info , n - i));
        }
        */
        int i = 0;
        for(BlockInfo data : nowList) {
            tmp.add(new BlockInfo(data,n - i));
            i++;
        }
        sequence.add(new Sequence(tmp));

        this.startHanoi(n, 'A', 'B', 'C');
    }

    public void startHanoi(int n, char from, char tmp, char to) {
        if (n == 1) {
            ++count;
            this.moveBlock(n - 1, from, to);
        } else {
            ++count;
            this.startHanoi(n - 1, from, to, tmp);
            this.moveBlock(n - 1, from, to);
            this.startHanoi(n - 1, tmp, from, to);
        }
    }

    public void moveBlock(int position, char from, char to) {
        int tBar;

        if(from == 'A') {
            a--;
        } else if(from == 'B') {
            b--;
        } else  {
            c--;
        }
        if(to == 'A') {
            a++;
            tBar = a;
        } else if(to == 'B') {
            b++;
            tBar = b;
        } else {
            c++;
            tBar = c;
        }
/*
        for (int i = 0; i < nowList.size(); i++) {
            BlockInfo info = nowList.get(i);
            if (info.getPosition() == position) {
                info.changeData(to, tBar);
                break;
            }
        }*/

        for(BlockInfo data : nowList) {
            if(data.getPosition() == position) {
                data.changeData(to, tBar);
                break;
            }
        }


        ArrayList<BlockInfo> tmpList = new ArrayList<>();

        for(int i = 0; i < nowList.size(); i++){
            tmpList.add(new BlockInfo(nowList.get(i), tBar-i));
        }
        sequence.add(new Sequence(tmpList));
    }

    public ArrayList<Sequence>	getSequence() {
        return sequence;
    }

}
