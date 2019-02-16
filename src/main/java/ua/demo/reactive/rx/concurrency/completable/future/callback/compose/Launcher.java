package ua.demo.reactive.rx.concurrency.completable.future.callback.compose;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CompletableFuture;

@Log4j2

public class Launcher {

    @SneakyThrows
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10)
                .thenCompose(result ->
                    CompletableFuture.supplyAsync(() -> result * 2)
                )
                .thenCompose(result ->
                    CompletableFuture.supplyAsync(() -> result * 5)
                );

        System.out.println("Result: " + future.get());
    }
}
