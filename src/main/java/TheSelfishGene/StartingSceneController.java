package TheSelfishGene;

import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class StartingSceneController extends Battle implements Initializable {
    Stage stage;

    @FXML
    private CheckBox defaultValues;
    @FXML
    private TextField philanderersInput;
    @FXML
    private TextField faithfulInput;
    @FXML
    private TextField fastInput;
    @FXML
    private TextField cowInput;
    @FXML
    private TextField inputA;
    @FXML
    private TextField inputB;
    @FXML
    private TextField inputC;

    private Boolean running = false;

    @FXML
    private Button exitButton;

    boolean executed = false;

    public void clickOnExitButton(ActionEvent event) {
        stage = (Stage) exitButton.getScene().getWindow();
        System.out.println("Program Closed");
        stage.close();
    }

    public void clickOnStartButton(ActionEvent event) throws Exception {
        if (!running) {
            rawValues.clear();
            executed = false;
            if (defaultValues.isSelected()) {
                running = true;
                Execution program = new Execution(7,9,2,5, 13, 40, 10,
                        100, 100, 10, 1, 100, 10, 10);
                program.start();
                running = false;
            } else {

                int numberPhilanderers = 0;
                int numberFaithful = 0;
                int numberCow = 0;
                int numberFast = 0;
                int a = 0;
                int b = 0;
                int c = 0;
                try {
                    numberPhilanderers = Integer.valueOf(philanderersInput.getText());
                    numberFaithful = Integer.valueOf(faithfulInput.getText());
                    numberCow = Integer.valueOf(cowInput.getText());
                    numberFast = Integer.valueOf(fastInput.getText());
                    a = Integer.valueOf(inputA.getText());
                    b = Integer.valueOf(inputB.getText());
                    c = Integer.valueOf(inputC.getText());
                } catch (Exception e) {
                    String Error = "Invalid input for People (Male/Female)\nPlease, Only Integer numbers supported\nWe don't want to split people in half!!!";
                    wrongInput(Error);
                    return;
                }
                running = true;
                Execution program = new Execution(a,b,c,numberPhilanderers, numberFaithful, numberCow, numberFast,
                        mDeathRate, fDeathRate, mut, approx, rep, year, stability);
                program.start();
                running = false;

            }
            executed = true;
        }
    }


    @FXML
    Slider maleDeathRateSlider;
    @FXML
    Label maleDeathRateDisplay;
    int mDeathRate;

    @FXML
    Slider maleMutationSlider;
    @FXML
    Label maleMutationDisplay;
    int mut;

    @FXML
    Slider femaleDeathRateSlider;
    @FXML
    Label femaleDeathRateDisplay;
    int fDeathRate;

    @FXML
    Slider approxSlider;
    @FXML
    Label approxDisplay;
    int approx;

    @FXML
    Slider repSlider;
    @FXML
    Label repDisplay;
    int rep;

    @FXML
    Slider yearSlider;
    @FXML
    Label yearDisplay;
    int year;

    @FXML
    Slider stabilitySlider;
    @FXML
    Label stabilityDisplay;
    int stability;


    //following vaiables are used to show real time values in the execution tab


    @FXML
    BarChart populationGraph;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //everything declared in this class is automatically running in the background

        //setting up population chart:
        XYChart.Series popData = new XYChart.Series();
        popData.getData().add(new XYChart.Data("Phil", 0));
        popData.getData().add(new XYChart.Data("Faith", 0));
        popData.getData().add(new XYChart.Data("Coy", 0));
        popData.getData().add(new XYChart.Data("Fast", 0));
        populationGraph.getData().addAll(popData);

        //setting up total population chart:


        maleDeathRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mDeathRate = (int) maleDeathRateSlider.getValue();
                maleDeathRateDisplay.setText(Integer.toString(mDeathRate) + "%");
            }
        });

        maleMutationSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                mut = (int) maleMutationSlider.getValue();
                maleMutationDisplay.setText(Integer.toString(mut));
            }
        });


        femaleDeathRateSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                fDeathRate = (int) femaleDeathRateSlider.getValue();
                femaleDeathRateDisplay.setText(Integer.toString(fDeathRate) + "%");
            }
        });

        approxSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                approx = (int) approxSlider.getValue();
                approxDisplay.setText(Integer.toString(approx));
            }
        });

        repSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                rep = (int) repSlider.getValue();
                repDisplay.setText(Integer.toString(rep));
            }
        });

        yearSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                year = (int) yearSlider.getValue();
                yearDisplay.setText(Integer.toString(year));
            }
        });

        stabilitySlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                stability = (int) stabilitySlider.getValue();
                stabilityDisplay.setText(Integer.toString(stability));
            }
        });


        //execution tab:

    }

    public void updateTotalPopDisplay(int value, int j) {
        Runnable task = () -> {
            Platform.runLater(() -> {

            });
        };
        task.run();
    }

    @FXML
    Label totalPopDisplay;

    public void updatePopChart(int cntp, int cntf, int cntc, int cnts) {
        Runnable task = () -> {
            Platform.runLater(() -> {
                populationGraph.setData(FXCollections.observableArrayList());
                XYChart.Series popData = new XYChart.Series();
                popData.getData().add(new XYChart.Data("Phil:" + cntp, cntp));
                popData.getData().add(new XYChart.Data("Faith:" + cntf, cntf));
                popData.getData().add(new XYChart.Data("Coy:" + cntc, cntc));
                popData.getData().add(new XYChart.Data("Fast:" + cnts, cnts));
                populationGraph.getData().addAll(popData);
                totalPopDisplay.setText("Total pop:" + (cntp + cntf + cntc + cnts));
            });
        };
        task.run();
    }

    @FXML
    ProgressBar progressBar;
    @FXML
    Label generationDisplay;

    public void updateProgressBar(int i, int tot) {
        Runnable task = () -> {
            Platform.runLater(() -> {
                progressBar.setProgress((double) i / (double) tot);
                generationDisplay.setText("Generation:" + i + "/" + tot);
            });
        };
        task.run();
    }

    public void eventStable(int i) {

        //the code below will ask to execute the stuff in runLater in the javaFx thread
        //In this way only javafx thread will try to update the UI and will not give errors.
        //        Runnable task = () -> {
        //            Platform.runLater(() ->{});
        //            };
        Runnable task = () -> {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Stable instance.");
                alert.setHeaderText("The population reached Stability");
                alert.setContentText("The ratio between the populations ended up to reach stability after generation number " + i);
                alert.show();
            });
        };
        task.run();
    }

    public void eventUnstable(int i) {
        Runnable task = () -> {
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Unstable instance.");
                alert.setHeaderText("Reached maximum number of generation");
                alert.setContentText("Population couldn't reach stability even after generation number " + i);
                alert.show();
            });
        };
        task.run();
    }

    public void wrongInput(String Error) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("WRONG INPUT.");
        alert.setResizable(false);
        alert.setHeaderText("The values given are Wrong");
        alert.setContentText("Error: " + Error);
        alert.show();
    }

    ArrayList<int[]> rawValues = new ArrayList<int[]>();

    public void addRawValues(int[] values) {
        Runnable task = () -> {
            Platform.runLater(() -> {
                rawValues.add(values);
            });
        };
        task.run();
    }

    public void showGraph(ActionEvent event) {
        if (executed == true) {
            //creating the graph
            NumberAxis xAxis = new NumberAxis();
            xAxis.setLabel("Year");
            NumberAxis yAxis = new NumberAxis();
            yAxis.setLabel("Population");
            LineChart BigGraph = new LineChart<>(xAxis, yAxis);

            int yearin; //sets the x in the grap
            if (defaultValues.isSelected()){
                yearin = 10;
            }else{
            yearin= year;
            }
            String[] names = {"Philanderers", "Faithful", "Coy", "Fast"};//used to set the name in the graph

            //creating the data for the graph
            for (c=0; c<=3; c++) {
                int x = 0;
                XYChart.Series data = new XYChart.Series();
                data.setName(names[c]);//set name for specific
                for (int[] generation : rawValues) {
                    x += 1;
                    data.getData().add(new XYChart.Data(x*yearin, generation[c]));
                }
                BigGraph.getData().add(data);
            }


            Stage graphStage = new Stage();
            Scene graphScene = new Scene(BigGraph);
            graphStage.setScene(graphScene);
            graphStage.setFullScreen(true);
            graphStage.show();
        }else{
            wrongInput("You didn't execute the program or the program is currently in execution.\nPlease wait to finish or start a new instance.");
        }


        }
    }




