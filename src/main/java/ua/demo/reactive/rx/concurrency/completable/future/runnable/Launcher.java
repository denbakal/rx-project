package ua.demo.reactive.rx.concurrency.completable.future.runnable;

import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@Log4j2
public class Launcher {

    public static void main(String[] args) {
        CompletableFuture<Void> firstFuture = CompletableFuture.runAsync(() -> {
            log.debug("Executing first thread ...");
            System.out.println("Hi!");
        });

        CompletableFuture<Void> secondFuture = CompletableFuture
                                            .runAsync(() -> {
                                                log.debug("Executing second thread ...");
                                                System.out.println("Hi!");
                                            }, Executors.newCachedThreadPool());
    }
}
