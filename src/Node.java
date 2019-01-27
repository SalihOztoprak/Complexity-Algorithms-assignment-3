import java.util.ArrayList;

/**
 * This class defines a node and all it's methods
 */
public class Node {
    private int number;
    private Color color;
    private ArrayList<Neighbour> neighbours;

    /**
     * This is the default constructor for this class
     *
     * @param number     The number of the node
     * @param color      The color of the node
     * @param neighbours An ArrayList with all the neighbours of the node
     */
    public Node(int number, Color color, ArrayList<Neighbour> neighbours) {
        this.number = number;
        this.color = color;
        this.neighbours = neighbours;
    }

    /**
     * This constructor is used when you want to create a node by giving a TextFile string
     *
     * @param nodeString The TextFile string with the data in it
     * @param neighbours An ArrayList with the neighbours
     */
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
