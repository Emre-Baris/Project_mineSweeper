public class gameConditions extends GUI {

    public static int width = 5;
    public static int height = 5;
    public static int gridsize = width*height;
    public static int startingmines = 5;
    public static int timecontrol = 60;
    public static int minesleft = 5;
    public static int flags = startingmines;
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

        if (minesleft == 0 && revealed == gridsize-startingmines) {
            lblMine.setText("You Win!");
            btnReset.setText("☺");

        }
    }
}
