package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09SwitchIfEmpty {

    public static void main(String[] args) {

        getOrderNumbers()
                .filter(i -> i > 10)
                .switchIfEmpty(fallbackMono())
                .subscribe(Util.subscriber());

    }

    // redis cache / db
    private static Flux<Integer> getOrderNumbers(){
        return Flux.range(1, 10);
    }

    // db // cache
    private static Flux<Integer> fallback(){
        return Flux.range(100, 5);
    }

    private static Mono<Integer> fallbackMono(){
        return Mono.just(85);
    }



}
