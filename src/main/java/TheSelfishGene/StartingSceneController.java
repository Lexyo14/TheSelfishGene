package TheSelfishGene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class StartingSceneController {
    @FXML
    private Button startButton;
    private Boolean running = false;

    public void clickOnStartButton(ActionEvent event) {
        if (!running){
            running = true;
            Execution program = new Execution();
            program.start();
            running = false;
        }

    }
}