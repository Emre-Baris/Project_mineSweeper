import java.util.ArrayList;
import java.util.List;

public class checkZeroNeighbors{

    public static void revealZero(cell thisCell) {

        ArrayList<Integer> cellsToBeRevealed = new ArrayList<>();

        int row = thisCell.getRow();
        int col = thisCell.getCol();

        int pos = thisCell.getCellCoordinates();


        GUI.currentMap.get(pos).getBtn().setText(String.valueOf(GUI.currentMap.get(pos).getAdjacentMines()));

        if (GUI.currentMap.get(pos).getAdjacentMines() == 0 && !GUI.currentMap.get(pos).isMine() && !GUI.currentMap.get(pos).isRevealed()) {
            // Mark the current cell as revealed
            GUI.currentMap.get(pos).setRevealed(true);
            thisCell.getBtn().setText("0"); // Clear the text of the button

            for (cell neighbor : GUI.currentMap.get(pos).getNeighbors()) {
                if (!GUI.currentMap.get(neighbor.getCellCoordinates()).isRevealed()) {
                    neighbor.getBtn().setText(String.valueOf(GUI.currentMap.get(neighbor.getCellCoordinates()).getAdjacentMines()));
                    if (!neighbor.isRevealed()){
                        cellsToBeRevealed.add(neighbor.getCellCoordinates());
                    }
                }
                    if(GUI.currentMap.get(pos).isFlagged()){
                        GUI.currentMap.get(pos).setFlagged(false);
                        gameConditions.minesLeft++;
                        GUI.lblMineCount.setText(String.valueOf(gameConditions.minesLeft));
                    }

                    revealZero(neighbor);


            }
        }
        for (int cellCords: cellsToBeRevealed) {
            GUI.currentMap.get(cellCords).setRevealed(true);

        }
    }

}
