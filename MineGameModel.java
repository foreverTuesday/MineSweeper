import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.lang.*;

class MineGameModel extends GameModel{
   private int sqrBrd = 3; //the size of the square board
   private int[][] board = {{0,0,0},{0,0,0},{0,1,1}};
   private int[] flatboard = new int[sqrBrd*sqrBrd];
   private ImageIcon [] images = new ImageIcon[sqrBrd*sqrBrd+1];
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
   private ImageIcon danger =  new ImageIcon("bombmark.jpg");


   private ImageIcon[] numbers = {num0,num1,num2,num3,num4,num5,num6,num7,num8};
   private BoardMaker gameBoard; 
   private int wincon=0;
   private int[] guessboard = new int[sqrBrd*sqrBrd];
   private int wincheck;
  





   MineGameModel(){ 
      gameBoard = new BoardMaker(sqrBrd);
      makeFlatBoard();
      makeGuessArray();
   }
   
   
   void makeFlatBoard(){
     int index = 0;
         for(int i=0; i<sqrBrd;i++){
            for(int a=0; a<sqrBrd;a++){
               flatboard[index]=board[i][a];
               index = index +1;
              
            }
         }
      
   }//flat board

   void makeGuessArray(){
      for(int index=0;index<guessboard.length;index++){
      
         guessboard[index]=1;
      
      }
   }

   void makeBoard(){
    
      int x=0; // image array index
      for(int i=0; i<sqrBrd;i++){
         for(int a=0; a<sqrBrd;a++){ 
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
      images[sqrBrd*sqrBrd] = danger;
   }//makeBoard


   void takeTurn(int t){
      guessboard[t]=0;
      boolean over = gameOverStatus();
      if(flatboard[t]==1){
         wincon = -1;
      }//if
      else if(over==true){
         wincon = 1;
      }//else
   
   }//takeTurn
   
   int getTurn(){
      return(wincon);
   }
           
   boolean gameOverStatus(){
      wincheck = 0;
      for(int index=0;index<guessboard.length;index++){
      
         if(guessboard[index]==flatboard[index]){
            wincheck = wincheck +1;
         }//if
      }//for
      if(wincheck == flatboard.length){
         return true;
      }
      else{
         return false;}
   }//gameOverStatus
   
   ImageIcon get(int c){
      return(images[c]);} 
  
   int getRows(){
      return sqrBrd;}

   int getCols(){
      return sqrBrd;}
   
   int getBoardSize(){
   return(sqrBrd*sqrBrd);
   }
   
   
   
   
   
   
   
   void display(){}
      
   String reportWinner(){
      return " ";}  
   
   

}// class