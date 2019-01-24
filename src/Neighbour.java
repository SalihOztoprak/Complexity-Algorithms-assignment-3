public class Neighbour {
    private Color pathway;
    private int number;

    public Neighbour(Color pathway, int number) {
        this.pathway = pathway;
        this.number = number;
    }

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
