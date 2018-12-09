package ua.demo.reactive.rx.observable.maybe;

import io.reactivex.Maybe;

public class Launcher {
    public static void main(String[] args) {
        Maybe.just("Hello")
                .subscribe(
                        it -> System.out.println("Received: " + it),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}
