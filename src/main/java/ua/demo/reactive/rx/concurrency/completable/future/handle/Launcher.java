package ua.demo.reactive.rx.concurrency.completable.future.handle;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;

public class Launcher {
    @SneakyThrows
    public static void main(String[] args) {
        Integer age = 3;

        CompletableFuture<String> maturityFuture = CompletableFuture.supplyAsync(() -> {
            if (age < 0) {
                throw new IllegalArgumentException("Age can not be negative");
            }

            if (age > 18) {
                return "Adult";
            } else {
                return "Child";
            }
        }).handle((res, ex) -> {
            if(ex != null) {
                System.out.println("Oops! We have an exception - " + ex.getMessage());
                return "Unknown!";
            }
            System.out.println("Handling result ...");
            return res;
        });

        System.out.println("Maturity : " + maturityFuture.get());
    }
}
