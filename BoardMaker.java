import javax.swing.*;
import java.awt.*;
import java.awt.event.*;  
import java.lang.*;

class BoardMaker{

   private int[][] board = {{0,0,0},{0,0,0},{0,1,1}};
private int sqrBrd;
   private int count;



   BoardMaker(int sqrBrdFetched){ 
sqrBrd = sqrBrdFetched;
   }
   
   
   int checkSides(int i, int a){
      count = 0;
      for(int y = i-1;y<i+2;y++){
         for(int x = a-1;x<a+2;x++){
            if(x>-1 && y>-1 && x<sqrBrd && y<sqrBrd){
               if(board[y][x]==1){
                  count = count +1;
               }
            }
         } //for x (a, column #)
      } //for y (i, row #)
      return count;
      }//checkSides
   
   
   
}