import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class mineGeneration extends GUI{

                                    //Creates/Resets hashmap with no mines(all Boolean values set to false)
    public static void mineReset(){

        HashMap<Integer, cell> gridValues = new HashMap<>();

        int i = 0;
        while (i < gridRows) {

            int j = 0;
            while (j < gridCols) {

                int a = i+(j*10);
                cell created = new cell();
                created.setBtn(currentMap.get(posOfCell(i,j)).getBtn());
                created.setRow(i);
                created.setCol(j);
                created.setMine(false);
                created.setFlagged(false);
                created.getBtn().setEnabled(true);
                created.getBtn().setText("");
                gridValues.put(a, created);
                j++;
            }
            i++;
        }

        btnReset.setText("☺"); //

        currentMap = gridValues; //set the old map to the newly generated one
        mineGenerator(); //execute the generation of mines
        mineCounter.countMines(currentMap); //count the mines after the grid is created for later use
    }

    //Used random numbers for both deciding num of mines and placement of mines
    public static void mineGenerator(){

        int floor = (int) Math.sqrt(gridRows * gridCols);

        int lowerLimit = (int) (floor*1.5);

        int upperLimit = (int) (floor*2);

        int numOfMines = randomNum(lowerLimit, upperLimit); //Random number of mines between 80% and 120% of the square root of the grid size

        gameConditions.minesLeft = numOfMines;
        gameConditions.startingMines = numOfMines;

        GUI.lblMineCount.setText(String.valueOf(numOfMines));


        while(numOfMines>0) {       //Values to decide mines placement
            int row = randomNum(0, gridRows-1);
            int column = randomNum(0, gridCols-1);
            int pos = posOfCell(row, column);

            if(!currentMap.get(pos).isMine()) {     //If the current cell is not a mine then
                currentMap.get(pos).setMine(true);     //Set the current cell to a mine
                numOfMines--;
            }
        }

    }

    public static int randomNum (int min, int max){      //Random number generator
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
