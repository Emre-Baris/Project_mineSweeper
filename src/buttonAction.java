import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class buttonAction extends GUI{

    public static LinkedList<moveList.gameMove> moveList = new LinkedList<>();



    public static void addListener(cell[][] grid){

        for (int i = 0; i < grid.length; i++) {       //Loop to iterate through the grid rows
            for (int j = 0; j < grid[i].length; j++) {  //Secondary loop for iterating columns, here grid[i] gives number of columns

                final int finalI = i;
                final int finalJ = j;
                int pos = i+(j*10);

                JButton button = currentMap.get(pos).getBtn(); //Get the button from the grid

                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {

                        if (button.isEnabled()){
                            //Define the action for left click
                            if (SwingUtilities.isLeftMouseButton(e)) {
                               // lblMine.setText("Mine Status: " + currentMap.get(grid[finalI][finalJ].getCellCoordinates()).isMine());
                                if (!currentMap.get(pos).isFlagged()) {

                                    if (currentMap.get(pos).isMine()) {
                                        lblMine.setText("Game Over");
                                        gameOver();
                                        button.setText("\uD83D\uDCA5"); //Set text of button to mine
                                    }
                                    else
                                        checkZeroNeighbors.revealZero(currentMap.get(pos));
                                        //button.setText(String.valueOf(currentMap.get(pos).getAdjacentMines())); //Set text of button to number of mines
                                }
                            }

                                                                            //Define the action for right click
                            else if (SwingUtilities.isRightMouseButton(e)) {
                                if (currentMap.get(pos).isFlagged()) {
                                    currentMap.get(pos).setFlagged(false);
                                    button.setText("");
                                } else {
                                    currentMap.get(pos).setFlagged(true);
                                    button.setText("\uD83D\uDEA9"); //Set text of button to flag
                                }
                            }

                        }

                    }//End of mouse released
                }); //End of mouse listener

            }//End of inner for loop
        } //End of for loop

    }

    public static void gameOver() {
        lblMine.setText("Game Over!");
        btnReset.setText("☹");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                if (currentMap.get(i+(j*10)).isMine()){
                    buttons[i][j].getBtn().setText("\uD83D\uDCA5");
                }

                else {
                    //buttons[i][j].getBtn().setText(String.valueOf(currentMap.get(i+(j*10)).getAdjacentMines()));
                }
                buttons[i][j].getBtn().setEnabled(false);
            }
        }
    }

}


