module com.example.studentrecordsystem {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.studentrecordsystem to javafx.fxml;
    exports com.example.studentrecordsystem;
}