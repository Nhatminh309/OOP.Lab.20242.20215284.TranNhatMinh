module hust.soict.itep.aims {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens hust.soict.itep.aims to javafx.fxml;
    opens hust.soict.itep.aims.screen.customer.controller to javafx.fxml;
    opens hust.soict.itep.aims.media to javafx.base, javafx.fxml;
    exports hust.soict.itep.aims;
}
