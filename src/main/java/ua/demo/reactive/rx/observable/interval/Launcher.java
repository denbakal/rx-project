package ua.demo.reactive.rx.observable.interval;


import io.reactivex.Observable;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class Launcher {

    @SneakyThrows
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(it -> System.out.println(it + " Mississippi"));

        Thread.sleep(5000L);
    }
}
