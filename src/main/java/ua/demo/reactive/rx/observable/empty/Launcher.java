package ua.demo.reactive.rx.observable.empty;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable<String> source = Observable.empty();

        source.subscribe(System.out::println, Throwable::printStackTrace, () -> System.out.println("Done!"));
    }
}
