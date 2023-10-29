import javax.swing.JFrame;

import javax.swing.SwingUtilities;

public class Main extends JFrame{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                // Player playerRed = new Player("bell");
                // Player playerBlue = new Player("LunLun");
                // new Board(playerRed, playerBlue);
                new Menu();
            }            
        });
    }
}
