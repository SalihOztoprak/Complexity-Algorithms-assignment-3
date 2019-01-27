import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to define a maze
 * It contains methods to find a path through the given maze
 */
public class Maze {
    private ArrayList<Node> nodes;
    private ArrayList<Move> moves;
    private Player currentPlayer;
    private Player otherPlayer;
    private boolean isFinished;

    /**
     * This is the default constructor for creating a maze
     */
    public Maze() {
        nodes = fileRead();
        moves = new ArrayList<>();
        Player player1 = new Player("Player 1", nodes.get(0));
        Player player2 = new Player("Player 2", nodes.get(1));
        currentPlayer = player1;
        otherPlayer = player2;
        isFinished = false;
    }

    /**
     * This method starts the maze
     */
    public void start() {
        while (!isFinished) {
            nextRound();
        }
    }

    /**
     * This method creates a new round for a player
     * A round will look for possibilities for the current user
     */
    private void nextRound() {
        Neighbour neighbour = checkForNeighbour();

        //If we found a neighbour, go to it
        if (neighbour != null) {
            movePlayer(neighbour);

            System.out.println(currentPlayer.getName() + " goes to " + currentPlayer.getCurrentNode().getNumber());

            //If the current player is now on the finish, stop the game
            if (currentPlayer.getCurrentNode().getColor().equals(Color.BLUE)) {
                System.out.println(currentPlayer.getName() + " has finished the maze");
                isFinished = true;
            }

            otherPlayer.setSwitchedBefore(false);
            currentPlayer.setSwitchedBefore(false);
        }

        //If we didn't found a neighbour, try to switch places
        else if (!otherPlayer.getSwitchedBefore()) {
            otherPlayer.setSwitchedBefore(true);
            switchSides();
        }

        //If we already switched places try to backtrack
        else {
            currentPlayer.setSwitchedBefore(false);
            currentPlayer.setSecondStepForPlayer(false);
            backtrack();
        }
    }

    /**
     * This method checks if the currentnode has neighbours which he can follow
     * When there is no neighbour left, it returns null
     *
     * @return The neighbour that has to be followed
     */
    private Neighbour checkForNeighbour() {
        //Create a boolean that checks if we followed a path before
        boolean followedBefore = false;

        //Loop through the neighbours to find one with the same path color of the other player
        for (Neighbour neighbour : currentPlayer.getCurrentNode().getNeighbours()) {
            //If there is a match, follow the color
            if (neighbour.getPathway().equals(otherPlayer.getCurrentNode().getColor())) {
                //Check if we followed that path before
                for (Move move : moves) {
                    if (move.getOrigin().equals(currentPlayer.getCurrentNode()) && move.getDestination() == neighbour.getNumber() && move.wentBackBefore()) {
                        //We followed this path before, so we don't follow it again
                        followedBefore = true;
                        break;
                    }
                }

                //We end up here if we didn't follow this path before
                if (!followedBefore) {
                    return neighbour;
                }
            }
        }
        return null;
    }

    /**
     * This method moves a player to the neighbour and saves it in a list of moves
     *
     * @param neighbour The neighbour you want to go to
     */
    private void movePlayer(Neighbour neighbour) {
        moves.add(new Move(currentPlayer, currentPlayer.getCurrentNode(), neighbour.getNumber()));
        currentPlayer.setCurrentNode(nodes.get(neighbour.getNumber() - 1));
        currentPlayer.setSecondStepForPlayer(true);
    }

    /**
     * This method let's the player backtrack in the maze
     * The method will be called when there are no options left for both players
     */
    private void backtrack() {
        //If we already did a second check, switch players
        if (currentPlayer.getSecondStepForPlayer()) {
            switchSides();
        }

        //If we didn't do a second step, try to go back a step
        else {
            //Find a move with your destination and that isn't used before to backtrack
            for (Move move : moves) {
                //If we find a move that matches, we go back to that move
                if (move.getDestination() == currentPlayer.getCurrentNode().getNumber() && move.getPlayer() == currentPlayer && !move.wentBackBefore()) {
                    move.setWentBack(true);
                    currentPlayer.setCurrentNode(move.getOrigin());
                    currentPlayer.setSecondStepForPlayer(true);
                    System.out.println(currentPlayer.getName() + " went back to " + currentPlayer.getCurrentNode().getNumber());
                    switchSides();
                    break;
                }
            }
        }
    }

    /**
     * This method let's the players switch sides
     */
    private void switchSides() {
        System.out.println(currentPlayer.getName() + " couldn't do a move, switching with my partner");
        Player tempPlayer = currentPlayer;
        currentPlayer = otherPlayer;
        otherPlayer = tempPlayer;
    }

    /**
     * This method reads the mazeStructure.txt file and converts it to an ArrayList
     *
     * @return The ArrayList containing the data of the file
     */
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
