package tictoeGame;

import java.util.Scanner;

class TikToe1{
    static char[][] game;
    TikToe1(){
        game=new char[3][3];
        InitBord();
    }
    void InitBord(){
        for(int i=0;i<=2;i++){
            for(int j=0;j<=2;j++){
                game[i][j]=' ';
            }
        }
    }
    static void display1(){
        System.out.println(".............");
        for(int i=0;i<3;i++){
            System.out.print("|");
            for(int j=0;j<3;j++){
                System.out.print(game[i][j] + " | ");
            }
          
            System.out.println();
            System.out.println(".............");
        }
        
    }
    
 
   static void enterValue(int r,int c, char a){
        if(r>=0 && r<=2 && c>=0 && c<=2){
            game[r][c]=a;
          
        }
    }
   static boolean winRowWise(){
        for(int i=0;i<3;i++){
            if(game[i][0]!=' ' && game[i][0]==game[i][1] && game[i][1]==game[i][2]){
               return true;
            }
           
        }
   
        for(int i=0;i<3;i++){
            if(game[0][i]!=' ' && game[0][i]==game[1][i] && game[1][i]==game[2][i]){
               return true;
            }
           
        }
   
        if(game[0][0]!=' ' && game[1][1]==game[2][2] && game[2][2]==game[0][0] || 
        game[0][2]!=' ' && game[0][2]==game[2][2] && game[2][2]==game[2][0]){
            return true;
           
        }
       
        return false;
    }
}
class Human{
    String  name;
char marks;
Human(String name, char marks){
    this.name=name;
    this.marks=marks;
}
void  PlaceMArks(){
    Scanner sc=new Scanner(System.in);
    int row;
    int col;
    int c=0;
    do{
       
        if(c==0)
        System.out.println("Choice row and col Number");
       else
        System.out.println("Please enter valid row and ccolumn number");
        row=sc.nextInt();
        col=sc.nextInt();
        c++;

    }while(!isValid(row, col));
    TikToe1.enterValue(row, col, marks);
}
boolean isValid(int r, int c){
    if(r>=0 && r<=2 && c>=0 && c<=2){
        if(TikToe1.game[r][c]==' ')
        return true;
    }
    return false;
   
}
}

public class TikTok {
    public static void main(String[] args) {
        TikToe1 t1=new TikToe1();
        //t1.display1();
        // t1.enterValue(0, 0, 'x');
        // t1.enterValue(1, 1, 'x');
        // t1.enterValue(2, 2, 'x');
        // t1.display1();
        Human  player1=new Human("saurabh", 'X')    ;
        Human Player2=new Human("Brijesh", 'O')   ;
        Human cp;
        cp=player1;
        while(true){
        System.out.println(cp.name + " turn");
        cp.PlaceMArks();
        TikToe1.display1();
        if(TikToe1.winRowWise()){
         System.out.println(cp.name+ " Won the game");
         break;
        }
        else{
            if(cp==player1){
                cp=Player2;
            }
            else{
                cp=player1;
            }
        }
    }
        
    }
    
}
