package ua.demo.reactive.rx.observable.single;

import io.reactivex.Single;

public class Launcher {
    public static void main(String[] args) {
        Single.just("Hello")
                .map(String::length)
                .subscribe(System.out::println);
    }
}
