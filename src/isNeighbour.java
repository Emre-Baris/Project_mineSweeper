import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class isNeighbour {

    public static ArrayList<JButton> isNeighbourOf(int row, int column, JButton[][] buttons){
        ArrayList<JButton> neighbours = new ArrayList<>();

        if(row != 0 && column !=0)

                for (int i = 0; i < 3; i++) {
                    int newColumn = column + 1;
                    neighbours.add(buttons[row - 1][newColumn--]);
                }

        return neighbours;
    }

}
