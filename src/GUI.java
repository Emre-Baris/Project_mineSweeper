import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GUI extends JFrame {

    static JLabel lblMineCountText = new JLabel("Mine Count", SwingConstants.CENTER);
    static JLabel lblMineCount = new JLabel();
    static JLabel lblBlnk = new JLabel("");
    static JLabel lblBlnk2 = new JLabel("");
    static JLabel lblMine = new JLabel("Mine Status", SwingConstants.CENTER);
    static JButton btnReset = new JButton("☺");
    static JButton btnReplay = new JButton("▶");
    static HashMap<Integer, cell> currentMap = new HashMap<>();

    public static int gridRows =5;

    public static int gridCols= 5;



    public GUI (){                      //Constructor for frame
        setTitle("MineSweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());
        setAlwaysOnTop(true);
    }

    public static JPanel panelGrid(){

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(gridRows,gridCols));

                                //Generated buttons
        int i = 0;              //Adds cells to 2D Array for later usage
        while (i < gridRows) {
            int j = 0;
            while (j < gridCols) {

                JButton button = new JButton();
                cell newCell = new cell();

                newCell.setBtn(button);         //Sets the values for the newly created cell
                newCell.setRow(i);
                newCell.setCol(j);
                currentMap.put(posOfCell(i,j), newCell);

                panelGrid.add(button);

                j++;
            }
            i++;
        }
        return panelGrid;
    }

    public static void main(String[] args) {


        lblMineCount.setHorizontalAlignment(SwingConstants.CENTER);

        GUI frame = new GUI();

        JPanel panelUpper = new JPanel(new GridLayout(1,5));
        panelUpper.add(lblMineCountText);
        panelUpper.add(lblMineCount);
        panelUpper.add(btnReset);
        panelUpper.add(lblBlnk);
        panelUpper.add(lblBlnk2);

        frame.add(panelUpper, BorderLayout.NORTH);
        frame.add(panelGrid(), BorderLayout.CENTER);

        frame.add(lblMine, BorderLayout.SOUTH);
        frame.add(btnReplay, BorderLayout.SOUTH);



        btnReplay.addActionListener(e -> {
            try {
                gameMove.replayGame();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        });

        mineGeneration.mineReset();
        buttonAction.addListener();
        btnReset.addActionListener(e -> {
            gameConditions.revealed = 0;
            buttonAction.moveList.clear();
            mineGeneration.mineReset();
            System.out.println("Game reset!");

        });
    }

    public static int posOfCell(int row, int col){
        return row+(col*10);
    }
}