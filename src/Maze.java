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

    private ArrayList<Node> fileRead(){


        return new ArrayList<>();
    }
}
