package main;


import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;


public class Focus {

    private Labels labels = new Labels();
    private static Label label = new Label();

    public static Label getLabel() {
        return label;
    }

// TODO make countdown using Timer and use addLabels3 as below





    public void setFocusScene() {
        Stage stage2;
        stage2 = new Stage();
        stage2.setTitle("CardsMemorising");
        stage2.setResizable(false);
        Pane Pane2 = labels.getPane();
        Scene scene3 = new Scene(Pane2, 1280, 720);
        stage2.setScene(scene3);
        stage2.show();

        Pane2.getChildren().add(label);

        labels.addLabels3(Settings.getTimeConcentration());



    }
}
