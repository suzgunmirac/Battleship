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
 private BufferedImage button1;
 private BufferedImage button2;
 private BufferedImage creditsbutton;
 private boolean condition1=false;
 private boolean condition2=false;
 private boolean condition3=false; //condition for credits
 
 public Menu(){
    try {
    background = ImageIO.read(new File("background.png"));
    button1 = ImageIO.read(new File("1player.png"));
    button2 = ImageIO.read(new File("2players.png"));
    creditsbutton = ImageIO.read (new File ("creditsbutton.png"));
    
     } catch (IOException e) {
       System.out.println("ERROR: Icon Not Found");
     }  
   
 }
 
 public void changePlayer2(boolean condition)
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
 
  public void changePlayer1(boolean condition)
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
  
   public void gotoCredits(boolean condition)
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
   
   try {
       creditsbutton = ImageIO.read (new File ("creditsbutton.png"));
   } catch (IOException e) {
       System.out.println("iconC not found");
     }
   
   
   if(condition2)
   {
   try {
     button2 = ImageIO.read(new File("2playersTank.png"));

     } catch (IOException e) {
       System.out.println("icon2 not found");
     }
   }
   else{
     try {
       button2 = ImageIO.read(new File("2players.png"));
    
     } catch (IOException e) {
       System.out.println("icon2 not found");
     }
   }
   
   
   if(condition1)
   {
      try {
    
    button1 = ImageIO.read(new File("1playerTank.png"));
    
     } catch (IOException e) {
       System.out.println("icon1 not found");
     }
   }
   else
   {
     try {
    
    button1 = ImageIO.read(new File("1player.png"));
    
     } catch (IOException e) {
       System.out.println("icon1 not found");
     }
   }
   
   
   
    g.drawImage(background,0,0,null);
    g.drawImage(button1,600,400,null);
    g.drawImage(button2,600,500,null);
    g.drawImage(creditsbutton, 600, 600, null);
  }
  
}