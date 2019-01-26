package ua.demo.reactive.rx.concurrency.completable.future.supplier;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Log4j2
public class Launcher {

    public static void main(String[] args) {
        CompletableFuture<String> firstFuture = CompletableFuture.supplyAsync(() -> {
            log.debug("Executing first thread ...");
            return "Hi!";
        });

        CompletableFuture<String> secondFuture = CompletableFuture
                                            .supplyAsync(() -> {
                                                log.debug("Executing second thread ...");
                                                return "Hi!";
                                            }, Executors.newCachedThreadPool());
    }

    @Test
    @SneakyThrows
    public void getTest() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e);
            }
            return "Hi!";
        });

        System.out.println("future = " + future.get());
    }

    @Test
    @SneakyThrows
    public void callbackTest() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi!");

        future.thenAccept(result -> System.out.println("result = " + result));

        future.get();
    }

    @Test
    @SneakyThrows
    public void thenApplyTest() {
        log.debug("Executing Completable Future ...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi!");

        future.thenApply(result -> {
            log.debug("Handling first thenApply() method ...");
            System.out.println("result1 = " + result);
            return result;
        }).thenApply(result -> {
            log.debug("Handling second thenApply() method ...");
            System.out.println("result2 = " + result);
            return result;
        });

        future.get();
    }

    @Test
    @SneakyThrows
    public void thenApplyAsyncTest() {
        log.debug("Executing Completable Future ...");
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hi!");

        future.thenApplyAsync(result -> {
            log.debug("Handling first thenApply() method ...");
            System.out.println("result1 = " + result);
            return result;
        }).thenApplyAsync(result -> {
            log.debug("Handling second thenApply() method ...");
            System.out.println("result2 = " + result);
            return result;
        });

        future.get();
    }

}
