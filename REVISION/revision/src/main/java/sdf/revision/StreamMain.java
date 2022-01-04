package sdf.revision;

import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class StreamMain {
    /*
     * A comparison between using collections and streams to manipulate groups of
     * objects/data.
     */

    public static void main(String[] args) {
        List<String> words = Arrays.asList("big", "bog", "balloon", "ballast", "boner", "banes", "bolter");
        List<String> uppercase = new LinkedList<>();

        uppercase = filterCollection(words); // Using Collections.
        // uppercase = filterStream(words); // Using Collections.

        for (String s : words) { // Raw data set
            System.out.println(s);
        }

        System.out.println(); // Link break.

        for (String s : uppercase) {                        // Filtered using traditional Java syntax
            System.out.println(s);
        }

        System.out.println(); // Link break.

        uppercase = filterStream(words);
        for (String s : uppercase) {                        // Same function as above but with lambda expressions.
            System.out.println(s);
        }

        System.out.println(); // Link break.

        System.out.println(orderedFilterStream(words));     // With lambda expressions, sorted in reverse order of input.

    }

    public static String orderedFilterStream(List<String> words) {
        String output = words.stream()
                .filter(v -> v.length() > 3)        // Arbitrary filter(mask)
                .map(String::toUpperCase)           // Transformation
                .reduce("", (s0, s1) -> "%s %s".formatted(s1, s0));
        return output;
    }

    public static List<String> filterStream(List<String> words) {
        // Declarative approach, just give me the next item.

        List<String> output = words.stream()
                .filter(v -> v.length() > 3)        // Arbitrary filter(mask)
                .map(String::toUpperCase)           // Transformation
                .toList();
        return output;
    }

    public static List<String> filterCollection(List<String> words) {
        // Imperative approach, all actions must be explciitly stated.

        List<String> output = new LinkedList<>();

        for (String s : words) {

            if (s.length() < 4) {                   // Arbitrary filter
                continue;
            }            
            output.add(s.toUpperCase());            // Transformation
        }
        return output;
    }
}