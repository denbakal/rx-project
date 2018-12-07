package ua.demo.reactive.rx.observable.range;

import io.reactivex.Observable;

public class Launcher {
    public static void main(String[] args) {

        /*
        * Note that there is also a long equivalent called Observable.rangeLong()
        * if you need to emit larger numbers.
        * */

        Observable.range(5, 10)
                .subscribe(it -> System.out.println("Received: " + it));
    }
}
