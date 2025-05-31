package hust.soict.itep.aims;

import hust.soict.itep.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private ObservableList<Media> itemsInStore = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsInStore() {
        return itemsInStore;
    }
    public void addMedia(Media media) {
        itemsInStore.add(media);
    }
    public void removeMedia(Media media) {
        itemsInStore.remove(media);
    }
}