package ua.demo.reactive.rx.operators.suppressing.element.at;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma", "Delta")
                .elementAt(3)
                .subscribe(it -> System.out.println("RECEIVED: " + it));
    }
}
