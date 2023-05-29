import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class gameConditions extends GUI {

    public static int width = 1;
    public static int height = 1;
    public static int totalCells = width * height;
    public static int startingMines = 5;
    public static int timeControl = 60;
    public static int minesLeft = 5;
    public static int flags = startingMines;
    public static int revealed = 0;

    public static void gameOver() {
        lblMine.setText("Game Over!");
        btnReset.setText("☹");
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[0].length; j++) {

                if (currentMap.get(i+(j*10)).isMine()){
                    buttons[i][j].getBtn().setText("\uD83D\uDCA5");
                }
//                else {
//                    buttons[i][j].getBtn().setText(String.valueOf(currentMap.get(i+(j*10)).getAdjacentMines()));
//                }
                buttons[i][j].getBtn().setEnabled(false);
            }
        }
    }

    static class toastWin extends JFrame{
        static JLabel lblWin = new JLabel("You Win!", SwingConstants.CENTER);
        public toastWin(){
            setTitle("You Win!");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(false);
            setAlwaysOnTop(true);
        }
    }

    public static void gameWon() {

        if (minesLeft == 0 && revealed == totalCells - startingMines) {
            btnReset.setText("☺");
            toastWin tst = new toastWin();
            tst.setLayout(new BorderLayout());
            tst.add(toastWin.lblWin, BorderLayout.CENTER);
            System.out.println("You Win!");
        }
    }

}
