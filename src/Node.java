import java.util.ArrayList;

public class Node {
    private int number;
    private Color color;
    private ArrayList<Neighbour> neighbours;

    public Node(int number, Color color, ArrayList<Neighbour> neighbours) {
        this.number = number;
        this.color = color;
        this.neighbours = neighbours;
    }

    public Node(String nodeString, ArrayList<Neighbour> neighbours) {
        String[] splitString = nodeString.split("-");
        this.color = Color.valueOf(splitString[0].toUpperCase());
        this.number = Integer.valueOf(splitString[1]);
        this.neighbours = neighbours;
    }

    public int getNumber() {
        return number;
    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Neighbour> getNeighbours() {
        return neighbours;
    }
}
