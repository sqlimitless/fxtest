module com.jty.jjejty {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.jty.jjejty to javafx.fxml;
    exports com.jty.jjejty;
}