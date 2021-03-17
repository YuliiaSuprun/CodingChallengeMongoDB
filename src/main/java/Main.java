package main.java;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("ERROR: incorrect number of arguments");
            return;
        }
        // Create a JSONConversion object, containing the initial and flattened
        // JSONObjects
        JSONConversion conversion = new JSONConversion(args[0]);
        // Prints the flattened JSONObject to stdout
        System.out.println(conversion.getNewJSON().toString());
    }
}

