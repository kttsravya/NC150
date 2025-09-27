package LeetCode.CloudKitchens.Task2;

import java.util.Scanner;

public class CoinGameDemo {
    public static void main(String[] args){
        CoinGame theCoinGame = new CoinGame("Sravya", "vineel");
        String usersAnswer;
        do{
            theCoinGame.startGame();
            System.out.println("Play Again? ");
            Scanner playGameAgain = new Scanner(System.in);
            usersAnswer =  playGameAgain.nextLine();
        }while (usersAnswer.startsWith("y") || usersAnswer.startsWith("Y"));
    }
}
