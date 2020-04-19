import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int livingNeighbours;
    private List neighborList;

    private boolean alive;

    public Cell(){
        livingNeighbours = -1;
        List neighborList = new ArrayList();
    }



    public void update(){


        //A dead cell with exactly three live neighbours becomes a live cell (birth)
        if (!alive && (livingNeighbours == 3)) {
            alive = true;
        }
        //A live cell with two or three live neighbours stays alive (survival)
        if ((alive && (livingNeighbours == 2)) || (alive && (livingNeighbours == 3))){
            alive = true;
        }

        //A cell dies if live neighbours is less than 2 (loneliness) or more than 3 (overcrowded)
        if ((livingNeighbours < 2 || livingNeighbours > 3)){
            alive = false;
        }

    }



    public int getLivingNeighbours(){
        return livingNeighbours;
    }

    public void setLivingNeighbours(int livingNeighbours){
        this.livingNeighbours = livingNeighbours;
    }

    public boolean isAlive(){
        return alive;
    }

    public void setAlive(boolean alive){
        this.alive = alive;
    }

}
