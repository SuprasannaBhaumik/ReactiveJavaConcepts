package com.rp.sec03;

import com.rp.courseutil.Util;
import com.rp.sec03.helper.NameProducer;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicInteger;

public class Lec08FluxPush {

    public static void main(String[] args) {


        NameProducer nameProducer = new NameProducer();

        Flux.push(nameProducer)
                .subscribe(Util.subscriber());

        Runnable runnable = nameProducer::produce;

        //new Thread(runnable).start();

        for (int i = 0; i <= 9; i++) {
            new Thread(runnable).start();
        }

        Util.sleepSeconds(2);



    }


}
