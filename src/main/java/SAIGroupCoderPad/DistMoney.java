package SAIGroupCoderPad;

public class DistMoney {
    public static void main(String[] args){
        DistMoney distMoney = new DistMoney();
        int numOf8s = distMoney.distMoney(16,2);
        System.out.println(numOf8s);
    }

    public int distMoney(int money, int children) {
        if(money < children){
            return -1;
        }
        money = money - children; // distributing one dollar for every child
        int numOf8s = money/7;
        int remainder = money%7;

        if(numOf8s > children){
            return children - 1;
        }
        if(numOf8s == children && remainder > 0){
            return children - 1;
        }
        if(numOf8s + 1 == children && remainder == 3){
            numOf8s = numOf8s - 1;
        }
        return  numOf8s;
    }
}
