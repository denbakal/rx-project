package ua.demo.reactive.rx.operators.suppressing.distinct;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .map(String::length)
                .distinct()
                .subscribe(it -> System.out.println("RECEIVED: " + it));

        Observable.just(1, 1, 1, 2, 2, 3, 3, 2, 1, 1)
                .distinctUntilChanged()
                .subscribe(it -> System.out.println("RECEIVED: " + it));

    }
}
