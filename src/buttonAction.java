import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class buttonAction {

    public static void addListener(cell[][] grid){

        for (int i = 0; i < grid.length; i++) {       //Loop to iterate through the grid rows
            for (int j = 0; j < grid[i].length; j++) {  //Secondary loop for iterating columns, here grid[i] gives number of columns

                int pos = i+(j*10);

                JButton button = grid[i][j].getBtn();

                button.addMouseListener(new MouseAdapter() {

                    public void mousePressed(MouseEvent e) {

                        cell thisCell = GUI.currentMap.get(pos);

                        if (button.isEnabled()){
                                                                        //Define the action for left click
                            if (SwingUtilities.isLeftMouseButton(e)) {
                                GUI.lblMine.setText("Mine Status: " + GUI.currentMap.get(thisCell.getCellCoordinates()).isMine());
                                if (!thisCell.isFlagged()) {

                                    if (thisCell.isMine()) {
                                        GUI.lblMine.setText("Game Over");
                                        GUI.gameOver();
                                    }

                                    mineCounter.countMines(thisCell.getCol(), thisCell.getRow(), grid);
                                }
                            }

                                                                            //Define the action for right click
                            else if (SwingUtilities.isRightMouseButton(e)) {
                                if (thisCell.isFlagged()) {
                                    thisCell.setFlagged(false);
                                    button.setText("");
                                } else {
                                    thisCell.setFlagged(true);
                                    button.setText("\uD83D\uDEA9"); //Set text of button to flag
                                }
                            }

                        GUI.currentMap.replace(thisCell.getCellCoordinates(), thisCell);
                        }

                    }//End of mouse released
                }); //End of mouse listener

            }//End of inner for loop
        } //End of for loop

    }
}


