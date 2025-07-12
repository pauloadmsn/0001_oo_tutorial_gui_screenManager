package org.example.tutorial_gui_screenmanager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects; // Necessário para Objects.requireNonNull

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void setStage(Stage stage) {
        this.stage = stage;
    }
    @FXML
    void irParaTela1(ActionEvent event) throws IOException {
        loadScene("tela1.fxml", "Tela 1");
    }
    @FXML
    void irParaTela2(ActionEvent event) throws IOException {
        loadScene("tela2.fxml", "Tela 2");
    }
    @FXML
    void irParaTela3(ActionEvent event) throws IOException {
        loadScene("tela3.fxml", "Tela 3");
    }
    private void loadScene(String fxmlFileName, String title) throws
            IOException {
        FXMLLoader loader = new FXMLLoader(Objects.requireNonNull(getClass().getResource(fxmlFileName)));
        root = loader.load();

        MainController newController = loader.getController();
        if (newController != null) {
            newController.setStage(this.stage);
        }

        scene = new Scene(root);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

    }
}
