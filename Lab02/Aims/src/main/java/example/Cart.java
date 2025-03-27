package example;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc []itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];

    private int qtyOrdered;

    // Constructor
    public Cart() {
        setQtyOrdered(0);
    }

    // Setter and Getter
    public DigitalVideoDisc[] getItemsOrdered() {
        return itemsOrdered;
    }

    public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
        this.itemsOrdered = itemsOrdered;
    }

    public int getQtyOrdered() {
        return qtyOrdered;
    }

    public void setQtyOrdered(int qtyOrdered) {
        this.qtyOrdered = qtyOrdered;
    }

    // Method to add a new DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        // If cart is full
        if (getQtyOrdered() >= 20) {
            System.out.println("The cart is almost full");
            return;
        }

        setQtyOrdered(getQtyOrdered() + 1);

        // Add to cart
        DigitalVideoDisc []newItemsOrdered = getItemsOrdered();
        newItemsOrdered[getQtyOrdered() - 1] = disc;
        setItemsOrdered(newItemsOrdered);

        System.out.println("The disc has been added");
    }

    // Method to remove a DVD
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }

                itemsOrdered[qtyOrdered - 1] = null;

                qtyOrdered--;
                System.out.println("Removed.");
                return;
            }
        }
        System.out.println("The disc was not found"); // In ra thông báo nếu đơn đặt hàng không tồn tại trong giỏ.
    }

    // Method to calculate the total cost
    public double totalCost() {
        double cost = 0;
        DigitalVideoDisc []itemsOrdered = getItemsOrdered();
        for (DigitalVideoDisc disc: itemsOrdered) {
            if (disc != null) {
                cost += disc.getCost();
            }
        }

        return Math.round(cost * 100.0) / 100.0;
    }

    //print Cart
    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:\n");

        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + dvd.getTitle() + " - " + dvd.getCategory() + " - "
                    + dvd.getDirector() + " - " + dvd.getLength() + ": " + dvd.getCost() + " $");
        }

        System.out.println("\nTotal cost: " + totalCost() + " $\n");
        System.out.println("***************************************************");
    }

    // method that has the same name but with different type of parameter.
    public void addDigitalVideoDisc(DigitalVideoDisc []dvdList) {
        // If cart is full
        if (qtyOrdered + dvdList.length > 20) {
            System.out.println("The cart is almost full");
            return;
        }

        // Add to cart
        System.arraycopy(dvdList, 0, itemsOrdered, qtyOrdered, dvdList.length);

        // Increase the qtyOrdered
        qtyOrdered += dvdList.length;

        // Notify
        System.out.println("The list has been added");
    }

    // Method to add two new DVD
    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
        // If cart is full
        if (qtyOrdered >= 19) {
            System.out.println("The cart is almost full");
            return;
        }

        // Increase the qtyOrdered
        qtyOrdered += 2;

        // Add to cart
        itemsOrdered[qtyOrdered - 2] = dvd1;
        itemsOrdered[qtyOrdered - 1] = dvd1;

        // Notify
        System.out.println("The disc has been added");
    }

}