package ua.demo.reactive.rx.concurrency.completable.future.callback.combine;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Log4j2
public class LauncherSecond {
    @SneakyThrows
    public static void main(String[] args) {
        log.debug("Starting application ...");

        ExecutorService pool = Executors.newFixedThreadPool(5);

        CompletableFuture<String> receiver = CompletableFuture.supplyAsync(findReceiver(), pool);
        CompletableFuture<String> content = CompletableFuture.supplyAsync(createContent(), pool);
        CompletableFuture<String> result = receiver.thenCombine(content, (to, body) -> "Sending a message to " + to + " with: " + body);

        System.out.println("Result: " + result.get());
    }

    @SneakyThrows
    private static Supplier<String> createContent() {
        log.debug("Create a content ...");
        Thread.sleep(5000L);
        return () -> "content";
    }

    @SneakyThrows
    private static Supplier<String> findReceiver() {
        log.debug("Try to find some receiver ...");
        Thread.sleep(3000L);
        return () -> "test";
    }
}
