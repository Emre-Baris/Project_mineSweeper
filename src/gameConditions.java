
public class gameConditions extends GUI {


    public static int minesLeft;
    public static int startingMines;

    public static int revealed;

    public static void gameOver() {
        lblWin.setText("Game Over!");
        btnReset.setText("☹");
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {

                if (currentMap.get(i+(j*10)).isMine()){
                    currentMap.get(posOfCell(i,j)).getBtn().setText("\uD83D\uDCA5");
                }
                currentMap.get(posOfCell(i,j)).getBtn().setEnabled(false);
            }
        }
    }


    public static void gameWon() {
        revealed = 0;
        int totalCells = currentMap.size();

        for (cell newCell: currentMap.values()) {
            if(!newCell.getBtn().getText().equals("")){
                revealed++;
            }
        }

        if (minesLeft == 0 && totalCells == revealed) {
            btnReset.setText("☺");
            lblWin.setText("You Win!");
        }
    }

}
