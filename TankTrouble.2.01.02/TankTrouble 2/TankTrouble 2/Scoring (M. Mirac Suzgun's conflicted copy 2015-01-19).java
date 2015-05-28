import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;

public class Scoring{
   private TankTrouble game;
   private int score1;
   private int score2;
  public Scoring(TankTrouble tk)
  {
    game = tk;
  }
  
  public void renderScoring(Graphics g)
  {
    g.drawImage(game.player1.icon,game.map.originX+game.map.w+100,100,null);
    g.drawString(Integer.toString(score1),game.map.originX+game.map.w+150,125);
    g.drawImage(game.player2.icon,game.map.originX+game.map.w+100,200,null);
    g.drawString(Integer.toString(score2),game.map.originX+game.map.w+150,225);
  }
  
  public void increaseScore(int a)
  {
    if(a==1)
      score1++;
    if(a==2)
      score2++;
  }
}