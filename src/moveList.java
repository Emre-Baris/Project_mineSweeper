import java.util.LinkedList;

public class moveList extends buttonAction{




    public static void moveLinkedList(){




    }


    public static class gameMove{
        private int clickedRow;
        private int clickedCol;

        public gameMove(int row, int col) {
            this.clickedRow = row;
            this.clickedCol = col;
        }

        // Add any additional getters or setters as needed


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

}
