package TheSelfishGene;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ResourceBundle;

public class StartingSceneController implements Initializable {
    Stage stage;

    @FXML
    private Button startButton;
    @FXML
    private TextField philanderersInput;
    @FXML
    private TextField faithfulInput;
    @FXML
    private TextField fastInput;
    @FXML
    private TextField cowInput;
    private Boolean running = false;

    public void clickOnStartButton(ActionEvent event) throws Exception{
        if (!running){

            int numberPhilanderers = 0;
            int numberFaithful = 0;
            int numberCow = 0;
            int numberFast = 0;
            try {
                numberPhilanderers = Integer.valueOf(philanderersInput.getText());
                numberFaithful = Integer.valueOf(faithfulInput.getText());
                numberCow = Integer.valueOf(cowInput.getText());
                numberFast = Integer.valueOf(fastInput.getText());
            }catch (Exception e){
                String Error = "Invalid input for People (Male/Female)\nPlease, Only Integer numbers supported\nWe don't want to split people in half!!!";
                wrongInput(Error);}


            running = true;
            Execution program = new Execution(numberPhilanderers,numberFaithful,numberCow,numberFast,mDeathRate,fDeathRate);
            program.start();
            running = false;
        }
    }

    @FXML
    Slider maleDeathRateSlider;
    @FXML
    Slider femaleDeathRateSlider;
    @FXML
    Label maleDeathRateDisplay;
    int mDeathRate;
    @FXML
    Label femaleDeathRateDisplay;
    int fDeathRate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //everything declared in this class is automatically running in the background

        maleDeathRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mDeathRate = (int) maleDeathRateSlider.getValue();
                maleDeathRateDisplay.setText(Integer.toString(mDeathRate));
            }
        });


        femaleDeathRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fDeathRate = (int) femaleDeathRateSlider.getValue();
                femaleDeathRateDisplay.setText(Integer.toString(fDeathRate));
        }
        });
    }




    @FXML
    private Button exitButton;
    public void clickOnExitButton(ActionEvent event){
        stage = (Stage) exitButton.getScene().getWindow();
        System.out.println("Program Closed");
        stage.close();
    }

    public void wrongInput(String Error){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("WRONG INPUT.");
        alert.setResizable(false);
        alert.setHeaderText("The values given are Wrong");
        alert.setContentText("Error: " + Error);
        alert.show();
    }
}


