import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    public static int SIZE_X = 25, SIZE_Y = 25;

    private Cell[][] myArray = new Cell[SIZE_X][SIZE_Y];
    private Game world;

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

    public static Game intialize(){
        Game world = new Game();
        return world;
    }

   public Game update(){

        for (int y = 0; y < SIZE_Y; y++) {
            for (int x = 0; x < SIZE_X; x++) {

                List neighborList = new ArrayList();

                if (y < SIZE_Y - 1 && x > 0){
                    if (myArray[x - 1][y + 1].isAlive()){
                        neighborList.add("SW");
                    }
                }
                if (y < SIZE_Y - 1){
                    if (myArray[x][y + 1].isAlive()){
                        neighborList.add("S");
                    }
                }

                if (x < SIZE_X - 1 && y < SIZE_Y - 1){
                    if (myArray[x + 1][y + 1].isAlive()){
                        neighborList.add("SE");
                    }
                }
                if (x > 0){
                    if (myArray[x - 1][y].isAlive()){
                        neighborList.add("W");
                    }
                }

                if (x < SIZE_X - 1){
                    if (myArray[x + 1][y].isAlive()){
                        neighborList.add("E");
                    }
                }
                if (x > 0 && y > 0){
                    if (myArray[x - 1][y - 1].isAlive()){
                        neighborList.add("NW");
                    }
                }
                if (y > 0){
                    if (myArray[x][y - 1].isAlive()){
                        neighborList.add("N");
                    }
                }
                if (x < SIZE_X - 1 && y > 0){
                    if (myArray[x + 1][y - 1].isAlive()){
                        neighborList.add("NE");
                    }
                }

                myArray[x][y].setLivingNeighbours(neighborList.size());
                myArray[x][y].setNeighborList(neighborList);
            }
        }

       for (int y = 0; y < SIZE_Y; y++) {
           for (int x = 0; x < SIZE_X; x++) {
               String result = myArray[x][y].update();
           }
       }

       return world;
    }



    public static int getSizeX(){
        return SIZE_X;
    }
    public static void setSizeX(int SIZE_X){
        Game.SIZE_X = SIZE_X;
    }
    public static int getSizeY(){
        return SIZE_Y;
    }
    public static  void setSizeY(int SIZE_Y){
        Game.SIZE_Y = SIZE_Y;
    }

    public Cell[][] getMyArray(){
        return myArray;
    }
    public void setMyArray(Cell[][] myArray){
        this.myArray = myArray;
    }

}
