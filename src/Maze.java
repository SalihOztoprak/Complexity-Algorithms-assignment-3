import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
    private ArrayList<Node> nodes;
    private Player player1;
    private Player player2;
    private boolean isFinished;

    public static void main(String[] args) {
        new Maze().fileRead();
    }

    public Maze() {
        nodes = fileRead();
        player1 = new Player(1, "Player 1", nodes.get(0));
        player2 = new Player(2, "Player 2", nodes.get(1));
        isFinished = false;
    }

    public void start() {
        while (!isFinished) {
            Color otherPlayersColor = player2.getCurrentNode().getColor();
            ArrayList<Neighbour> currentPlayersNeighbours = player1.getCurrentNode().getNeighbours();
            for (int i = 0; i < currentPlayersNeighbours.size(); i++) {
                if (currentPlayersNeighbours.get(i).getPathway().equals(otherPlayersColor)) {

                }
            }
        }
    }

    private ArrayList<Node> fileRead() {
        ArrayList<Node> nodes = new ArrayList<>();
        ArrayList<Neighbour> neighbours;
        try (BufferedReader br = new BufferedReader(new FileReader("mazeStructure.txt"))) {
            String line;
            String[] splitNode;
            String[] splitNeighbours;

            while ((line = br.readLine()) != null) {
                neighbours = new ArrayList<>();
                splitNode = line.split(";");

                if (splitNode.length > 1) {
                    splitNeighbours = splitNode[1].split(",");

                    for (String splitNeighbour : splitNeighbours) {
                        Neighbour neighbour = new Neighbour(splitNeighbour);
                        neighbours.add(neighbour);
                    }
                }

                Node node = new Node(splitNode[0],neighbours);
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nodes;
    }
}
