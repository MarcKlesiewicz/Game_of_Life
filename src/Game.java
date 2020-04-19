import java.util.Random;

public class Game {

    private static int SIZE_X = 10, SIZE_Y = 10;

    private Cell[][] myArray = new Cell[SIZE_X][SIZE_Y];

    private Game(){

        for (int y = 0; y < SIZE_Y ; y++) {
            for (int x = 0; x < SIZE_X ; x++) {
                Random random = new Random();
                int num = random.nextInt(2);
                Cell cell = new Cell();
                if (num == 0){
                    cell.setAlive(false);
                }else {
                    cell.setAlive(true);
                }
                myArray[x][y] = cell;

            }

        }
    }

}
