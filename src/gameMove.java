import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

public class gameMove {
        private int clickedRow;
        private int clickedCol;
        private boolean clickedLeftClick;



        public gameMove(int row, int col,boolean click) {
            this.clickedRow = row;
            this.clickedCol = col;
            this.clickedLeftClick = click;
        }

    public static void replayGame() throws InterruptedException {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 ; j++) {
                //JButton btn = ;
                GUI.currentMap.get(i+(j*10)).getBtn().setEnabled(true);
                GUI.currentMap.get(i+(j*10)).getBtn().setText("");
            }
        }
        for (gameMove move : buttonAction.moveList) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            replayClick(move);
        }

        }

        public static void replayClick(gameMove move){


                int row = move.getClickedRow();
                int col = move.getClickedCol();
                boolean isLeftClick = move.isClickedLeftClick();

                JButton btn = GUI.buttons[row][col].getBtn();
                buttonAction.clickAction(row, col, isLeftClick,btn);
                if(isLeftClick){
                    checkZeroNeighbors.revealZero(GUI.currentMap.get(row+(col*10)));
                }

                // Delay for a brief period to allow time for the actions to be processed
            }


        // Add any additional getters or setters as needed


        public boolean isClickedLeftClick() {
            return clickedLeftClick;
        }

        public void setClickedLeftClick(boolean clickedLeftClick) {
            this.clickedLeftClick = clickedLeftClick;
        }

        public int getClickedRow() {
            return clickedRow;
        }

        public void setClickedRow(int clickedRow) {
            this.clickedRow = clickedRow;
        }

        public int getClickedCol() {
            return clickedCol;
        }

        public void setClickedCol(int clickedCol) {
            this.clickedCol = clickedCol;
        }
}