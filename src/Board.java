
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.scene.layout.GridPane;
public class Board extends Application {

    @Override
    public void start(Stage primaryStage){

        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        Cell myCell = new Cell();
        String image;
        for (int y = 0; y < Game.getSizeY() ; y++) {
            for (int x = 0; x < Game.getSizeY() ; x++) {

                if (myCell.isAlive() == false){
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
