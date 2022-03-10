package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class TextLabel extends JLabel {

    private static final String title = "Tic-Tac-Toe";

    private static final int LABEL_WIDTH = 100;
    private static final int LABEL_HEIGHT = 100;

    private static final int TEXT_SIZE = 30;

    private static final Color color = new Color(0, 170, 0);
    private static final Font font = new Font("DialogInput", Font.BOLD, TEXT_SIZE);

    public TextLabel() {
        this.setText(title);
        this.setForeground(color);
        this.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        this.setFont(font);
        this.setHorizontalAlignment(SwingConstants.CENTER);
    }
}