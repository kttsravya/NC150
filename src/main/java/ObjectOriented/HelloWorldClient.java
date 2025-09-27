package ObjectOriented;

public class HelloWorldClient {
    public static void main(String[] args){
        HelloWorld helloWorld = new HelloWorld();
        int a = helloWorld.getA();
        System.out.println(helloWorld.c);
        System.out.println(a);
    }
}
