package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec02HandleAssignment {

    public static void main(String[] args) {

    //emit until India
    Flux.generate(synchronousSink -> {
                synchronousSink.next(Util.faker().country().name());
            }).map( country -> country.toString())
            .handle( (country, synchronousSink) -> {
                System.out.println("emitting --> "+ country);
                synchronousSink.next(country);
                if(country.equals("India")) {
                    synchronousSink.complete();
                }

            }).subscribe(Util.subscriber());










    }

}
