package LeetCode.CloudKitchens.Task2;

public class CoinGame {
    Player[] players = new Player[2];
    Coin theCoin = new Coin();
    CoinGame(String player1Name, String player2Name){
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
    }

    public void startGame(){
        // pick a random player to choose the face value guess
        int randIndex = (Math.random() < 0.5)? 0 :1;
        String playersPick = players[randIndex].getRandomCoinOption();
        // set the opponents coin option to the opposite value
        int opponentsIndex = (randIndex == 0)?1:0;
        players[opponentsIndex].setCoinOption(playersPick);
        // flip the coin to find the winning side
        String winningFlip = theCoin.getCoinOption();
        // see the result of the flip
        players[0].didPlayerWin(winningFlip);
        players[1].didPlayerWin(winningFlip);

    }

}
