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
  
  
private Rectangle2D button1 = new Rectangle(600,400,300,100); //player1 -> MENU
private Rectangle2D button2 = new Rectangle(600,500,300,100); //player2 -> MENU
private Rectangle2D button3 = new Rectangle(600, 600, 300, 100); //credits -> MENU
private Rectangle2D button4 = new Rectangle (50, 50, 300, 100);
private Rectangle2D button5 = new Rectangle (50, 450, 300, 100);

private AudioClip clip,menuClip,hover;
private TankTrouble game;


   public MouseHandler (TankTrouble tanktrouble)
   {
     
     clip = Applet.newAudioClip(TankTrouble.class.getResource("laser.wav"));
     menuClip = Applet.newAudioClip(TankTrouble.class.getResource("menuMusic.wav"));
    
     menuClip.play();
     game = tanktrouble; 
     
    
   }

  
  public void mouseClicked(MouseEvent event){
    
    if (game.state ==  TankTrouble.STATE.MENU){ 
      
      if(button2.contains(event.getPoint()))
      {
        menuClip.stop();
        clip.play();
        
        //System.out.println("hey");
        game.setGame();
      }
      if(button1.contains(event.getPoint()))
      {
        System.exit(0);
      }
      
      if(button3.contains(event.getPoint()))
      {
        
        //  System.exit(0);
        menuClip.stop();
        
        game.setCredits();
      }
    }
    
     if (game.state ==  TankTrouble.STATE.CREDITS){ 
      
      if(button4.contains(event.getPoint()))
      {
         game.setMenu();
      }
    }
 
   }
   
   public void mouseEntered(MouseEvent arg0) {} 
    public void mouseExited(MouseEvent arg0) {} 
   public void mousePressed(MouseEvent arg0) {} 
   public void mouseReleased(MouseEvent arg0) {}
   
   
   public void mouseDragged(MouseEvent arg0) {} 
   
   public void mouseMoved(MouseEvent event) {
     
     if (game.state ==  TankTrouble.STATE.MENU){
     
     if(button2.contains(event.getPoint()))
     {
          game.menu.changePlayer2(true);
          
     }
     if(!button2.contains(event.getPoint()))
     {
          game.menu.changePlayer2(false);
     }
     if(button1.contains(event.getPoint()))
     {
         game.menu.changePlayer1(true);
     }
     if(!button1.contains(event.getPoint()))
     {
          game.menu.changePlayer1(false);
     }
     
     if(button3.contains(event.getPoint()))
     {
         game.menu.gotoCredits(true);
     }
     if(!button3.contains(event.getPoint()))
     {
          game.menu.gotoCredits(false);
     }
     
     } 
     
     else if (game.state == TankTrouble.STATE.CREDITS){
       if (button4.contains(event.getPoint()))
       {
         game.credits.gotoMenu (true);
       }
       if (!button4.contains(event.getPoint()))
       {
         game.credits.gotoMenu (false);
       }
     }
   }
   
}