package sdf.revision;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.PathMatcher;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FileChecker {

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
