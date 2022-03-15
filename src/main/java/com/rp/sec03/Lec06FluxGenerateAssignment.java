package com.rp.sec03;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec06FluxGenerateAssignment {

    public static void main(String[] args) {

        // canada
        // max = 10
        // subscriber cancels - exit

        //case 1: using condition inside syncSink
        Flux.generate(synchronousSink -> {
            String country = Util.faker().country().name();
            System.out.println("emitting " + country);
            synchronousSink.next(country);
            if(country.toLowerCase().equals("canada"))
                synchronousSink.complete();
        })
        .subscribe(Util.subscriber());


        System.out.println("--------------case 2 : emit untill----------");
        Flux.generate(synchronousSink -> {
            synchronousSink.next(Util.faker().country().name());
        })
                .takeUntil(country -> country.equals("India"))
                .subscribe(Util.subscriber());

        Util.sleepSeconds(5);
    }


}
