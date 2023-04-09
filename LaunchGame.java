import java.util.*;
class Guesser{    // This class takes a guessed number from guesser
    Scanner sc = new Scanner (System.in);
    int guessNum;
    public int GuessNum() {
        System.out.println("Guesser Guess a Number between 0-10");
        guessNum = sc.nextInt();
        if (guessNum>=0 && guessNum<=10) {
            return guessNum;
        } 
        else {
           System.out.println("Try Again and give input in given range");
           return GuessNum(); 
        }
    }
}
class Player{    // This class takes a guessed number from Players
    Scanner sc = new Scanner (System.in);
    int guessNum;
    public int GuessNum(int count) {
        System.out.println("Player "+count+" Guess a Number between 0-10");
        guessNum = sc.nextInt();
        if (guessNum>=0 && guessNum<=10) {
            return guessNum;
        } 
        else {
           System.out.println("Try Again and give input in given range");
           return GuessNum(count); 
        }
    }
}
class Umpire{    // This class compares guessed number with number given by players
    int guessNum;
    int numPlayer1;
    int numPlayer2;
    int numPlayer3;
    void collectorFromGuesser() {        // This function collects input from Guesser class
        Guesser g = new Guesser();
        guessNum = g.GuessNum();
    }
    void collectorFromPlayer() {        // This function collects input from Player class
        Player p1 = new Player();
        Player p2 = new Player();
        Player p3 = new Player();
        numPlayer1 = p1.GuessNum(1);
        numPlayer2 = p2.GuessNum(2);
        numPlayer3 = p3.GuessNum(3);
    }
    void compare(){                     // This function compares value from Guesser and Players
        if (guessNum == numPlayer1) {
            if (guessNum == numPlayer2 && guessNum == numPlayer3) {
                System.out.println("Game Tie Try Again");
            } 
            else if(guessNum == numPlayer2){
                System.out.println("Player 1 & 2 are winner");
            }
            else if (guessNum == numPlayer3){
                System.out.println("Player 1 & 3 are winner");
            }
            else {
                System.out.println("Player 1 is winner");
            }
        }
        else if(guessNum == numPlayer2){
            if(guessNum == numPlayer3){
                System.out.println("Player 2 & 3 are winner");
            }
            else{
                System.out.println("Player 2 is winner");
            }
        }
        else if(guessNum == numPlayer3){
            System.out.println("Player 3 is winner");
        }
        else{
            System.out.println("No one win, Try again");
        }
    }
}
class LaunchGame{
    public static void main(String[] args) {
        System.out.println("Game Started");
        Umpire u = new Umpire();
        u.collectorFromGuesser();
        u.collectorFromPlayer();
        u.compare();
    }
}