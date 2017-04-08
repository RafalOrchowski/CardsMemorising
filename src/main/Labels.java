package main;

import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.lang.String;
import java.util.Arrays;
import java.util.Collections;

public class Labels {
    private GridPane gridPane = new GridPane();
    private Cards cards = new Cards();
    private Pane Pane2 = new Pane();



    public GridPane getGridPane() {
        return gridPane;
    }
    public Pane getPane() {
        return Pane2;
    }
    public void addLabels(String labelname, int columnIndex, int rowIndex) {
        Label label = new Label();
        ColumnConstraints column = new ColumnConstraints();
        column.setMinWidth(98.4);
        gridPane.getColumnConstraints().add(column);
        GridPane.setColumnIndex(label, columnIndex);
        GridPane.setRowIndex(label, rowIndex);


        label.setId(labelname + columnIndex);

        if (gridPane.getRowIndex(label) == 3 && Settings.getHearts()) {         //checking if the color is selected; If not, doesn't set text;
            label.setText(cards.hearts[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("red"));
        }
        if (gridPane.getRowIndex(label) == 4 && Settings.getDiamonds()) {
            label.setText(cards.diamonds[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("blue"));
        }
        if (gridPane.getRowIndex(label) == 5 && Settings.getSpades()) {
            label.setText(cards.spades[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("black"));
        }
        if (gridPane.getRowIndex(label) == 6 && Settings.getClubs()) {
            label.setText(cards.clubs[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("green"));
        }
        label.setFont(new Font("Arial", 100));
        gridPane.getChildren().add(label);


    }


    public void addLabels2(String labelname, int columnIndex, int rowIndex) {
        Collections.shuffle(Arrays.asList(cards.spades));   // shuffling cards
        Collections.shuffle(Arrays.asList(cards.hearts));
        Collections.shuffle(Arrays.asList(cards.clubs));
        Collections.shuffle(Arrays.asList(cards.diamonds));


        Label label = new Label();
        ColumnConstraints column = new ColumnConstraints();
        column.setMinWidth(98.4);
        gridPane.getColumnConstraints().add(column);
        GridPane.setColumnIndex(label, columnIndex);
        GridPane.setRowIndex(label, rowIndex);
        label.setText("");
        label.setFont(new Font("Arial", 75));
        gridPane.getChildren().add(label);

    }
    public void addLabels3(int time){

        Focus.getLabel().setText(String.valueOf(time));
        Focus.getLabel().setFont(new Font("Arial", 100));
    }


}
