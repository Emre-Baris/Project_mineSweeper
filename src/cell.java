import javax.swing.*;
import java.util.ArrayList;

public class cell {

    private int row; // row index of the button
    private int col; // column index of the button
    private boolean isMine; // whether the button has a mine
    private int adjacentMines; // number of adjacent buttons with mines

    private ArrayList<JButton> neighbors; // list of adjacent buttons
    public cell(){

    }

    public ArrayList<JButton> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(ArrayList<JButton> neighbors) {
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
}
