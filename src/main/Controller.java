package main;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private ComboBox<String> comboBox = new ComboBox<>();
    @FXML
    public ComboBox<String> comboBox1 = new ComboBox<>();
    @FXML
    public Button goButton = new Button();
    @FXML
    private CheckBox checkHearts = new CheckBox();
    @FXML
    private CheckBox checkSpades = new CheckBox();
    @FXML
    private CheckBox checkClubs = new CheckBox();
    @FXML
    private CheckBox checkDiamonds = new CheckBox();

    private Settings settings = new Settings();
    private Labels labels = new Labels();
    Label label = new Label();

    public void handleGoAction() throws IOException {        // pressing GO button sets values user input and if values are OK it proceeds to a new scene
        boolean isCorrect = false;  // temporary variables to store info if comboboxes are selected
        boolean isCorrect2 = false;

        settings.setDiamonds(checkDiamonds.isSelected());
        settings.setClubs(checkClubs.isSelected());
        settings.setSpades(checkSpades.isSelected());
        settings.setHearts(checkHearts.isSelected());
        if (comboBox1.getValue() == null) {
            System.out.println("zle");
            isCorrect = false;          // checking if value is selected
        } else if (comboBox1.getValue() != null) {
            settings.setTimeConcentration(Integer.parseInt(comboBox1.getValue()));
            isCorrect = true;
        }
        if (!checkDiamonds.isSelected() && !checkClubs.isSelected() &&
                !checkSpades.isSelected() && !checkHearts.isSelected()) {            // checking if at least one checkbox is selected
            System.out.println("check the cards");
            isCorrect2 = false;
        }
        if (comboBox.getValue() == null) {
            System.out.println("zle");                  // checking if value is selected
        } else if (comboBox.getValue() != null) {
            settings.setTimeRemember(Integer.parseInt(comboBox.getValue()));
            isCorrect2 = true;
        }
        if (isCorrect && isCorrect2) {
            Stage stage;
            stage = (Stage) goButton.getScene().getWindow();
            stage.setTitle("CardsMemorising");
            stage.setResizable(false);


            GridPane gridPane = labels.getGridPane();
            for (int i3 = 0; i3 < 3; i3++) {
                labels.addLabels2("label", 0, i3);

                for (int i4 = 0; i4 < 13; i4++) {
                    labels.addLabels2("label", i4, i3);
                }
            }
            for (int i3 = 3; i3 < 7; i3++) {
                labels.addLabels("label", 0, i3);

                for (int i4 = 0; i4 < 13; i4++) {
                    labels.addLabels("label", i4, i3);
                }
            }

            Scene scene2 = new Scene(gridPane, 1280, 720);
            stage.setScene(scene2);
            stage.show();


        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox.getItems().addAll("15", "30", "45", "60", "90");
        comboBox1.getItems().addAll("15", "30", "45", "60");


    }
}





