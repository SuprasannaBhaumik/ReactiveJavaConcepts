package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec02MultipleSubscribers {

    public static void main(String[] args) {

        Flux<Object> myFlux = Flux.just(1, "a", true);

        myFlux.subscribe( t -> System.out.println("Sub 1: " + t), Util.onError(), Util.onComplete());

        myFlux.subscribe( t -> System.out.println("Sub 2: " + t), Util.onError(), Util.onComplete());





    }

}
