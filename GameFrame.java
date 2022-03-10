package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private static final String TITLE = "Tic-Tac-Toe";

    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 500;

    public GameFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        this.setTitle(TITLE);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
