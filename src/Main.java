/**
 * This class is used to define a maze and start the maze
 */
public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Maze maze = new Maze();
        maze.start();
    }
}
