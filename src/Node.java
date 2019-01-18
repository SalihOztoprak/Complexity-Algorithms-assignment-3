import java.util.ArrayList;

public class Node {
    private int number;
    private Color color;
    private ArrayList<Node> neighbours;

    public Node(int number, Color color) {
        this.number = number;
        this.color = color;
        this.neighbours = new ArrayList<>();
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Node> getNeighbours() {
        return neighbours;
    }
}
