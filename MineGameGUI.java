import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class MineGameGUI extends JFrame implements ActionListener{
   private final int WINDOW_WIDTH = 600;
   private final int WINDOW_HEIGHT = 600;
   private JButton [] panels = new JButton[9];
   private MineGameModel gamePlan; 
    private JRadioButton bomb;
 private JRadioButton flip;





   public MineGameGUI(){
      setVisible(true);
      setTitle("Minesweeper");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
      Panel menu = new Panel();/////make lower buttons
       bomb = new JRadioButton("Bomb");
       flip = new JRadioButton("Safe");
menu.add(flip);
menu.add(bomb);
      add (menu,BorderLayout.SOUTH);
   
   
   
      Panel grid = new Panel();/////make grid
      grid.setLayout(new GridLayout(3,3));
      for(int i=0;i<9;i++){
         panels[i] = new JButton ("");
         panels[i].addActionListener(this);
         grid.add(panels[i]);
      }//for
      add (grid,BorderLayout.CENTER);
   
      gamePlan = new MineGameModel();
   }//mineGameGUI

   public void actionPerformed(ActionEvent ae){
   gamePlan.makeBoard();
      JButton source = (JButton)ae.getSource();
      int i=0;
      while( source != panels[i])
         i++;
      
      
      panels[i].setIcon(gamePlan.get(i));
   
   }//actionPerformed




}