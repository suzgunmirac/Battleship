import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.geom.*;
import java.util.LinkedList;

public class Map{
  
  public int w = 700; // width
  public int h = 700; // height
  public int originX;
  public int originY;
  public int wallWidth=10;
  public int randomNumber;
  public TankTrouble game;
  public LinkedList<Rectangle2D.Double> walls = new LinkedList<Rectangle2D.Double>();
  public LinkedList<Integer> wallType = new LinkedList<Integer>();
  private BufferedImage background;
  
  public Map(int x, int y,TankTrouble tanktrouble) throws ArrayIndexOutOfBoundsException
  {
    originX = x;
    originY = y;
    try {
    background = ImageIO.read(new File("gamebackground.png"));
     } catch (IOException e) {
       System.out.println("icon not found");
     }
   game = tanktrouble;
   
  // walls.add(new Rectangle2D.Double(originX,originY,wallWidth,h));
  // walls.add(new Rectangle2D.Double(originX + w-wallWidth ,originY,wallWidth,h));
  // walls.add(new Rectangle2D.Double(originX,originY,w,wallWidth));
  // walls.add(new Rectangle2D.Double(originX,originY + h-wallWidth,w,wallWidth));
   
    
   
   for(int i=0;i<8;i++)
   {
     for(int j=0;j<8;j++)
     {
       if(i==0 || i==7 || j==0 || j==7)
       {
        if(i!=7)
        {
       walls.add(new Rectangle2D.Double(originX + j*100, originY+i*100, wallWidth,110));
       wallType.add(1);
        }
       if(j!=7)
       {
       walls.add(new Rectangle2D.Double(originX + j*100, originY +i*100, 110,wallWidth));
       wallType.add(0);
       }
      
       continue;
       }
       
       randomNumber = (int) (Math.random()*3 +1);
       if(randomNumber==1)
       {
       if(i!=7)
       {
       walls.add(new Rectangle2D.Double(originX + j*100, originY+i*100, wallWidth,110));
       wallType.add(1);
       }
       if(j!=7)
       {
       walls.add(new Rectangle2D.Double(originX + j*100, originY +i*100, 110,wallWidth));
       wallType.add(0);
       }
       }
     }
   }
   
  }
  public void renderMap(Graphics g)
  {
    Graphics2D g2 = (Graphics2D) g;
    g2.drawImage(background,0,0,null);
    
    g2.setColor (Color.BLACK);
    
    for(int i = 0; i<walls.size();i++)
    {
      g2.fill(walls.get(i));
    }
  }
}