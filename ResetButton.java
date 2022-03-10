package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class ResetButton extends JButton {

    private static final String TEXT = "Reset Game";

    public ResetButton() {
        this.setBounds(500, 20, 50, 10);
        this.setText(TEXT);
        this.setFont(new Font("", Font.BOLD, 20));
        this.setFocusable(false);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
    }
}