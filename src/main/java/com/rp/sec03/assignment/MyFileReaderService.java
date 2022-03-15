package com.rp.sec03.assignment;

import reactor.core.publisher.Flux;
import reactor.core.publisher.SynchronousSink;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class MyFileReaderService {

    Path path = Paths.get("src/main/resources/assignment/sec03/file01.txt");
    public Flux<String> myStringFlux() {
        return Flux.generate(
                openFileReader(path),
                readFile(),
                closeFileReader()
        );
    }

    public Callable<BufferedReader> openFileReader(Path path) {
        return () -> Files.newBufferedReader(path);
    }

    public Consumer<BufferedReader> closeFileReader() {
         return br -> {
             try {
                 br.close();
             } catch (IOException e) {
                 e.printStackTrace();
             }
         };
    }


    public BiFunction<BufferedReader, SynchronousSink<String>, BufferedReader> readFile() {
        return (br, syncSink ) -> {
            try {
                String line = br.readLine();
                if(Objects.isNull(line)) {
                    syncSink.complete();
                }
                syncSink.next(line);
            } catch (IOException e) {
                syncSink.error(new RuntimeException(e.getMessage()));
            }
            return br;
        };
    }

}
