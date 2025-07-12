package org.example.tutorial_gui_screenmanager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects; // Necessário para Objects.requireNonNull
public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
// Carrega a primeira tela (tela1.fxml)
        FXMLLoader fxmlLoader = new
                FXMLLoader(Objects.requireNonNull(HelloApplication.class.getResource("tela1.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
// Obtém o controlador e passa o Stage para ele
        MainController controller = fxmlLoader.getController();
        if (controller != null) {
            controller.setStage(stage);
        }
        stage.setTitle("Gerenciador de Telas");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}