import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class mineGeneration extends GUI{



                        //Creates/Resets hashmap with no mines(all Boolean values set to false)
    public static void mineReset(){

        HashMap<Integer, cell> gridValues = new HashMap<>();

        int i = 0;
        while (i < 5) {

            int j = 0;
            while (j < 5) {

                int a = j+(i*10);
                    cell created = new cell();
                    created.setRow(i);
                    created.setCol(j);
                    created.setMine(false);
                    gridValues.put(a, created);
                    GUI.buttons[i][j].getBtn().setText("");

                j++;
            }
            i++;
        }
        GUI.currentMap = gridValues;
        mineGenerator();
    }



    //Used random numbers for both deciding num of mines and placement of mines
    public static void mineGenerator(){

        int numOfMines = randomNum(4,10);

        while(numOfMines>0) {       //Values to decide mines placement
            int row = randomNum(0, 4);
            int column = 10*randomNum(0, 4);

            GUI.currentMap.get(row+column).setMine(true);                     //Setting mines
            GUI.buttons[row][column/10].getBtn().setText("\uD83D\uDCA3");         //Setting text of mines to see where mines are
            numOfMines--;
        }


    }

    public static int randomNum (int min, int max){      //Random number generator
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return random;
    }

}
