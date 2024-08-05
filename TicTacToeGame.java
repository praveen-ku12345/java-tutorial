import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TicTacToeGame extends JPanel {
    private JButton[] buttons = new JButton[9];
    private boolean xTurn = true;

    public TicTacToeGame() {
        setLayout(new GridLayout(3, 3));
        initializeButtons();
    }

    private void initializeButtons() {
        for (int i = 0; i < 9; i++) {
            JButton button = new JButton();
            button.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 100));
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JButton btn = (JButton) e.getSource();
                    if (btn.getText().equals("")) {
                        btn.setText(xTurn ? "X" : "O");
                        xTurn = !xTurn;
                        checkForWinner();
                    }
                }
            });
            buttons[i] = button;
            add(button);
        }
    }

    private void checkForWinner() {
        // Check for a winner horizontally, vertically, and diagonally
        for (int i = 0; i < 3; i++) {
            // Horizontal lines
            if (!buttons[i * 3].getText().equals("") && 
                buttons[i * 3].getText().equals(buttons[i * 3 + 1].getText()) &&
                buttons[i * 3].getText().equals(buttons[i * 3 + 2].getText())) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[i * 3].getText() + " wins!");
                resetButtons();
            }
            // Vertical lines
            if (!buttons[i].getText().equals("") && 
                buttons[i].getText().equals(buttons[i + 3].getText()) &&
                buttons[i].getText().equals(buttons[i + 6].getText())) {
                JOptionPane.showMessageDialog(this, "Player " + buttons[i].getText() + " wins!");
                resetButtons();
            }
        }
        // Diagonal checks
        if (!buttons[0].getText().equals("") && 
            buttons[0].getText().equals(buttons[4].getText()) &&
            buttons[0].getText().equals(buttons[8].getText()) ||
            !buttons[2].getText().equals("") && 
            buttons[2].getText().equals(buttons[4].getText()) &&
            buttons[2].getText().equals(buttons[6].getText())) {
            JOptionPane.showMessageDialog(this, "Player " + buttons[0].getText() + " wins!");
            resetButtons();
        }
    }

    private void resetButtons() {
        for (JButton button : buttons) {
            button.setText("");
        }
        xTurn = true;  // Reset turn
    }
}
