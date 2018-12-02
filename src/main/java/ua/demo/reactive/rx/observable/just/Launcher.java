package ua.demo.reactive.rx.observable.just;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable<String> source = Observable
                .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        source.map(String::toUpperCase).subscribe(System.out::println);
    }
}
