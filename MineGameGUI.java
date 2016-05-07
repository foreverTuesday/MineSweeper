import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.util.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.text.DecimalFormat;


public class MineGameGUI extends JFrame implements ActionListener{
   private final int WINDOW_WIDTH = 600;
   private final int WINDOW_HEIGHT = 600;
   private JButton [] panels = new JButton[9];
   private MineGameModel gamePlan; 
   private JRadioButton bomb;
   private JRadioButton flip;
   private ButtonGroup bg;
   private int size;
   int checkWin = 0;




   public MineGameGUI(){
      gamePlan = new MineGameModel();
      size = gamePlan.getBoardSize();
      setVisible(true);
      setTitle("Minesweeper");
      setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
   
      Panel menu = new Panel();/////make lower buttons
      bomb = new JRadioButton("Bomb");
      flip = new JRadioButton("Safe");
      bg = new ButtonGroup();
      bg.add(bomb);
      bg.add(flip);
       
      menu.add(flip);
      menu.add(bomb);
      add (menu,BorderLayout.SOUTH);
   
   
   
      Panel grid = new Panel();/////make grid
      grid.setLayout(new GridLayout(gamePlan.getRows(),gamePlan.getCols()));
      for(int i=0;i<gamePlan.getRows()*gamePlan.getCols();i++){
         panels[i] = new JButton ("");
         panels[i].addActionListener(this);
         grid.add(panels[i]);
      }//for
      add (grid,BorderLayout.CENTER);
       JOptionPane.showMessageDialog(null, "Welcome to minesweeper. \nSome of the squares are safe "+
       "and some of them hide bombs.  \nYou win if you reveal all of the safe spaces without "+
       "revealing a bomb.  \nTo reveal a square, select the flip button and then click on it. "+
       "\nTo mark a square as a bomb, select the bomb button and then click on it. "+
       "\nEvery safe space contains a number that indicates how many bombs are adjacent to it."+ 
       "\nGood luck.");

   
      
   }//mineGameGUI

   public void actionPerformed(ActionEvent ae){
      gamePlan.makeBoard();
      JButton source = (JButton)ae.getSource();
      int i=0;
      while( source != panels[i])
         i++;
         
         
      if (bomb.isSelected()){
         panels[i].setIcon(gamePlan.get(size));
      }
      
      else if(flip.isSelected()){
         panels[i].setIcon(gamePlan.get(i));
          gamePlan.takeTurn(i);
      checkWin = gamePlan.getTurn();
      if(checkWin != 0){
         for(int a=0;a<size;a++){
            panels[a].removeActionListener(this);
         }//for
      }//if
      }
      
      else{
        JOptionPane.showMessageDialog(null, "Please select bomb or flip before clicking a square");
      }
      
     
      
      if(checkWin == 1){
         JOptionPane.showMessageDialog(null, "You've Won!");
      }//if
      
      else if(checkWin == -1){
         JOptionPane.showMessageDialog(null, "You've Lost :(");
      }//if
   
   
   }//actionPerformed




}