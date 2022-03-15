package com.rp.sec02;

import com.rp.courseutil.Util;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {

        //starts from 3, and till the count is 13
        Flux.range(3, 13)
                .subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
