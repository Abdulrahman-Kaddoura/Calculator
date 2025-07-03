
import java.util.ArrayList;

public class History {
    private ArrayList<String> history; 
    private final int max = 10;
    private int count = 0;

    public History(ArrayList<String> x) {
        history = x;
    }

    public void undo() {

    }

    public void addToHistory() {
        if (count == max) {
            removeFromHistory();
        }
        count++;
    }

    public void removeFromHistory() {
        count--;
    }

    public void resetHistory() {
        history = new ArrayList<>();
    }

    
}