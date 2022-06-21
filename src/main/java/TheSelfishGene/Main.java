package TheSelfishGene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public static StartingSceneController controller;

    @Override
    public void start(Stage mainStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("StartingScene.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        mainStage.setTitle("TheSelfishGene.com");
        mainStage.setScene(scene);
        mainStage.setResizable(false);
        mainStage.show();
        controller = fxmlLoader.getController();
    }
}

