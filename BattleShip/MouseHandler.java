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
import java.io.*;
import sun.audio.*;


public class MouseHandler implements MouseListener, MouseMotionListener  {
  
  private Rectangle2D playButton = new Rectangle(900,100,250,120); //player1 -> MENU // player1 = PLAY
  private Rectangle2D settingsButton = new Rectangle(900,250,250,120); //player2 -> MENU // player2 = EXIT
  private Rectangle2D exitButton = new Rectangle(900, 400, 250, 120); //credits -> MENU

  
  
  private AudioClip clip,menuClip,hover;
  private Game game; 

  /**Constructor**/
  //It gets the game itself as its parameter
  
   public MouseHandler (Game game)
   {
    this.game = game;
 
   }

  
  public void mouseClicked(MouseEvent event){
    
    if (game.state ==  Game.STATE.MENU){
  
      
      if(playButton.contains(event.getPoint()))
      {
        game.setPlay();
      }
      
      
      if(settingsButton.contains(event.getPoint()))
      {
        
        System.exit(0);
     
      }
      
      
      if(exitButton.contains(event.getPoint()))
      {
        System.exit(0);
      }
    }
    
    
    }
   
   public void mouseEntered(MouseEvent arg0) {} 
   public void mouseExited(MouseEvent arg0) {} 
   public void mousePressed(MouseEvent arg0) {} 
   public void mouseReleased(MouseEvent arg0) {}
   
   public void mouseDragged(MouseEvent arg0) {} 
   
   public void mouseMoved(MouseEvent event) {
     if (game.state ==  Game.STATE.MENU){
     
     if(playButton.contains(event.getPoint()))
     {
          game.menu.changePlay(true);
          
     }
     if(!playButton.contains(event.getPoint()))
     {
          game.menu.changePlay(false);
     }
     
     
     
     if(settingsButton.contains(event.getPoint()))
     {
         game.menu.changeSettings(true);
     }
     if(!settingsButton.contains(event.getPoint()))
     {
          game.menu.changeSettings(false);
     }
     
     
     if(exitButton.contains(event.getPoint()))
     {
         game.menu.changeExit(true);
     }
     if(!exitButton.contains(event.getPoint()))
     {
          game.menu.changeExit(false);
     }
     
     } 
   }
   
}