package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {

    private static final int X = 0;
    private static final int Y = 0;

    private static final int PANEL_WIDTH = 300;
    private static final int PANEL_HEIGHT = 500;

    public TextPanel() {
        this.setBounds(X, Y, PANEL_WIDTH, PANEL_HEIGHT);
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(1, 2));
    }
}