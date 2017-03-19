package main;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.lang.String;

public class Labels {
    private GridPane gridPane = new GridPane();
    private Cards cards = new Cards();
    public GridPane getGridPane() {
        return gridPane;
    }

    public void addLabels(String labelname, int columnIndex, int rowIndex) {
        Label label = new Label();
        ColumnConstraints column = new ColumnConstraints();
        column.setMinWidth(98.4);
        gridPane.getColumnConstraints().add(column);
        GridPane.setColumnIndex(label, columnIndex);
        GridPane.setRowIndex(label, rowIndex);

        label.setId(labelname + columnIndex);
        if(gridPane.getRowIndex(label) == 3) {
            label.setText(cards.hearts[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("red"));
        }else if(gridPane.getRowIndex(label) == 4) {
            label.setText(cards.diamonds[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("blue"));
        }else if(gridPane.getRowIndex(label) == 5) {
            label.setText(cards.spades[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("black"));
        }else if(gridPane.getRowIndex(label) == 6) {
            label.setText(cards.clubs[gridPane.getColumnIndex(label)]);
            label.setTextFill(Color.web("green"));
        }
        label.setFont(new Font("Arial", 100));
        gridPane.getChildren().add(label);


    }

    public void addLabels2(String labelname, int columnIndex, int rowIndex) {
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


}
