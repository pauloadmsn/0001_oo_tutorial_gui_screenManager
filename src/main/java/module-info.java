module org.example.tutorial_gui_screenmanager {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens org.example.tutorial_gui_screenmanager to javafx.fxml;
    exports org.example.tutorial_gui_screenmanager;
}