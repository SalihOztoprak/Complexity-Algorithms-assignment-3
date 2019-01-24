public class Player {
    private int number;
    private String name;
    private Node currentNode;

    public Player(int number, String name, Node currentNode) {
        this.number = number;
        this.name = name;
        this.currentNode = currentNode;
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
}
