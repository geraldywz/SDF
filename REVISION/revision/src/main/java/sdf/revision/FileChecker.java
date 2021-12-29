package sdf.revision;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileChecker {

    /* Application of the file suffix filter using the Java.nio packages.
    The intent is to familiarize myself with the workings of this package in preparation for future evaluations. */

    public static void main(String[] args) {

        final ExecutorService svc = Executors.newFixedThreadPool(5);
        final Path path = Paths.get("/", "tmp", "static");

        final PathMatcher filter = path.getFileSystem().getPathMatcher("glob:*.png");

        svc.submit(() -> {
            try (final Stream<Path> stream = Files.list(path)) {
                
                stream.filter(filter::matches).forEach(System.out::println);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
