package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec04LimitRate {

    public static void main(String[] args) {

        Flux.range(1, 100)
                .log()
                .limitRate(70, 30) // take 70 at a time, resend after 30
                .subscribe(Util.subscriber());

    }


}
