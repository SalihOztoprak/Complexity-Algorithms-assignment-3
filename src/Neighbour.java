/**
 * This class defines a neighbour, used to follow your path
 */
public class Neighbour {
    private Color pathway;
    private int number;

    /**
     * This is the default constructor for this class
     *
     * @param pathway The color of the pathway to the neighbour
     * @param number  The number of the neighbour
     */
    public Neighbour(Color pathway, int number) {
        this.pathway = pathway;
        this.number = number;
    }

    /**
     * This constructor is used when you want to create a neighbour from a TextFile
     *
     * @param neighbourString The string that contains the data of the neighbour
     */
    public Neighbour(String neighbourString) {
        String[] splitString = neighbourString.split("-");
        this.pathway = Color.valueOf(splitString[0].toUpperCase());
        this.number = Integer.valueOf(splitString[1]);
    }

    public Color getPathway() {
        return pathway;
    }

    public int getNumber() {
        return number;
    }
}
