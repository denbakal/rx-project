package ua.demo.reactive.rx.operators.suppressing.filter;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .filter(it -> it.length() != 5)
                .subscribe(it -> System.out.println("RECEIVED: " + it));
    }
}
