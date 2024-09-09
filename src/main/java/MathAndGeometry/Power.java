package MathAndGeometry;


public class Power {
    public static void main(String[] args){
        Power pow = new Power();
        double d = pow.myPow(2.00000,-3);
        System.out.println(d);
    }

    public double myPow(double x, int n) {
        double res = myPowHelper(x, Math.abs(n));
        if(n < 0){
            return 1/res;
        }else{
            return res;
        }
    }

    private double myPowHelper(double x, int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return x;
        }
        double half = myPowHelper(x, n/2);
        if(n % 2 == 0){
             return half * half;
        }
        else{
           return x * half * half;
        }
    }
}
