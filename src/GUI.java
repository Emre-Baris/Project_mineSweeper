import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    static JLabel lblMineCount = new JLabel("Mines");
    static JLabel lblTimer = new JLabel("time");
    static JButton btnReset = new JButton("☺");


    public static JPanel panelGrid(){

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(5,5));

                                             //Temp buttons for the grid
                                             //Note make function to generate buttons based on user input

        JButton grid11 = new JButton("11");
        JButton grid12 = new JButton("12");
        JButton grid13 = new JButton("13");
        JButton grid14 = new JButton("14");
        JButton grid15 = new JButton("15");
        JButton grid21 = new JButton("21");
        JButton grid22 = new JButton();
        JButton grid23 = new JButton();
        JButton grid24 = new JButton();
        JButton grid25 = new JButton();
        JButton grid31 = new JButton("31");
        JButton grid32 = new JButton();
        JButton grid33 = new JButton();
        JButton grid34 = new JButton();
        JButton grid35 = new JButton();
        JButton grid41 = new JButton("41");
        JButton grid42 = new JButton();
        JButton grid43 = new JButton();
        JButton grid44 = new JButton();
        JButton grid45 = new JButton();
        JButton grid51 = new JButton("51");
        JButton grid52 = new JButton();
        JButton grid53 = new JButton();
        JButton grid54 = new JButton();
        JButton grid55 = new JButton();

        panelGrid.add(grid11);
        panelGrid.add(grid12);
        panelGrid.add(grid13);
        panelGrid.add(grid14);
        panelGrid.add(grid15);
        panelGrid.add(grid21);
        panelGrid.add(grid22);
        panelGrid.add(grid23);
        panelGrid.add(grid24);
        panelGrid.add(grid25);
        panelGrid.add(grid31);
        panelGrid.add(grid32);
        panelGrid.add(grid33);
        panelGrid.add(grid34);
        panelGrid.add(grid35);
        panelGrid.add(grid41);
        panelGrid.add(grid42);
        panelGrid.add(grid43);
        panelGrid.add(grid44);
        panelGrid.add(grid45);
        panelGrid.add(grid51);
        panelGrid.add(grid52);
        panelGrid.add(grid53);
        panelGrid.add(grid54);
        panelGrid.add(grid55);

        return panelGrid;

    }


    public GUI (){
                                    //Constructor for frame
        setTitle("MineSweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
        setLayout(new BorderLayout());

    }


    public static void main(String[] args) {
        GUI frame = new GUI();

        JPanel panelUpper = new JPanel(new FlowLayout());
        panelUpper.add(lblMineCount);
        panelUpper.add(btnReset);
        panelUpper.add(lblTimer);


        frame.add(panelGrid(), BorderLayout.CENTER);
        frame.add(panelUpper, BorderLayout.NORTH);
        frame.pack();

    }

}