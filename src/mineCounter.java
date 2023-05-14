import java.util.ArrayList;

public class mineCounter {

    public static void countMines(cell[][] grid){


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[1].length; j++) {
                ArrayList<cell> neighbors = isNeighbour.isNeighbourOf(i, j, grid); //find neighbours of button
                int numOfMines = 0;                 //Start count for mines
                for (cell thisCell: neighbors) {     //iterate through buttons
                    if(GUI.currentMap.get(thisCell.getCellCoordinates()).isMine()){  //if this neighbour is a mine add to total count
                        numOfMines++;
                    }
                }
                GUI.currentMap.get(i+(j*10)).setAdjacentMines(numOfMines); //set the number of mines for the button
            }
        }

    }

}
