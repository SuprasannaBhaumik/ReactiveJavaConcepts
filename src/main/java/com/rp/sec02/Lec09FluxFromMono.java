package com.rp.sec02;

import com.rp.courseutil.Util;
import jdk.jfr.FlightRecorder;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

        //convert from mono
        Mono<String> myMono = Mono.just("Suprasanna");
        Flux.from(myMono)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //convert to mono
        //picks the first number from the flux that is available after all the operations
        Flux.range(10, 10)
                .filter( i -> i > 13)
                .next()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        System.out.println("------checking block-----");

        String stringList =
                Flux.range(1, 5)
                .map( i -> {
                    String name = Util.faker().name().fullName();
                    System.out.println(name);
                    return name;
                })
                        .blockLast();

        System.out.println(stringList);


    }

}
