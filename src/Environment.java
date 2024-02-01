import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Environment {
    Cell[][] grid;
    List<Ant> ants;

    Random random;

    Environment(int x, int y, int numAnts){
        this.grid = new Cell[x][y];
        this.ants = new ArrayList<>();
        InitializeGrid(x,y);
    }


    public void InitializeGrid(int x, int y){
        random = new Random();
        for(int i=0; i< x; i++){
            for(int j=0; j<y; j++){
                int rand = random.nextInt(10);
                //Can adjust these numbers later if I want
                //20% cell has something, 40% cell is empty
                if(rand < 2) {
                    grid[i][j] = new Cell(CellType.FOOD);
                } else if (rand < 4){
                    grid[i][j] = new Cell(CellType.WATER);
                } else if (rand < 6){
                    grid[i][j] = new Cell(CellType.POISON);
                } else {
                    grid[i][j] = new Cell(CellType.EMPTY);
                }
            }
        }
        //place home at the center
        //maybe change this to a 2x2 or something bigger later
        int homeX = x / 2;
        int homeY = y / 2;
        grid[homeX][homeY] = new Cell(CellType.HOME);
    }

    public void intializeAnts(int numAnts){
        random = new Random();
        for(int i=0; i<numAnts;i++){
            int randX = random.nextInt(this.grid.length);
            int randY = random.nextInt(this.grid[0].length);
        }
    }


}
