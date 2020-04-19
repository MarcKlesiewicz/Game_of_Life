
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
public class Board extends Application {

    private Cell[][] matrix;
    private Game world;
    private String image;

    @Override
    public void start(Stage primaryStage){

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);

        matrix = world.getMyArray();

        for (int y = 0; y < Game.getSizeY() ; y++) {
            for (int x = 0; x < Game.getSizeY() ; x++) {

                if (matrix[x][y].isAlive()){
                    image = "image/bTile.JPG";
                }else {
                    image = "image/wTile.JPG";
                }
                pane.add(new ImageView(new Image(image)), y, x);

            }

        }

        Scene scene = new Scene(pane, 600,600);
        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
