import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.awt.geom.*;


public class Bullet{
 private double x;
 private double y;
 private double velocityX;
 private double velocityY;
 private double velocity;
 private double rotation;
 private BufferedImage icon;
 private TankTrouble game;
 public Tank tank;
 public Rectangle2D previousWall;
 public long timer;
 public Bullet(double xCoordinate, double yCoordinate, int type, TankTrouble tanktrouble,Tank tankNew)
 {
   tank = tankNew;
   game = tanktrouble;
   velocity = -4;
   rotation = tank.getRotation();
   timer = System.currentTimeMillis();
   if(type==0)
   {
     x = xCoordinate-5-(32*Math.sin(Math.toRadians(rotation)));
     y = yCoordinate-5+(32*Math.cos(Math.toRadians(rotation)));
     
    try {
    icon = ImageIO.read(new File("defaultBullet.png"));
     } catch (IOException e) {
       System.out.println("icon not found");
     }
   }
  
 }
 
 public void updateBullet(){
   velocityX = (velocity) * Math.sin(Math.toRadians(rotation));
   velocityY = -(velocity) * Math.cos(Math.toRadians(rotation));
   x+=velocityX;
   y+=velocityY;
   
 }
 
 public void renderBullet(Graphics g)
 {
   Graphics2D g2 = (Graphics2D) g;
   AffineTransform t = new AffineTransform();
   t.translate(x, y);
   t.scale(1, 1); 
   g2.drawImage(icon, t, null); 
 }
  
 
 public double getY()
  {
    return y;
  }
  public double getX()
  {
    return x;
  }
  
  public Ellipse2D.Double getShape()
  {
    Ellipse2D.Double shape = new Ellipse2D.Double(x,y,5,5);
    return shape;
  }
  public void setRotation(double a)
  {
    rotation = a;
  }
  public double getRotation()
  {
    return rotation;
  }
  public void setVelocity(double a)
  {
    velocity = a;
  }
  public double getVelocity()
  {
    return velocity;
  }
}