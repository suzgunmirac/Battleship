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
import javax.imageio.*;
import java.awt.geom.*;
import java.util.LinkedList;
import javax.imageio.*;
import java.awt.geom.*;
import java.util.LinkedList;


public class Credits 
{  
  public int originX;
  public int originY;
  
 private BufferedImage background;
 private BufferedImage menubutton;
// private BufferedImage creditsbutton;
 private boolean conditionMenu=false;


  public TankTrouble game;
  
  public Credits(int x, int y,TankTrouble tanktrouble) throws ArrayIndexOutOfBoundsException  
  {
    originX = x;
    originY = y;
    
    try {
    background = ImageIO.read(new File("CreditsPage.png"));
    menubutton = ImageIO.read(new File("menu.png"));
    
     } catch (IOException e) {
       System.out.println("ERROR: Icon Not Found");
     }  
     
   game = tanktrouble;
   
   }
  
  public void gotoMenu(boolean condition)
  {
   if(condition)
   {
     conditionMenu=true;
   }
   else
   {
    conditionMenu=false;
   }
 }  

  public void renderCredits(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(background,0,0,null);
    
    g2.setColor (Color.WHITE);
    

    
    if (conditionMenu){
      try {
        
        menubutton = ImageIO.read(new File("menu.png"));
        
      } catch (IOException e) {
        System.out.println("icon1 not found");
      }
    }
    //CREDITS
    
  //  g2.setColor (Color.BLACK);
    
  //  Font font = new Font("Serif", Font.PLAIN, 40);
  //  g2.setFont(font);
    g2.drawImage(menubutton,50,450,null);
    g2.drawImage(background,0,0,null);
   // g2.drawString("Tank Trouble v2.01", 50, 150);

   // g2.drawImage(creditsbutton, 600, 600, null);
    
    
  }
  
}