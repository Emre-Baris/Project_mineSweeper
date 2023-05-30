import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class gameConditions extends GUI {


    public static int minesLeft;
    public static int startingMines;

    public static int revealed;

    public static void gameOver() {
        lblMine.setText("Game Over!");
        btnReset.setText("☹");
        for (int i = 0; i < gridRows; i++) {
            for (int j = 0; j < gridCols; j++) {

                if (currentMap.get(i+(j*10)).isMine()){
                    currentMap.get(posOfCell(i,j)).getBtn().setText("\uD83D\uDCA5");
                }
                currentMap.get(posOfCell(i,j)).getBtn().setEnabled(false);
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

    public static void gameWon(cell clickedCell) {
        revealed = 0;
        int totalCells = currentMap.size();

        for (cell newCell: currentMap.values()) {
            if(!newCell.getBtn().getText().equals("")){
                revealed++;
            }
        }

        if (minesLeft == 0 && totalCells == revealed) {
            btnReset.setText("☺");
            toastWin tst = new toastWin();
            tst.setLayout(new BorderLayout());
            tst.add(toastWin.lblWin, BorderLayout.CENTER);
            System.out.println("You Win!");
        }
    }

}
