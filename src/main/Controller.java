package main;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    public CheckBox checkHearts = new CheckBox();
    @FXML
    public CheckBox checkSpades = new CheckBox();
    @FXML
    public CheckBox checkClubs = new CheckBox();
    @FXML
    public CheckBox checkDiamonds = new CheckBox();

    private Settings settings = new Settings();
    private Labels labels = new Labels();
    private Cards cards = new Cards();

    static void alertBox() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("Choose settings");
        alert.showAndWait();

    }


    public void handleGoAction() throws IOException {        // pressing GO button sets values the user inputs and if values are OK it proceeds to a new scene
        boolean isCorrect = false;  // temporary variables to store info if comboboxes are selected
        boolean isCorrect2 = false;
        boolean isCorrect3 = false;



        if (comboBox1.getValue() == null) {

            isCorrect = false;          // checking if value is selected
        } else if (comboBox1.getValue() != null) {
            settings.setTimeConcentration(Integer.parseInt(comboBox1.getValue()));
            isCorrect = true;
        }
        if (!checkDiamonds.isSelected() && !checkClubs.isSelected() &&
                !checkSpades.isSelected() && !checkHearts.isSelected()) {           // checking if at least one checkbox is selected
            isCorrect3 = false;

        } else if (checkDiamonds.isSelected() || checkClubs.isSelected() ||
                checkSpades.isSelected() || checkHearts.isSelected()) {
            isCorrect3 = true;

        }
        if (comboBox.getValue() == null) {
            isCorrect2 = false; // checking if value is selected
        } else if (comboBox.getValue() != null) {
            settings.setTimeRemember(Integer.parseInt(comboBox.getValue()));
            isCorrect2 = true;
        }
        if (!isCorrect || !isCorrect2 || !isCorrect3) {
            alertBox();                                   // if at least one of the settings isn't selected alert box appears
        }
        if (isCorrect && isCorrect2 && isCorrect3) {
            Stage stage;
            stage = (Stage) goButton.getScene().getWindow();
            stage.setTitle("CardsMemorising");
            stage.setResizable(false);


            GridPane gridPane = labels.getGridPane();


            Scene scene2 = new Scene(gridPane, 1280, 720);
            stage.setScene(scene2);
            stage.show();
            int cardsNum = 0;       // var storing info about how long the sequence of cards to memorize will be
            if (checkDiamonds.isSelected()) {
                cardsNum += 13;
                settings.setDiamonds(true);
            }
            if (checkClubs.isSelected()) {
                cardsNum += 13;
                settings.setClubs(true);                   // counting number of selected cards to declare array size
            }
            if (checkHearts.isSelected()) {
                cardsNum += 13;
                settings.setHearts(true);
            }
            if (checkSpades.isSelected()) {
                cardsNum += 13;
                settings.setSpades(true);
            }
            String[] sequence = new String[cardsNum];
            int cardsCount = 0;
            if (checkHearts.isSelected()) {                   // if given color is checked, random sequence of cards of this color is added to an array
                for (int i = 0; i < 13; i++) {
                    sequence[cardsCount] = cards.hearts[i];
                    cardsCount++;
                }
            }

            if (checkDiamonds.isSelected()) {
                for (int i = 0; i < 13; i++) {
                    sequence[cardsCount] = cards.diamonds[i];
                    cardsCount++;
                }
            }
            if (checkSpades.isSelected()) {
                for (int i = 0; i < 13; i++) {
                    sequence[cardsCount] = cards.spades[i];
                    cardsCount++;
                }
            }
            if (checkClubs.isSelected()) {
                for (int i = 0; i < 13; i++) {
                    sequence[cardsCount] = cards.clubs[i];
                    cardsCount++;
                }
            }
            for (int i = 0; i < cardsCount; i++) {
                System.out.println(sequence[i]);
            }

            for (int i3 = 0; i3 < 7; i3++) {
                labels.addLabels2("label", 0, i3);
                for (int i4 = 0; i4 < 13; i4++) {
                    labels.addLabels2("label", i4, i3);                     // calling addlabels methods that creates labels with cards
                }
            }
            for (int i3 = 3; i3 < 7; i3++) {
                labels.addLabels("label", 0, i3);
                for (int i4 = 0; i4 < 13; i4++) {
                    labels.addLabels("label", i4, i3);
                }
            }
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        comboBox.getItems().addAll("15", "30", "45", "60", "90");
        comboBox1.getItems().addAll("15", "30", "45", "60");


    }
}





