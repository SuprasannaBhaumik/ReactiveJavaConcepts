package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just("ball")
                                .map(String::length)
                                .map(l -> l / 0);

        // 0 prints name
        System.out.println(mono);

        // 1 prints nothing
        //mono.subscribe();

        // 2 actual usage
        mono.subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("completed")
        );

    }

}
