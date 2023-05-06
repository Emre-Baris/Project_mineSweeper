import javax.swing.*;

import java.util.ArrayList;

import static java.util.Arrays.stream;

public class mineCounter {

    public static void countMines(int row,int col,JButton[][] grid){


        ArrayList<JButton> neighbors = isNeighbour.isNeighbourOf(row, col, grid); //find neighbours of button


        int numOfMines = 0;                 //Start count for mines
        for (JButton btn: neighbors) {     //iterate through buttons
            int[] index= buttonAction.findBtnPos(btn);  //get index of button
            int target = -1;
            if (stream(index).noneMatch(x -> x == target)){
                int posOf = (index[0] + (index[1]*10)); //get position of button
                if(GUI.currentMap.get(posOf).isMine()){  //if this neighbour is a mine add to total count
                    numOfMines++;
                }
            }
        }
        GUI.currentMap.get(row+(col*10)).setAdjacentMines(numOfMines); //set the number of mines for the button
        grid[row][col].setText(String.valueOf(numOfMines)); //set the text of the button to the number of mines
    }

}
