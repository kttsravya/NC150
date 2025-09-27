package LeetCode.CloudKitchens.Task2;

public class Coin {
    CoinValue coinValue = null;
    public Coin(){
        double random = Math.random();
        if(random > 0.5){
            coinValue = CoinValue.HEAD;
        }else{
            coinValue = CoinValue.TAIL;
        }
    }

    public String getCoinOption(){
        return coinValue.name();
    }
}
