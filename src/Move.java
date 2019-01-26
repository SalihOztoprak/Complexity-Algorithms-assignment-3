public class Move {
    private Player player;
    private Node origin;
    private int destination;
    private Color otherPlayersColor;
    private boolean wentBack;

    public Move(Player player, Node origin, int destination, Color otherPlayersColor) {
        this.player = player;
        this.origin = origin;
        this.destination = destination;
        this.otherPlayersColor = otherPlayersColor;
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
