import java.util.ArrayList;

public class Sequence {
    private ArrayList<BlockInfo> current;

    public Sequence(ArrayList<BlockInfo> data) {
        current = data;
    }

    public ArrayList<BlockInfo> getNowData() { 	return current;  }
}
