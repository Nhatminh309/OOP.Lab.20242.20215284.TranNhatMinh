package hust.soict.itep.aims;

import hust.soict.itep.aims.media.Book;
import hust.soict.itep.aims.media.CompactDisc;
import hust.soict.itep.aims.media.DigitalVideoDisc;
import hust.soict.itep.aims.media.Track;
import hust.soict.itep.aims.screen.customer.controller.ViewStoreController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();

        Book book1 = new Book(1, "Doraemon", "Comic", 9.99f);
        book1.addAuthor("Fujiko F. Fujio");
        Book book2 = new Book(2, "Clean Code", "Programming", 15.5f);
        book2.addAuthor("Robert C. Martin");
        book2.addAuthor("Martin Fowler");
        Book book3 = new Book(3, "Sherlock Holmes", "Detective", 12.5f);
        book3.addAuthor("Arthur Conan Doyle");
        Book book4 = new Book(4, "The Great Gatsby", "Classic", 8.4f);
        book4.addAuthor("F. Scott Fitzgerald");
        Book book5 = new Book(5, "To Kill a Mockingbird", "Classic", 11.2f);
        book5.addAuthor("Harper Lee");
        Book book6 = new Book(6, "1984", "Dystopian", 10.6f);
        book6.addAuthor("George Orwell");

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);
        store.addMedia(book6);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(7, "Harry Potter", "Fantasy", "Chris Columbus", 0, 19.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(8, "Star Wars", "Sci-Fi", "George Lucas", 110, 17.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(9, "Avengers: Endgame", "Action", "Anthony Russo", 180, 25.0f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc(10, "Inception", "Thriller", "Christopher Nolan", 148, 15.0f);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);

        CompactDisc cd1 = new CompactDisc(11, "The Best of Mozart", "Classical", 12.0f, "Wolfgang Amadeus Mozart", 30, "Mozart");
        cd1.addTrack(new Track("Symphony No. 40", 15));
        cd1.addTrack(new Track("Eine kleine Nachtmusik", 8));
        CompactDisc cd2 = new CompactDisc(12, "Lofi Chill", "Instrumental", 8.5f, "DJ Chill", 25, "Various Artists");
        cd2.addTrack(new Track("Chill Vibes", 10));
        cd2.addTrack(new Track("Morning Coffee", 15));

        store.addMedia(cd1);
        store.addMedia(cd2);

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/itep/aims/screen/customer/view/Store.fxml"));
        Parent root = loader.load();
        ViewStoreController controller = loader.getController();
        controller.setStoreAndCart(store, cart);
        primaryStage.setTitle("AIMS Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
