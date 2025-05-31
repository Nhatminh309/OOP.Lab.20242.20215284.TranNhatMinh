package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.Cart;
import hust.soict.itep.aims.media.*;
import hust.soict.itep.aims.exception.PlayerException;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class ItemController {
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblCost;
    @FXML
    private Button btnAddToCart;
    @FXML
    private Button btnPlay;

    private Media media;
    private Cart cart; // để add vào cart

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lblTitle.setText(media.getTitle());
        lblCost.setText(String.format("%.2f $", media.getCost()));
        btnPlay.setVisible(media instanceof Playable);
    }

    @FXML
    private void btnAddToCartClicked() {
        if (cart != null && media != null) {
            cart.addMedia(media);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added to cart!");
            alert.showAndWait();
        }
    }

    @FXML
    private void btnPlayClicked() {
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Playing: " + media.getTitle());
                alert.showAndWait();
            } catch (PlayerException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        }
    }
}
