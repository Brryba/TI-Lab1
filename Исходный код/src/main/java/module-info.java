module org.example.lab1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens lab1 to javafx.fxml;
    opens lab1.GUI to javafx.fxml;
    exports lab1;
    exports lab1.GUI;
    exports lab1.ciphers;
    opens lab1.ciphers to javafx.fxml;
}