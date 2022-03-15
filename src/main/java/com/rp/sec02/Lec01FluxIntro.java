package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux.just(1, "a", true)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        System.out.println("-----demonstration of empty-------");
        //demonstration of empty
        Flux.range(1, 5)
                .filter(i -> i>6)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        System.out.println("-----demonstration of error-------");
        //demonstration of error
        Flux.range(1, 5)
                .map(i -> (i-2)/(i-1))
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
