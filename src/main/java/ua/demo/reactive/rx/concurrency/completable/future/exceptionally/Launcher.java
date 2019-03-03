package ua.demo.reactive.rx.concurrency.completable.future.exceptionally;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Launcher {
    @SneakyThrows
    public static void main(String[] args) {
        Integer age = -1;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if(age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }
            if(age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }
}
