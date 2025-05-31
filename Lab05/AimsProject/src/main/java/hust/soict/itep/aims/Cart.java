package hust.soict.itep.aims;

import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
    public void addMedia(Media media) {
        itemsOrdered.add(media);
    }
    public void removeMedia(Media media) {
        itemsOrdered.remove(media);
    }
    public float totalCost() {
        float total = 0;
        for (Media m : itemsOrdered) total += m.getCost();
        return total;
    }
}