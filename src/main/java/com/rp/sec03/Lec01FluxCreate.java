package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {

        System.out.println("--------complete handling--------");
        Flux.create( fluxSink ->  {
            fluxSink.next(1);
            fluxSink.next("a");
            fluxSink.complete();
        }).subscribe(Util.subscriber());

        System.out.println("--------error--------");
        Flux.create( fluxSink ->  {
            fluxSink.next(1);
            fluxSink.next("a");
            fluxSink.error(new RuntimeException("forced error"));
        }).subscribe(Util.subscriber());

        System.out.println("--------without complete-------");
        Flux.create( fluxSink ->  {
            fluxSink.next(1);
            fluxSink.next("a");
            //it still runs, but we have nothing
        }).subscribe(Util.subscriber());

        System.out.println("----------programmatic emitting---------");
        System.out.println("use case : emit till number is 16");
        Flux.create(fluxSink -> {

            int number;
            do {
                number = Util.faker().random().nextInt(-5,20);
                System.out.println("emitting number -> " + number);
                fluxSink.next(number);
            } while(number != 16);
            fluxSink.complete();
        }).subscribe(Util.subscriber());

    }

}
