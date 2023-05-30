import java.util.ArrayList;
import java.util.HashMap;

public class mineCounter {

    public static void countMines(HashMap map){


        for (int i = 0; i < GUI.gridRows; i++) {
            for (int j = 0; j < GUI.gridCols; j++) {
                ArrayList<cell> neighbors = isNeighbour.isNeighbourOf(i,j, map); //find neighbours of button
                int numOfMines = 0;                 //Start count for mines
                for (cell thisCell: neighbors) {     //iterate through buttons
                    if(GUI.currentMap.get(thisCell.getCellCoordinates()).isMine()){  //if this neighbour is a mine add to total count
                        numOfMines++;
                    }
                }
                GUI.currentMap.get(GUI.posOfCell(i,j)).setAdjacentMines(numOfMines); //set the number of mines for the button
            }
        }

    }

}
