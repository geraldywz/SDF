package sdf.revision;

import java.io.File;

public class CheckSuffix {
    
    private final String suffix;

    public CheckSuffix(String suffix){
        this.suffix = suffix;
    }

    // @FunctionalInterface
    public boolean hasSuffix(File f){
        return f.getName().endsWith(suffix);
    }
}
