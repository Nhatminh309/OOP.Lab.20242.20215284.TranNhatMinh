package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.Cart;
import hust.soict.itep.aims.Store;
import hust.soict.itep.aims.media.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ViewStoreController {
    @FXML
    private GridPane gridPane;
    @FXML
    private Button btnViewCart;

    private Store store;
    private Cart cart;

    public void setStoreAndCart(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        loadMedia();
    }

    @FXML
    public void initialize() {
        // Sau khi setStoreAndCart mới load data.
    }

    private void loadMedia() {
        try {
            gridPane.getChildren().clear();
            int column = 0;
            int row = 0;
            for (Media media : store.getItemsInStore()) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/itep/aims/screen/customer/view/Item.fxml"));
                AnchorPane anchorPane = loader.load();
                ItemController controller = loader.getController();
                controller.setData(media, cart);

                gridPane.add(anchorPane, column, row);

                column++;
                if (column == 3) { // 3 sản phẩm một hàng
                    column = 0;
                    row++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void btnViewCartPressed(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/itep/aims/screen/customer/view/Cart.fxml"));
            Parent root = loader.load();
            CartController controller = loader.getController();
            controller.setStoreAndCart(store, cart); // Nhớ thêm phương thức này vào CartController!
            Stage stage = (Stage) btnViewCart.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
