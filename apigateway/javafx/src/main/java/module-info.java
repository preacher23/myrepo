module com.example.java.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java.javafx to javafx.fxml;
    exports com.example.java.javafx;
}