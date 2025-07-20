import java.util.ArrayList;

public class History {
    private ArrayList<String> history; 
    private final int max = 10;
    private int count = 0;

    public History(ArrayList<String> x) {
        history = x;
        count = x.size();
    }

    public void undo() {
        if (count > 0) {
            history.remove(count - 1);
            count--;
        }
    }

    public void addToHistory(String entry) {
        if (count == max) {
            history.remove(0);
            count--;
        }
        history.add(entry);
        count++;
    }

    public void removeFromHistory() {
        if (count > 0) {
            history.remove(count - 1);
            count--;
        }
    }

    public void resetHistory() {
        history = new ArrayList<>();
        count = 0;
    }

    public ArrayList<String> getHistory() {
        return history;
    }
}
