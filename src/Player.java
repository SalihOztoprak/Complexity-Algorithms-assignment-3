/**
 * This class is used to define a player
 */
public class Player {
    private String name;
    private Node currentNode;
    private boolean secondStepForPlayer;
    private boolean switchedBefore;

    /**
     * This is the default constructor for a player
     *
     * @param name        The name of the player
     * @param currentNode The current node where the player is standing
     */
    public Player(String name, Node currentNode) {
        this.name = name;
        this.currentNode = currentNode;
        this.switchedBefore = false;
        this.secondStepForPlayer = false;
    }

    public String getName() {
        return name;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public boolean getSecondStepForPlayer() {
        return secondStepForPlayer;
    }

    public void setSecondStepForPlayer(boolean secondStepForPlayer) {
        this.secondStepForPlayer = secondStepForPlayer;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public boolean getSwitchedBefore() {
        return switchedBefore;
    }

    public void setSwitchedBefore(boolean switchedBefore) {
        this.switchedBefore = switchedBefore;
    }
}
