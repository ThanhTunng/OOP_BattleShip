package battleship.controller;

import battleship.Main;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable, EventHandler<ActionEvent> {

    @FXML
    private Button btnResume;

    @FXML
    private Button btnNewGame;

    @FXML
    private Button btnHighScore;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnMusic;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnQuit.setOnAction(this);
        btnNewGame.setOnAction(this);
        btnResume.setOnAction(this);
        btnHighScore.setOnAction(this);
        btnMusic.setOnAction(this);
    }


    private static boolean exitCheck(Stage stage) {
        Alert alert =
                new Alert(Alert.AlertType.CONFIRMATION, "Are you sure to quit?", ButtonType.NO, ButtonType.YES);
        alert.setHeaderText("");
        alert.setTitle("Warning?");
        alert.initOwner(stage);
        Optional<ButtonType> type = alert.showAndWait();
        return type.isPresent() && type.get() == ButtonType.YES;
    }

    public static boolean close(Stage stage) {
        if (exitCheck(stage)) {
            Platform.exit();
            return true;
        }
        return false;
    }

    public void setVisibleResume(boolean visible) {
        this.btnResume.setVisible(visible);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Object source = actionEvent.getSource();
        Node s = (Node) source;
        Stage stage = (Stage) s.getScene().getWindow();
        if (btnResume.equals(source)) {
            if (Main.gameScene != null)
                stage.setScene(Main.gameScene);
        } else if (btnNewGame.equals(source)) {
//            Main.gameScene = new Scene(new Main().createContent());
            if (Main.gameScene != null)
                stage.setScene(Main.gameScene);
        } else if (btnHighScore.equals(source)) {
            if (Main.historyScene != null){
                Stage newStage = new Stage();
                newStage.setTitle("High Score");
                newStage.setScene(Main.historyScene);
                newStage.show();
            }
        } else if (btnMusic.equals(source)) {
            if (Main.bgMediaPlayer.isMute()) {
                btnMusic.setText("Music Off");
                Main.bgMediaPlayer.setMute(false);
            } else {
                btnMusic.setText("Music On");
                Main.bgMediaPlayer.setMute(true);
            }
        } else if (btnQuit.equals(source)) {
            close(stage);
        }
    }
}
