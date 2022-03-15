package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {

        /*Flux.generate(synchronousSink -> {
            System.out.println("emitting");
            synchronousSink.next(Util.faker().country().name()); // 1
            //synchronousSink.error(new RuntimeException("oops"));
        })
        .takeUntil( t -> t.equals("India"))
        .subscribe(Util.subscriber());*/


        //india
        //max- 10
        //subscriber cancels - then cancel
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            synchronousSink.next(country);
            if( country.equals("India")) {
                synchronousSink.complete();
            }
        }).take(10).subscribe(Util.subscriber());


    }

}
