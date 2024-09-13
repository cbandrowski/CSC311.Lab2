module org.example.lab2_bandrowski_c {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.lab2_bandrowski_c to javafx.fxml;
    exports org.example.lab2_bandrowski_c;
}