/*
public class checkZeroNeighbors {ArrayList<JButton> zeroNeighbors = isNeighbour.isNeighbourOf(clickedRow, clickedCol, buttons);

for(JButton neighbor : zeroNeighbors) {
        int neighborRow = -1, neighborCol = -1;
        // Find the position of the current neighbor button in the grid
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j] == neighbor) {
                    neighborRow = i;
                    neighborCol = j;
                    break;
                }
            }
            if (neighborRow != -1) {
                break;
            }
        }
        // Check if the current neighbor button has 0 neighbors and reveal them if it does
        if (neighborRow != -1 && neighborCol != -1) {
            checkZeroNeighbors(neighborRow, neighborCol, buttons);
        }
        neighbor.setText(mineCounter.countMines(neighborRow, neighborCol, buttons)); // update the text of the neighbor button to show the number of nearby mines
    }
}
*/