public class Cell {

    int livingNeighbours;
    boolean alive;


    public void update(){

        if (livingNeighbours == 2 || livingNeighbours == 3){
            alive = true;
        }else if (livingNeighbours < 1 || livingNeighbours > 4){
            alive = false;
        }

    }

    public int getLivingNeighbours(){
        return livingNeighbours;
    }

    public void setLivingNeighbours(){
        this.livingNeighbours = livingNeighbours;
    }

    public void setAlive(){
        this.alive = alive;
    }
    
}
