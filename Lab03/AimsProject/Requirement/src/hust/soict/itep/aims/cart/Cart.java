package hust.soict.itep.aims.cart;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Media> itemsOrdered = new ArrayList<Media>();
    private int numOfDVDs;

    // Constructor
    public Cart() {
        numOfDVDs = 0;
    }

    public void addMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            System.out.println("Media is already in the list");
            return;
        }
        itemsOrdered.add(media);
        if (media instanceof DigitalVideoDisc) {
            numOfDVDs++;
        }
        System.out.println("Added");
    }

    public void removeMedia(Media media) {
        if (!itemsOrdered.remove(media)) {
            System.out.println("Not found");
            return;
        }
        if (media instanceof DigitalVideoDisc) {
            numOfDVDs--;
        }
        System.out.println("Removed");
    }


    // Method to calculate the total cost
    public double totalCost() {
        float cost = 0;
        for (Media media: itemsOrdered) {
            cost += media.getCost();
        }

        return Math.round(cost * 100.0) / 100.0;
    }

    // Method to print the list of ordered items of a cart, the price of each item, and the total price
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            media.print();
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("**************************************************");
    }

    // Method to search for media in the cart by ID and display the search results.
    public Media searchByID(int id) {
        for (Media media: itemsOrdered) {
            if (media.getId() == id) {
                return media;
            }
        }
        System.out.println("Not found!");
        return null;
    }

    // Method to search for media in the cart by title.
    public Media searchByTitle(String title) {
        for (Media media: itemsOrdered) {
            if (media.isMatch(title)) {
                return media;
            }
        }
        System.out.println("Not found!");
        return null;
    }

    // Method to sort by title and print
    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE);
        printCart();
    }

    // Method to sort by cost and print
    public void sortByCost() {
        itemsOrdered.sort(Media.COMPARE_BY_COST);
        printCart();
    }

    // Getter and Setter

    public int getNumOfDVDs() {
        return numOfDVDs;
    }

    public void setNumOfDVDs(int numOfDVDs) {
        this.numOfDVDs = numOfDVDs;
    }
}