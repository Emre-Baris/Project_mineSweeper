import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class GUI extends JFrame {

    static JLabel lblMineCountText = new JLabel("Mine Count", SwingConstants.CENTER);
    static JLabel lblMineCount = new JLabel(String.valueOf(gameConditions.flags), SwingConstants.CENTER);
    static JLabel lblTimerText = new JLabel("Time", SwingConstants.CENTER);
    static JLabel lblTimer = new JLabel(String.valueOf(gameConditions.timeControl), SwingConstants.CENTER);
    static JLabel lblMine = new JLabel("Mine Status", SwingConstants.CENTER);
    static JButton btnReset = new JButton("☺");
    static JButton btnReplay = new JButton("▶");
    public static cell[][] buttons = new cell[5][5];
    static HashMap<Integer, cell> currentMap = new HashMap<>();




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
        panelGrid.setLayout(new GridLayout(5,5));

                                //Generated buttons
        int i = 0;              //Adds cells to 2D Array for later usage
        while (i < 5) {
            int j = 0;
            while (j < 5) {

                JButton button = new JButton();
                cell newCell = new cell();

                newCell.setBtn(button);         //Sets the values for the newly created cell
                newCell.setRow(i);
                newCell.setCol(j);
                buttons[i][j] = newCell;

                panelGrid.add(button);

                j++;
            }
            i++;
        }
        return panelGrid;
    }

    public static void main(String[] args) {

        GUI frame = new GUI();

        JPanel panelUpper = new JPanel(new GridLayout(1,5));
        panelUpper.add(lblMineCountText);
        panelUpper.add(lblMineCount);
        panelUpper.add(btnReset);
        panelUpper.add(lblTimerText);
        panelUpper.add(lblTimer);

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
        buttonAction.addListener(buttons);
        btnReset.addActionListener(e -> {
            mineGeneration.mineReset();
            System.out.println("Game reset!");

        });
    }
}