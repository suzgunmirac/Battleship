import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.RenderingHints;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.Rectangle2D;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;

public class Play
{
  private BufferedImage map1;
  private BufferedImage map2;
  private Game game;
  public Play(Game game)
  {
    this.game = game;
    try{
      map1 = ImageIO.read(new File("./images/map.png"));
      map2 = ImageIO.read(new File("./images/map.png"));
    }
    catch (IOException e) {
       System.out.println("ERROR: Icon Not Found");
     } 
  }
    
    
  
    
  
  public void renderPlay(Graphics g)
  {
   // g.setBackground(Color.BLACK);
    g.setColor(Color.GRAY);
    Graphics2D g2 = (Graphics2D) g;
    g2.fill(new Rectangle(0,0,game.getWidth(),game.getHeight()));
    g.drawImage(map1,50,50,null);
    g.drawImage(map2,600,50,null);
  }
}