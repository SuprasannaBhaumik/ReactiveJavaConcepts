package com.rp.sec01;

import com.rp.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec10Trivia {

    public static Mono<String> getStringMono() {
        return Mono.fromRunnable(() -> {
            System.out.println("nothings comes out of here");
        });
    }

    public static Mono<String> getStringMonoAgain() {
        return Mono.fromSupplier(() -> {
            System.out.println("nothings comes out of here");
            return Util.faker().name().fullName();
        });
    }

    public static void main(String[] args) {

        getStringMono().subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        getStringMonoAgain().subscribe(Util.onNext(), Util.onError(), Util.onComplete());



    }
}
