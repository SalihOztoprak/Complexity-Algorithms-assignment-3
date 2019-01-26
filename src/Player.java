public class Player {
    private int number;
    private String name;
    private Node currentNode;
    private boolean secondStepForPlayer;
    private boolean switchedBefore;

    public Player(int number, String name, Node currentNode) {
        this.number = number;
        this.name = name;
        this.currentNode = currentNode;
        this.switchedBefore = false;
        this.secondStepForPlayer = false;
    }

    public int getNumber() {
        return number;
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
