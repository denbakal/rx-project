package ua.demo.reactive.rx.observable.from;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Launcher {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("Alpha", "Beta", "Gamma", "Delta", "Epsilon");

        Observable<String> source = Observable.fromIterable(items);

        source.filter(it -> it.startsWith("A")).subscribe(System.out::println);

        String[] arrayItems = new String[] {"Alpha", "Beta", "Gamma", "Delta", "Epsilon"};

        source = Observable.fromArray(arrayItems);

        source.filter(it -> it.startsWith("B")).subscribe(System.out::println);
    }
}
