package TicTacToe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JPanel implements ActionListener {

    private static final ImageIcon gameIcon = new ImageIcon("src/main/java/TicTacToe/imgs/TicTacToe.png");

    private static final GameFrame gameFrame = new GameFrame();
    private static final TextLabel textLabel = new TextLabel();
    private static final TextPanel textPanel = new TextPanel();

    private static final JPanel buttonsPanel = new JPanel();
    private static final JButton[] buttons = new JButton[9];
    private static final ResetButton resetButton = new ResetButton();

    private static boolean xTurn = true;
    private static boolean gameEnded = false;

    private static final String TEXT_RESET = "Tic-Tac-Toe";
    private static String currentPLayer = "";

    public TicTacToe() {
        gameFrame.setIconImage(gameIcon.getImage());

        textPanel.add(textLabel);
        textPanel.add(resetButton);

        buttonsPanel.setLayout(new GridLayout(3, 3));
        buttonsPanel.setBackground(new Color(255, 255, 255));

        addButtons();

        gameFrame.add(textPanel, BorderLayout.NORTH);
        gameFrame.add(buttonsPanel);
    }

    private void addButtons() {
        for (int current = 0; current < buttons.length; current++) {
            buttons[current] = new JButton();
            buttonsPanel.add(buttons[current]);
            buttons[current].setBackground(Color.WHITE);
            buttons[current].setFont(new Font("", Font.BOLD, 100));
            buttons[current].setFocusable(false);
            buttons[current].addActionListener(this);
        }

        resetButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (JButton button : buttons) {

            if (button.getText().equals("")) {
                if (e.getSource() == button) {

                    if (xTurn) {
                        button.setForeground(new Color(180, 0, 0));
                        button.setText("X");
                        xTurn = false;
                        textLabel.setText("O turn");

                    } else {
                        button.setForeground(new Color(0, 120, 0));
                        button.setText("O");
                        xTurn = true;
                        textLabel.setText("X turn");
                    }
                }
            }
        }

        if (e.getSource() == resetButton) {
            resetGame();
        }

        checkForWinner();

        if (!gameEnded) {
            checkForDraw();
        }
    }

    private void checkForWinner() {
        currentPLayer = xTurn ? "O" : "X";

        checkRowsForWin();
        checkColsForWin();
        checkDiagonalsForWin();
    }

    private void checkRowsForWin() {
        if (buttons[0].getText().equals(currentPLayer) &&
                buttons[1].getText().equals(currentPLayer) &&
                buttons[2].getText().equals(currentPLayer)) {
            playerWins(0, 1, 2);
        }

        if (buttons[3].getText().equals(currentPLayer) &&
                buttons[4].getText().equals(currentPLayer) &&
                buttons[5].getText().equals(currentPLayer)) {
            playerWins(3, 4, 5);
        }

        if (buttons[6].getText().equals(currentPLayer) &&
                buttons[7].getText().equals(currentPLayer) &&
                buttons[8].getText().equals(currentPLayer)) {
            playerWins(6, 7, 8);
        }
    }

    private void checkColsForWin() {
        if (buttons[0].getText().equals(currentPLayer) &&
                buttons[3].getText().equals(currentPLayer) &&
                buttons[6].getText().equals(currentPLayer)) {
            playerWins(0, 3, 6);
        }

        if (buttons[1].getText().equals(currentPLayer) &&
                buttons[4].getText().equals(currentPLayer) &&
                buttons[7].getText().equals(currentPLayer)) {
            playerWins(1, 4, 7);
        }

        if (buttons[2].getText().equals(currentPLayer) &&
                buttons[5].getText().equals(currentPLayer) &&
                buttons[8].getText().equals(currentPLayer)) {
            playerWins(2, 5, 8);
        }
    }

    private void checkDiagonalsForWin() {
        //primary diagonal - "\"
        if (buttons[0].getText().equals(currentPLayer) &&
                buttons[4].getText().equals(currentPLayer) &&
                buttons[8].getText().equals(currentPLayer)) {
            playerWins(0, 4, 8);
        }

        //secondary diagonal - "/"
        if (buttons[2].getText().equals(currentPLayer) &&
                buttons[4].getText().equals(currentPLayer) &&
                buttons[6].getText().equals(currentPLayer)) {
            playerWins(2, 4, 6);
        }
    }

    private void checkForDraw() {
        boolean drawGame = false;

        for (JButton button : buttons) {
            if (button.getText().equals("")) {
                drawGame = false;
                break;
            } else {
                drawGame = true;
            }
        }

        if (drawGame) {
            textLabel.setText("DRAW");
            disableButtons();
        }
    }

    public static void playerWins(int first, int second, int third) {
        buttons[first].setBackground(Color.GREEN);
        buttons[second].setBackground(Color.GREEN);
        buttons[third].setBackground(Color.GREEN);

        gameEnded = true;
        disableButtons();

        textLabel.setText(String.format("%s wins", currentPLayer));
    }

    private static void disableButtons() {
        for (JButton button : buttons) {
            button.setEnabled(false);
        }
    }

    private void resetGame() {
        enableButtons();

        xTurn = true;
        gameEnded = false;
        textLabel.setText(TEXT_RESET);
    }

    private void enableButtons() {
        for (JButton button : buttons) {
            if (!button.getText().equals("")) {
                button.setBackground(Color.WHITE);
                button.setText("");
            }
            button.setEnabled(true);
        }
    }
}