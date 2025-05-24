package hust.soict.itep.aims.screen.manager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import hust.soict.itep.Cart;
import hust.soict.itep.Store;
import hust.soict.itep.media.Book;
import hust.soict.itep.media.CompactDisc;
import hust.soict.itep.media.DigitalVideoDisc;
import hust.soict.itep.media.Media;


public class StoreScreen extends JFrame {
    // Attribute
    private Store store;
    private Cart cart;

    // Constructor
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout. NORTH);
        cp.add(createCenter(), BorderLayout. CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
    }

    // Method to create NORTH component
    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Method to create Menu Bar
    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        MenuListener menuListener = new MenuListener(store, cart);
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(menuListener);
        smUpdateStore.add(addBook);
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(menuListener);
        smUpdateStore.add(addCD);
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(menuListener);
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(menuListener);
        menu.add(viewStore);
        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(menuListener);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    // Method to create Header
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);



        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    // Method to create Center
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout (new GridLayout(3, 3, 2, 2));

        List<Media> mediaInStore = store.getItemsInStore();
        MediaStore.setCart(cart);
        for (int i = 0; i < 9; i++) {
            if (i >= mediaInStore.size()) {
                break;
            }
            MediaStore cell = new MediaStore(mediaInStore.get(i));
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) throws Exception {
        Store store = new Store();
        Cart cart = new Cart();
        // Create new media and add them to the store
        // Addng Books
        Media book1 = new DigitalVideoDisc(1, "Harry Potter and the Philosopher's Stone (2021)",
                "Thriller", 3.0f);
        store.addMedia(book1);

        Media book2 = new DigitalVideoDisc(2, "Harry Potter and the Chamber of Secrets (2022)",
                "Mystery", 3.5f);
        store.addMedia(book2);

        Media book3 = new Book(3, "Harry Potter and the Prisoner of Azkaban (2004)",
                "Memoir", 5.0f);
        store.addMedia(book3);

        Media book4 = new Book(4, "Harry Potter and the Goblet of Fire (2005)",
                "Autobiography", 4.5f);
        store.addMedia(book4);

        Media book5 = new Book(5, "Fetch the Bolt Cutters",
                "Mystery", 10.39f);
        store.addMedia(book5);

        Media book6 = new Book(6, "Future Nostalgia",
                "Mystery", 9.6f);
        store.addMedia(book6);

        // Adding DVDs
        Media dvd1 = new DigitalVideoDisc(7, "Inception",
                "Science Fiction", "Christopher Nolan", 148, 19.99f);
        store.addMedia(dvd1);

        Media dvd2 = new DigitalVideoDisc(8, "The Dark Knight",
                "Action", "Christopher Nolan", 152, 17.99f);
        store.addMedia(dvd2);

        Media dvd3 = new DigitalVideoDisc(9, "Interstellar",
                "Science Fiction", "Christopher Nolan", 169, 21.99f);
        store.addMedia(dvd3);

        // Adding CDs
        Media cd1 = new CompactDisc(10, "Random Access Memories",
                "Electronic", 15.99f, "Daft Punk", 13, "Daft Punk");
        store.addMedia(cd1);

        Media cd2 = new CompactDisc(11, "25",
                "Pop", 14.99f, "Adele", 11, "Adele");
        store.addMedia(cd2);

        Media cd3 = new CompactDisc(12, "Lover",
                "Pop", 17.99f, "Taylor Swift", 18, "Taylor Swift");
        store.addMedia(cd3);


        new StoreScreen(store, cart);


    }

    // Button Listener for View Cart
    private class ButtonListener implements ActionListener {
        // Attribute
        private Cart cart;

        // Constructor
        public ButtonListener(Cart cart) {
            super();
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand();
            if (button.equals("View cart")) {
                new CartScreen(cart);
                setVisible(false);
                dispose();
            }
        }
    }

    // Menu Listener for Menu Option
    private class MenuListener implements ActionListener {
        // Attribute
        private Store store;
        private Cart cart;

        // Constructor
        public MenuListener(Store store, Cart cart) {
            super();
            this.store = store;
            this.cart = cart;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String menu = e.getActionCommand();
            switch (menu) {
                case "Add Book" -> {
                    new AddBookToStore(store, cart);
                    setVisible(false);
                    dispose();
                }
                case "Add CD" -> {
                    new AddCDToStore(store, cart);
                    setVisible(false);
                    dispose();
                }
                case "Add DVD" -> {
                    new AddDVDToStoreScreen(store, cart);
                    setVisible(false);
                    dispose();
                }
                case "View store" -> {
                    new StoreScreen(store, cart);
                    setVisible(false);
                    dispose();
                }
                case "View cart" -> {
                    new CartScreen(cart);
                    setVisible(false);
                    dispose();
                }
            }
        }
    }
}
