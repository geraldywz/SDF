package sdf.revision;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lambda {

    public static void main(String[] args) {
        final ExecutorService svc = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            final String text = "%d".formatted(i);
            svc.submit(() -> {
                String thrname = Thread.currentThread().getName();
                System.out.println("Name: %s, text: %s" + thrname + text);
            });
        }
    }
}
