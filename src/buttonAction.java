import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class buttonAction extends GUI{

    public static LinkedList<gameMove> moveList = new LinkedList<>();

    public static void addListener(){

        for (int i = 0; i < gridRows; i++) {       //Loop to iterate through the grid rows
            for (int j = 0; j < gridCols; j++) {  //Secondary loop for iterating columns, here grid[i] gives number of columns

                final int finalI = i;
                final int finalJ = j;
                int pos = i+(j*10);

                JButton button = currentMap.get(pos).getBtn(); //Get the button from the grid

                button.addMouseListener(new MouseAdapter() {


                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (button.isEnabled()){
                            moveList.add(clickAction(finalI, finalJ, SwingUtilities.isLeftMouseButton(e),button));

                        }
                                     //gameConditions.gameWon();
                    }//End of mouse released
                }); //End of mouse listener

            }//End of inner for loop
        } //End of for loop

    }

    public static gameMove clickAction(int row, int col, boolean isLeftClick,JButton button){

        int pos = row+(col*10);

        //Define the action for left click
        if (isLeftClick) {
            if (!currentMap.get(pos).isFlagged()) {

                if (currentMap.get(pos).isMine()) {
                    lblWin.setText("Game Over");
                    gameConditions.gameOver();
                    button.setText("\uD83D\uDCA5"); //Set text of button to mine
                }
                else{
                    checkZeroNeighbors.revealZero(currentMap.get(pos));
                }
            }

        }

        //Define the action for right click
        else{
            if (currentMap.get(pos).isFlagged()) {
                currentMap.get(pos).setFlagged(false);
                button.setText("");
                gameConditions.minesLeft++;
                GUI.lblMineCount.setText(String.valueOf(gameConditions.minesLeft));
            } else {
                currentMap.get(pos).setFlagged(true);
                button.setText("\uD83D\uDEA9");         //Set text of button to flag
                gameConditions.minesLeft--;
                GUI.lblMineCount.setText(String.valueOf(gameConditions.minesLeft));
            }


        }
        gameConditions.gameWon();
        return new gameMove(row,col,isLeftClick);
    }

}


