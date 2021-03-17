package main.java;

public class Main {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("ERROR: incorrect number of arguments");
            return;
        }
        JSONConversion conversion = new JSONConversion(args[0]);
        System.out.println(conversion.getNewJSON().toString());
    }
}

