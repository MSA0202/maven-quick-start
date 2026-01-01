package clinic.programming.training;

import java.util.*;

public class Application {

    public Application() {
        System.out.println ("Inside Application");
    }

    public void greet() {
        List<String> greetings = new ArrayList<>();
        greetings.add("hi");
        var list = List.of(1, 2, 3);
        System.out.println(greetings);
    }

    // method main(): ALWAYS the APPLICATION entry point
    public static void main (String[] args) {
        System.out.println ("Starting Application");
        Application x = new Application();
        x.greet();
    }
}