package ua.demo.reactive.rx.observable.defer;

import io.reactivex.Observable;

public class Launcher {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        Observable<Integer> source = Observable.defer(() -> Observable.range(start, count));

        source.subscribe(it -> System.out.println("Observer 1: " + it));

        count = 10;

        source.subscribe(it -> System.out.println("Observer 2: " + it));
    }
}
