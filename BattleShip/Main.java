import javax.swing.JFrame;
import java.awt.*;
import java.awt.Dimension;
import java.awt.image.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.applet.AudioClip;
import java.applet.Applet;
import java.util.Random;
//runnable interface contains run () method  -> (interface kullaniminda gerekli)
public class Main extends Canvas implements Runnable {
  
  public static final int WIDTH = 1300; // screen width
  public static final int HEIGHT = 768; // screen height
  public final String TITLE = "BattleShip";
  
 


  
  public static void main(String[] args)
  {
    Game game = new Game();
        
    game.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    
    game.setMaximumSize(new Dimension(WIDTH,HEIGHT));
    
    game.setMinimumSize(new Dimension(WIDTH,HEIGHT)); 
    
    JFrame frame = new JFrame(game.TITLE);
    
    frame.add(game);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    
    game.start();
  }
  
  
}