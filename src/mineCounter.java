import javax.swing.*;

import java.util.ArrayList;

import static java.util.Arrays.stream;

public class mineCounter {

    public static int countMines(int i,int j,JButton[][] grid){


        ArrayList<JButton> neighbors = isNeighbour.isNeighbourOf(i, j, grid); //find neighbours of button


        int numOfMines = 0;                //Start count for mines
        for (JButton btn: neighbors) {     //iterate through buttons
            int[] index= buttonAction.findBtnPos(btn);  //get index of button
            int target = -1;
            if (stream(index).noneMatch(x -> x == target)){
                int posOf = (index[0] + (index[1]*10));
                if(GUI.currentMap.get(posOf)){  //if this neighbour is a mine add to total count
                    numOfMines++;
                }
            }
        }
        grid[i][j].setText(String.valueOf(numOfMines));
        return numOfMines;

    }

}
