
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
import javafx.util.Duration;

public class Board extends Application {

    private Cell[][] matrix;
    private Game world;
    private String image;
    private GridPane pane;
    private Label label;

    @Override
    public void start(Stage primaryStage){

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        Game world = Game.intialize();
        matrix = world.getMyArray();
        updateScene(matrix, pane);



        for (int y = 0; y < Game.getSizeY() ; y++) {
            for (int x = 0; x < Game.getSizeX() ; x++) {

                if (matrix[x][y].isAlive()){
                    image = "image/bTile.JPG";
                }else {
                    image = "image/wTile.JPG";
                }
                pane.add(new ImageView(new Image(image)), y, x);

            }

        }
        Button btn = new Button();
        btn.setText("Start");
        btn.setOnAction((ActionEvent event) -> {
            // Setting up a timer
            Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> evolve(world, pane)));
            timeline.setCycleCount(100);
            timeline.play();

        });

        // Displaying an iteration counter
        label = new Label("0");
        label.setLayoutX(200);
        pane.getChildren().add(label);
        pane.getChildren().add(btn);

        Scene scene = new Scene(pane, 900,900);
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void evolve(Game world, GridPane pane) {
        matrix = world.getMyArray();
        world.update();
        updateScene(matrix, pane);
    }

    private void updateScene(Cell[][] matrix, GridPane pane) {
        pane.getChildren().removeAll();

        for (int y = 0; y < Game.SIZE_Y; y++) {
            for (int x = 0; x < Game.SIZE_X; x++) {

                if (matrix[x][y].isAlive()){
                    image = "image/bTile.JPG";
                }else {
                    image = "image/wTile.JPG";
                }
                pane.add(new ImageView(new Image(image)), y, x);

            }

        }
    }




}
