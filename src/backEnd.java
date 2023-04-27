import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class backEnd extends GUI{



                        //Creates/Resets hashmap with no mines(Boolean false)
    public static void mineReset(){

        HashMap<Integer, Boolean> gridValues = new HashMap<>();

        int i = 0;
        while (i < 5) {

            int j = 0;
            while (j < 5) {

                int a = j+(i*10);

                    gridValues.put(a, false);
                j++;
            }
            i++;
        }
        GUI.currentMap = gridValues;
        mineGenerator();
    }



    public static void mineGenerator(){

        int numOfMines = randomNum(0,10);

        while(numOfMines>0) {
            int row = randomNum(0, 4);
            int column = 10*randomNum(0, 4);

            GUI.currentMap.replace(row+column, true);
            numOfMines--;
        }


    }

    public static int randomNum (int min, int max){      //Random number generator
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return random;
    }

}
