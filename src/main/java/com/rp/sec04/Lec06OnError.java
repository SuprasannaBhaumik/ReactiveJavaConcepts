package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec06OnError {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .map(i -> 10 / (5 - i))
                //.onErrorReturn(-1)
                .onErrorResume(e -> fallback())
                /*.onErrorContinue((err, obj) -> {
                    System.out.println("Error caused by:"+obj);
                })*/
                .subscribe(Util.subscriber());


    }

    /*private static Mono<Integer> fallback(){
        return Mono.fromSupplier(() -> Util.faker().random().nextInt(100, 200));
    }*/

    private static Flux<Integer> fallback(){
        return Flux.range(30, 5);
    }

}
