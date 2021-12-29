package sdf.revision;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        File dir = new File("/tmp/static");
        CheckSuffix dotPng = new CheckSuffix(".png");

        /*
         * File[] files = dir.listFiles(
         * (f) -> f.getName().endsWith(".png")); //Lambda expression? I don't think i
         * understand tho.
         */

        File[] files = dir.listFiles(dotPng::hasSuffix); // method reference, i don't fully understand this either.

        for (File f : files) {
            System.out.printf("%s\n", f.getName());
        }
    }
}
