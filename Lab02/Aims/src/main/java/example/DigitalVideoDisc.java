package example;

public class DigitalVideoDisc {
    // Attribute
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // Constructor
    public DigitalVideoDisc(String title) {
        this.title = title;
    }


    public DigitalVideoDisc(String title, String category, float cost) {
        this(title);
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, cost);
        this.director = director;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this(title, category, director, cost);
        this.length = length;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }



}