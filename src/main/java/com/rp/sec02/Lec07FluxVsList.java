package com.rp.sec02;

import com.rp.courseutil.Util;
import com.rp.sec02.helper.NameGenerator;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class Lec07FluxVsList {

    public static List<String> getNameList(int count) {
        List<String> myList = new ArrayList<>();
        for( int i = 0; i < count; i++) {
            //each name fetch takes 2 seconds
            Util.sleepSeconds(2);
            myList.add(Util.faker().name().fullName());
        }
        return myList;
    }


    public static Flux<String> getNameFlux(int count) {
        return Flux.range(1, count)
                .map( i -> {
                    Util.sleepSeconds(2);
                    return Util.faker().name().fullName();
                });
    }

    public static void main(String[] args) {

        //will wait for 10 seconds to get the entire list and then show
        //not a continuous stream of data
        getNameList(5).forEach(System.out::println);

        //this sends the name as soon as it is generated, does not wait for
        //entire flux to be formed
        getNameFlux(5).subscribe(Util.onNext(), Util.onError(), Util.onComplete());

    }

}
