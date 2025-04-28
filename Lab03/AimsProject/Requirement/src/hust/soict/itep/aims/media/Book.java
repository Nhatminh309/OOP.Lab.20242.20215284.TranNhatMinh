package hust.soict.itep.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthor() {
        return authors;
    }

    public void setAuthor(List<String> author) {
        this.authors = author;
    }

    // Constructor
    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    // Crate addAuthor

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author added: " + authorName);
        }
        System.out.println("Failed to add author: " + authorName);
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author removed: " + authorName);
        }
        System.out.println("Failed to remove author: " + authorName);
    }

    // Method to print a book
    @Override
    public void print() {
        System.out.print(getId() + ". Book - "
                + getTitle() + " - "
                + getCategory() + " - ");
        for (String author: authors) {
            System.out.print(author + " - ");
        }
        System.out.println(getCost() + "$");
    }

}
