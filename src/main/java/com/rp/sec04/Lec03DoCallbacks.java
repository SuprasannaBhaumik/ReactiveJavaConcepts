package com.rp.sec04;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec03DoCallbacks {

    public static void main(String[] args) {

        Flux.create( fluxSink -> {
            for(int i=1; i<= 5; i++) {
                fluxSink.next(i);
            }
            fluxSink.complete();
            System.out.println("--complete");
        })
                //.take(2)
                .doFirst( () -> System.out.println("doFirst"))

                .doOnSubscribe( s -> System.out.println("doOnSubscribe:"+s))
                .doOnRequest( l -> System.out.println("doOnRequest: " + l))

                .doOnNext(o -> System.out.println("doOnNext: "+o))
                .doOnError(err -> System.out.println("doOnError:"+err.getMessage()))
                .doOnComplete( () -> System.out.println("doOnComplete"))

                .doOnCancel( () -> System.out.println("doOnCancel"))
                .doOnTerminate( () -> System.out.println("doOnTerminate"))
                .doOnDiscard(Object.class, o -> System.out.println("doOnDiscard:"+o))
                .doFinally( signalType -> System.out.println("doFinally:"+signalType))

                .take(2)
                .subscribe(Util.subscriber());




    }

}
