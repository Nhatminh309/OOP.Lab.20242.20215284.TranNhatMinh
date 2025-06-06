package hust.soict.itep.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    // Constructor
    public DigitalVideoDisc(int id, String title) {
        super(id, title);
    }

    public DigitalVideoDisc(int id, String title, String category, float cost) {
        this(id, title);
        this.setCategory(category);
        this.setCost(cost);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, float cost) {
        this(id, title, category, cost);
        this.setDirector(director);
    }

    public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
        this(id, title, category, director, cost);
        this.setLength(length);
    }

    // To String
    public String toString(){
        return ". DVD - " + getTitle() + " - " + getCategory() + " - "
                + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    // Method to play a dvd
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }


    // Method to print a dvd
    @Override
    public void print() {
        System.out.println(getId() + ". DVD - "
                + getTitle() + " - "
                + getCategory() + " - "
                + getDirector() + " - "
                + getLength() + ": "
                + getCost() + "$");
    }
}