import javax.swing.*;

public class buttonAction {

    public static void addListener(JButton[][] grid){


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                final int finalI = i;                // declare i as final variable for use in action
                final int finalJ = j;               // declare j as final variable

                int pos = finalI+(finalJ*10);

                grid[i][j].addActionListener(e -> {

                    GUI.lblMine.setText("Mine Status: " + GUI.currentMap.get(pos)); //Set value of lbl at bottom to true or false depending on if there is a mine

                    mineCounter.countMines(finalI,finalJ,grid);

                });

            }
        }

    }
                //Method to find the position of a button and return as coordinates
    public static int[] findBtnPos(JButton btn){

        int[] indices = {-1,-1};
        JButton[][] arr= GUI.buttons;

        int i = 0;          //Loop looking through array for buttons
        while(i < arr.length){
        int j = 0;
            while (j< arr[0].length){
                if (arr[i][j] == btn) { //Check if the button is the one searched for
                    indices[0] = i;
                    indices[1] = j;
                    return indices;     //Return the index of said button
                }
                else j++;
            }
            i++;
        }
        return indices;
    }
}

