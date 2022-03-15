package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lec03FluxFromArrayOrList {

    public static void main(String[] args) {

        Integer[] a = {1, 2, 3, 4};
        List<Integer> intList = List.of(5, 6, 7, 8);

        Flux.fromArray(a).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

        Flux.fromIterable(intList).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
