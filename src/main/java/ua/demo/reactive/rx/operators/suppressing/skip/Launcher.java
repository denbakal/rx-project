package ua.demo.reactive.rx.operators.suppressing.skip;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .skip(90)
                .subscribe(it -> System.out.println("RECEIVED: " + it));

        Observable.range(1,100)
                .skipWhile(it -> it <= 95)
                .subscribe(it -> System.out.println("RECEIVED: " + it));
    }
}
