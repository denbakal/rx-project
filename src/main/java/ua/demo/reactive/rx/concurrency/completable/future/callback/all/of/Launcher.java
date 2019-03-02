package ua.demo.reactive.rx.concurrency.completable.future.callback.all.of;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.fluttercode.datafactory.impl.DataFactory;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
public class Launcher {
    @SneakyThrows
    public static void main(String[] args) {
        List<CompletableFuture<String>> users = Stream.iterate(0, n -> n + 1)
                                                        .limit(10)
                                                        .map(it -> generateUser())
                                                        .collect(Collectors.toList());

        CompletableFuture<Void> futureAll = CompletableFuture.allOf(users.toArray(new CompletableFuture[0]));

        CompletableFuture<String> result = futureAll.thenApply((it) -> {
            log.debug("The handling data were be completed.");
            return "Ok";
        });

        result.get();
    }

    public static CompletableFuture<String> generateUser() {
        DataFactory dataFactory = new DataFactory();

        return CompletableFuture.supplyAsync(() -> {
            String user = dataFactory.getFirstName() + ":" + dataFactory.getLastName();
            log.debug("Generate an user: {}", user);
            return user;
        });
    }
}
