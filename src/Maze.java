import java.util.ArrayList;

public class Maze {
    private ArrayList<Node> nodes;
    private Player player1;
    private Player player2;
    private boolean isFinished;

    public Maze() {
        nodes = fileRead();
        player1 = new Player(1, "Player 1", nodes.get(0));
        player2 = new Player(2, "Player 2", nodes.get(1));
        isFinished = false;
    }

    public void start() {
        while (!isFinished){
            Color otherPlayersColor = player2.getCurrentNode().getColor();
            ArrayList<Neighbour> currentPlayersNeighbours = player1.getCurrentNode().getNeighbours();
            for (int i = 0; i < currentPlayersNeighbours.size(); i++) {
                if (currentPlayersNeighbours.get(i).getPathway().equals(otherPlayersColor)){

                }
            }
        }
    }

    private ArrayList<Node> fileRead(){

        return new ArrayList<>();
    }
}
