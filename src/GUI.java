import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class GUI extends JFrame {

    static JLabel lblMineCount = new JLabel("Time", SwingConstants.CENTER);
    static JLabel lblTimer = new JLabel("Time", SwingConstants.CENTER);
    static JLabel lblMine = new JLabel("Mine Status", SwingConstants.CENTER);
    static JButton btnReset = new JButton("☺");
    static JButton[][] buttons = new JButton[5][5];
    static HashMap<Integer, Boolean> currentMap = new HashMap<>();


    public GUI (){                      //Constructor for frame
        setTitle("MineSweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());
    }

    public static JPanel panelGrid(){

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(5,5));

                                //Generated buttons
        int i = 0;              //Adds buttons to 2D Array for later usage
        while (i < 5) {
            int j = 0;
            while (j < 5) {

                int num = i + (j*10);
                JButton button = new JButton(""+num);
                panelGrid.add(button);
                buttons[i][j] = button;

                j++;
            }
            i++;
        }
        return panelGrid;
    }

    public static void main(String[] args) {

        GUI frame = new GUI();

        JPanel panelUpper = new JPanel(new GridLayout(1,3));
        panelUpper.add(lblMineCount);
        panelUpper.add(btnReset);
        panelUpper.add(lblTimer);

        frame.add(panelGrid(), BorderLayout.CENTER);
        frame.add(panelUpper, BorderLayout.NORTH);
        frame.add(lblMine, BorderLayout.SOUTH);

        mineGeneration.mineReset();
        buttonAction.addListener(buttons);
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mineGeneration.mineReset();
                System.out.println("Game reset!");

            }
        });
    }

}