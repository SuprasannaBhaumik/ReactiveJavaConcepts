package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class Lec04FluxFromStream {

    public static void main(String[] args) {

        //flux from stream
        List<Integer> myIntegerList = List.of(1, 2, 3, 4);
        Stream<Integer> integerStream = myIntegerList.stream();
        Flux.fromStream(integerStream).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //if I try to read from the stream again there will be error
        Flux.fromStream(integerStream).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //stream use cases: this will also not work
        Flux.fromStream(() -> integerStream).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        //since we are creating the stream again from list, multiple invocation of this is new stream
        Flux.fromStream(() -> myIntegerList.stream()).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
