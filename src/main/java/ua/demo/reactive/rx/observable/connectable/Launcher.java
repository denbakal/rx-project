package ua.demo.reactive.rx.observable.connectable;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class Launcher {
    public static void main(String[] args) {
        // hot
        ConnectableObservable<String> source = Observable
                .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .publish();

        source.subscribe(it -> System.out.println("Observer 1: " + it));

        source.subscribe(it -> System.out.println("Observer 2: " + it));

        source.connect();
    }
}
