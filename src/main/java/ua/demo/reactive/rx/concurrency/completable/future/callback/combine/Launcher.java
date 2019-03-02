package ua.demo.reactive.rx.concurrency.completable.future.callback.combine;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

import java.util.concurrent.CompletableFuture;

@Log4j2

public class Launcher {

    @SneakyThrows
    public static void main(String[] args) {
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> 10);
        CompletableFuture<Integer> anotherFuture = CompletableFuture.supplyAsync(() -> 2);
        CompletableFuture<Integer> result = future.thenCombine(anotherFuture, (a, b) -> a * b);

        System.out.println("Result: " + result.get());
    }
}
