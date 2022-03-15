package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec02MonoJust {

    public static void main(String[] args) {

        //this is just pipleline creation. Nothing happens
        Mono.just("Suprasanna")
                .subscribe();

        //actual execution since we have subscribe
        Mono.just("Bhaumik")
                .subscribe(Util.onNext());

        //usage of just should be done only when the object is certain
        //no calculations are allowed inside of just
        //even if we dont subscribe method is called, and output logged
        Mono.just(getNumber());//creating number

        Mono.just(getNumber()).subscribe(Util.onNext());
    }

    private static Object getNumber() {
        System.out.println("creating number");
        return 45;
    }

}
