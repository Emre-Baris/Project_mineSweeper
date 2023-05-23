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
        for (gameMove move : buttonAction.moveList) {
            int row = move.getClickedRow();
            int col = move.getClickedCol();

            GUI.buttons[row][col].getBtn().doClick(1);

            TimeUnit.SECONDS.sleep(2);
            // Simulate the button click based on the row and column indices
            // Perform the necessary actions for the replay
        }
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