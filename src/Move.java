/**
 * This class defines a move in the maze
 */
public class Move {
    private Player player;
    private Node origin;
    private int destination;
    private boolean wentBack;

    /**
     * This is the default constructor for a move
     *
     * @param player      The player that makes the move
     * @param origin      The node where you came from
     * @param destination The number of the node you are going to
     */
    public Move(Player player, Node origin, int destination) {
        this.player = player;
        this.origin = origin;
        this.destination = destination;
        this.wentBack = false;
    }

    public Player getPlayer() {
        return player;
    }

    public Node getOrigin() {
        return origin;
    }

    public int getDestination() {
        return destination;
    }

    public boolean wentBackBefore() {
        return wentBack;
    }

    public void setWentBack(boolean wentBack) {
        this.wentBack = wentBack;
    }
}
