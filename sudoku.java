/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import static com.mycompany.mavenproject1.main.randInt;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Irfandi
 * Bondowoso, 23 April 2020 - 16.24
 */
public class sudoku {
    //input how many row and colomn
    static int row_coloumn = 9;
    
    //input sudoku challenge
    static int[][] tabel = {
      {0, 3, 0, 0, 0, 0, 0, 6, 0},
      {8, 0, 0, 6, 0, 0, 4, 0, 7},
      {0, 5, 0, 0, 0, 0, 0, 0, 0},
      {0, 0, 5, 0, 7, 0, 0, 3, 0},
      {0, 0, 0, 0, 0, 6, 0, 0, 8},
      {9, 1, 0, 0, 5, 0, 0, 0, 0},
      {6, 0, 0, 7, 0, 9, 0, 2, 0},
      {0, 0, 0, 3, 0, 0, 0, 0, 0},
      {0, 0, 0, 4, 0, 1, 0, 0, 6}
    };
    
    static int[][] reset = new int [row_coloumn][row_coloumn];
    
 public static void main(String[] args) {
     //make backup if do reset
     for(int x1 = 0; x1<row_coloumn; x1++){
            for(int y1 = 0; y1<row_coloumn; y1++){
              reset[x1][y1]=tabel[x1][y1];
          }
    }  

     System.out.println("Quiz : ");
    //print the quiz
    for(int x = 0; x<row_coloumn; x++){
      for(int y = 0; y<row_coloumn; y++){
        System.out.print(" "+tabel[x][y]); 
    }
    System.out.print("\n");
    }

    //make room for forbiden and available number
    ArrayList forbiden = new ArrayList<Integer>();
    ArrayList available = new ArrayList<Integer>();
    
     System.out.println("\n\nLet me think ...");
     
     //lets loop
      for(int x = 0; x<row_coloumn; x++){
        for(int y = 0; y<row_coloumn; y++){
            if(tabel[x][y]==0){
    forbiden.clear();
    //get forbiden number in vertical
    for(int sekolom = 0; sekolom < row_coloumn; sekolom++){
      if(tabel[sekolom][y]!=0){
        forbiden.add(tabel[sekolom][y]);
      }
    }
    
    //get forbiden number in horizontal
    for(int sebaris = 0; sebaris < row_coloumn; sebaris++){
      if(tabel[x][sebaris]!=0){
        forbiden.add(tabel[x][sebaris]);
      }
    }
    
    available.clear();
    //check available option
    for(int z=1; z<=row_coloumn ; z++){
      if(!forbiden.contains(z)){
        available.add(z);
      }
    }
    
    //if 0 available option, reset
    if(!available.isEmpty()){
        if(available.size()>1){
            //get random from available option
            int rand = randInt(0,available.size()-1);
            tabel[x][y] = (int) available.get(rand); 
        } else {
            //get the only available option
            tabel[x][y] = (int) available.get(0); 
        }
    } else {
      //reset 
             x = 0;
             y = -1;
             
             //reset table
           for(int x1 = 0; x1<row_coloumn; x1++){
            for(int y1 = 0; y1<row_coloumn; y1++){
              tabel[x1][y1]=reset[x1][y1];
          }
          }

    }
        }
            }
      }
      
       System.out.println("done, result :");
    //print result
    for(int x = 0; x<row_coloumn; x++){
      for(int y = 0; y<row_coloumn; y++){
        System.out.print(" "+tabel[x][y]); 
    }
    System.out.print("\n");
    }
 }
    
 //get random from range
    public static int randInt(int min, int max) {
        Random rand = null;
        int randomNum =(int) (Math.random() * ((max - min) + 1)) + min;

        return randomNum;
    }
}
