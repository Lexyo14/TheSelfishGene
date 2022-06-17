package TheSelfishGene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartingScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        mainStage.setTitle("Hello!");
        mainStage.setScene(scene);
        mainStage.show();
    }
}

