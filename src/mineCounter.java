import java.util.ArrayList;

public class mineCounter {

    public static void countMines(int row,int col,cell[][] grid){


        ArrayList<cell> neighbors = isNeighbour.isNeighbourOf(row, col, grid); //find neighbours of button


        int numOfMines = 0;                 //Start count for mines
        for (cell thisCell: neighbors) {     //iterate through buttons
            if(GUI.currentMap.get(thisCell.getCellCoordinates()).isMine()){  //if this neighbour is a mine add to total count
                numOfMines++;
            }
        }
        GUI.currentMap.get(row+(col*10)).setAdjacentMines(numOfMines); //set the number of mines for the button
        grid[row][col].getBtn().setText(String.valueOf(numOfMines)); //set the text of the button to the number of mines
    }

}
