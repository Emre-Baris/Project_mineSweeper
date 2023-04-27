import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
public class backEnd extends GUI{



    public static HashMap<Integer, Boolean> hashMine = mineReset();
    public static int totalMines;

                                                 //Creates temp hashmap with all values false used for reset
    public static HashMap<Integer, Boolean> mineReset(){

                                                //Reset mines count
        totalMines = 0;

        HashMap<Integer, Boolean> gridValues = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                int a = j+(i*10);

                                                //Generates random number between 0 and 10, if num is equal to 5 sets a mine

                int rand = ThreadLocalRandom.current().nextInt(0, 10);

                if(rand == 5){
                    totalMines++;
                    gridValues.put(a, true);
                    System.out.println(a);
                }
                else
                    gridValues.put(a, false);

            }
        }

        return gridValues;
    }







}
