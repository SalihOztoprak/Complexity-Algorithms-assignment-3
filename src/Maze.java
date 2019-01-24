import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Maze {
    private ArrayList<Node> nodes;
    private ArrayList<Move> moves;
    private Player currentPlayer;
    private Player otherPlayer;
    private boolean isFinished;

    public Maze() {
        nodes = fileRead();
        moves = new ArrayList<>();
        Player player1 = new Player(1, "Player 1", nodes.get(0));
        Player player2 = new Player(2, "Player 2", nodes.get(1));
        currentPlayer = player1;
        otherPlayer = player2;
        isFinished = false;
    }

    public void start() {
        while (!isFinished) {
            nextRound();
        }
        System.out.println("Game is finished, the winner is " + currentPlayer.getName());
    }

    private void nextRound() {
        //First get the color of the other player
        Color otherPlayersColor = otherPlayer.getCurrentNode().getColor();

        //Then we check if the current player has neighbours
        ArrayList<Neighbour> currentPlayersNeighbours = currentPlayer.getCurrentNode().getNeighbours();
        boolean switchSides = true;

        //Loop through the neighbours to find one with the same color
        for (Neighbour currentPlayersNeighbour : currentPlayersNeighbours) {
            //If there is a match, follow the color
            if (currentPlayersNeighbour.getPathway().equals(otherPlayersColor)) {
                //Add the movement to the stack
                moves.add(new Move(currentPlayer, currentPlayer.getCurrentNode(), currentPlayersNeighbour.getNumber()));
                currentPlayer.setCurrentNode(nodes.get(currentPlayersNeighbour.getNumber() - 1));
                currentPlayer.setSecondStepForPlayer(true);
                switchSides = false;

                System.out.println(currentPlayer.getName() + " goes to " + currentPlayer.getCurrentNode().getNumber());

                //If the current player is now on the finish, stop the game
                if (currentPlayer.getCurrentNode().getColor().equals(Color.BLUE)) {
                    isFinished = true;
                    break;
                }
            }
        }

        //First we have to check if we already did a movement before we swap
        if (switchSides) {
            if (currentPlayer.getSecondStepForPlayer()) {
                Player tempPlayer = currentPlayer;
                currentPlayer = otherPlayer;
                otherPlayer = tempPlayer;
                currentPlayer.setSecondStepForPlayer(false);
                otherPlayer.setSecondStepForPlayer(false);
            } else {
                //The current player may take a step back
                for (Move move1 : moves) {
                    if (move1.getDestination() == currentPlayer.getCurrentNode().getNumber() && move1.getPlayer() == currentPlayer){
                        currentPlayer.setCurrentNode(move1.getOrigin());
                        currentPlayer.setSecondStepForPlayer(true);
                        moves.remove(move1);
                        System.out.println(currentPlayer.getName() + " went back to " + currentPlayer.getCurrentNode().getNumber());
                        break;
                    }
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

                Node node = new Node(splitNode[0], neighbours);
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return nodes;
    }
}
