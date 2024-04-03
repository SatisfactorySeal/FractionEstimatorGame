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
