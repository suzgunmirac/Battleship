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

public class Game extends Canvas implements Runnable {
  
  /**Enumerator to understand whether or not the game has started **/
  public enum STATE{
    MENU,
    SETTINGS,
    PLAY,
  };
  
  public STATE state = STATE.MENU; // state = MENU 
  
  
  private boolean isRunning = false;  //whether or not the program is running 
  public Thread thread; // For more info about threads: http://docs.oracle.com/javase/tutorial/essential/concurrency/sleep.html
  public Menu menu;
  public Play play;
  
  

  
  public Game()
  {
  }

  
  private void initializeGame()
  {
    /*Listeners*/
    addMouseListener(new MouseHandler(this));
    addMouseMotionListener(new MouseHandler(this));  
    menu = new Menu(this);  
    play = new Play(this);
  }
  
  
  public synchronized void start()
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
        //System.out.println(updates + " ticks, fps " + frames);
        updates = 0;
        frames = 0;
      }
    }
    
  }
  
  private void updateGame()
  {
    if(state == STATE.PLAY)
    {
     
    }
    else if(state == STATE.MENU)
    {
      
    }
    
  }
  
  private void renderGame()
  {
    
    BufferStrategy bs = this.getBufferStrategy();
    if(bs == null)
    {
      createBufferStrategy(2);
      return;
    }
    
    
    Graphics g = bs.getDrawGraphics();
    
    //Graphics g = null;
    ////////////////////
   
   if(state == STATE.MENU)
    {
      menu.renderMenu(g);
    }
    
   if(state == STATE.PLAY)
   {
     play.renderPlay(g);
   }
    
    
    ///////////////////
    g.dispose();
    bs.show();
    
  }
  
  
  
 
  
  public void setPlay()
  {
    state = STATE.PLAY;
  }
 
  
  /*
  public void setCredits(){
    state = STATE.CREDITS;
  }
  
  */
  
  public void setMenu()
  {
    state = STATE.MENU;
  }
  
  public void setSettings()
  {
     state = STATE.SETTINGS; 
  }
  
}