package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        //create a subscriber and consume
        Supplier<Integer> mySupplier = () -> getNumber();

        //pipeline creation
        Mono.fromSupplier(mySupplier); //nothing happens if I call this

        //actual call happens: onNext, onComplete signals called
        Mono.fromSupplier(mySupplier)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //create a callable and consume, similar to supplier
        Callable<Integer> myCallable = () -> getNumber();
        Mono.fromCallable(myCallable).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

    private static int getNumber() {
        System.out.println("creating number");
        return Util.faker().random().nextInt(1, 300);
    }

}
