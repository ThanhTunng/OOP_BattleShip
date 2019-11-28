package battleship;

import battleship.model.History;
import battleship.utils.CSV;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

import static battleship.controller.MainScreenController.close;

public class Main extends Application {

    public static Scene menuScene;
    public static Scene gameScene;
    public static Scene historyScene;
    public static MediaPlayer bgMediaPlayer;
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        initScene();
        setBackgroundSong();

        primaryStage.setTitle("Battleship Game");
        primaryStage.setScene(menuScene);
        primaryStage.setOnCloseRequest(event -> {
            if (!close(stage)) {
                event.consume();
            }
        });
        primaryStage.show();

        System.out.println(History.getHistories());
    }

    private void setBackgroundSong(){
        URL songPath = getClass().getResource("sounds/fortunate_son_various_artists.mp3");
        Media sound = new Media(songPath.toString());
        bgMediaPlayer = new MediaPlayer(sound);
        bgMediaPlayer.play();
    }

    private void initScene() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/main_screen.fxml"));
        root.setId("pane");
        menuScene = new Scene(root, 1024, 600);
        menuScene.getStylesheets().addAll(getClass().getResource("styles/first_scene_style.css").toExternalForm());
//        gameScene = new Scene(createContent(), 1024, 600);
        root = FXMLLoader.load(getClass().getResource("view/history_screen.fxml"));
        historyScene = new Scene(root);
    }

    public static void main(String[] args) {
        launch(args);
    }
}





