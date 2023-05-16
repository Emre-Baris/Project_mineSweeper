public class checkZeroNeighbors{

    public static void revealZero(cell thisCell) {



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
//                    if(GUI.currentMap.get(neighbor.getCellCoordinates()).isFlagged()){
//                        neighbor.setFlagged(false);
//                        gameConditions.flags++;
//                        GUI.lblMineCount.setText(String.valueOf(gameConditions.flags));
//                    }
                    neighbor.getBtn().setText(String.valueOf(GUI.currentMap.get(neighbor.getCellCoordinates()).getAdjacentMines()));
                }
                    revealZero(neighbor);
            }
        }
    }

}
