import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.lang.*;

class MineGameModel extends GameModel{
   private ImageIcon [] images = new ImageIcon[9];
   private int[][] board = {{0,0,0},{0,0,0},{0,1,1}};
   private ImageIcon bomb =  new ImageIcon("bomb.jpg");
    private ImageIcon num0 =  new ImageIcon("number0.jpg");
   private ImageIcon num1 =  new ImageIcon("number1.jpg");
   private ImageIcon num2 =  new ImageIcon("number2.jpg");
   private ImageIcon num3 =  new ImageIcon("number3.jpg");
   private ImageIcon num4 =  new ImageIcon("number4.jpg");
   private ImageIcon num5 =  new ImageIcon("number5.jpg");
   private ImageIcon num6 =  new ImageIcon("number6.jpg");
   private ImageIcon num7 =  new ImageIcon("number7.jpg");
   private ImageIcon num8 =  new ImageIcon("number8.jpg");

      private ImageIcon[] numbers = {num0,num1,num2,num3,num4,num5,num6,num7,num8};
   private BoardMaker gameBoard; 




   MineGameModel(){ 
  gameBoard = new BoardMaker();
   }

   void makeBoard(){
    
      int x=0; // image array index
      for(int i=0; i<3;i++){
         for(int a=0; a<3;a++){ 
            if (board[i][a] == 1){
               images[x] = bomb;
            }//if
            else{
            int bomb_count = gameBoard.checkSides(i, a);
               images[x]=numbers[bomb_count];
            }//else
            x = x+1;
            
         }//for 2 (column index)
      } //for 1 (row index)
   }//makeBoard


   void takeTurn(int t){}
           
   boolean gameOverStatus(){
      return true;}
   
   ImageIcon get(int c){
      return(images[c]);} 
  
   int getRows(){
      return 2;}

   int getCols(){
      return 2;}
   
   void display(){}
      
   String reportWinner(){
      return " ";}  
   
}// class