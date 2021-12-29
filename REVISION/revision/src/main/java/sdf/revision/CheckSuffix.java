package sdf.revision;

import java.io.File;

public class CheckSuffix {

    private final String suffix;

    public CheckSuffix(String suffix) {
        this.suffix = suffix;
    }

    public boolean isInDirectory(File root, String fn) {
        // File f = new File(root + "/" + fn);
        return new File(root + "/" + fn).exists();
    }

    // @FunctionalInterface
    public boolean hasSuffix(File f) {
        return f.getName().endsWith(suffix);
    }
}
