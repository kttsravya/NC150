package LeetCode.CloudKitchens.Task2;

public class Player {
    private String name="";
    private CoinValue coinValue;

    public Player(String name){
        this.name = name;
    }

    public String getCoinValue(){
        return this.coinValue.name();
    }

    public void setCoinOption(String oppositeFlip){
        coinValue = oppositeFlip.equals(CoinValue.HEAD.name())? CoinValue.TAIL :CoinValue.HEAD;
    }

    public String getRandomCoinOption(){
        double random = Math.random();
        if(random > 0.5){
            coinValue = CoinValue.HEAD;
        }else{
            coinValue = CoinValue.TAIL;
        }
        return coinValue.name();
    }

    public void didPlayerWin(String winningFlip){
        if(coinValue.name().equals(winningFlip)){
            System.out.println(name + "won with a flip of "+ coinValue.name());
        }else{
            System.out.println(name + "lost with a flip of "+ coinValue.name());
        }
    }



}
