package ua.demo.reactive.rx.concurrency.completable.future.callback.run.of.both;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

@Log4j2
public class Launcher {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(5);

        CompletableFuture<String> future = CompletableFuture.supplyAsync(findReceiver(), pool);
        CompletableFuture<String> anotherFuture = CompletableFuture.supplyAsync(createContent(), pool);

        future.runAfterBoth(anotherFuture, () -> log.debug("Success"));
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
