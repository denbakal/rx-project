package ua.demo.reactive.rx.operators.suppressing.take;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        // take(3) will emit the first three emissions and then call the onComplete() event
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3)
                .subscribe(it -> System.out.println("RECEIVED: " + it));

        Observable.range(1,100)
                .takeWhile(it -> it < 5)
                .subscribe(it -> System.out.println("RECEIVED: " + it));
    }
}
