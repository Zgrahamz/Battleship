import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BattleShipGenerator extends JFrame implements ActionListener {
    JPanel mainPanel, boardPanel, statsPanel, controlPanel;
    JButton playAgainButton, quitButton;

    int totalHits = 0;
    int totalMisses = 0;
    int currentHits = 0;
    int strikes = 0;
    int currentShips = 5;

    JLabel totalHitsLabel = new JLabel("Total Hits: " + totalHits);
    JLabel totalMissesLabel = new JLabel("Total Misses: " + totalMisses);
    JLabel currentHitsLabel = new JLabel("Current Hits: " + currentHits);
    JLabel strikesLabel = new JLabel("Strikes: " + strikes);
    JLabel currentShipsLabel = new JLabel("Current Ships: " + currentShips);

    JButton[][] board = new JButton[10][10];
    BoardMaker boardMaker = new BoardMaker();

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    public BattleShipGenerator() {
        mainPanel = new JPanel();
        setTitle("Battleship");
        setSize(1000,1000);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(mainPanel, BorderLayout.CENTER);

        createBoardPanel();
        createStatsPanel();
        createControlPanel();

        setVisible(true);
    }

    public void createBoardPanel() {
       boardPanel = new JPanel();
       boardPanel.setLayout(new GridLayout(10,10));
       boardMaker.boardSetup(board);

       for (int i = 0; i < 10; i++) {
           for (int j = 0; j < 10; j++) {
               boardPanel.add(board[i][j]);
           }
       }

       mainPanel.add(boardPanel, BorderLayout.NORTH);
    }

    public void createStatsPanel() {
        statsPanel = new JPanel();
        GridLayout statsPanelLayout = new GridLayout(1,5);
        statsPanelLayout.setHgap(50);
        statsPanel.setLayout(statsPanelLayout);
        totalHitsLabel.setFont(new java.awt.Font("Times New Roman", 1, 25));
        totalMissesLabel.setFont(new java.awt.Font("Times New Roman", 1, 25));
        currentHitsLabel.setFont(new java.awt.Font("Times New Roman", 1, 25));
        strikesLabel.setFont(new java.awt.Font("Times New Roman", 1, 25));
        currentShipsLabel.setFont(new java.awt.Font("Times New Roman", 1, 25));
        statsPanel.add(totalHitsLabel);
        statsPanel.add(totalMissesLabel);
        statsPanel.add(currentHitsLabel);
        statsPanel.add(strikesLabel);
        statsPanel.add(currentShipsLabel);
        mainPanel.add(statsPanel, BorderLayout.CENTER);
    }

    public void createControlPanel() {
        controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1,2));

        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(this);
        controlPanel.add(playAgainButton);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(this);
        controlPanel.add(quitButton);

        mainPanel.add(controlPanel, BorderLayout.SOUTH);
    }
}
