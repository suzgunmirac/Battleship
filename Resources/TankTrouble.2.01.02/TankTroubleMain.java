import java.applet.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

public class TankTroubleMain extends JApplet //implements ActionListener
{  
  
  public JLabel user1;
  public JLabel user2;
  public Container contentPane;
  public JButton gameStarts;
  
  
  /**Applet initiation**/
  public void init ()
  {
    initializeTankTroubleComponent();
  }
  
  public void initializeTankTroubleComponent(){
    user1 = new JLabel ();
    user1.setFont (new Font ("Times New Roman", Font.BOLD, 30));
    user1.setText ("Cengiz");
    
    user2 = new JLabel ();
    user2.setFont (new Font ("Times New Roman", Font.BOLD, 30));
    user2.setText ("Agalar");
    
    gameStarts = new JButton ();
    
    contentPane = (Container)this.getContentPane(); // biraz advanced konular: http://docs.oracle.com/javase/tutorial/uiswing/components/toplevel.html
          
    // ContentPane : http://docs.unity3d.com/ScriptReference/GameObject.AddComponent.html
    /*
     * public GroupLayout.Group addComponent(Component component,
                             int min,
                             int pref,
                             int max)
                             
                             Parameters:
                             component - the Component to add
                             min - the minimum size or one of DEFAULT_SIZE or PREFERRED_SIZE
                             pref - the preferred size or one of DEFAULT_SIZE or PREFERRED_SIZE
                             max - the maximum size or one of DEFAULT_SIZE or PREFERRED_SIZE
     */
    
     
    gameStarts.setText ("Tank Trouble 2.01.01! Play ");
    gameStarts.addActionListener (new ActionListener(){
      public void actionPerformed (ActionEvent e){
        gameStarts_actionPerformed (e);
      }
    });
    
    contentPane.setLayout (null);
    addComponent(contentPane, user1, 10, 10, 100, 100);
    addComponent(contentPane, user2, 10, 100, 100, 100);
    
    
  }
  
  private void addComponent (Container tankContainer, Component ccc, int x, int y, int width, int height){
    ccc.setBounds (x, y, width, height);
    tankContainer.add (ccc);
  }
  
  private void gameStarts_actionPerformed (ActionEvent e){
    ;
  }
  
  
  /* public void paint (Graphics g)
   {
         
    g.drawString ("Arda Basaran", 25, 50);
   }
   */
}