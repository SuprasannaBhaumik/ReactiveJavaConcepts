package com.rp.sec04;

import com.rp.courseutil.Util;
import com.rp.sec04.helper.OrderService;
import com.rp.sec04.helper.UserService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.BufferedReader;

public class Lec12FlatMap {

    public static void main(String[] args) {

        /*UserService.getUsers()
                .flatMap(user -> OrderService.getOrders(user.getUserId()))
                .flatMap( purchaseOrder -> Flux.range(1, 3))
                .filter(p -> p > 10)
                .switchIfEmpty(Flux.just(85,90, 95))
                .subscribe(Util.subscriber());


        Util.sleepSeconds(60);*/


        Flux<Integer> myFlux = Flux.range(1, 10);
        myFlux.map( i -> i * 10);
        myFlux.subscribe(System.out::println);

        Flux.range(1, 3)
                .log()
                .map(i -> i / (2 - i))
                .onErrorReturn(3)
                .subscribe(Util.subscriber());

        Mono<Integer> myMono = Mono.just(1);
        myMono.map( i -> i * 10);
        myMono.subscribe(Util.subscriber());

        Mono.just(1).map( i -> i*10).subscribe(Util.subscriber());

    }


}
