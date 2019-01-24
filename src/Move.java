public class Move {
    private Player player;
    private Node origin;
    private int destination;

    public Move(Player player, Node origin, int destination) {
        this.player = player;
        this.origin = origin;
        this.destination = destination;
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
}
