package battleship.controller;

import battleship.model.History;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HistoryScreenController implements  Initializable {
    @FXML
    private GridPane body;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<History> histories = History.getHistories();
        for (int i = 0; i < histories.size(); i++) {
            body.getChildren().add(renderHostoryItem(i, histories.get(i)));
        }
    }

    public SplitPane renderHostoryItem(int rowIndex, History historyModel) {
        SplitPane history = new SplitPane();
        history.setDividerPositions(0.5);
        history.setPrefHeight(120);
        history.setPrefWidth(500);

        AnchorPane left = new AnchorPane();
        left.setPrefHeight(160);
        left.setPrefWidth(355);


        Label title = new Label();
        title.setPrefHeight(35);
        title.setPrefWidth(148);
        title.setText("Player: " + historyModel.getPlayerName());
        title.setLayoutX(61.0);
        title.setLayoutY(27.0);
        title.setAlignment(Pos.CENTER);
        title.setFont(Font.font("System Bold Italic", 16.0));

        Label result = new Label();
        result.setPrefHeight(35);
        result.setPrefWidth(70);
        result.setText(historyModel.getWin() ?  "WIN" : "LOSE");
        result.setLayoutX(112.0);
        result.setLayoutY(62.0);
        result.setAlignment(Pos.CENTER);
        result.setTextFill(Paint.valueOf("#e41111"));
        result.setFont(Font.font("System Bold Italic", 20.0));

        left.getChildren().addAll(title, result);

        AnchorPane right = new AnchorPane();

        Label ratio = new Label();
        ratio.setAlignment(Pos.CENTER);
        ratio.setPrefHeight(35);
        ratio.setPrefWidth(148);
        ratio.setLayoutX(63);
        ratio.setLayoutY(40);
        ratio.setText(historyModel.getRatio());
        ratio.setTextFill(Paint.valueOf("#b0b94e"));
        ratio.setFont(Font.font("System Bold Italic", 33));

        right.getChildren().addAll(ratio);

        history.getItems().addAll(right, left);

        GridPane.setRowIndex(history, rowIndex);
        GridPane.setValignment(history, VPos.CENTER);
        return history;
    }
}
