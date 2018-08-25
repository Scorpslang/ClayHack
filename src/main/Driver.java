package main;


public class Driver{
    public static String status;
    public static void main(String[] args){
        status = "START";
        Main main = new Main();
        main.run(1.0/560.0);
    }
}
