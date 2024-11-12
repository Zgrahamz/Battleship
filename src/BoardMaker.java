import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class BoardMaker implements ActionListener {
    private JButton[][] board = new JButton[10][10];
    Icon waterIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource("water1.jpg")));

    public void boardMaker(JButton[][] board) {
        board = this.board;
    }

    public JButton[][] boardSetup(JButton[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = new JButton(waterIcon);
                board[i][j].setPreferredSize(new Dimension(100, 100));
                board[i][j].addActionListener(this);
            }
        }
        return board;
    }

    public JButton[][] clearBoard(JButton[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j].setIcon(waterIcon);
            }
        }
        return board;
    }

    public JButton[][] getBoard() {
        return board;
    }

    public void setBoard(JButton[][] board) {
        this.board = board;
    }

    @Override
    public void actionPerformed(ActionEvent e) {}
}