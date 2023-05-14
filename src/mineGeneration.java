import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class mineGeneration extends GUI{

                                    //Creates/Resets hashmap with no mines(all Boolean values set to false)
    public static void mineReset(){

        HashMap<Integer, cell> gridValues = new HashMap<>();

        int i = 0;
        while (i < buttons.length) {

            int j = 0;
            while (j < buttons[1].length) {

                int a = i+(j*10);
                cell created = new cell();
                created.setBtn(buttons[i][j].getBtn());
                created.setRow(i);
                created.setCol(j);
                created.setMine(false);
                created.setFlagged(false);
                created.getBtn().setEnabled(true);
                created.getBtn().setText(" ");
                gridValues.put(a, created);
                j++;
            }
            i++;
        }
        currentMap = gridValues;
        mineGenerator();
        mineCounter.countMines(buttons);
        btnReset.setText("☺");
    }

    //Used random numbers for both deciding num of mines and placement of mines
    public static void mineGenerator(){

        int numOfMines = 2;//randomNum(2,2);

        while(numOfMines>0) {       //Values to decide mines placement
            int row = randomNum(0, 4);
            int column = 10*randomNum(0, 4);

            currentMap.get(row+column).setMine(true);                     //Setting mines
            buttons[row][column/10].getBtn().setText(" ");         //Setting text of mines to see where mines are
            numOfMines--;

        }


    }

    public static int randomNum (int min, int max){      //Random number generator
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

}
