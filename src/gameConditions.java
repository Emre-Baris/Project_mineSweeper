public class gameConditions extends GUI {

    public static int width = 5;
    public static int height = 5;
    public static int gridSize = width*height;
    public static int startingMines = 5;
    public static int timeControl = 60;
    public static int minesLeft = 5;
    public static int flags = startingMines;
    public static int revealed = 0;

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
    public void gameWon() {

        if (minesLeft == 0 && revealed == gridSize - startingMines) {
            lblMine.setText("You Win!");
            btnReset.setText("☺");

        }
    }

    public static void replayGame() {
        for (gameMove move : buttonAction.moveList) {
            int row = move.getClickedRow();
            int col = move.getClickedCol();
            boolean isLeftClick = move.isClickedLeftClick();
            // Simulate the button click based on the row and column indices
            // Perform the necessary actions for the replay

            GUI.buttons[row][col].getBtn().doClick();


        }
    }

}
