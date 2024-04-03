/**
 * GamePanel
 * Last Modified: April 2, 2024
 * 
 * The GamePanel class. Represents a JPanel and contains the game logic.
 */

import java.awt.Dimension;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
  private static final int PANEL_WIDTH = 1024;
  private static final int PANEL_HEIGHT = 768;
  private static final int GAME_ROUNDS = 25;
  private int currentRound;

  {
    this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    currentRound = 1;
  }

  public void startGame() {
    while (currentRound <= GAME_ROUNDS) {
      createNewFractionRow();
      currentRound++;
    }
  }

  public void createNewFractionRow() {

  }
}
