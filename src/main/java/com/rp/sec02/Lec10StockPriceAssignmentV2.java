package com.rp.sec02;

import com.rp.courseutil.Util;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Lec10StockPriceAssignmentV2 {

    public static void main(String[] args) {

        Flux<Integer> priceFlux = getIntegerFlux();

        AtomicReference<Subscription> mySubscriber = new AtomicReference<>();
        priceFlux.subscribeWith(new Subscriber<Integer>() {
            @Override
            public void onSubscribe(Subscription subscription) {
                System.out.println("subscription is set");
                System.out.println(subscription);
                mySubscriber.set(subscription);
                subscription.request(Long.MAX_VALUE);
            }

            @Override
            public void onNext(Integer integer) {
                if(integer > 105 || integer < 95) {
                    System.out.println("subscription will be cancelled");
                    mySubscriber.get().cancel();
                }
                System.out.println("Received: " + integer);
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("error: " + throwable.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("completed");
            }
        });

        Util.sleepSeconds(100);
    }

    private static Flux<Integer> getIntegerFlux() {
        List<Integer> stockPrice = new ArrayList<>();
        stockPrice.add(100);
        Flux<Integer> priceFlux = Flux.interval(Duration.ofSeconds(1))
                .map( i -> {
                    int randomNumber = Util.faker().random().nextInt(-3,3);
                    int index = Math.toIntExact(i);
                    stockPrice.add(stockPrice.get(index) + randomNumber);
                    return stockPrice.get(index) + randomNumber;
                });
        return priceFlux;
    }
}
