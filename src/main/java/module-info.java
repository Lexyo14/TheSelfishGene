module com.example.thesefishgeneui {
    requires javafx.controls;
    requires javafx.fxml;


    opens TheSelfishGene to javafx.fxml;
    exports TheSelfishGene;
}