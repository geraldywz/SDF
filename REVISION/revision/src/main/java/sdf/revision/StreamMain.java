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
        List<String> words = Arrays.asList("big", "bog", "balloon", "boot", "bone", "bane", "bolt");
        List<String> uppercase = new LinkedList<>();

        uppercase = filterCollection(words); // Using Collections.
        // uppercase = filterStream(words); // Using Collections.

        for (String s : words) {
            System.out.println(s);
        }
        System.out.println();
        for (String s : uppercase) {
            System.out.println(s);
        }
    }

    public static List<String> orderedFilterStream(List<String> words) {
        // Declarative approach, just give me the next item.
        List<String> output = words.stream()
                .filter(v -> v.length() > 3)        // Arbitrary filter(mask)
                .map(String::toUpperCase)           // Transformation
                .reduce("", (s0, s1));
        return output;
    }

    public static List<String> filterStream(List<String> words) {
        List<String> output = words.stream()
                .filter(v -> v.length() > 3) // Arbitrary filter(mask)
                .map(String::toUpperCase) // Transformation
                .toList();
        return output;
    }

    public static List<String> filterCollection(List<String> words) {
        // Imperative approach, all actions must be explciitly stated.
        List<String> output = new LinkedList<>();

        for (String s : words) {

            // Arbitrary filter
            if (s.length() < 4) {
                continue;
            }
            // Transformation
            output.add(s.toUpperCase());
        }
        return output;
    }
}