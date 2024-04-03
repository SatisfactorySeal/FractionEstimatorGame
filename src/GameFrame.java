/**
 * GameFrame
 * Last Modified: April 2, 2024
 * 
 * The GameFrame class. Sets up the frame attributes and instantiates the GamePanel.
 */

import javax.swing.JFrame;

public class GameFrame extends JFrame {
  public GameFrame() {
    this.add(new GamePanel());
    this.setTitle("Fraction Estimator");
    this.setResizable(false);
    this.pack();
    this.setVisible(true);
    this.setLocationRelativeTo(null);
  }
}
