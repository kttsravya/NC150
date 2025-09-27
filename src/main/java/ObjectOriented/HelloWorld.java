package ObjectOriented;

public class HelloWorld {
    // not accessible to client
    private int a;
    private int b;
    //accessible to client
    public int c;
    public int getA(){
        return this.a;
    }
    private int getB(){
        return this.b;
    }
    private int getC(){
        return this.c;
    }
}
