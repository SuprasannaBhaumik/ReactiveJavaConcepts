package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {

        AtomicReference<Subscription> atomicReference = new AtomicReference<>();
        Subscriber<Integer> onComplete = new Subscriber<>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("Received Sub : " + subscription);
                atomicReference.set(subscription);
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("onNext : " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("onError : " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        };

        Flux.range(1, 7)
                .log()
                .subscribeWith(onComplete);

        //we have to now direct the subscription object to send the request/cancel
        Util.sleepSeconds(3);
        atomicReference.get().request(2);

        Util.sleepSeconds(5);
        atomicReference.get().request(3);

        Util.sleepSeconds(2);
        System.out.println("going to cancel");
        atomicReference.get().cancel();

        Util.sleepSeconds(3);
        atomicReference.get().request(2);

        Util.sleepSeconds(3);


    }

}
