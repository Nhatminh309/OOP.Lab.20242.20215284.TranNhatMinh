package hust.soict.itep.aims.screen.customer.controller;

import hust.soict.itep.aims.Cart;
import hust.soict.itep.aims.Store;
import hust.soict.itep.aims.exception.PlayerException;
import hust.soict.itep.aims.media.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class CartController {

    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TableColumn<Media, Integer> colNo;
    @FXML
    private TableColumn<Media, Integer> colMediaId;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediaCategory;
    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;
    @FXML
    private Button btnRemove;
    @FXML
    private Button btnViewStore;
    @FXML
    private Button btnPlaceOrder;
    @FXML
    private Label costLabel;
    @FXML
    private TextField tfFilter;
    @FXML
    private RadioButton rbById;
    @FXML
    private RadioButton rbByTitle;

    private Store store;
    private Cart cart;
    private ObservableList<Media> fullData = FXCollections.observableArrayList();

    public CartController() {}

    @FXML
    public void initialize() {
        // Table columns
        colMediaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        // Số thứ tự (STT)
        colNo.setCellFactory(col -> new TableCell<Media, Integer>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || getTableRow() == null || getTableRow().getIndex() >= tblMedia.getItems().size()) {
                    setText(null);
                } else {
                    setText(String.valueOf(getTableRow().getIndex() + 1));
                }
            }
        });

        // ToggleGroup cho filter
        ToggleGroup filterGroup = new ToggleGroup();
        rbById.setToggleGroup(filterGroup);
        rbByTitle.setToggleGroup(filterGroup);

        // Mặc định chọn By ID
        rbById.setSelected(true);

        // Filter
        tfFilter.textProperty().addListener((obs, oldVal, newVal) -> applyFilter());
        rbById.setOnAction(e -> applyFilter());
        rbByTitle.setOnAction(e -> applyFilter());

        // Xử lý nút Play/Remove
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            boolean hasSelection = newVal != null;
            btnPlay.setVisible(hasSelection && newVal instanceof Playable);
            btnRemove.setVisible(hasSelection);
        });
    }

    public void setStoreAndCart(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        // Copy danh sách media để filter
        fullData.setAll(cart.getItemsOrdered());
        tblMedia.setItems(fullData);
        updateTotalCost();
    }

    private void updateTotalCost() {
        if (cart != null) {
            costLabel.setText(String.format("%.2f $", cart.totalCost()));
        }
    }

    private void applyFilter() {
        String filterText = tfFilter.getText().trim().toLowerCase();
        ObservableList<Media> filtered = FXCollections.observableArrayList();
        if (cart != null) {
            for (Media m : cart.getItemsOrdered()) {
                if (rbById.isSelected()) {
                    if (String.valueOf(m.getId()).contains(filterText)) filtered.add(m);
                } else if (rbByTitle.isSelected()) {
                    if (m.getTitle().toLowerCase().contains(filterText)) filtered.add(m);
                }
            }
        }
        tblMedia.setItems(filtered);
        updateTotalCost();
    }

    @FXML
    private void btnRemovePressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected != null && cart != null) {
            cart.removeMedia(selected);
            applyFilter(); // filter lại (hoặc tblMedia.setItems(cart.getItemsOrdered()))
            updateTotalCost();
        }
    }

    @FXML
    private void btnPlayPressed() {
        Media selected = tblMedia.getSelectionModel().getSelectedItem();
        if (selected instanceof Playable) {
            try {
                ((Playable) selected).play();
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Playing: " + selected.getTitle());
                alert.showAndWait();
            } catch (PlayerException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage());
                alert.showAndWait();
            }
        }
    }

    @FXML
    private void btnViewStorePressed() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/itep/aims/screen/customer/view/Store.fxml"));
            Parent root = loader.load();
            ViewStoreController controller = loader.getController();
            controller.setStoreAndCart(store, cart);
            Stage stage = (Stage) btnViewStore.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
