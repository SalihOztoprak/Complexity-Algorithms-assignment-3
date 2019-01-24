import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private ArrayList<Node> nodes;
    private Player player1;
    private Player player2;

    public Maze() {
        nodes = fileRead();
        player1 = new Player(1, "Player 1", nodes.get(0));
        player2 = new Player(2, "Player 2", nodes.get(1));
    }

    public void start() {

    }

    private ArrayList<Node> fileRead() {
        try (BufferedReader br = new BufferedReader(new FileReader("mazeStructure.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] stringParts = line.split(";");
                String[] edgeStrings = stringParts[1].split(",");
                ArrayList<Node> edges = new ArrayList<>();

                for (String edgeString : edgeStrings) {
                    String[] edgeParts = edgeString.split("-");
                    int destination = Integer.parseInt(edgeParts[1]);
                    edges.add(new Node(edgeParts[0], destination));
                }

                nodes.add(new Node(stringParts[0], edges));
            }
            nodes.add(new Node("blue", null));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }
}
