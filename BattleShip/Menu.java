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

public class Menu{
 private BufferedImage background;
 private BufferedImage playButton;
 private BufferedImage settingsButton;
 private BufferedImage exitButton;
 
 private BufferedImage playButtonPressed;
 private BufferedImage settingsButtonPressed;
 private BufferedImage exitButtonPressed;
 
 private Game game;
 
 private boolean condition1=false;
 private boolean condition2=false;
 private boolean condition3=false;

 
 public Menu(Game game){
   this.game = game;
    try {
    background = ImageIO.read(new File("./images/bg.png"));
    playButton = ImageIO.read(new File("./images/playButton.png")); 
    settingsButton = ImageIO.read(new File("./images/settingsButton.png"));
    exitButton = ImageIO.read (new File ("./images/exitButton.png"));
    playButtonPressed = ImageIO.read(new File("./images/playButtonPressed.png")); 
    settingsButtonPressed = ImageIO.read(new File("./images/settingsButtonPressed.png"));
    exitButtonPressed = ImageIO.read (new File ("./images/exitButtonPressed.png"));
    
     } catch (IOException e) {
       System.out.println("ERROR: Icon Not Found");
     }  
   
 }
 
 public void changePlay(boolean condition)
 {
   if(condition)
   {
     condition1=true;
   }
   else
   {
    condition1=false;
   }
 }
 
  public void changeSettings(boolean condition)
 {
   if(condition)
   {
     condition2=true;
   }
   else
   {
    condition2=false;
   }
 }
  
 public void changeExit(boolean condition)
  {
   if(condition)
   {
     condition3=true;
   }
   else
   {
    condition3=false;
   }
  }
 
  
 
  
  

 public void renderMenu(Graphics g)
  {  
   
    g.drawImage(background,0,0,game.getWidth(),game.getHeight(),null);
    
    
    if(condition1)
    {
    g.drawImage(playButton,900,100,null);
    }
    else
    {
      g.drawImage(playButtonPressed,900,100,null);
    }
    
    if(condition2)
    {
     g.drawImage(settingsButton, 900, 250, null);
    }
    else
    {
      g.drawImage(settingsButtonPressed, 900, 250, null);
    }
    
    
    if(condition3)
    {
    g.drawImage(exitButton, 900, 400, null);
    }
    else
    {
      g.drawImage(exitButtonPressed, 900, 400, null);
    }
  }
  
}