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
public class TankTrouble extends Canvas implements Runnable {
  
  public static final int WIDTH = 1300; // screen width
  public static final int HEIGHT = 768; // screen height
  public final String TITLE = "TankTrouble v2.0";
  public static final int VEL = 3;
 
  public Tank player1;
  public Tank player2;
  public AllBullets b;
  private final double ROTDEG = 3;
  private boolean isRunning = false;  //whether or not the program is running 
  public Thread thread; // For more info about threads: http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
 
  public Menu menu;
  public Map map;
  public Physics physics;
  public Scoring scoring;
  private BufferedImage image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_RGB);
 
  
  /**Enumerator to understand whether or not the game has started **/
  private enum STATE{
    MENU,
    GAME 
  };
  
  private STATE state = STATE.MENU; // state = MENU 
  
  
  private void initializeGame(){
    
    requestFocus(); // for more info: https://answers.yahoo.com/question/index?qid=20100201110043AAdu0ic
    
    /*Listeners*/
    addKeyListener(new KeyboardHandler(this)); 
    addMouseListener(new MouseHandler(this));
    addMouseMotionListener(new MouseHandler(this));
    
    menu = new Menu();
    // Menu'ye eklemeler yapilacak! (TO DO)
    map = new Map(0,0,this);
    // Map'e width and height gonderilecek ! (TO DO)
    physics = new Physics(this);
    scoring = new Scoring(this);
    
    player1 = new Tank("Tank 1: Cengiz", "blue",0,this);
    player2 = new Tank("Tank 2: Agalar", "red",0,this);
       
    
    b = new AllBullets(this);
    
  }

  
  private synchronized void start()
  {
    if(isRunning)
      return;
    isRunning =  true;
    thread = new Thread(this);
    thread.start();
  }
  
  private synchronized void stop()
  {
    long lastTime = System.nanoTime();
    if(!isRunning)
      return;
    
    isRunning = false;
    try {
    thread.join();
    }
    catch (InterruptedException e){
      e.printStackTrace();
    }
      
      System.exit(1);
  }
  
  public void run()
  {
    initializeGame();
    long lastTime = System.nanoTime();
    final double amountPerSecond = 60.0;
    double n = 1000000000 / amountPerSecond;
    double interval = 0;
    int updates = 0;
    int frames = 0;
    long timer = System.currentTimeMillis();
    
    while(isRunning)
    {
      long timeNow = System.nanoTime();
      interval += (timeNow - lastTime) / n;
      lastTime=timeNow;
      if(interval>=1)
      {
      //System.out.println("Working");
      updateGame();
      updates++;
      interval--;
      }
      renderGame();
      frames++;
      
      if(System.currentTimeMillis() - timer > 1000)
      {
        timer+=1000;
       System.out.println(updates + " ticks, fps " + frames);
        updates = 0;
        frames = 0;
      }
    }
    
  }
  
  private void updateGame()
  {
    if(state == STATE.GAME)
    {
    player1.updateTank();
    player2.updateTank();
    b.updateAllBullets();
   
     //System.out.println(b.bullets.size());
   // System.out.println(player1.getRotation() + " rot");
    }
    else if(state == STATE.MENU)
    {
      ;
    }
  }
  
  private void renderGame()
  {
   
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null)
    {
      createBufferStrategy(3);
      return;
    }
    Graphics g = bs.getDrawGraphics();
    
    ////////////////////
     if(state == STATE.GAME)
    {
    g.drawImage(image,0,0,getWidth(),getHeight(),this);
    map.renderMap(g);
    player1.renderTank(g);
    player2.renderTank(g);
    b.renderAllBullets(g);
    scoring.renderScoring(g);
     }
     else if(state == STATE.MENU)
     {
      menu.renderMenu(g);
     }
    ///////////////////
    g.dispose();
    bs.show();
   
  }
  
  
  
  public void keyPressed(KeyEvent event)
  {
    if(state == STATE.GAME)
    {
    int pressed = event.getKeyCode();
    
    if(pressed == KeyEvent.VK_RIGHT)
    {
     player1.addRotationDegree(ROTDEG);
    //  player1.setVelocityX(VEL);
    }
    else if (pressed == KeyEvent.VK_LEFT)
    {
      player1.addRotationDegree(-ROTDEG);
     // player1.setVelocityX(-VEL);
    }
    else if (pressed == KeyEvent.VK_DOWN)
    {
     
     player1.setVelocity(VEL);
    }
    else if (pressed == KeyEvent.VK_UP)
    {
     player1.setVelocity(-VEL);
    }
    
     else if (pressed == KeyEvent.VK_M)
    {
      if(player1.hasShoot())
      {
        //player1.addShoot (1);
       b.insertBullet(new Bullet(player1.getX(),player1.getY(),0,this,player1));
        AudioClip clip = Applet.newAudioClip(TankTrouble.class.getResource("blop.wav"));
         clip.play();
        //player1.addShoot (-1);
       player1.setShoot(false);
      }
    }
     
     
    else if(pressed == KeyEvent.VK_F)
    {
       player2.addRotationDegree(ROTDEG);
    }
    else if (pressed == KeyEvent.VK_S)
    {
       player2.addRotationDegree(-ROTDEG);
    }
    else if (pressed == KeyEvent.VK_D)
    {
      player2.setVelocity(VEL);
    }
    else if (pressed == KeyEvent.VK_E)
    {
      player2.setVelocity(-VEL);
    }
     else if (pressed == KeyEvent.VK_Q)
    {
      if(player2.hasShoot())
      {
        //player2.addShoot (1); // addShot methodu ekledim ama bunu silebiliriz
        b.insertBullet(new Bullet(player2.getX(),player2.getY(),0,this,player2));
        AudioClip clip = Applet.newAudioClip(TankTrouble.class.getResource("blop.wav"));
         clip.play();
       //  player2.addShoot(-1); // addShot
        player2.setShoot(false); // originally we used setShoot to shoot the opponent
      }
    }
     
   
    }
  }
  
  public void keyReleased(KeyEvent event)
  {
    if(state==STATE.GAME)
    {
    int pressed = event.getKeyCode();
    
    if(pressed == KeyEvent.VK_RIGHT)
    {
      player1.addRotationDegree(0);
    }
    else if (pressed == KeyEvent.VK_LEFT)
    {
      player1.addRotationDegree(0);
    }
    else if (pressed == KeyEvent.VK_DOWN)
    {
      player1.setVelocity(0);
    }
    
    else if (pressed == KeyEvent.VK_UP)
    {
     player1.setVelocity(0);
    }
    
    
    
    else if(pressed == KeyEvent.VK_F)
    {
    player2.addRotationDegree(0);
    }
    else if (pressed == KeyEvent.VK_S)
    {
    player2.addRotationDegree(0);
    }
    else if (pressed == KeyEvent.VK_D)
    {
     player2.setVelocity(0);
    }
    else if (pressed == KeyEvent.VK_E)
    {
     player2.setVelocity(0);
    }
    }
  }
  
  public void restart()
  {
    Random rand = new Random();
    player1.setRotation(0);
    player1.setX(map.originX + rand.nextInt(7)*100 + 40);
    player1.setY(map.originY + rand.nextInt(7)*100 + 40);
    player1.setShoot(true);
    player2.setRotation(0);
    player2.setX(map.originX + rand.nextInt(7)*100 + 40);
    player2.setY(map.originY + rand.nextInt(7)*100 + 40);
    player2.setShoot(true);
    for(int i=0;i<b.bullets.size();i++)
    {
      Bullet temp = b.bullets.get(i);
      b.eraseBullet(temp);
    }
  }
  
  public void setGame()
  {
    state = STATE.GAME;
  }
  
  public static void main(String[] args)
  {
    TankTrouble game = new TankTrouble();
        
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