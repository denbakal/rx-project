package ua.demo.reactive.rx;


import io.reactivex.Observable;

public class Main {
    public static void main(String[] args) {
        Observable<String> observable = Observable
                .just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        observable.subscribe(System.out::println);
    }
}
