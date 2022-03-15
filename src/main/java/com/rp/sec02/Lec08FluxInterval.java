package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxInterval {

    public static void main(String[] args) {

        //keeps emitting in fixed duration, long running stream
        //it does not complete, so we won't get onComplete signal
        Flux.interval(Duration.ofSeconds(2))
                .log()
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //to make the above running
        Util.sleepSeconds(10);
    }

}
