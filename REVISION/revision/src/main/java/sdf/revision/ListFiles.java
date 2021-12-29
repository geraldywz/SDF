package sdf.revision;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {

        CheckSuffix dotPng = new CheckSuffix(".png");
        File dir = new File("/tmp/static");
        File[] files = dir.listFiles(dotPng::hasSuffix);    // method reference

        for (File f : files) {
            System.out.printf("%s\n", f.getName());
        }

    }
}
