import javax.swing.*;
import java.util.ArrayList;

public class cell {

    private JButton btn;
    private int row; // row index of the button
    private int col; // column index of the button
    private boolean isMine; // whether the button has a mine
    private int adjacentMines; // number of adjacent buttons with mines
    private boolean isFlagged; // whether the button is flagged
    private boolean isRevealed; // whether the button is revealed
    private ArrayList<cell> neighbors; // list of adjacent buttons


    public cell(){

    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public int getCellCoordinates() {
        return row + (col*10);
    }

    public JButton getBtn() {
        return btn;
    }
    public void setBtn(JButton btn) {
        this.btn = btn;
    }
    public ArrayList<cell> getNeighbors() { return neighbors; }

    public void setNeighbors(ArrayList<cell> neighbors) {
        this.neighbors = neighbors;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public int getAdjacentMines() {
        return adjacentMines;
    }

    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }

    @Override
    public String toString() {
        return "cell{" +
                "btn=" + btn +
                ", row=" + row +
                ", col=" + col +
                ", isMine=" + isMine +
                ", adjacentMines=" + adjacentMines +
                ", neighbors=" + neighbors +
                '}';
    }
}


