import java.util.HashMap;

public class backEnd {

    public static void main(String[] args) {

        //Created temp hashmap with all values false

        HashMap<Integer, Boolean> gridValues = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
               int a = j+(i*10);
               gridValues.put(a, false);
            }
        }


    }


}
