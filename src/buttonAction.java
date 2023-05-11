import javax.swing.*;

public class buttonAction {

    public static void addListener(cell[][] grid){

        for (int i = 0; i < grid.length; i++) {       //Loop to iterate through the grid rows
            for (int j = 0; j < grid[i].length; j++) {  //Secondary loop for iterating columns, here grid[i] gives number of columns

                final int finalI = i;                // declare i as final variable for use in action
                final int finalJ = j;               // declare j as final variable

                int pos = finalI+(finalJ*10);

                grid[i][j].getBtn().addActionListener(e -> {

                                                //Set value of lbl at bottom to true or false depending on if there is a mine
                    GUI.lblMine.setText("Mine Status: " + GUI.currentMap.get(pos).isMine());

                    mineCounter.countMines(finalI,finalJ,grid);

                });

            }
        } //End of for loop
    }

}


