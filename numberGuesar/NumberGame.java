
package numberGuesar;

import java.util.Random;
import java.util.Scanner;

class Guesser{
    int guesNum;
    int guesNumber(){
        // Scanner scanner=new Scanner(System.in);
        // System.out.println("Enter the Number from guesser");
        Random random=new Random();
        int ran=random.nextInt(100);
        // guesNum=scanner.nextInt();
         guesNum=ran;
        return guesNum;
    }
}
class Player{
    int guesNum1;
    int guesNumber1(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the Player NUMber");
        guesNum1=scanner.nextInt();
        return guesNum1;
    }
}
class Umpire{
    int Numgues;
    int NumPlayer1;
   
    void collectTheNumFromGuesser(){
        Guesser gu=new Guesser();
       Numgues= gu.guesNumber();
    }
 void testNumbr(){
    int a=1;
    Player p=new Player();
    for(int i=10;i>0;i--){
        System.out.println("You have left "+i+ " chance");
        NumPlayer1=p.guesNumber1();
        if(NumPlayer1>Numgues){
            System.out.println("number is less than to player "+NumPlayer1);
        }
        else if(NumPlayer1<Numgues)
        System.out.println("Number is greater than to player number "+NumPlayer1);
        else{
            a=0;
            break;
        }
    }
    if(a==0){
        System.out.println("Player won the game");
    }
    else{
    System.out.println("player loss the game");
    System.out.println("the gueser numbr was "+Numgues);
    }
 }
}


public class NumberGame {
    public static void main(String[] args)
     {
        Umpire um=new Umpire();
        um.collectTheNumFromGuesser();
        um.testNumbr();
    }
    
}
